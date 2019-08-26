package cn.xtits.job.scheduling;

import cn.xtits.job.entity.TaskDetail;
import cn.xtits.job.entity.TaskDetailExample;
import cn.xtits.job.enums.TaskStatusEnums;
import cn.xtits.job.service.TaskDetailService;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @version 1.0
 * @author: Bo
 * @fileName: ScheduledTest
 * @createDate: 2019-08-16 13:35.
 * @description: 定时任务
 */
@Component
public class TaskScheduled {

    private static final Logger logger = LoggerFactory.getLogger(TaskScheduled.class);

    @Autowired
    private TaskDetailService taskDetailService;

    @Autowired
    private DynamicTaskService dynamicTaskService;

    /**
     * 定时读取可执行的任务:状态为1的
     * 启动时:60秒后加载一次,然后120秒查一次
     */
    @Scheduled(initialDelay = 1000 * 60, fixedRate = 1000 * 120)
    public void taskScheduled() {
        TaskDetailExample taskDetailExample = new TaskDetailExample();
        TaskDetailExample.Criteria taskDetailExampleCriteria = taskDetailExample.createCriteria();
        taskDetailExampleCriteria.andDeleteFlagEqualTo(false);
        taskDetailExampleCriteria.andAuditFlagEqualTo(true);
        taskDetailExampleCriteria.andTaskStatusEqualTo(TaskStatusEnums.START.value);

        List<TaskDetail> listTaskDetailAll = taskDetailService.listTaskDetailAll(taskDetailExample);
        if (listTaskDetailAll.size() > 0) {
            TaskDetail taskDetail;
            for (TaskDetail serverTaskDetail : listTaskDetailAll) {
                //开启任务-开启成功返回true,然后更改状态为执行中
                boolean flag = dynamicTaskService.startTaskCron(serverTaskDetail.getId(), serverTaskDetail.getCron(), serverTaskDetail.getStartDate(), serverTaskDetail.getEndDate());
                taskDetail = new TaskDetail();
                taskDetail.setId(serverTaskDetail.getId());
                if (flag) {
                    taskDetail.setTaskStatus(TaskStatusEnums.EXECUTING.value);
                } else {
                    taskDetail.setTaskStatus(TaskStatusEnums.EXEC_ERROR.value);
                }
                taskDetailService.updateByPrimaryKeySelective(taskDetail);
            }
        }
        logger.info("taskScheduled()===>date:【{}】,size:【{}】", DateTime.now().toString("yyyy-MM-dd HH:mm:ss"), listTaskDetailAll.size());
    }
}
