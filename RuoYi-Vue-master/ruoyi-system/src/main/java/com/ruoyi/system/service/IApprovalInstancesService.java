package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.ApprovalInstances;

/**
 * 审批实例Service接口
 * 
 * @author ruoyi
 * @date 2025-12-11
 */
public interface IApprovalInstancesService 
{
    /**
     * 查询审批实例
     * 
     * @param id 审批实例主键
     * @return 审批实例
     */
    public ApprovalInstances selectApprovalInstancesById(Long id);

    /**
     * 查询审批实例列表
     * 
     * @param approvalInstances 审批实例
     * @return 审批实例集合
     */
    public List<ApprovalInstances> selectApprovalInstancesList(ApprovalInstances approvalInstances);

    /**
     * 新增审批实例
     * 
     * @param approvalInstances 审批实例
     * @return 结果
     */
    public int insertApprovalInstances(ApprovalInstances approvalInstances);

    /**
     * 修改审批实例
     * 
     * @param approvalInstances 审批实例
     * @return 结果
     */
    public int updateApprovalInstances(ApprovalInstances approvalInstances);

    /**
     * 批量删除审批实例
     * 
     * @param ids 需要删除的审批实例主键集合
     * @return 结果
     */
    public int deleteApprovalInstancesByIds(Long[] ids);

    /**
     * 删除审批实例信息
     * 
     * @param id 审批实例主键
     * @return 结果
     */
    public int deleteApprovalInstancesById(Long id);
}
