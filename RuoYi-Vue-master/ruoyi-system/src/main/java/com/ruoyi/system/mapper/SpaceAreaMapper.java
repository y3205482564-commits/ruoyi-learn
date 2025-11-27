package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SpaceArea;

/**
 * 空间区域Mapper接口
 * 
 * @author ruoyi
 * @date 2025-11-26
 */
public interface SpaceAreaMapper 
{
    /**
     * 查询空间区域
     * 
     * @param areaId 空间区域主键
     * @return 空间区域
     */
    public SpaceArea selectSpaceAreaByAreaId(Long areaId);

    /**
     * 查询空间区域列表
     * 
     * @param spaceArea 空间区域
     * @return 空间区域集合
     */
    public List<SpaceArea> selectSpaceAreaList(SpaceArea spaceArea);

    /**
     * 新增空间区域
     * 
     * @param spaceArea 空间区域
     * @return 结果
     */
    public int insertSpaceArea(SpaceArea spaceArea);

    /**
     * 修改空间区域
     * 
     * @param spaceArea 空间区域
     * @return 结果
     */
    public int updateSpaceArea(SpaceArea spaceArea);

    /**
     * 删除空间区域
     * 
     * @param areaId 空间区域主键
     * @return 结果
     */
    public int deleteSpaceAreaByAreaId(Long areaId);

    /**
     * 批量删除空间区域
     * 
     * @param areaIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSpaceAreaByAreaIds(Long[] areaIds);
}
