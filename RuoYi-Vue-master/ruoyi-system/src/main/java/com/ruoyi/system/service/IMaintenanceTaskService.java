package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.MaintenanceTask;

/**
 * 检修任务Service接口
 * 
 * @author ruoyi
 * @date 2025-11-26
 */
public interface IMaintenanceTaskService 
{
    /**
     * 查询检修任务
     * 
     * @param taskId 检修任务主键
     * @return 检修任务
     */
    public MaintenanceTask selectMaintenanceTaskByTaskId(Long taskId);

    /**
     * 查询检修任务列表
     * 
     * @param maintenanceTask 检修任务
     * @return 检修任务集合
     */
    public List<MaintenanceTask> selectMaintenanceTaskList(MaintenanceTask maintenanceTask);

    /**
     * 新增检修任务
     * 
     * @param maintenanceTask 检修任务
     * @return 结果
     */
    public int insertMaintenanceTask(MaintenanceTask maintenanceTask);

    /**
     * 修改检修任务
     * 
     * @param maintenanceTask 检修任务
     * @return 结果
     */
    public int updateMaintenanceTask(MaintenanceTask maintenanceTask);

    /**
     * 批量删除检修任务
     * 
     * @param taskIds 需要删除的检修任务主键集合
     * @return 结果
     */
    public int deleteMaintenanceTaskByTaskIds(Long[] taskIds);

    /**
     * 删除检修任务信息
     * 
     * @param taskId 检修任务主键
     * @return 结果
     */
    public int deleteMaintenanceTaskByTaskId(Long taskId);
}
