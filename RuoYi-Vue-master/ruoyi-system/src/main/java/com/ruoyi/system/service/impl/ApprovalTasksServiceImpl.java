package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ApprovalTasksMapper;
import com.ruoyi.system.domain.ApprovalTasks;
import com.ruoyi.system.service.IApprovalTasksService;

/**
 * 审批任务Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-12-11
 */
@Service
public class ApprovalTasksServiceImpl implements IApprovalTasksService 
{
    @Autowired
    private ApprovalTasksMapper approvalTasksMapper;

    /**
     * 查询审批任务
     * 
     * @param id 审批任务主键
     * @return 审批任务
     */
    @Override
    public ApprovalTasks selectApprovalTasksById(Long id)
    {
        return approvalTasksMapper.selectApprovalTasksById(id);
    }

    /**
     * 查询审批任务列表
     * 
     * @param approvalTasks 审批任务
     * @return 审批任务
     */
    @Override
    public List<ApprovalTasks> selectApprovalTasksList(ApprovalTasks approvalTasks)
    {
        return approvalTasksMapper.selectApprovalTasksList(approvalTasks);
    }

    /**
     * 新增审批任务
     * 
     * @param approvalTasks 审批任务
     * @return 结果
     */
    @Override
    public int insertApprovalTasks(ApprovalTasks approvalTasks)
    {
        return approvalTasksMapper.insertApprovalTasks(approvalTasks);
    }

    /**
     * 修改审批任务
     * 
     * @param approvalTasks 审批任务
     * @return 结果
     */
    @Override
    public int updateApprovalTasks(ApprovalTasks approvalTasks)
    {
        return approvalTasksMapper.updateApprovalTasks(approvalTasks);
    }

    /**
     * 批量删除审批任务
     * 
     * @param ids 需要删除的审批任务主键
     * @return 结果
     */
    @Override
    public int deleteApprovalTasksByIds(Long[] ids)
    {
        return approvalTasksMapper.deleteApprovalTasksByIds(ids);
    }

    /**
     * 删除审批任务信息
     * 
     * @param id 审批任务主键
     * @return 结果
     */
    @Override
    public int deleteApprovalTasksById(Long id)
    {
        return approvalTasksMapper.deleteApprovalTasksById(id);
    }
}
