package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 审批任务对象 approval_tasks
 * 
 * @author ruoyi
 * @date 2025-12-11
 */
public class ApprovalTasks extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 任务ID */
    private Long id;

    /** 审批实例ID */
    @Excel(name = "审批实例ID")
    private Long instanceId;

    /** 节点ID */
    @Excel(name = "节点ID")
    private Long nodeId;

    /** 审批人ID */
    @Excel(name = "审批人ID")
    private Long approverId;

    /** 审批人类型(主审/转审) */
    @Excel(name = "审批人类型(主审/转审)")
    private String approverType;

    /** 原审批人ID(转审时使用) */
    @Excel(name = "原审批人ID(转审时使用)")
    private Long originalApproverId;

    /** 任务状态 */
    @Excel(name = "任务状态")
    private String status;

    /** 截止时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "截止时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dueTime;

    /** 分配时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "分配时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date assignedTime;

    /** 处理时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "处理时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date handledTime;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdAt;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedAt;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setInstanceId(Long instanceId) 
    {
        this.instanceId = instanceId;
    }

    public Long getInstanceId() 
    {
        return instanceId;
    }

    public void setNodeId(Long nodeId) 
    {
        this.nodeId = nodeId;
    }

    public Long getNodeId() 
    {
        return nodeId;
    }

    public void setApproverId(Long approverId) 
    {
        this.approverId = approverId;
    }

    public Long getApproverId() 
    {
        return approverId;
    }

    public void setApproverType(String approverType) 
    {
        this.approverType = approverType;
    }

    public String getApproverType() 
    {
        return approverType;
    }

    public void setOriginalApproverId(Long originalApproverId) 
    {
        this.originalApproverId = originalApproverId;
    }

    public Long getOriginalApproverId() 
    {
        return originalApproverId;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setDueTime(Date dueTime) 
    {
        this.dueTime = dueTime;
    }

    public Date getDueTime() 
    {
        return dueTime;
    }

    public void setAssignedTime(Date assignedTime) 
    {
        this.assignedTime = assignedTime;
    }

    public Date getAssignedTime() 
    {
        return assignedTime;
    }

    public void setHandledTime(Date handledTime) 
    {
        this.handledTime = handledTime;
    }

    public Date getHandledTime() 
    {
        return handledTime;
    }

    public void setCreatedAt(Date createdAt) 
    {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() 
    {
        return createdAt;
    }

    public void setUpdatedAt(Date updatedAt) 
    {
        this.updatedAt = updatedAt;
    }

    public Date getUpdatedAt() 
    {
        return updatedAt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("instanceId", getInstanceId())
            .append("nodeId", getNodeId())
            .append("approverId", getApproverId())
            .append("approverType", getApproverType())
            .append("originalApproverId", getOriginalApproverId())
            .append("status", getStatus())
            .append("dueTime", getDueTime())
            .append("assignedTime", getAssignedTime())
            .append("handledTime", getHandledTime())
            .append("createdAt", getCreatedAt())
            .append("updatedAt", getUpdatedAt())
            .toString();
    }
}
