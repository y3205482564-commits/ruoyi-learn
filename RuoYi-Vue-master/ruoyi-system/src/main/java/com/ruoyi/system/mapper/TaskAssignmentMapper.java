package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TaskAssignment;

/**
 * 任务分配记录Mapper接口
 * 
 * @author ruoyi
 * @date 2025-11-26
 */
public interface TaskAssignmentMapper 
{
    /**
     * 查询任务分配记录
     * 
     * @param assignmentId 任务分配记录主键
     * @return 任务分配记录
     */
    public TaskAssignment selectTaskAssignmentByAssignmentId(Long assignmentId);

    /**
     * 查询任务分配记录列表
     * 
     * @param taskAssignment 任务分配记录
     * @return 任务分配记录集合
     */
    public List<TaskAssignment> selectTaskAssignmentList(TaskAssignment taskAssignment);

    /**
     * 新增任务分配记录
     * 
     * @param taskAssignment 任务分配记录
     * @return 结果
     */
    public int insertTaskAssignment(TaskAssignment taskAssignment);

    /**
     * 修改任务分配记录
     * 
     * @param taskAssignment 任务分配记录
     * @return 结果
     */
    public int updateTaskAssignment(TaskAssignment taskAssignment);

    /**
     * 删除任务分配记录
     * 
     * @param assignmentId 任务分配记录主键
     * @return 结果
     */
    public int deleteTaskAssignmentByAssignmentId(Long assignmentId);

    /**
     * 批量删除任务分配记录
     * 
     * @param assignmentIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTaskAssignmentByAssignmentIds(Long[] assignmentIds);
}
