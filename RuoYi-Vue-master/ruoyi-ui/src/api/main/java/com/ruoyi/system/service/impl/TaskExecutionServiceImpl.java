package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TaskExecutionMapper;
import com.ruoyi.system.domain.TaskExecution;
import com.ruoyi.system.service.ITaskExecutionService;

/**
 * 任务执行记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-11-26
 */
@Service
public class TaskExecutionServiceImpl implements ITaskExecutionService 
{
    @Autowired
    private TaskExecutionMapper taskExecutionMapper;

    /**
     * 查询任务执行记录
     * 
     * @param executionId 任务执行记录主键
     * @return 任务执行记录
     */
    @Override
    public TaskExecution selectTaskExecutionByExecutionId(Long executionId)
    {
        return taskExecutionMapper.selectTaskExecutionByExecutionId(executionId);
    }

    /**
     * 查询任务执行记录列表
     * 
     * @param taskExecution 任务执行记录
     * @return 任务执行记录
     */
    @Override
    public List<TaskExecution> selectTaskExecutionList(TaskExecution taskExecution)
    {
        return taskExecutionMapper.selectTaskExecutionList(taskExecution);
    }

    /**
     * 新增任务执行记录
     * 
     * @param taskExecution 任务执行记录
     * @return 结果
     */
    @Override
    public int insertTaskExecution(TaskExecution taskExecution)
    {
        taskExecution.setCreateTime(DateUtils.getNowDate());
        return taskExecutionMapper.insertTaskExecution(taskExecution);
    }

    /**
     * 修改任务执行记录
     * 
     * @param taskExecution 任务执行记录
     * @return 结果
     */
    @Override
    public int updateTaskExecution(TaskExecution taskExecution)
    {
        taskExecution.setUpdateTime(DateUtils.getNowDate());
        return taskExecutionMapper.updateTaskExecution(taskExecution);
    }

    /**
     * 批量删除任务执行记录
     * 
     * @param executionIds 需要删除的任务执行记录主键
     * @return 结果
     */
    @Override
    public int deleteTaskExecutionByExecutionIds(Long[] executionIds)
    {
        return taskExecutionMapper.deleteTaskExecutionByExecutionIds(executionIds);
    }

    /**
     * 删除任务执行记录信息
     * 
     * @param executionId 任务执行记录主键
     * @return 结果
     */
    @Override
    public int deleteTaskExecutionByExecutionId(Long executionId)
    {
        return taskExecutionMapper.deleteTaskExecutionByExecutionId(executionId);
    }
}
