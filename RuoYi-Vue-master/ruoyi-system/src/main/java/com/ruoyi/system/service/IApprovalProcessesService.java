package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.ApprovalProcesses;

/**
 * 审批流程定义Service接口
 * 
 * @author ruoyi
 * @date 2025-12-11
 */
public interface IApprovalProcessesService 
{
    /**
     * 查询审批流程定义
     * 
     * @param id 审批流程定义主键
     * @return 审批流程定义
     */
    public ApprovalProcesses selectApprovalProcessesById(Long id);

    /**
     * 查询审批流程定义列表
     * 
     * @param approvalProcesses 审批流程定义
     * @return 审批流程定义集合
     */
    public List<ApprovalProcesses> selectApprovalProcessesList(ApprovalProcesses approvalProcesses);

    /**
     * 新增审批流程定义
     * 
     * @param approvalProcesses 审批流程定义
     * @return 结果
     */
    public int insertApprovalProcesses(ApprovalProcesses approvalProcesses);

    /**
     * 修改审批流程定义
     * 
     * @param approvalProcesses 审批流程定义
     * @return 结果
     */
    public int updateApprovalProcesses(ApprovalProcesses approvalProcesses);

    /**
     * 批量删除审批流程定义
     * 
     * @param ids 需要删除的审批流程定义主键集合
     * @return 结果
     */
    public int deleteApprovalProcessesByIds(Long[] ids);

    /**
     * 删除审批流程定义信息
     * 
     * @param id 审批流程定义主键
     * @return 结果
     */
    public int deleteApprovalProcessesById(Long id);
}
