package cn.xtits.job.entity;

import java.io.Serializable;
import java.util.Date;

public class TaskExecute implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ip_taskexecute.Id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ip_taskexecute.BillNo
     *
     * @mbg.generated
     */
    private String billNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ip_taskexecute.Status
     *
     * @mbg.generated
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ip_taskexecute.LocationId
     *
     * @mbg.generated
     */
    private Integer locationId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ip_taskexecute.LocationName
     *
     * @mbg.generated
     */
    private String locationName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ip_taskexecute.TaskId
     *
     * @mbg.generated
     */
    private Integer taskId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ip_taskexecute.TaskBillCode
     *
     * @mbg.generated
     */
    private String taskBillCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ip_taskexecute.TaskDetailId
     *
     * @mbg.generated
     */
    private Integer taskDetailId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ip_taskexecute.TaskType
     *
     * @mbg.generated
     */
    private String taskType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ip_taskexecute.Remark
     *
     * @mbg.generated
     */
    private String remark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ip_taskexecute.ParentId
     *
     * @mbg.generated
     */
    private Integer parentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ip_taskexecute.MakeBillMan
     *
     * @mbg.generated
     */
    private String makeBillMan;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ip_taskexecute.CreateDate
     *
     * @mbg.generated
     */
    private Date createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ip_taskexecute.ModifyDate
     *
     * @mbg.generated
     */
    private Date modifyDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ip_taskexecute.Modifier
     *
     * @mbg.generated
     */
    private String modifier;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ip_taskexecute.DeleteFlag
     *
     * @mbg.generated
     */
    private Boolean deleteFlag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ip_taskexecute.InspectDate
     *
     * @mbg.generated
     */
    private Date inspectDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ip_taskexecute.InspectDescription
     *
     * @mbg.generated
     */
    private String inspectDescription;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ip_taskexecute.InspectPassFLag
     *
     * @mbg.generated
     */
    private String inspectPassFLag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ip_taskexecute.InspectFile
     *
     * @mbg.generated
     */
    private String inspectFile;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ip_taskexecute.InspectMan
     *
     * @mbg.generated
     */
    private String inspectMan;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ip_taskexecute.ManagerId
     *
     * @mbg.generated
     */
    private Integer managerId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ip_taskexecute.Manager
     *
     * @mbg.generated
     */
    private String manager;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ip_taskexecute.SolveDate
     *
     * @mbg.generated
     */
    private Date solveDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ip_taskexecute.SolveDescription
     *
     * @mbg.generated
     */
    private String solveDescription;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ip_taskexecute.SolveFile
     *
     * @mbg.generated
     */
    private String solveFile;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ip_taskexecute.SolveDelayDescription
     *
     * @mbg.generated
     */
    private String solveDelayDescription;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ip_taskexecute.PrecautionDate
     *
     * @mbg.generated
     */
    private Date precautionDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ip_taskexecute.PrecautionDescription
     *
     * @mbg.generated
     */
    private String precautionDescription;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ip_taskexecute.PrecautionReason
     *
     * @mbg.generated
     */
    private String precautionReason;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ip_taskexecute
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ip_taskexecute.Id
     *
     * @return the value of ip_taskexecute.Id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ip_taskexecute.Id
     *
     * @param id the value for ip_taskexecute.Id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ip_taskexecute.BillNo
     *
     * @return the value of ip_taskexecute.BillNo
     *
     * @mbg.generated
     */
    public String getBillNo() {
        return billNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ip_taskexecute.BillNo
     *
     * @param billNo the value for ip_taskexecute.BillNo
     *
     * @mbg.generated
     */
    public void setBillNo(String billNo) {
        this.billNo = billNo == null ? null : billNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ip_taskexecute.Status
     *
     * @return the value of ip_taskexecute.Status
     *
     * @mbg.generated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ip_taskexecute.Status
     *
     * @param status the value for ip_taskexecute.Status
     *
     * @mbg.generated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ip_taskexecute.LocationId
     *
     * @return the value of ip_taskexecute.LocationId
     *
     * @mbg.generated
     */
    public Integer getLocationId() {
        return locationId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ip_taskexecute.LocationId
     *
     * @param locationId the value for ip_taskexecute.LocationId
     *
     * @mbg.generated
     */
    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ip_taskexecute.LocationName
     *
     * @return the value of ip_taskexecute.LocationName
     *
     * @mbg.generated
     */
    public String getLocationName() {
        return locationName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ip_taskexecute.LocationName
     *
     * @param locationName the value for ip_taskexecute.LocationName
     *
     * @mbg.generated
     */
    public void setLocationName(String locationName) {
        this.locationName = locationName == null ? null : locationName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ip_taskexecute.TaskId
     *
     * @return the value of ip_taskexecute.TaskId
     *
     * @mbg.generated
     */
    public Integer getTaskId() {
        return taskId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ip_taskexecute.TaskId
     *
     * @param taskId the value for ip_taskexecute.TaskId
     *
     * @mbg.generated
     */
    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ip_taskexecute.TaskBillCode
     *
     * @return the value of ip_taskexecute.TaskBillCode
     *
     * @mbg.generated
     */
    public String getTaskBillCode() {
        return taskBillCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ip_taskexecute.TaskBillCode
     *
     * @param taskBillCode the value for ip_taskexecute.TaskBillCode
     *
     * @mbg.generated
     */
    public void setTaskBillCode(String taskBillCode) {
        this.taskBillCode = taskBillCode == null ? null : taskBillCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ip_taskexecute.TaskDetailId
     *
     * @return the value of ip_taskexecute.TaskDetailId
     *
     * @mbg.generated
     */
    public Integer getTaskDetailId() {
        return taskDetailId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ip_taskexecute.TaskDetailId
     *
     * @param taskDetailId the value for ip_taskexecute.TaskDetailId
     *
     * @mbg.generated
     */
    public void setTaskDetailId(Integer taskDetailId) {
        this.taskDetailId = taskDetailId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ip_taskexecute.TaskType
     *
     * @return the value of ip_taskexecute.TaskType
     *
     * @mbg.generated
     */
    public String getTaskType() {
        return taskType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ip_taskexecute.TaskType
     *
     * @param taskType the value for ip_taskexecute.TaskType
     *
     * @mbg.generated
     */
    public void setTaskType(String taskType) {
        this.taskType = taskType == null ? null : taskType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ip_taskexecute.Remark
     *
     * @return the value of ip_taskexecute.Remark
     *
     * @mbg.generated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ip_taskexecute.Remark
     *
     * @param remark the value for ip_taskexecute.Remark
     *
     * @mbg.generated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ip_taskexecute.ParentId
     *
     * @return the value of ip_taskexecute.ParentId
     *
     * @mbg.generated
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ip_taskexecute.ParentId
     *
     * @param parentId the value for ip_taskexecute.ParentId
     *
     * @mbg.generated
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ip_taskexecute.MakeBillMan
     *
     * @return the value of ip_taskexecute.MakeBillMan
     *
     * @mbg.generated
     */
    public String getMakeBillMan() {
        return makeBillMan;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ip_taskexecute.MakeBillMan
     *
     * @param makeBillMan the value for ip_taskexecute.MakeBillMan
     *
     * @mbg.generated
     */
    public void setMakeBillMan(String makeBillMan) {
        this.makeBillMan = makeBillMan == null ? null : makeBillMan.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ip_taskexecute.CreateDate
     *
     * @return the value of ip_taskexecute.CreateDate
     *
     * @mbg.generated
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ip_taskexecute.CreateDate
     *
     * @param createDate the value for ip_taskexecute.CreateDate
     *
     * @mbg.generated
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ip_taskexecute.ModifyDate
     *
     * @return the value of ip_taskexecute.ModifyDate
     *
     * @mbg.generated
     */
    public Date getModifyDate() {
        return modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ip_taskexecute.ModifyDate
     *
     * @param modifyDate the value for ip_taskexecute.ModifyDate
     *
     * @mbg.generated
     */
    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ip_taskexecute.Modifier
     *
     * @return the value of ip_taskexecute.Modifier
     *
     * @mbg.generated
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ip_taskexecute.Modifier
     *
     * @param modifier the value for ip_taskexecute.Modifier
     *
     * @mbg.generated
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ip_taskexecute.DeleteFlag
     *
     * @return the value of ip_taskexecute.DeleteFlag
     *
     * @mbg.generated
     */
    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ip_taskexecute.DeleteFlag
     *
     * @param deleteFlag the value for ip_taskexecute.DeleteFlag
     *
     * @mbg.generated
     */
    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ip_taskexecute.InspectDate
     *
     * @return the value of ip_taskexecute.InspectDate
     *
     * @mbg.generated
     */
    public Date getInspectDate() {
        return inspectDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ip_taskexecute.InspectDate
     *
     * @param inspectDate the value for ip_taskexecute.InspectDate
     *
     * @mbg.generated
     */
    public void setInspectDate(Date inspectDate) {
        this.inspectDate = inspectDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ip_taskexecute.InspectDescription
     *
     * @return the value of ip_taskexecute.InspectDescription
     *
     * @mbg.generated
     */
    public String getInspectDescription() {
        return inspectDescription;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ip_taskexecute.InspectDescription
     *
     * @param inspectDescription the value for ip_taskexecute.InspectDescription
     *
     * @mbg.generated
     */
    public void setInspectDescription(String inspectDescription) {
        this.inspectDescription = inspectDescription == null ? null : inspectDescription.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ip_taskexecute.InspectPassFLag
     *
     * @return the value of ip_taskexecute.InspectPassFLag
     *
     * @mbg.generated
     */
    public String getInspectPassFLag() {
        return inspectPassFLag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ip_taskexecute.InspectPassFLag
     *
     * @param inspectPassFLag the value for ip_taskexecute.InspectPassFLag
     *
     * @mbg.generated
     */
    public void setInspectPassFLag(String inspectPassFLag) {
        this.inspectPassFLag = inspectPassFLag == null ? null : inspectPassFLag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ip_taskexecute.InspectFile
     *
     * @return the value of ip_taskexecute.InspectFile
     *
     * @mbg.generated
     */
    public String getInspectFile() {
        return inspectFile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ip_taskexecute.InspectFile
     *
     * @param inspectFile the value for ip_taskexecute.InspectFile
     *
     * @mbg.generated
     */
    public void setInspectFile(String inspectFile) {
        this.inspectFile = inspectFile == null ? null : inspectFile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ip_taskexecute.InspectMan
     *
     * @return the value of ip_taskexecute.InspectMan
     *
     * @mbg.generated
     */
    public String getInspectMan() {
        return inspectMan;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ip_taskexecute.InspectMan
     *
     * @param inspectMan the value for ip_taskexecute.InspectMan
     *
     * @mbg.generated
     */
    public void setInspectMan(String inspectMan) {
        this.inspectMan = inspectMan == null ? null : inspectMan.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ip_taskexecute.ManagerId
     *
     * @return the value of ip_taskexecute.ManagerId
     *
     * @mbg.generated
     */
    public Integer getManagerId() {
        return managerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ip_taskexecute.ManagerId
     *
     * @param managerId the value for ip_taskexecute.ManagerId
     *
     * @mbg.generated
     */
    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ip_taskexecute.Manager
     *
     * @return the value of ip_taskexecute.Manager
     *
     * @mbg.generated
     */
    public String getManager() {
        return manager;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ip_taskexecute.Manager
     *
     * @param manager the value for ip_taskexecute.Manager
     *
     * @mbg.generated
     */
    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ip_taskexecute.SolveDate
     *
     * @return the value of ip_taskexecute.SolveDate
     *
     * @mbg.generated
     */
    public Date getSolveDate() {
        return solveDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ip_taskexecute.SolveDate
     *
     * @param solveDate the value for ip_taskexecute.SolveDate
     *
     * @mbg.generated
     */
    public void setSolveDate(Date solveDate) {
        this.solveDate = solveDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ip_taskexecute.SolveDescription
     *
     * @return the value of ip_taskexecute.SolveDescription
     *
     * @mbg.generated
     */
    public String getSolveDescription() {
        return solveDescription;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ip_taskexecute.SolveDescription
     *
     * @param solveDescription the value for ip_taskexecute.SolveDescription
     *
     * @mbg.generated
     */
    public void setSolveDescription(String solveDescription) {
        this.solveDescription = solveDescription == null ? null : solveDescription.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ip_taskexecute.SolveFile
     *
     * @return the value of ip_taskexecute.SolveFile
     *
     * @mbg.generated
     */
    public String getSolveFile() {
        return solveFile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ip_taskexecute.SolveFile
     *
     * @param solveFile the value for ip_taskexecute.SolveFile
     *
     * @mbg.generated
     */
    public void setSolveFile(String solveFile) {
        this.solveFile = solveFile == null ? null : solveFile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ip_taskexecute.SolveDelayDescription
     *
     * @return the value of ip_taskexecute.SolveDelayDescription
     *
     * @mbg.generated
     */
    public String getSolveDelayDescription() {
        return solveDelayDescription;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ip_taskexecute.SolveDelayDescription
     *
     * @param solveDelayDescription the value for ip_taskexecute.SolveDelayDescription
     *
     * @mbg.generated
     */
    public void setSolveDelayDescription(String solveDelayDescription) {
        this.solveDelayDescription = solveDelayDescription == null ? null : solveDelayDescription.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ip_taskexecute.PrecautionDate
     *
     * @return the value of ip_taskexecute.PrecautionDate
     *
     * @mbg.generated
     */
    public Date getPrecautionDate() {
        return precautionDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ip_taskexecute.PrecautionDate
     *
     * @param precautionDate the value for ip_taskexecute.PrecautionDate
     *
     * @mbg.generated
     */
    public void setPrecautionDate(Date precautionDate) {
        this.precautionDate = precautionDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ip_taskexecute.PrecautionDescription
     *
     * @return the value of ip_taskexecute.PrecautionDescription
     *
     * @mbg.generated
     */
    public String getPrecautionDescription() {
        return precautionDescription;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ip_taskexecute.PrecautionDescription
     *
     * @param precautionDescription the value for ip_taskexecute.PrecautionDescription
     *
     * @mbg.generated
     */
    public void setPrecautionDescription(String precautionDescription) {
        this.precautionDescription = precautionDescription == null ? null : precautionDescription.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ip_taskexecute.PrecautionReason
     *
     * @return the value of ip_taskexecute.PrecautionReason
     *
     * @mbg.generated
     */
    public String getPrecautionReason() {
        return precautionReason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ip_taskexecute.PrecautionReason
     *
     * @param precautionReason the value for ip_taskexecute.PrecautionReason
     *
     * @mbg.generated
     */
    public void setPrecautionReason(String precautionReason) {
        this.precautionReason = precautionReason == null ? null : precautionReason.trim();
    }
}