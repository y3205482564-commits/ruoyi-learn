package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 审批记录对象 approval_records
 * 
 * @author ruoyi
 * @date 2025-12-11
 */
public class ApprovalRecords extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 记录ID */
    private Long id;

    /** 审批实例ID */
    @Excel(name = "审批实例ID")
    private Long instanceId;

    /** 节点ID */
    @Excel(name = "节点ID")
    private Long nodeId;

    /** 对应任务ID */
    @Excel(name = "对应任务ID")
    private Long taskId;

    /** 审批人ID */
    @Excel(name = "审批人ID")
    private Long approverId;

    /** 审批动作 */
    @Excel(name = "审批动作")
    private String action;

    /** 审批意见 */
    @Excel(name = "审批意见")
    private String comment;

    /** 表单快照 */
    @Excel(name = "表单快照")
    private String formSnapshot;

    /** 下一节点ID */
    @Excel(name = "下一节点ID")
    private Long nextNodeId;

    /** 操作时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "操作时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date operationTime;

    /** 操作IP地址 */
    @Excel(name = "操作IP地址")
    private String ipAddress;

    /** 用户代理 */
    @Excel(name = "用户代理")
    private String userAgent;

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

    public void setTaskId(Long taskId) 
    {
        this.taskId = taskId;
    }

    public Long getTaskId() 
    {
        return taskId;
    }

    public void setApproverId(Long approverId) 
    {
        this.approverId = approverId;
    }

    public Long getApproverId() 
    {
        return approverId;
    }

    public void setAction(String action) 
    {
        this.action = action;
    }

    public String getAction() 
    {
        return action;
    }

    public void setComment(String comment) 
    {
        this.comment = comment;
    }

    public String getComment() 
    {
        return comment;
    }

    public void setFormSnapshot(String formSnapshot) 
    {
        this.formSnapshot = formSnapshot;
    }

    public String getFormSnapshot() 
    {
        return formSnapshot;
    }

    public void setNextNodeId(Long nextNodeId) 
    {
        this.nextNodeId = nextNodeId;
    }

    public Long getNextNodeId() 
    {
        return nextNodeId;
    }

    public void setOperationTime(Date operationTime) 
    {
        this.operationTime = operationTime;
    }

    public Date getOperationTime() 
    {
        return operationTime;
    }

    public void setIpAddress(String ipAddress) 
    {
        this.ipAddress = ipAddress;
    }

    public String getIpAddress() 
    {
        return ipAddress;
    }

    public void setUserAgent(String userAgent) 
    {
        this.userAgent = userAgent;
    }

    public String getUserAgent() 
    {
        return userAgent;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("instanceId", getInstanceId())
            .append("nodeId", getNodeId())
            .append("taskId", getTaskId())
            .append("approverId", getApproverId())
            .append("action", getAction())
            .append("comment", getComment())
            .append("formSnapshot", getFormSnapshot())
            .append("nextNodeId", getNextNodeId())
            .append("operationTime", getOperationTime())
            .append("ipAddress", getIpAddress())
            .append("userAgent", getUserAgent())
            .toString();
    }
}
