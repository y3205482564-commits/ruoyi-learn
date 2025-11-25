package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TaskExecution;

/**
 * 任务执行记录Mapper接口
 * 
 * @author ruoyi
 * @date 2025-11-26
 */
public interface TaskExecutionMapper 
{
    /**
     * 查询任务执行记录
     * 
     * @param executionId 任务执行记录主键
     * @return 任务执行记录
     */
    public TaskExecution selectTaskExecutionByExecutionId(Long executionId);

    /**
     * 查询任务执行记录列表
     * 
     * @param taskExecution 任务执行记录
     * @return 任务执行记录集合
     */
    public List<TaskExecution> selectTaskExecutionList(TaskExecution taskExecution);

    /**
     * 新增任务执行记录
     * 
     * @param taskExecution 任务执行记录
     * @return 结果
     */
    public int insertTaskExecution(TaskExecution taskExecution);

    /**
     * 修改任务执行记录
     * 
     * @param taskExecution 任务执行记录
     * @return 结果
     */
    public int updateTaskExecution(TaskExecution taskExecution);

    /**
     * 删除任务执行记录
     * 
     * @param executionId 任务执行记录主键
     * @return 结果
     */
    public int deleteTaskExecutionByExecutionId(Long executionId);

    /**
     * 批量删除任务执行记录
     * 
     * @param executionIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTaskExecutionByExecutionIds(Long[] executionIds);
}
