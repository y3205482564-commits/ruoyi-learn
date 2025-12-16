package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * EQMS委托单信息对象 eqms_commission_order
 * 
 * @author ruoyi
 * @date 2025-12-16
 */
public class EqmsCommissionOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 委托单编号 */
    @Excel(name = "委托单编号")
    private String commissionNo;

    /** 计划编号 */
    @Excel(name = "计划编号")
    private String planNo;

    /** 标准项目编号 */
    @Excel(name = "标准项目编号")
    private String standardItemNo;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String equipmentName;

    /** 工程项目名称 */
    @Excel(name = "工程项目名称")
    private String projectName;

    /** 预计施工日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "预计施工日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date expectedStartDate;

    /** 预计完工日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "预计完工日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date expectedEndDate;

    /** 请修原因 */
    @Excel(name = "请修原因")
    private String repairReason;

    /** 施工班代码 */
    @Excel(name = "施工班代码")
    private String constructionTeamCode;

    /** 施工班名称 */
    @Excel(name = "施工班名称")
    private String constructionTeamName;

    /** 项目类别 */
    @Excel(name = "项目类别")
    private String projectCategory;

    /** 委托日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "委托日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date commissionDate;

    /** 委托人 */
    @Excel(name = "委托人")
    private String commissioner;

    /** 点检姓名 */
    @Excel(name = "点检姓名")
    private String inspectorName;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 同步状态（0未处理 1已接收 2处理中 3已完成 4失败） */
    @Excel(name = "同步状态", readConverterExp = "0=未处理,1=已接收,2=处理中,3=已完成,4=失败")
    private String syncStatus;

    /** 同步时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "同步时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date syncTime;

    /** 同步消息 */
    @Excel(name = "同步消息")
    private String syncMessage;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setCommissionNo(String commissionNo) 
    {
        this.commissionNo = commissionNo;
    }

    public String getCommissionNo() 
    {
        return commissionNo;
    }

    public void setPlanNo(String planNo) 
    {
        this.planNo = planNo;
    }

    public String getPlanNo() 
    {
        return planNo;
    }

    public void setStandardItemNo(String standardItemNo) 
    {
        this.standardItemNo = standardItemNo;
    }

    public String getStandardItemNo() 
    {
        return standardItemNo;
    }

    public void setEquipmentName(String equipmentName) 
    {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentName() 
    {
        return equipmentName;
    }

    public void setProjectName(String projectName) 
    {
        this.projectName = projectName;
    }

    public String getProjectName() 
    {
        return projectName;
    }

    public void setExpectedStartDate(Date expectedStartDate) 
    {
        this.expectedStartDate = expectedStartDate;
    }

    public Date getExpectedStartDate() 
    {
        return expectedStartDate;
    }

    public void setExpectedEndDate(Date expectedEndDate) 
    {
        this.expectedEndDate = expectedEndDate;
    }

    public Date getExpectedEndDate() 
    {
        return expectedEndDate;
    }

    public void setRepairReason(String repairReason) 
    {
        this.repairReason = repairReason;
    }

    public String getRepairReason() 
    {
        return repairReason;
    }

    public void setConstructionTeamCode(String constructionTeamCode) 
    {
        this.constructionTeamCode = constructionTeamCode;
    }

    public String getConstructionTeamCode() 
    {
        return constructionTeamCode;
    }

    public void setConstructionTeamName(String constructionTeamName) 
    {
        this.constructionTeamName = constructionTeamName;
    }

    public String getConstructionTeamName() 
    {
        return constructionTeamName;
    }

    public void setProjectCategory(String projectCategory) 
    {
        this.projectCategory = projectCategory;
    }

    public String getProjectCategory() 
    {
        return projectCategory;
    }

    public void setCommissionDate(Date commissionDate) 
    {
        this.commissionDate = commissionDate;
    }

    public Date getCommissionDate() 
    {
        return commissionDate;
    }

    public void setCommissioner(String commissioner) 
    {
        this.commissioner = commissioner;
    }

    public String getCommissioner() 
    {
        return commissioner;
    }

    public void setInspectorName(String inspectorName) 
    {
        this.inspectorName = inspectorName;
    }

    public String getInspectorName() 
    {
        return inspectorName;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setSyncStatus(String syncStatus) 
    {
        this.syncStatus = syncStatus;
    }

    public String getSyncStatus() 
    {
        return syncStatus;
    }

    public void setSyncTime(Date syncTime) 
    {
        this.syncTime = syncTime;
    }

    public Date getSyncTime() 
    {
        return syncTime;
    }

    public void setSyncMessage(String syncMessage) 
    {
        this.syncMessage = syncMessage;
    }

    public String getSyncMessage() 
    {
        return syncMessage;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("commissionNo", getCommissionNo())
            .append("planNo", getPlanNo())
            .append("standardItemNo", getStandardItemNo())
            .append("equipmentName", getEquipmentName())
            .append("projectName", getProjectName())
            .append("expectedStartDate", getExpectedStartDate())
            .append("expectedEndDate", getExpectedEndDate())
            .append("repairReason", getRepairReason())
            .append("constructionTeamCode", getConstructionTeamCode())
            .append("constructionTeamName", getConstructionTeamName())
            .append("projectCategory", getProjectCategory())
            .append("commissionDate", getCommissionDate())
            .append("commissioner", getCommissioner())
            .append("inspectorName", getInspectorName())
            .append("status", getStatus())
            .append("syncStatus", getSyncStatus())
            .append("syncTime", getSyncTime())
            .append("syncMessage", getSyncMessage())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
