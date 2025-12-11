package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 审批节点对象 approval_nodes
 * 
 * @author ruoyi
 * @date 2025-12-11
 */
public class ApprovalNodes extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 节点ID */
    private Long id;

    /** 所属流程ID */
    @Excel(name = "所属流程ID")
    private Long processId;

    /** 节点名称 */
    @Excel(name = "节点名称")
    private String nodeName;

    /** 节点顺序(从1开始) */
    @Excel(name = "节点顺序(从1开始)")
    private Long nodeOrder;

    /** 审批人类型 */
    @Excel(name = "审批人类型")
    private String approverType;

    /** 审批人值(用户ID、角色等) */
    @Excel(name = "审批人值(用户ID、角色等)")
    private String approverValue;

    /** 是否必须审批 */
    @Excel(name = "是否必须审批")
    private Integer isRequired;

    /** 是否允许转审 */
    @Excel(name = "是否允许转审")
    private Integer canDelegate;

    /** 审批超时时间(小时) */
    @Excel(name = "审批超时时间(小时)")
    private Long timeoutHours;

    /** 审批条件(JSON格式) */
    @Excel(name = "审批条件(JSON格式)")
    private String conditions;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdAt;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setProcessId(Long processId) 
    {
        this.processId = processId;
    }

    public Long getProcessId() 
    {
        return processId;
    }

    public void setNodeName(String nodeName) 
    {
        this.nodeName = nodeName;
    }

    public String getNodeName() 
    {
        return nodeName;
    }

    public void setNodeOrder(Long nodeOrder) 
    {
        this.nodeOrder = nodeOrder;
    }

    public Long getNodeOrder() 
    {
        return nodeOrder;
    }

    public void setApproverType(String approverType) 
    {
        this.approverType = approverType;
    }

    public String getApproverType() 
    {
        return approverType;
    }

    public void setApproverValue(String approverValue) 
    {
        this.approverValue = approverValue;
    }

    public String getApproverValue() 
    {
        return approverValue;
    }

    public void setIsRequired(Integer isRequired) 
    {
        this.isRequired = isRequired;
    }

    public Integer getIsRequired() 
    {
        return isRequired;
    }

    public void setCanDelegate(Integer canDelegate) 
    {
        this.canDelegate = canDelegate;
    }

    public Integer getCanDelegate() 
    {
        return canDelegate;
    }

    public void setTimeoutHours(Long timeoutHours) 
    {
        this.timeoutHours = timeoutHours;
    }

    public Long getTimeoutHours() 
    {
        return timeoutHours;
    }

    public void setConditions(String conditions) 
    {
        this.conditions = conditions;
    }

    public String getConditions() 
    {
        return conditions;
    }

    public void setCreatedAt(Date createdAt) 
    {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() 
    {
        return createdAt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("processId", getProcessId())
            .append("nodeName", getNodeName())
            .append("nodeOrder", getNodeOrder())
            .append("approverType", getApproverType())
            .append("approverValue", getApproverValue())
            .append("isRequired", getIsRequired())
            .append("canDelegate", getCanDelegate())
            .append("timeoutHours", getTimeoutHours())
            .append("conditions", getConditions())
            .append("createdAt", getCreatedAt())
            .toString();
    }
}
