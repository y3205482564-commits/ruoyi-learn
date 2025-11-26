package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 检修任务对象 maintenance_task
 * 
 * @author ruoyi
 * @date 2025-11-26
 */
public class MaintenanceTask extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 任务ID */
    private Long taskId;

    /** 项目ID */
    @Excel(name = "项目ID")
    private Long projectId;

    /** 任务编号 */
    @Excel(name = "任务编号")
    private String taskCode;

    /** 任务名称 */
    @Excel(name = "任务名称")
    private String taskName;

    /** 任务类型 */
    @Excel(name = "任务类型")
    private String taskType;

    /** 分配班组ID */
    @Excel(name = "分配班组ID")
    private Long assignedTeamId;

    /** 分配人员用户ID */
    @Excel(name = "分配人员用户ID")
    private Long assignedUserId;

    /** 分配人用户ID */
    @Excel(name = "分配人用户ID")
    private Long assignerId;

    /** 任务描述 */
    @Excel(name = "任务描述")
    private String description;

    /** 任务要求 */
    @Excel(name = "任务要求")
    private String requirements;

    /** 检查项目 */
    @Excel(name = "检查项目")
    private String checkItems;

    /** 计划开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "计划开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date planStartTime;

    /** 计划结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "计划结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date planEndTime;

    /** 实际开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "实际开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date actualStartTime;

    /** 实际结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "实际结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date actualEndTime;

    /** 状态（pending:待分配 assigned:已分配 in_progress:进行中 completed:已完成 cancelled:已取消） */
    @Excel(name = "状态", readConverterExp = "p=ending:待分配,a=ssigned:已分配,i=n_progress:进行中,c=ompleted:已完成,c=ancelled:已取消")
    private String status;

    /** 进度百分比 */
    @Excel(name = "进度百分比")
    private Long progress;

    /** 预计工时 */
    @Excel(name = "预计工时")
    private BigDecimal workHours;

    /** 实际工时 */
    @Excel(name = "实际工时")
    private BigDecimal actualHours;

    /** 执行结果描述 */
    @Excel(name = "执行结果描述")
    private String resultDescription;

    /** 质量检查（0未检查 1合格 2不合格） */
    @Excel(name = "质量检查", readConverterExp = "0=未检查,1=合格,2=不合格")
    private String qualityCheck;

    /** 优先级（1低 2中 3高） */
    @Excel(name = "优先级", readConverterExp = "1=低,2=中,3=高")
    private String priority;

    /** 紧急程度（0一般 1紧急 2特急） */
    @Excel(name = "紧急程度", readConverterExp = "0=一般,1=紧急,2=特急")
    private String urgency;

    /** 删除标志（0存在 2删除） */
    private String delFlag;

    public void setTaskId(Long taskId) 
    {
        this.taskId = taskId;
    }

    public Long getTaskId() 
    {
        return taskId;
    }

    public void setProjectId(Long projectId) 
    {
        this.projectId = projectId;
    }

    public Long getProjectId() 
    {
        return projectId;
    }

    public void setTaskCode(String taskCode) 
    {
        this.taskCode = taskCode;
    }

    public String getTaskCode() 
    {
        return taskCode;
    }

    public void setTaskName(String taskName) 
    {
        this.taskName = taskName;
    }

    public String getTaskName() 
    {
        return taskName;
    }

    public void setTaskType(String taskType) 
    {
        this.taskType = taskType;
    }

    public String getTaskType() 
    {
        return taskType;
    }

    public void setAssignedTeamId(Long assignedTeamId) 
    {
        this.assignedTeamId = assignedTeamId;
    }

    public Long getAssignedTeamId() 
    {
        return assignedTeamId;
    }

    public void setAssignedUserId(Long assignedUserId) 
    {
        this.assignedUserId = assignedUserId;
    }

    public Long getAssignedUserId() 
    {
        return assignedUserId;
    }

    public void setAssignerId(Long assignerId) 
    {
        this.assignerId = assignerId;
    }

    public Long getAssignerId() 
    {
        return assignerId;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

    public void setRequirements(String requirements) 
    {
        this.requirements = requirements;
    }

    public String getRequirements() 
    {
        return requirements;
    }

    public void setCheckItems(String checkItems) 
    {
        this.checkItems = checkItems;
    }

    public String getCheckItems() 
    {
        return checkItems;
    }

    public void setPlanStartTime(Date planStartTime) 
    {
        this.planStartTime = planStartTime;
    }

    public Date getPlanStartTime() 
    {
        return planStartTime;
    }

    public void setPlanEndTime(Date planEndTime) 
    {
        this.planEndTime = planEndTime;
    }

    public Date getPlanEndTime() 
    {
        return planEndTime;
    }

    public void setActualStartTime(Date actualStartTime) 
    {
        this.actualStartTime = actualStartTime;
    }

    public Date getActualStartTime() 
    {
        return actualStartTime;
    }

    public void setActualEndTime(Date actualEndTime) 
    {
        this.actualEndTime = actualEndTime;
    }

    public Date getActualEndTime() 
    {
        return actualEndTime;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setProgress(Long progress) 
    {
        this.progress = progress;
    }

    public Long getProgress() 
    {
        return progress;
    }

    public void setWorkHours(BigDecimal workHours) 
    {
        this.workHours = workHours;
    }

    public BigDecimal getWorkHours() 
    {
        return workHours;
    }

    public void setActualHours(BigDecimal actualHours) 
    {
        this.actualHours = actualHours;
    }

    public BigDecimal getActualHours() 
    {
        return actualHours;
    }

    public void setResultDescription(String resultDescription) 
    {
        this.resultDescription = resultDescription;
    }

    public String getResultDescription() 
    {
        return resultDescription;
    }

    public void setQualityCheck(String qualityCheck) 
    {
        this.qualityCheck = qualityCheck;
    }

    public String getQualityCheck() 
    {
        return qualityCheck;
    }

    public void setPriority(String priority) 
    {
        this.priority = priority;
    }

    public String getPriority() 
    {
        return priority;
    }

    public void setUrgency(String urgency) 
    {
        this.urgency = urgency;
    }

    public String getUrgency() 
    {
        return urgency;
    }

    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("taskId", getTaskId())
            .append("projectId", getProjectId())
            .append("taskCode", getTaskCode())
            .append("taskName", getTaskName())
            .append("taskType", getTaskType())
            .append("assignedTeamId", getAssignedTeamId())
            .append("assignedUserId", getAssignedUserId())
            .append("assignerId", getAssignerId())
            .append("description", getDescription())
            .append("requirements", getRequirements())
            .append("checkItems", getCheckItems())
            .append("planStartTime", getPlanStartTime())
            .append("planEndTime", getPlanEndTime())
            .append("actualStartTime", getActualStartTime())
            .append("actualEndTime", getActualEndTime())
            .append("status", getStatus())
            .append("progress", getProgress())
            .append("workHours", getWorkHours())
            .append("actualHours", getActualHours())
            .append("resultDescription", getResultDescription())
            .append("qualityCheck", getQualityCheck())
            .append("priority", getPriority())
            .append("urgency", getUrgency())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
