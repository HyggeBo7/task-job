package cn.xtits.job.scheduling;

import cn.xtits.job.dto.TaskDetailDto;
import cn.xtits.job.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
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

    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    private static final ConcurrentHashMap<Integer, ScheduledFuture> TASK_FUTURE_MAP = new ConcurrentHashMap<>();

    public void startTaskCron(List<TaskDetailDto> taskDetailList) {
        for (TaskDetailDto taskDetailDto : taskDetailList) {
            startTaskCron(taskDetailDto);
        }
    }

    /**
     * 启动一个任务
     * 在ScheduledFuture中有一个cancel可以停止定时任务。
     */
    public void startTaskCron(TaskDetailDto taskDetail) {
        ScheduledFuture scheduledFuture = TASK_FUTURE_MAP.get(taskDetail.getId());
        if (scheduledFuture == null) {
            //scheduledFuture = threadPoolTaskScheduler.schedule(new TaskRunnable(taskDetail), new CronTrigger(taskDetail.getCron()));
            scheduledFuture = threadPoolTaskScheduler.schedule(new TaskRunnable(taskDetail), new Trigger() {
                @Override
                public Date nextExecutionTime(TriggerContext triggerContext) {
                    //log.info("id:【{}】,lastCompletionTime【{}】,lastCompletionTime:【{}】,lastScheduledExecutionTime:【{}】", taskDetail.getId(), DateUtil.parseToString(triggerContext.lastCompletionTime()), DateUtil.parseToString(triggerContext.lastCompletionTime()), DateUtil.parseToString(triggerContext.lastScheduledExecutionTime()));
                    return DateUtil.getCronSchduleDate(taskDetail.getCron());
                }
            });
            TASK_FUTURE_MAP.put(taskDetail.getId(), scheduledFuture);
            log.info("新增任务【{}】,cron:【{}】", taskDetail.getId(), taskDetail.getCron());
        } else {
            scheduledFuture.cancel(true);
            scheduledFuture = threadPoolTaskScheduler.schedule(new TaskRunnable(taskDetail), new CronTrigger(taskDetail.getCron()));
            TASK_FUTURE_MAP.put(taskDetail.getId(), scheduledFuture);
            log.info("更新任务【{}】,cron:【{}】", taskDetail.getId(), taskDetail.getCron());
        }
    }

    /**
     * 启此任务
     **/
    public boolean stopTaskCron(Integer taskId) {
        ScheduledFuture future = TASK_FUTURE_MAP.get(taskId);
        if (future != null) {
            boolean cancelFlag = future.cancel(true);
            if (cancelFlag) {
                TASK_FUTURE_MAP.remove(taskId);
                log.info("停止任务【{}】", taskId);
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

        log.info("销毁任务...");
    }
}
