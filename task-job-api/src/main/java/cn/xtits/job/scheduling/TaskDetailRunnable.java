package cn.xtits.job.scheduling;

import cn.xtits.job.entity.TaskExecute;
import cn.xtits.job.enums.TaskStatusEnums;
import cn.xtits.job.service.TaskExecuteService;
import cn.xtits.job.util.DateUtil;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @version 1.0
 * @author: Bo
 * @fileName: TaskRunnable
 * @createDate: 2019-08-16 08:37.
 * @description: 创建一个线程，给定时任务调用
 */
public class TaskDetailRunnable implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(TaskDetailRunnable.class);

    private Integer taskDetailId;
    private String cron;

    /**
     * 开始时间
     */
    private Date startDate;
    /**
     * 结束时间
     */
    private Date endDate;

    private TaskExecuteService taskExecuteService;

    private DynamicTaskService dynamicTaskService;

   /* public TaskDetailRunnable(Integer taskDetailId, String cron) {
        this.taskDetailId = taskDetailId;
        this.cron = cron;
    }*/

    public TaskDetailRunnable(Integer taskDetailId, String cron, Date startDate, Date endDate) {
        this.taskDetailId = taskDetailId;
        this.cron = cron;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * 生成任务
     */
    @Override
    public void run() {
        if (taskExecuteService == null) {
            taskExecuteService = ApplicationContextUtils.getBean(TaskExecuteService.class);
        }
        long thisTime = System.currentTimeMillis();
        //当前时间大于开始时间(00:00:00)开始生成任务
        if (thisTime >= DateUtil.getStartOfDay(startDate).getTime()) {

            //结束时间(23:59:59)小于当前时间才执行任务-否则结束任务
            if (thisTime <= DateUtil.getEndOfDay(endDate).getTime()) {
                TaskExecute taskExecute = taskExecuteService.insertTaskExecuteSynchronizeGenerate(taskDetailId);
                Integer taskExecuteId = null;
                String billNo = null;
                if (null == taskExecute) {
                    if (dynamicTaskService == null) {
                        dynamicTaskService = ApplicationContextUtils.getBean(DynamicTaskService.class);
                    }
                    //异常停止任务
                    dynamicTaskService.stopTaskCron(taskDetailId, TaskStatusEnums.STOP.value);
                } else {
                    taskExecuteId = taskExecute.getId();
                    billNo = taskExecute.getBillNo();
                }
                logger.info("run()===>date：【{}】,id:{},cron:【{}】,TaskExecuteId:【{}】,code:【{}】", DateTime.now().toString("yyyy-MM-dd HH:mm:ss"), taskDetailId, cron, taskExecuteId, billNo);
            } else {
                //结束当前任务
                if (dynamicTaskService == null) {
                    dynamicTaskService = ApplicationContextUtils.getBean(DynamicTaskService.class);
                }
                //任务完成
                dynamicTaskService.stopTaskCron(taskDetailId, TaskStatusEnums.CARRY_OUT.value);
            }
        }
        /*try {
            Thread.sleep(1000 * 3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }
}
