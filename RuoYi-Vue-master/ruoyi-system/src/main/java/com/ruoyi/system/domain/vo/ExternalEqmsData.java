package com.ruoyi.system.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 外部系统EQMS数据对象
 * 
 * @author ruoyi
 * @date 2025-12-17
 */
public class ExternalEqmsData extends BaseEntity
{
    private static final long serialVersionUID = 1L;

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

    /** 外部系统标识 */
    @Excel(name = "外部系统标识")
    private String externalSystemId;

    /** 数据来源 */
    @Excel(name = "数据来源")
    private String dataSource;

    public String getCommissionNo() 
    {
        return commissionNo;
    }

    public void setCommissionNo(String commissionNo) 
    {
        this.commissionNo = commissionNo;
    }

    public String getPlanNo() 
    {
        return planNo;
    }

    public void setPlanNo(String planNo) 
    {
        this.planNo = planNo;
    }

    public String getStandardItemNo() 
    {
        return standardItemNo;
    }

    public void setStandardItemNo(String standardItemNo) 
    {
        this.standardItemNo = standardItemNo;
    }

    public String getEquipmentName() 
    {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) 
    {
        this.equipmentName = equipmentName;
    }

    public String getProjectName() 
    {
        return projectName;
    }

    public void setProjectName(String projectName) 
    {
        this.projectName = projectName;
    }

    public Date getExpectedStartDate() 
    {
        return expectedStartDate;
    }

    public void setExpectedStartDate(Date expectedStartDate) 
    {
        this.expectedStartDate = expectedStartDate;
    }

    public Date getExpectedEndDate() 
    {
        return expectedEndDate;
    }

    public void setExpectedEndDate(Date expectedEndDate) 
    {
        this.expectedEndDate = expectedEndDate;
    }

    public String getRepairReason() 
    {
        return repairReason;
    }

    public void setRepairReason(String repairReason) 
    {
        this.repairReason = repairReason;
    }

    public String getConstructionTeamCode() 
    {
        return constructionTeamCode;
    }

    public void setConstructionTeamCode(String constructionTeamCode) 
    {
        this.constructionTeamCode = constructionTeamCode;
    }

    public String getConstructionTeamName() 
    {
        return constructionTeamName;
    }

    public void setConstructionTeamName(String constructionTeamName) 
    {
        this.constructionTeamName = constructionTeamName;
    }

    public String getProjectCategory() 
    {
        return projectCategory;
    }

    public void setProjectCategory(String projectCategory) 
    {
        this.projectCategory = projectCategory;
    }

    public Date getCommissionDate() 
    {
        return commissionDate;
    }

    public void setCommissionDate(Date commissionDate) 
    {
        this.commissionDate = commissionDate;
    }

    public String getCommissioner() 
    {
        return commissioner;
    }

    public void setCommissioner(String commissioner) 
    {
        this.commissioner = commissioner;
    }

    public String getInspectorName() 
    {
        return inspectorName;
    }

    public void setInspectorName(String inspectorName) 
    {
        this.inspectorName = inspectorName;
    }

    public String getExternalSystemId() 
    {
        return externalSystemId;
    }

    public void setExternalSystemId(String externalSystemId) 
    {
        this.externalSystemId = externalSystemId;
    }

    public String getDataSource() 
    {
        return dataSource;
    }

    public void setDataSource(String dataSource) 
    {
        this.dataSource = dataSource;
    }
}