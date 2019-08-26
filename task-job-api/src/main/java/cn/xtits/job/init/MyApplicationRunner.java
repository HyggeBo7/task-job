package cn.xtits.job.init;

import cn.xtits.job.entity.TaskDetail;
import cn.xtits.job.entity.TaskDetailExample;
import cn.xtits.job.enums.TaskStatusEnums;
import cn.xtits.job.scheduling.DynamicTaskService;
import cn.xtits.job.service.TaskDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.support.CronSequenceGenerator;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @version 1.0
 * @author: Bo
 * @fileName: MyApplicationRunner
 * @createDate: 2019-08-16 13:16.
 * @description:
 */
@Component
public class MyApplicationRunner implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(MyApplicationRunner.class);

    @Autowired
    private TaskDetailService taskDetailService;

    @Autowired
    private DynamicTaskService dynamicTaskService;

    @Override
    public void run(ApplicationArguments applicationArguments) {
        // 初始加载数据库里状态为正常的定时任务
        new Thread(() -> {
            TaskDetailExample taskDetailExample = new TaskDetailExample();
            TaskDetailExample.Criteria taskDetailExampleCriteria = taskDetailExample.createCriteria();
            taskDetailExampleCriteria.andDeleteFlagEqualTo(false);
            taskDetailExampleCriteria.andAuditFlagEqualTo(true);
            taskDetailExampleCriteria.andTaskStatusIn(Arrays.asList(TaskStatusEnums.START.value, TaskStatusEnums.EXECUTING.value));

            List<TaskDetail> listTaskDetailAll = taskDetailService.listTaskDetailAll(taskDetailExample);
            if (listTaskDetailAll.size() > 0) {
                List<TaskDetail> collectAll = listTaskDetailAll.stream().filter(d -> CronSequenceGenerator.isValidExpression(d.getCron())).collect(Collectors.toList());
                logger.info("开始加载定时任务...共:【{}】,执行:【{}】", listTaskDetailAll.size(), collectAll.size());
                int taskSize = 0;
                if (collectAll.size() > 0) {
                    TaskDetail taskDetail;
                    for (TaskDetail serverTaskDetail : collectAll) {
                        boolean flag = dynamicTaskService.startTaskCron(serverTaskDetail.getId(), serverTaskDetail.getCron(), serverTaskDetail.getStartDate(), serverTaskDetail.getEndDate());
                        //执行成功,并且不是执行状态,修改为执行状态
                        if (flag && !TaskStatusEnums.EXECUTING.value.equals(serverTaskDetail.getTaskStatus())) {
                            taskDetail = new TaskDetail();
                            taskDetail.setId(serverTaskDetail.getId());
                            taskDetail.setTaskStatus(TaskStatusEnums.EXECUTING.value);
                            taskDetailService.updateByPrimaryKeySelective(taskDetail);
                        }
                        if (flag) {
                            taskSize++;
                        }
                    }
                }
                logger.info("定时任务已加载完毕...size:{}", taskSize);
            } else {
                logger.info("无定时任务加载...");
            }

        }).start();
    }
}
