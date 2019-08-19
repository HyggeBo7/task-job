package cn.xtits.job.enums;

/**
 * @version 1.0
 * @author: Bo
 * @fileName: TaskStatusEnums
 * @createDate: 2019-08-16 11:13.
 * @description: 任务执行状态[1:正常,2:执行中,-2:执行异常,10:停止]
 */
public enum TaskStatusEnums {

    START(1, "正常"),
    EXECUTING(2, "执行中"),
    EXEC_ERROR(-2, "执行异常"),
    STOP(10, "停止");

    TaskStatusEnums(Integer value, String msg) {
        this.value = value;
        this.msg = msg;
    }

    public Integer value;
    public String msg;
}
