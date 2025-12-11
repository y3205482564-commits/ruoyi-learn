package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 审批实例对象 approval_instances
 * 
 * @author ruoyi
 * @date 2025-12-11
 */
public class ApprovalInstances extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 实例ID */
    private Long id;

    /** 审批单号 */
    @Excel(name = "审批单号")
    private String instanceNo;

    /** 流程ID */
    @Excel(name = "流程ID")
    private Long processId;

    /** 审批标题 */
    @Excel(name = "审批标题")
    private String title;

    /** 申请人ID */
    @Excel(name = "申请人ID")
    private Long applicantId;

    /** 申请人部门ID */
    @Excel(name = "申请人部门ID")
    private Long applicantDeptId;

    /** 表单数据(JSON格式) */
    @Excel(name = "表单数据(JSON格式)")
    private String formData;

    /** 附件信息 */
    @Excel(name = "附件信息")
    private String attachments;

    /** 当前状态 */
    @Excel(name = "当前状态")
    private String currentStatus;

    /** 当前节点ID */
    @Excel(name = "当前节点ID")
    private Long currentNodeId;

    /** 优先级 */
    @Excel(name = "优先级")
    private String priority;

    /** 提交时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "提交时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date submitTime;

    /** 完成时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "完成时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date completeTime;

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

    public void setInstanceNo(String instanceNo) 
    {
        this.instanceNo = instanceNo;
    }

    public String getInstanceNo() 
    {
        return instanceNo;
    }

    public void setProcessId(Long processId) 
    {
        this.processId = processId;
    }

    public Long getProcessId() 
    {
        return processId;
    }

    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }

    public void setApplicantId(Long applicantId) 
    {
        this.applicantId = applicantId;
    }

    public Long getApplicantId() 
    {
        return applicantId;
    }

    public void setApplicantDeptId(Long applicantDeptId) 
    {
        this.applicantDeptId = applicantDeptId;
    }

    public Long getApplicantDeptId() 
    {
        return applicantDeptId;
    }

    public void setFormData(String formData) 
    {
        this.formData = formData;
    }

    public String getFormData() 
    {
        return formData;
    }

    public void setAttachments(String attachments) 
    {
        this.attachments = attachments;
    }

    public String getAttachments() 
    {
        return attachments;
    }

    public void setCurrentStatus(String currentStatus) 
    {
        this.currentStatus = currentStatus;
    }

    public String getCurrentStatus() 
    {
        return currentStatus;
    }

    public void setCurrentNodeId(Long currentNodeId) 
    {
        this.currentNodeId = currentNodeId;
    }

    public Long getCurrentNodeId() 
    {
        return currentNodeId;
    }

    public void setPriority(String priority) 
    {
        this.priority = priority;
    }

    public String getPriority() 
    {
        return priority;
    }

    public void setSubmitTime(Date submitTime) 
    {
        this.submitTime = submitTime;
    }

    public Date getSubmitTime() 
    {
        return submitTime;
    }

    public void setCompleteTime(Date completeTime) 
    {
        this.completeTime = completeTime;
    }

    public Date getCompleteTime() 
    {
        return completeTime;
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
            .append("instanceNo", getInstanceNo())
            .append("processId", getProcessId())
            .append("title", getTitle())
            .append("applicantId", getApplicantId())
            .append("applicantDeptId", getApplicantDeptId())
            .append("formData", getFormData())
            .append("attachments", getAttachments())
            .append("currentStatus", getCurrentStatus())
            .append("currentNodeId", getCurrentNodeId())
            .append("priority", getPriority())
            .append("submitTime", getSubmitTime())
            .append("completeTime", getCompleteTime())
            .append("createdAt", getCreatedAt())
            .append("updatedAt", getUpdatedAt())
            .toString();
    }
}
