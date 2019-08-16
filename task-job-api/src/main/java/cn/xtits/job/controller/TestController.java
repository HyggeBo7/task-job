package cn.xtits.job.controller;

import cn.xtits.xtf.common.web.AjaxResult;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @fileName: TestController.java
 * @author: Dan
 * @createDate: 2018/2/6 15:20
 * @description: 测试
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    @RequestMapping("testJson")
    @ResponseBody
    public AjaxResult testJson() {
        threadPoolTaskScheduler.getActiveCount();
        return new AjaxResult("task-job-api,成功!" + DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
    }

    @RequestMapping("testCount")
    @ResponseBody
    public AjaxResult testCount() {
        int activeCount = threadPoolTaskScheduler.getActiveCount();
        return new AjaxResult(String.valueOf(activeCount));
    }

}
