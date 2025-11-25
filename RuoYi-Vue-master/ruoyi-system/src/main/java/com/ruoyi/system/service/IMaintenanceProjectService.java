package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.MaintenanceProject;

/**
 * 检修项目Service接口
 * 
 * @author ruoyi
 * @date 2025-11-26
 */
public interface IMaintenanceProjectService 
{
    /**
     * 查询检修项目
     * 
     * @param projectId 检修项目主键
     * @return 检修项目
     */
    public MaintenanceProject selectMaintenanceProjectByProjectId(Long projectId);

    /**
     * 查询检修项目列表
     * 
     * @param maintenanceProject 检修项目
     * @return 检修项目集合
     */
    public List<MaintenanceProject> selectMaintenanceProjectList(MaintenanceProject maintenanceProject);

    /**
     * 新增检修项目
     * 
     * @param maintenanceProject 检修项目
     * @return 结果
     */
    public int insertMaintenanceProject(MaintenanceProject maintenanceProject);

    /**
     * 修改检修项目
     * 
     * @param maintenanceProject 检修项目
     * @return 结果
     */
    public int updateMaintenanceProject(MaintenanceProject maintenanceProject);

    /**
     * 批量删除检修项目
     * 
     * @param projectIds 需要删除的检修项目主键集合
     * @return 结果
     */
    public int deleteMaintenanceProjectByProjectIds(Long[] projectIds);

    /**
     * 删除检修项目信息
     * 
     * @param projectId 检修项目主键
     * @return 结果
     */
    public int deleteMaintenanceProjectByProjectId(Long projectId);
}
