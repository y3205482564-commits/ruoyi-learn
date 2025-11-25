package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.MaintenanceProjectMapper;
import com.ruoyi.system.domain.MaintenanceProject;
import com.ruoyi.system.service.IMaintenanceProjectService;

/**
 * 检修项目Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-11-26
 */
@Service
public class MaintenanceProjectServiceImpl implements IMaintenanceProjectService 
{
    @Autowired
    private MaintenanceProjectMapper maintenanceProjectMapper;

    /**
     * 查询检修项目
     * 
     * @param projectId 检修项目主键
     * @return 检修项目
     */
    @Override
    public MaintenanceProject selectMaintenanceProjectByProjectId(Long projectId)
    {
        return maintenanceProjectMapper.selectMaintenanceProjectByProjectId(projectId);
    }

    /**
     * 查询检修项目列表
     * 
     * @param maintenanceProject 检修项目
     * @return 检修项目
     */
    @Override
    public List<MaintenanceProject> selectMaintenanceProjectList(MaintenanceProject maintenanceProject)
    {
        return maintenanceProjectMapper.selectMaintenanceProjectList(maintenanceProject);
    }

    /**
     * 新增检修项目
     * 
     * @param maintenanceProject 检修项目
     * @return 结果
     */
    @Override
    public int insertMaintenanceProject(MaintenanceProject maintenanceProject)
    {
        maintenanceProject.setCreateTime(DateUtils.getNowDate());
        return maintenanceProjectMapper.insertMaintenanceProject(maintenanceProject);
    }

    /**
     * 修改检修项目
     * 
     * @param maintenanceProject 检修项目
     * @return 结果
     */
    @Override
    public int updateMaintenanceProject(MaintenanceProject maintenanceProject)
    {
        maintenanceProject.setUpdateTime(DateUtils.getNowDate());
        return maintenanceProjectMapper.updateMaintenanceProject(maintenanceProject);
    }

    /**
     * 批量删除检修项目
     * 
     * @param projectIds 需要删除的检修项目主键
     * @return 结果
     */
    @Override
    public int deleteMaintenanceProjectByProjectIds(Long[] projectIds)
    {
        return maintenanceProjectMapper.deleteMaintenanceProjectByProjectIds(projectIds);
    }

    /**
     * 删除检修项目信息
     * 
     * @param projectId 检修项目主键
     * @return 结果
     */
    @Override
    public int deleteMaintenanceProjectByProjectId(Long projectId)
    {
        return maintenanceProjectMapper.deleteMaintenanceProjectByProjectId(projectId);
    }
}
