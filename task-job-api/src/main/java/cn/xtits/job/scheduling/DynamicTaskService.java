package cn.xtits.job.scheduling;

import cn.xtits.job.entity.TaskDetail;
import cn.xtits.job.service.TaskDetailService;
import cn.xtits.job.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronSequenceGenerator;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

/**
 * @version 1.0
 * @author: Bo
 * @fileName: DynamicTaskController
 * @createDate: 2019-08-16 08:36.
 * @description:
 */
@Component
public class DynamicTaskService implements DisposableBean {

    private static final Logger log = LoggerFactory.getLogger(DynamicTaskService.class);

    /**
     * 存放任务
     */
    private static final ConcurrentHashMap<Integer, ScheduledFuture> TASK_FUTURE_MAP = new ConcurrentHashMap<>();

    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    @Autowired
    private TaskDetailService taskDetailService;

    /**
     * 启动一个任务
     * 在ScheduledFuture中有一个cancel可以停止定时任务。
     */
    public boolean startTaskCron(Integer taskId, String cron, Date startDate, Date endDate) {
        ScheduledFuture scheduledFuture = TASK_FUTURE_MAP.get(taskId);
        if (!CronSequenceGenerator.isValidExpression(cron)) {
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
                TASK_FUTURE_MAP.remove(taskId);
            }
            return false;
        }
        //开始/结束 日期为空,或者结束日期小于开始日期
        if (startDate == null || endDate == null || DateUtil.getEndOfDay(endDate).getTime() < DateUtil.getStartOfDay(startDate).getTime()) {
            return false;
        }

        if (scheduledFuture == null) {
            scheduledFuture = threadPoolTaskScheduler.schedule(new TaskDetailRunnable(taskId, cron, startDate, endDate), new CronTrigger(cron));
            TASK_FUTURE_MAP.put(taskId, scheduledFuture);
            log.info("新增任务【{}】,cron:【{}】", taskId, cron);
        } else {
            scheduledFuture.cancel(true);
            scheduledFuture = threadPoolTaskScheduler.schedule(new TaskDetailRunnable(taskId, cron, startDate, endDate), new CronTrigger(cron));
            TASK_FUTURE_MAP.put(taskId, scheduledFuture);
            log.info("更新任务【{}】,cron:【{}】", taskId, cron);
        }
        return true;
    }

    public boolean updateTaskCron(Integer taskId, String cron, Date startDate, Date endDate) {
        ScheduledFuture scheduledFuture = TASK_FUTURE_MAP.get(taskId);
        if (scheduledFuture != null && CronSequenceGenerator.isValidExpression(cron)) {
            scheduledFuture.cancel(true);
            scheduledFuture = threadPoolTaskScheduler.schedule(new TaskDetailRunnable(taskId, cron, startDate, endDate), new CronTrigger(cron));
            TASK_FUTURE_MAP.put(taskId, scheduledFuture);
            log.info("修改任务【{}】,cron:【{}】", taskId, cron);
            return true;
        }
        return false;
    }

    /**
     * 停止任务
     **/
    public boolean stopTaskCron(Integer taskId, Integer taskStatus) {
        ScheduledFuture future = TASK_FUTURE_MAP.get(taskId);
        if (future != null) {
            boolean cancelFlag = future.cancel(true);
            if (cancelFlag) {
                TASK_FUTURE_MAP.remove(taskId);
                log.info("停止任务【{}】", taskId);
                if (taskStatus != null) {
                    TaskDetail taskDetail = new TaskDetail();
                    taskDetail.setId(taskId);
                    taskDetail.setTaskStatus(taskStatus);
                    taskDetailService.updateByPrimaryKeySelective(taskDetail);
                }
            }
            return cancelFlag;
        }
        return false;
    }

    @Override
    public void destroy() throws Exception {
        for (ScheduledFuture future : TASK_FUTURE_MAP.values()) {
            future.cancel(true);
        }
        TASK_FUTURE_MAP.clear();
        threadPoolTaskScheduler.destroy();
        log.info("销毁全部任务...");
    }
}
