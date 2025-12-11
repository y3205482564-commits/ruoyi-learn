package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.ApprovalNodes;

/**
 * 审批节点Service接口
 * 
 * @author ruoyi
 * @date 2025-12-11
 */
public interface IApprovalNodesService 
{
    /**
     * 查询审批节点
     * 
     * @param id 审批节点主键
     * @return 审批节点
     */
    public ApprovalNodes selectApprovalNodesById(Long id);

    /**
     * 查询审批节点列表
     * 
     * @param approvalNodes 审批节点
     * @return 审批节点集合
     */
    public List<ApprovalNodes> selectApprovalNodesList(ApprovalNodes approvalNodes);

    /**
     * 新增审批节点
     * 
     * @param approvalNodes 审批节点
     * @return 结果
     */
    public int insertApprovalNodes(ApprovalNodes approvalNodes);

    /**
     * 修改审批节点
     * 
     * @param approvalNodes 审批节点
     * @return 结果
     */
    public int updateApprovalNodes(ApprovalNodes approvalNodes);

    /**
     * 批量删除审批节点
     * 
     * @param ids 需要删除的审批节点主键集合
     * @return 结果
     */
    public int deleteApprovalNodesByIds(Long[] ids);

    /**
     * 删除审批节点信息
     * 
     * @param id 审批节点主键
     * @return 结果
     */
    public int deleteApprovalNodesById(Long id);
}
