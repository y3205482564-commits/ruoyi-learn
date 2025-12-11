package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.ApprovalTasks;

/**
 * 审批任务Mapper接口
 * 
 * @author ruoyi
 * @date 2025-12-11
 */
public interface ApprovalTasksMapper 
{
    /**
     * 查询审批任务
     * 
     * @param id 审批任务主键
     * @return 审批任务
     */
    public ApprovalTasks selectApprovalTasksById(Long id);

    /**
     * 查询审批任务列表
     * 
     * @param approvalTasks 审批任务
     * @return 审批任务集合
     */
    public List<ApprovalTasks> selectApprovalTasksList(ApprovalTasks approvalTasks);

    /**
     * 新增审批任务
     * 
     * @param approvalTasks 审批任务
     * @return 结果
     */
    public int insertApprovalTasks(ApprovalTasks approvalTasks);

    /**
     * 修改审批任务
     * 
     * @param approvalTasks 审批任务
     * @return 结果
     */
    public int updateApprovalTasks(ApprovalTasks approvalTasks);

    /**
     * 删除审批任务
     * 
     * @param id 审批任务主键
     * @return 结果
     */
    public int deleteApprovalTasksById(Long id);

    /**
     * 批量删除审批任务
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteApprovalTasksByIds(Long[] ids);
}
