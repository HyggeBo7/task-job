package cn.xtits.job.init;

import cn.xtits.job.dto.TaskDetailDto;
import cn.xtits.job.scheduling.DynamicTaskService;
import cn.xtits.job.service.TaskDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            Map<String, Object> map = new HashMap<>();
            map.put("auditFlag", true);
            map.put("taskStatusList", Arrays.asList(1, 2));
            List<TaskDetailDto> listTaskDetailAll = taskDetailService.listTaskDetailAll(map);
            if (listTaskDetailAll.size() > 0) {
                logger.info("开始加载定时任务...size:{}", listTaskDetailAll.size());
                dynamicTaskService.startTaskCron(listTaskDetailAll);
                logger.info("定时任务已加载完毕...size:{}", listTaskDetailAll.size());
            } else {
                logger.info("无定时任务加载...");
            }

        }).start();
    }
}
