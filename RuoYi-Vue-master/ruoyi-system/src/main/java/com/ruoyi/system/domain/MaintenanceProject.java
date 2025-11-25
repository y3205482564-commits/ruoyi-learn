package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 检修项目对象 maintenance_project
 * 
 * @author ruoyi
 * @date 2025-11-26
 */
public class MaintenanceProject extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 项目ID */
    private Long projectId;

    /** 项目编号 */
    @Excel(name = "项目编号")
    private String projectCode;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

    /** 项目类型 */
    @Excel(name = "项目类型")
    private String projectType;

    /** 负责部门ID */
    @Excel(name = "负责部门ID")
    private Long deptId;

    /** 负责班组ID */
    @Excel(name = "负责班组ID")
    private Long teamId;

    /** 项目负责人用户ID */
    @Excel(name = "项目负责人用户ID")
    private Long projectLeader;

    /** 项目描述 */
    @Excel(name = "项目描述")
    private String description;

    /** 检修地点 */
    @Excel(name = "检修地点")
    private String location;

    /** 优先级（1低 2中 3高） */
    @Excel(name = "优先级", readConverterExp = "1=低,2=中,3=高")
    private String priority;

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

    /** 状态（draft:草稿 published:已发布 assigned:已分配 in_progress:进行中 completed:已完成 cancelled:已取消） */
    @Excel(name = "状态", readConverterExp = "d=raft:草稿,p=ublished:已发布,a=ssigned:已分配,i=n_progress:进行中,c=ompleted:已完成,c=ancelled:已取消")
    private String status;

    /** 进度百分比 */
    @Excel(name = "进度百分比")
    private Long progress;

    /** 预算金额 */
    @Excel(name = "预算金额")
    private BigDecimal budgetAmount;

    /** 实际金额 */
    @Excel(name = "实际金额")
    private BigDecimal actualAmount;

    /** 计划工时 */
    @Excel(name = "计划工时")
    private BigDecimal manHours;

    /** 实际工时 */
    @Excel(name = "实际工时")
    private BigDecimal actualManHours;

    /** 安全等级（general:一般 important:重要 critical:关键） */
    @Excel(name = "安全等级", readConverterExp = "g=eneral:一般,i=mportant:重要,c=ritical:关键")
    private String safetyLevel;

    /** 风险评估 */
    @Excel(name = "风险评估")
    private String riskAssessment;

    /** 删除标志（0存在 2删除） */
    private String delFlag;

    public void setProjectId(Long projectId) 
    {
        this.projectId = projectId;
    }

    public Long getProjectId() 
    {
        return projectId;
    }

    public void setProjectCode(String projectCode) 
    {
        this.projectCode = projectCode;
    }

    public String getProjectCode() 
    {
        return projectCode;
    }

    public void setProjectName(String projectName) 
    {
        this.projectName = projectName;
    }

    public String getProjectName() 
    {
        return projectName;
    }

    public void setProjectType(String projectType) 
    {
        this.projectType = projectType;
    }

    public String getProjectType() 
    {
        return projectType;
    }

    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }

    public void setTeamId(Long teamId) 
    {
        this.teamId = teamId;
    }

    public Long getTeamId() 
    {
        return teamId;
    }

    public void setProjectLeader(Long projectLeader) 
    {
        this.projectLeader = projectLeader;
    }

    public Long getProjectLeader() 
    {
        return projectLeader;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

    public void setLocation(String location) 
    {
        this.location = location;
    }

    public String getLocation() 
    {
        return location;
    }

    public void setPriority(String priority) 
    {
        this.priority = priority;
    }

    public String getPriority() 
    {
        return priority;
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

    public void setBudgetAmount(BigDecimal budgetAmount) 
    {
        this.budgetAmount = budgetAmount;
    }

    public BigDecimal getBudgetAmount() 
    {
        return budgetAmount;
    }

    public void setActualAmount(BigDecimal actualAmount) 
    {
        this.actualAmount = actualAmount;
    }

    public BigDecimal getActualAmount() 
    {
        return actualAmount;
    }

    public void setManHours(BigDecimal manHours) 
    {
        this.manHours = manHours;
    }

    public BigDecimal getManHours() 
    {
        return manHours;
    }

    public void setActualManHours(BigDecimal actualManHours) 
    {
        this.actualManHours = actualManHours;
    }

    public BigDecimal getActualManHours() 
    {
        return actualManHours;
    }

    public void setSafetyLevel(String safetyLevel) 
    {
        this.safetyLevel = safetyLevel;
    }

    public String getSafetyLevel() 
    {
        return safetyLevel;
    }

    public void setRiskAssessment(String riskAssessment) 
    {
        this.riskAssessment = riskAssessment;
    }

    public String getRiskAssessment() 
    {
        return riskAssessment;
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
            .append("projectId", getProjectId())
            .append("projectCode", getProjectCode())
            .append("projectName", getProjectName())
            .append("projectType", getProjectType())
            .append("deptId", getDeptId())
            .append("teamId", getTeamId())
            .append("projectLeader", getProjectLeader())
            .append("description", getDescription())
            .append("location", getLocation())
            .append("priority", getPriority())
            .append("planStartTime", getPlanStartTime())
            .append("planEndTime", getPlanEndTime())
            .append("actualStartTime", getActualStartTime())
            .append("actualEndTime", getActualEndTime())
            .append("status", getStatus())
            .append("progress", getProgress())
            .append("budgetAmount", getBudgetAmount())
            .append("actualAmount", getActualAmount())
            .append("manHours", getManHours())
            .append("actualManHours", getActualManHours())
            .append("safetyLevel", getSafetyLevel())
            .append("riskAssessment", getRiskAssessment())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
