package cn.xtits.job.enums;

/**
 * @version 1.0
 * @author: Bo
 * @fileName: TaskExecuteStatusEnums
 * @createDate: 2019-08-19 17:13.
 * @description: [1：初始化 2：提交 3：纠正 4：预防 10：结束]
 */
public enum TaskExecuteStatusEnums {
    INIT(1, "初始化"),
    SUBMIT(2, "提交"),
    CORRECT(3, "纠正"),
    PREVENTION(4, "预防"),
    End(10, "结束");

    TaskExecuteStatusEnums(Integer value, String msg) {
        this.value = value;
        this.msg = msg;
    }

    public Integer value;
    public String msg;
}
