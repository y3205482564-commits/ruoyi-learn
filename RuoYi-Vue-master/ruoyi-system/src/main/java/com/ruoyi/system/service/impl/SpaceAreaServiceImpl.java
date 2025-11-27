package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SpaceAreaMapper;
import com.ruoyi.system.domain.SpaceArea;
import com.ruoyi.system.service.ISpaceAreaService;

/**
 * 空间区域Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-11-26
 */
@Service
public class SpaceAreaServiceImpl implements ISpaceAreaService 
{
    @Autowired
    private SpaceAreaMapper spaceAreaMapper;

    /**
     * 查询空间区域
     * 
     * @param areaId 空间区域主键
     * @return 空间区域
     */
    @Override
    public SpaceArea selectSpaceAreaByAreaId(Long areaId)
    {
        return spaceAreaMapper.selectSpaceAreaByAreaId(areaId);
    }

    /**
     * 查询空间区域列表
     * 
     * @param spaceArea 空间区域
     * @return 空间区域
     */
    @Override
    public List<SpaceArea> selectSpaceAreaList(SpaceArea spaceArea)
    {
        return spaceAreaMapper.selectSpaceAreaList(spaceArea);
    }

    /**
     * 新增空间区域
     * 
     * @param spaceArea 空间区域
     * @return 结果
     */
    @Override
    public int insertSpaceArea(SpaceArea spaceArea)
    {
        spaceArea.setCreateTime(DateUtils.getNowDate());
        return spaceAreaMapper.insertSpaceArea(spaceArea);
    }

    /**
     * 修改空间区域
     * 
     * @param spaceArea 空间区域
     * @return 结果
     */
    @Override
    public int updateSpaceArea(SpaceArea spaceArea)
    {
        spaceArea.setUpdateTime(DateUtils.getNowDate());
        return spaceAreaMapper.updateSpaceArea(spaceArea);
    }

    /**
     * 批量删除空间区域
     * 
     * @param areaIds 需要删除的空间区域主键
     * @return 结果
     */
    @Override
    public int deleteSpaceAreaByAreaIds(Long[] areaIds)
    {
        return spaceAreaMapper.deleteSpaceAreaByAreaIds(areaIds);
    }

    /**
     * 删除空间区域信息
     * 
     * @param areaId 空间区域主键
     * @return 结果
     */
    @Override
    public int deleteSpaceAreaByAreaId(Long areaId)
    {
        return spaceAreaMapper.deleteSpaceAreaByAreaId(areaId);
    }
}
