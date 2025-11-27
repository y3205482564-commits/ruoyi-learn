package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SpaceEquipment;

/**
 * 空间设备Mapper接口
 * 
 * @author ruoyi
 * @date 2025-11-26
 */
public interface SpaceEquipmentMapper 
{
    /**
     * 查询空间设备
     * 
     * @param equipmentId 空间设备主键
     * @return 空间设备
     */
    public SpaceEquipment selectSpaceEquipmentByEquipmentId(Long equipmentId);

    /**
     * 查询空间设备列表
     * 
     * @param spaceEquipment 空间设备
     * @return 空间设备集合
     */
    public List<SpaceEquipment> selectSpaceEquipmentList(SpaceEquipment spaceEquipment);

    /**
     * 新增空间设备
     * 
     * @param spaceEquipment 空间设备
     * @return 结果
     */
    public int insertSpaceEquipment(SpaceEquipment spaceEquipment);

    /**
     * 修改空间设备
     * 
     * @param spaceEquipment 空间设备
     * @return 结果
     */
    public int updateSpaceEquipment(SpaceEquipment spaceEquipment);

    /**
     * 删除空间设备
     * 
     * @param equipmentId 空间设备主键
     * @return 结果
     */
    public int deleteSpaceEquipmentByEquipmentId(Long equipmentId);

    /**
     * 批量删除空间设备
     * 
     * @param equipmentIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSpaceEquipmentByEquipmentIds(Long[] equipmentIds);
}
