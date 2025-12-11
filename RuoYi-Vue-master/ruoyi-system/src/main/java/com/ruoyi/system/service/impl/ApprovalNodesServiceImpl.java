package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ApprovalNodesMapper;
import com.ruoyi.system.domain.ApprovalNodes;
import com.ruoyi.system.service.IApprovalNodesService;

/**
 * 审批节点Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-12-11
 */
@Service
public class ApprovalNodesServiceImpl implements IApprovalNodesService 
{
    @Autowired
    private ApprovalNodesMapper approvalNodesMapper;

    /**
     * 查询审批节点
     * 
     * @param id 审批节点主键
     * @return 审批节点
     */
    @Override
    public ApprovalNodes selectApprovalNodesById(Long id)
    {
        return approvalNodesMapper.selectApprovalNodesById(id);
    }

    /**
     * 查询审批节点列表
     * 
     * @param approvalNodes 审批节点
     * @return 审批节点
     */
    @Override
    public List<ApprovalNodes> selectApprovalNodesList(ApprovalNodes approvalNodes)
    {
        return approvalNodesMapper.selectApprovalNodesList(approvalNodes);
    }

    /**
     * 新增审批节点
     * 
     * @param approvalNodes 审批节点
     * @return 结果
     */
    @Override
    public int insertApprovalNodes(ApprovalNodes approvalNodes)
    {
        return approvalNodesMapper.insertApprovalNodes(approvalNodes);
    }

    /**
     * 修改审批节点
     * 
     * @param approvalNodes 审批节点
     * @return 结果
     */
    @Override
    public int updateApprovalNodes(ApprovalNodes approvalNodes)
    {
        return approvalNodesMapper.updateApprovalNodes(approvalNodes);
    }

    /**
     * 批量删除审批节点
     * 
     * @param ids 需要删除的审批节点主键
     * @return 结果
     */
    @Override
    public int deleteApprovalNodesByIds(Long[] ids)
    {
        return approvalNodesMapper.deleteApprovalNodesByIds(ids);
    }

    /**
     * 删除审批节点信息
     * 
     * @param id 审批节点主键
     * @return 结果
     */
    @Override
    public int deleteApprovalNodesById(Long id)
    {
        return approvalNodesMapper.deleteApprovalNodesById(id);
    }
}
