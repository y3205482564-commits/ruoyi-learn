package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 班组信息对象 sys_team
 * 
 * @author ruoyi
 * @date 2025-11-26
 */
public class SysTeam extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 班组ID */
    private Long teamId;

    /** 班组名称 */
    @Excel(name = "班组名称")
    private String teamName;

    /** 班组编码 */
    @Excel(name = "班组编码")
    private String teamCode;

    /** 所属部门ID */
    @Excel(name = "所属部门ID")
    private Long deptId;

    /** 班组长用户ID */
    @Excel(name = "班组长用户ID")
    private Long teamLeader;

    /** 班组描述 */
    @Excel(name = "班组描述")
    private String description;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String contactInfo;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 删除标志（0存在 2删除） */
    private String delFlag;

    public void setTeamId(Long teamId) 
    {
        this.teamId = teamId;
    }

    public Long getTeamId() 
    {
        return teamId;
    }

    public void setTeamName(String teamName) 
    {
        this.teamName = teamName;
    }

    public String getTeamName() 
    {
        return teamName;
    }

    public void setTeamCode(String teamCode) 
    {
        this.teamCode = teamCode;
    }

    public String getTeamCode() 
    {
        return teamCode;
    }

    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }

    public void setTeamLeader(Long teamLeader) 
    {
        this.teamLeader = teamLeader;
    }

    public Long getTeamLeader() 
    {
        return teamLeader;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

    public void setContactInfo(String contactInfo) 
    {
        this.contactInfo = contactInfo;
    }

    public String getContactInfo() 
    {
        return contactInfo;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
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
            .append("teamId", getTeamId())
            .append("teamName", getTeamName())
            .append("teamCode", getTeamCode())
            .append("deptId", getDeptId())
            .append("teamLeader", getTeamLeader())
            .append("description", getDescription())
            .append("contactInfo", getContactInfo())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
