package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 任务分配记录对象 task_assignment
 * 
 * @author ruoyi
 * @date 2025-11-26
 */
public class TaskAssignment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 分配记录ID */
    private Long assignmentId;

    /** 任务ID */
    @Excel(name = "任务ID")
    private Long taskId;

    /** 分配人ID */
    @Excel(name = "分配人ID")
    private Long assignerId;

    /** 分配类型（user:用户 team:班组） */
    @Excel(name = "分配类型", readConverterExp = "u=ser:用户,t=eam:班组")
    private String assigneeType;

    /** 被分配对象ID */
    @Excel(name = "被分配对象ID")
    private Long assigneeId;

    /** 分配时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "分配时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date assignmentTime;

    /** 截止时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "截止时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date deadline;

    /** 分配说明 */
    @Excel(name = "分配说明")
    private String instructions;

    /** 状态（active:有效 cancelled:已取消 completed:已完成） */
    @Excel(name = "状态", readConverterExp = "a=ctive:有效,c=ancelled:已取消,c=ompleted:已完成")
    private String status;

    public void setAssignmentId(Long assignmentId) 
    {
        this.assignmentId = assignmentId;
    }

    public Long getAssignmentId() 
    {
        return assignmentId;
    }

    public void setTaskId(Long taskId) 
    {
        this.taskId = taskId;
    }

    public Long getTaskId() 
    {
        return taskId;
    }

    public void setAssignerId(Long assignerId) 
    {
        this.assignerId = assignerId;
    }

    public Long getAssignerId() 
    {
        return assignerId;
    }

    public void setAssigneeType(String assigneeType) 
    {
        this.assigneeType = assigneeType;
    }

    public String getAssigneeType() 
    {
        return assigneeType;
    }

    public void setAssigneeId(Long assigneeId) 
    {
        this.assigneeId = assigneeId;
    }

    public Long getAssigneeId() 
    {
        return assigneeId;
    }

    public void setAssignmentTime(Date assignmentTime) 
    {
        this.assignmentTime = assignmentTime;
    }

    public Date getAssignmentTime() 
    {
        return assignmentTime;
    }

    public void setDeadline(Date deadline) 
    {
        this.deadline = deadline;
    }

    public Date getDeadline() 
    {
        return deadline;
    }

    public void setInstructions(String instructions) 
    {
        this.instructions = instructions;
    }

    public String getInstructions() 
    {
        return instructions;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("assignmentId", getAssignmentId())
            .append("taskId", getTaskId())
            .append("assignerId", getAssignerId())
            .append("assigneeType", getAssigneeType())
            .append("assigneeId", getAssigneeId())
            .append("assignmentTime", getAssignmentTime())
            .append("deadline", getDeadline())
            .append("instructions", getInstructions())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
