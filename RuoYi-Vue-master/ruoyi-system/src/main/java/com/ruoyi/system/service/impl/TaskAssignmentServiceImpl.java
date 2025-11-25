package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TaskAssignmentMapper;
import com.ruoyi.system.domain.TaskAssignment;
import com.ruoyi.system.service.ITaskAssignmentService;

/**
 * 任务分配记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-11-26
 */
@Service
public class TaskAssignmentServiceImpl implements ITaskAssignmentService 
{
    @Autowired
    private TaskAssignmentMapper taskAssignmentMapper;

    /**
     * 查询任务分配记录
     * 
     * @param assignmentId 任务分配记录主键
     * @return 任务分配记录
     */
    @Override
    public TaskAssignment selectTaskAssignmentByAssignmentId(Long assignmentId)
    {
        return taskAssignmentMapper.selectTaskAssignmentByAssignmentId(assignmentId);
    }

    /**
     * 查询任务分配记录列表
     * 
     * @param taskAssignment 任务分配记录
     * @return 任务分配记录
     */
    @Override
    public List<TaskAssignment> selectTaskAssignmentList(TaskAssignment taskAssignment)
    {
        return taskAssignmentMapper.selectTaskAssignmentList(taskAssignment);
    }

    /**
     * 新增任务分配记录
     * 
     * @param taskAssignment 任务分配记录
     * @return 结果
     */
    @Override
    public int insertTaskAssignment(TaskAssignment taskAssignment)
    {
        taskAssignment.setCreateTime(DateUtils.getNowDate());
        return taskAssignmentMapper.insertTaskAssignment(taskAssignment);
    }

    /**
     * 修改任务分配记录
     * 
     * @param taskAssignment 任务分配记录
     * @return 结果
     */
    @Override
    public int updateTaskAssignment(TaskAssignment taskAssignment)
    {
        taskAssignment.setUpdateTime(DateUtils.getNowDate());
        return taskAssignmentMapper.updateTaskAssignment(taskAssignment);
    }

    /**
     * 批量删除任务分配记录
     * 
     * @param assignmentIds 需要删除的任务分配记录主键
     * @return 结果
     */
    @Override
    public int deleteTaskAssignmentByAssignmentIds(Long[] assignmentIds)
    {
        return taskAssignmentMapper.deleteTaskAssignmentByAssignmentIds(assignmentIds);
    }

    /**
     * 删除任务分配记录信息
     * 
     * @param assignmentId 任务分配记录主键
     * @return 结果
     */
    @Override
    public int deleteTaskAssignmentByAssignmentId(Long assignmentId)
    {
        return taskAssignmentMapper.deleteTaskAssignmentByAssignmentId(assignmentId);
    }
}
