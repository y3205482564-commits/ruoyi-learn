package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 空间设备对象 space_equipment
 * 
 * @author ruoyi
 * @date 2025-11-26
 */
public class SpaceEquipment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 设备ID */
    private Long equipmentId;

    /** 设备编码 */
    @Excel(name = "设备编码")
    private String equipmentCode;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String equipmentName;

    /** 设备类型 */
    @Excel(name = "设备类型")
    private String equipmentType;

    /** 所在区域ID */
    @Excel(name = "所在区域ID")
    private Long areaId;

    /** 设备型号 */
    @Excel(name = "设备型号")
    private String model;

    /** 规格参数 */
    @Excel(name = "规格参数")
    private String specification;

    /** 生产厂家 */
    @Excel(name = "生产厂家")
    private String manufacturer;

    /** 安装日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "安装日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date installDate;

    /** 状态（normal:正常 maintenance:维修中 fault:故障 scrapped:报废） */
    @Excel(name = "状态", readConverterExp = "n=ormal:正常,m=aintenance:维修中,f=ault:故障,s=crapped:报废")
    private String status;

    /** 保养周期（天） */
    @Excel(name = "保养周期", readConverterExp = "天=")
    private Long maintenanceCycle;

    /** 上次保养日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上次保养日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastMaintenanceDate;

    /** 下次保养日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "下次保养日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date nextMaintenanceDate;

    /** 负责人用户ID */
    @Excel(name = "负责人用户ID")
    private Long managerId;

    /** 负责班组ID */
    @Excel(name = "负责班组ID")
    private Long teamId;

    /** 设备描述 */
    @Excel(name = "设备描述")
    private String description;

    /** 删除标志（0存在 2删除） */
    private String delFlag;

    public void setEquipmentId(Long equipmentId) 
    {
        this.equipmentId = equipmentId;
    }

    public Long getEquipmentId() 
    {
        return equipmentId;
    }

    public void setEquipmentCode(String equipmentCode) 
    {
        this.equipmentCode = equipmentCode;
    }

    public String getEquipmentCode() 
    {
        return equipmentCode;
    }

    public void setEquipmentName(String equipmentName) 
    {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentName() 
    {
        return equipmentName;
    }

    public void setEquipmentType(String equipmentType) 
    {
        this.equipmentType = equipmentType;
    }

    public String getEquipmentType() 
    {
        return equipmentType;
    }

    public void setAreaId(Long areaId) 
    {
        this.areaId = areaId;
    }

    public Long getAreaId() 
    {
        return areaId;
    }

    public void setModel(String model) 
    {
        this.model = model;
    }

    public String getModel() 
    {
        return model;
    }

    public void setSpecification(String specification) 
    {
        this.specification = specification;
    }

    public String getSpecification() 
    {
        return specification;
    }

    public void setManufacturer(String manufacturer) 
    {
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() 
    {
        return manufacturer;
    }

    public void setInstallDate(Date installDate) 
    {
        this.installDate = installDate;
    }

    public Date getInstallDate() 
    {
        return installDate;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setMaintenanceCycle(Long maintenanceCycle) 
    {
        this.maintenanceCycle = maintenanceCycle;
    }

    public Long getMaintenanceCycle() 
    {
        return maintenanceCycle;
    }

    public void setLastMaintenanceDate(Date lastMaintenanceDate) 
    {
        this.lastMaintenanceDate = lastMaintenanceDate;
    }

    public Date getLastMaintenanceDate() 
    {
        return lastMaintenanceDate;
    }

    public void setNextMaintenanceDate(Date nextMaintenanceDate) 
    {
        this.nextMaintenanceDate = nextMaintenanceDate;
    }

    public Date getNextMaintenanceDate() 
    {
        return nextMaintenanceDate;
    }

    public void setManagerId(Long managerId) 
    {
        this.managerId = managerId;
    }

    public Long getManagerId() 
    {
        return managerId;
    }

    public void setTeamId(Long teamId) 
    {
        this.teamId = teamId;
    }

    public Long getTeamId() 
    {
        return teamId;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
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
            .append("equipmentId", getEquipmentId())
            .append("equipmentCode", getEquipmentCode())
            .append("equipmentName", getEquipmentName())
            .append("equipmentType", getEquipmentType())
            .append("areaId", getAreaId())
            .append("model", getModel())
            .append("specification", getSpecification())
            .append("manufacturer", getManufacturer())
            .append("installDate", getInstallDate())
            .append("status", getStatus())
            .append("maintenanceCycle", getMaintenanceCycle())
            .append("lastMaintenanceDate", getLastMaintenanceDate())
            .append("nextMaintenanceDate", getNextMaintenanceDate())
            .append("managerId", getManagerId())
            .append("teamId", getTeamId())
            .append("description", getDescription())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
