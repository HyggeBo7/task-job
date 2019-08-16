package cn.xtits.job.dto;

import cn.xtits.job.entity.TaskDetail;

public class TaskDetailDto extends TaskDetail {

    private String taskBillCode;
    private String taskType;

    public String getTaskBillCode() {
        return taskBillCode;
    }

    public void setTaskBillCode(String taskBillCode) {
        this.taskBillCode = taskBillCode;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }
}