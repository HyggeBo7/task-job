package cn.xtits.job.scheduling;

import cn.xtits.job.entity.TaskExecute;
import cn.xtits.job.service.TaskExecuteService;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private TaskExecuteService taskExecuteService;

    public TaskDetailRunnable(Integer taskDetailId, String cron) {
        this.taskDetailId = taskDetailId;
        this.cron = cron;
    }

    /**
     * 生成任务
     */
    @Override
    public void run() {
        if (taskExecuteService == null) {
            taskExecuteService = ApplicationContextUtils.getBean(TaskExecuteService.class);
        }
        TaskExecute taskExecute = taskExecuteService.insertTaskExecuteSynchronizeGenerate(taskDetailId);
        logger.info("run()===>date：【{}】,id:{},cron:【{}】,TaskExecuteId:【{}】,code:【{}】", DateTime.now().toString("yyyy-MM-dd HH:mm:ss"), taskDetailId, cron, taskExecute.getId(), taskExecute.getBillNo());
        /*try {
            Thread.sleep(1000 * 3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }
}
