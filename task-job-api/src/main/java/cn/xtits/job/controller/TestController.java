package cn.xtits.job.controller;

import cn.xtits.job.entity.TaskDetail;
import cn.xtits.job.scheduling.DynamicTaskService;
import cn.xtits.job.service.TaskDetailService;
import cn.xtits.job.util.DateUtil;
import cn.xtits.xtf.common.web.AjaxResult;
import org.joda.time.DateTime;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

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
    private DynamicTaskService dynamicTaskService;

    @Autowired
    private TaskDetailService taskDetailService;

    @RequestMapping("testJson")
    @ResponseBody
    public AjaxResult testJson() {
        return new AjaxResult("task-job-api,成功!" + DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
    }

    @RequestMapping("startTask")
    @ResponseBody
    public AjaxResult startTask(
            @RequestParam(value = "id", required = false) Integer id) {
        if (id == null || id < 1) {
            return new AjaxResult(-1, "请输入任务Id!");
        }
        TaskDetail taskDetail = taskDetailService.getByPrimaryKey(id);
        if (taskDetail == null || taskDetail.getDeleteFlag()) {
            return new AjaxResult(-1, "任务Id【" + id + "】不存在,或者已删除!");
        }
        Date date = DateUtil.getDate();
        boolean taskFlag = dynamicTaskService.startTaskCron(taskDetail.getId(), taskDetail.getCron(), date, DateUtil.addDay(date, 1));
        return new AjaxResult(taskFlag);
    }

    @Test
    public void test01() {
        Date[] cronScheduledDate = DateUtil.getCronScheduledDate("00 00 00 01 9 ? 2018-2019", 10);
        for (Date date : cronScheduledDate) {

            System.out.println("cronScheduledDate:" + date);
        }
    }

}
