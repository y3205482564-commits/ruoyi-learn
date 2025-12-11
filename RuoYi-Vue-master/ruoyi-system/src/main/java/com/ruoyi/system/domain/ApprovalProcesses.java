package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 审批流程定义对象 approval_processes
 * 
 * @author ruoyi
 * @date 2025-12-11
 */
public class ApprovalProcesses extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 流程ID */
    private Long id;

    /** 流程名称 */
    @Excel(name = "流程名称")
    private String processName;

    /** 流程编码 */
    @Excel(name = "流程编码")
    private String processCode;

    /** 流程描述 */
    @Excel(name = "流程描述")
    private String description;

    /** 流程分类(如：请假、报销等) */
    @Excel(name = "流程分类(如：请假、报销等)")
    private String category;

    /** 流程版本 */
    @Excel(name = "流程版本")
    private Long version;

    /** 是否启用(1启用，0停用) */
    @Excel(name = "是否启用(1启用，0停用)")
    private Integer isActive;

    /** 创建人ID */
    @Excel(name = "创建人ID")
    private Long creatorId;

    /** 最少审批人数 */
    @Excel(name = "最少审批人数")
    private Long minApprovers;

    /** 审批策略 */
    @Excel(name = "审批策略")
    private String approvalStrategy;

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

    public void setProcessName(String processName) 
    {
        this.processName = processName;
    }

    public String getProcessName() 
    {
        return processName;
    }

    public void setProcessCode(String processCode) 
    {
        this.processCode = processCode;
    }

    public String getProcessCode() 
    {
        return processCode;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

    public void setCategory(String category) 
    {
        this.category = category;
    }

    public String getCategory() 
    {
        return category;
    }

    public void setVersion(Long version) 
    {
        this.version = version;
    }

    public Long getVersion() 
    {
        return version;
    }

    public void setIsActive(Integer isActive) 
    {
        this.isActive = isActive;
    }

    public Integer getIsActive() 
    {
        return isActive;
    }

    public void setCreatorId(Long creatorId) 
    {
        this.creatorId = creatorId;
    }

    public Long getCreatorId() 
    {
        return creatorId;
    }

    public void setMinApprovers(Long minApprovers) 
    {
        this.minApprovers = minApprovers;
    }

    public Long getMinApprovers() 
    {
        return minApprovers;
    }

    public void setApprovalStrategy(String approvalStrategy) 
    {
        this.approvalStrategy = approvalStrategy;
    }

    public String getApprovalStrategy() 
    {
        return approvalStrategy;
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
            .append("processName", getProcessName())
            .append("processCode", getProcessCode())
            .append("description", getDescription())
            .append("category", getCategory())
            .append("version", getVersion())
            .append("isActive", getIsActive())
            .append("creatorId", getCreatorId())
            .append("minApprovers", getMinApprovers())
            .append("approvalStrategy", getApprovalStrategy())
            .append("createdAt", getCreatedAt())
            .append("updatedAt", getUpdatedAt())
            .toString();
    }
}
