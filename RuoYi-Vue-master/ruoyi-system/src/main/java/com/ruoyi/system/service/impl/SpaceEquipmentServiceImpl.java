package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SpaceEquipmentMapper;
import com.ruoyi.system.domain.SpaceEquipment;
import com.ruoyi.system.service.ISpaceEquipmentService;

/**
 * 空间设备Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-11-26
 */
@Service
public class SpaceEquipmentServiceImpl implements ISpaceEquipmentService 
{
    @Autowired
    private SpaceEquipmentMapper spaceEquipmentMapper;

    /**
     * 查询空间设备
     * 
     * @param equipmentId 空间设备主键
     * @return 空间设备
     */
    @Override
    public SpaceEquipment selectSpaceEquipmentByEquipmentId(Long equipmentId)
    {
        return spaceEquipmentMapper.selectSpaceEquipmentByEquipmentId(equipmentId);
    }

    /**
     * 查询空间设备列表
     * 
     * @param spaceEquipment 空间设备
     * @return 空间设备
     */
    @Override
    public List<SpaceEquipment> selectSpaceEquipmentList(SpaceEquipment spaceEquipment)
    {
        return spaceEquipmentMapper.selectSpaceEquipmentList(spaceEquipment);
    }

    /**
     * 新增空间设备
     * 
     * @param spaceEquipment 空间设备
     * @return 结果
     */
    @Override
    public int insertSpaceEquipment(SpaceEquipment spaceEquipment)
    {
        spaceEquipment.setCreateTime(DateUtils.getNowDate());
        return spaceEquipmentMapper.insertSpaceEquipment(spaceEquipment);
    }

    /**
     * 修改空间设备
     * 
     * @param spaceEquipment 空间设备
     * @return 结果
     */
    @Override
    public int updateSpaceEquipment(SpaceEquipment spaceEquipment)
    {
        spaceEquipment.setUpdateTime(DateUtils.getNowDate());
        return spaceEquipmentMapper.updateSpaceEquipment(spaceEquipment);
    }

    /**
     * 批量删除空间设备
     * 
     * @param equipmentIds 需要删除的空间设备主键
     * @return 结果
     */
    @Override
    public int deleteSpaceEquipmentByEquipmentIds(Long[] equipmentIds)
    {
        return spaceEquipmentMapper.deleteSpaceEquipmentByEquipmentIds(equipmentIds);
    }

    /**
     * 删除空间设备信息
     * 
     * @param equipmentId 空间设备主键
     * @return 结果
     */
    @Override
    public int deleteSpaceEquipmentByEquipmentId(Long equipmentId)
    {
        return spaceEquipmentMapper.deleteSpaceEquipmentByEquipmentId(equipmentId);
    }
}
