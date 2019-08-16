package cn.xtits.job.scheduling;

import cn.xtits.job.dto.TaskDetailDto;
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
public class TaskRunnable implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(TaskRunnable.class);

    private TaskDetailDto taskDetail;

    public TaskRunnable(TaskDetailDto taskDetail) {
        this.taskDetail = taskDetail;
    }

    @Override
    public void run() {
        log.info("TaskRunnable.run()===>data：【{}】,id:{},cron:【{}】", DateTime.now().toString("yyyy-MM-dd HH:mm:ss"), taskDetail.getId(), taskDetail.getCron());
        try {
            Thread.sleep(1000 * 3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
