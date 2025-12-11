package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ApprovalProcessesMapper;
import com.ruoyi.system.domain.ApprovalProcesses;
import com.ruoyi.system.service.IApprovalProcessesService;

/**
 * 审批流程定义Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-12-11
 */
@Service
public class ApprovalProcessesServiceImpl implements IApprovalProcessesService 
{
    @Autowired
    private ApprovalProcessesMapper approvalProcessesMapper;

    /**
     * 查询审批流程定义
     * 
     * @param id 审批流程定义主键
     * @return 审批流程定义
     */
    @Override
    public ApprovalProcesses selectApprovalProcessesById(Long id)
    {
        return approvalProcessesMapper.selectApprovalProcessesById(id);
    }

    /**
     * 查询审批流程定义列表
     * 
     * @param approvalProcesses 审批流程定义
     * @return 审批流程定义
     */
    @Override
    public List<ApprovalProcesses> selectApprovalProcessesList(ApprovalProcesses approvalProcesses)
    {
        return approvalProcessesMapper.selectApprovalProcessesList(approvalProcesses);
    }

    /**
     * 新增审批流程定义
     * 
     * @param approvalProcesses 审批流程定义
     * @return 结果
     */
    @Override
    public int insertApprovalProcesses(ApprovalProcesses approvalProcesses)
    {
        return approvalProcessesMapper.insertApprovalProcesses(approvalProcesses);
    }

    /**
     * 修改审批流程定义
     * 
     * @param approvalProcesses 审批流程定义
     * @return 结果
     */
    @Override
    public int updateApprovalProcesses(ApprovalProcesses approvalProcesses)
    {
        return approvalProcessesMapper.updateApprovalProcesses(approvalProcesses);
    }

    /**
     * 批量删除审批流程定义
     * 
     * @param ids 需要删除的审批流程定义主键
     * @return 结果
     */
    @Override
    public int deleteApprovalProcessesByIds(Long[] ids)
    {
        return approvalProcessesMapper.deleteApprovalProcessesByIds(ids);
    }

    /**
     * 删除审批流程定义信息
     * 
     * @param id 审批流程定义主键
     * @return 结果
     */
    @Override
    public int deleteApprovalProcessesById(Long id)
    {
        return approvalProcessesMapper.deleteApprovalProcessesById(id);
    }
}
