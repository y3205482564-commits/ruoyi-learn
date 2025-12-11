package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ApprovalInstancesMapper;
import com.ruoyi.system.domain.ApprovalInstances;
import com.ruoyi.system.service.IApprovalInstancesService;

/**
 * 审批实例Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-12-11
 */
@Service
public class ApprovalInstancesServiceImpl implements IApprovalInstancesService 
{
    @Autowired
    private ApprovalInstancesMapper approvalInstancesMapper;

    /**
     * 查询审批实例
     * 
     * @param id 审批实例主键
     * @return 审批实例
     */
    @Override
    public ApprovalInstances selectApprovalInstancesById(Long id)
    {
        return approvalInstancesMapper.selectApprovalInstancesById(id);
    }

    /**
     * 查询审批实例列表
     * 
     * @param approvalInstances 审批实例
     * @return 审批实例
     */
    @Override
    public List<ApprovalInstances> selectApprovalInstancesList(ApprovalInstances approvalInstances)
    {
        return approvalInstancesMapper.selectApprovalInstancesList(approvalInstances);
    }

    /**
     * 新增审批实例
     * 
     * @param approvalInstances 审批实例
     * @return 结果
     */
    @Override
    public int insertApprovalInstances(ApprovalInstances approvalInstances)
    {
        return approvalInstancesMapper.insertApprovalInstances(approvalInstances);
    }

    /**
     * 修改审批实例
     * 
     * @param approvalInstances 审批实例
     * @return 结果
     */
    @Override
    public int updateApprovalInstances(ApprovalInstances approvalInstances)
    {
        return approvalInstancesMapper.updateApprovalInstances(approvalInstances);
    }

    /**
     * 批量删除审批实例
     * 
     * @param ids 需要删除的审批实例主键
     * @return 结果
     */
    @Override
    public int deleteApprovalInstancesByIds(Long[] ids)
    {
        return approvalInstancesMapper.deleteApprovalInstancesByIds(ids);
    }

    /**
     * 删除审批实例信息
     * 
     * @param id 审批实例主键
     * @return 结果
     */
    @Override
    public int deleteApprovalInstancesById(Long id)
    {
        return approvalInstancesMapper.deleteApprovalInstancesById(id);
    }
}
