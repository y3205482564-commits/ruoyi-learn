package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.MaintenanceTaskMapper;
import com.ruoyi.system.domain.MaintenanceTask;
import com.ruoyi.system.service.IMaintenanceTaskService;

/**
 * 检修任务Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-11-26
 */
@Service
public class MaintenanceTaskServiceImpl implements IMaintenanceTaskService 
{
    @Autowired
    private MaintenanceTaskMapper maintenanceTaskMapper;

    /**
     * 查询检修任务
     * 
     * @param taskId 检修任务主键
     * @return 检修任务
     */
    @Override
    public MaintenanceTask selectMaintenanceTaskByTaskId(Long taskId)
    {
        return maintenanceTaskMapper.selectMaintenanceTaskByTaskId(taskId);
    }

    /**
     * 查询检修任务列表
     * 
     * @param maintenanceTask 检修任务
     * @return 检修任务
     */
    @Override
    public List<MaintenanceTask> selectMaintenanceTaskList(MaintenanceTask maintenanceTask)
    {
        return maintenanceTaskMapper.selectMaintenanceTaskList(maintenanceTask);
    }

    /**
     * 新增检修任务
     * 
     * @param maintenanceTask 检修任务
     * @return 结果
     */
    @Override
    public int insertMaintenanceTask(MaintenanceTask maintenanceTask)
    {
        maintenanceTask.setCreateTime(DateUtils.getNowDate());
        return maintenanceTaskMapper.insertMaintenanceTask(maintenanceTask);
    }

    /**
     * 修改检修任务
     * 
     * @param maintenanceTask 检修任务
     * @return 结果
     */
    @Override
    public int updateMaintenanceTask(MaintenanceTask maintenanceTask)
    {
        maintenanceTask.setUpdateTime(DateUtils.getNowDate());
        return maintenanceTaskMapper.updateMaintenanceTask(maintenanceTask);
    }

    /**
     * 批量删除检修任务
     * 
     * @param taskIds 需要删除的检修任务主键
     * @return 结果
     */
    @Override
    public int deleteMaintenanceTaskByTaskIds(Long[] taskIds)
    {
        return maintenanceTaskMapper.deleteMaintenanceTaskByTaskIds(taskIds);
    }

    /**
     * 删除检修任务信息
     * 
     * @param taskId 检修任务主键
     * @return 结果
     */
    @Override
    public int deleteMaintenanceTaskByTaskId(Long taskId)
    {
        return maintenanceTaskMapper.deleteMaintenanceTaskByTaskId(taskId);
    }
}
