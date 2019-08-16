package cn.xtits.job.scheduling;

import org.joda.time.DateTime;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @author: Bo
 * @fileName: ScheduledTest
 * @createDate: 2019-08-16 13:35.
 * @description: 定时任务
 */
@Component
public class TaskScheduled {

    @Scheduled(initialDelay = 1000 * 30, fixedRate = 1000 * 120)
    public void testScheduled() {
        System.out.println("testScheduled-----------" + DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
    }
}
