package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.vo.ExternalEqmsData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.EqmsCommissionOrderMapper;
import com.ruoyi.system.domain.EqmsCommissionOrder;
import com.ruoyi.system.service.IEqmsCommissionOrderService;

/**
 * EQMS委托单信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-12-16
 */
@Service
public class EqmsCommissionOrderServiceImpl implements IEqmsCommissionOrderService 
{
    @Autowired
    private EqmsCommissionOrderMapper eqmsCommissionOrderMapper;

    /**
     * 查询EQMS委托单信息
     * 
     * @param id EQMS委托单信息主键
     * @return EQMS委托单信息
     */
    @Override
    public EqmsCommissionOrder selectEqmsCommissionOrderById(Long id)
    {
        return eqmsCommissionOrderMapper.selectEqmsCommissionOrderById(id);
    }

    /**
     * 查询EQMS委托单信息列表
     * 
     * @param eqmsCommissionOrder EQMS委托单信息
     * @return EQMS委托单信息
     */
    @Override
    public List<EqmsCommissionOrder> selectEqmsCommissionOrderList(EqmsCommissionOrder eqmsCommissionOrder)
    {
        return eqmsCommissionOrderMapper.selectEqmsCommissionOrderList(eqmsCommissionOrder);
    }

    /**
     * 新增EQMS委托单信息
     * 
     * @param eqmsCommissionOrder EQMS委托单信息
     * @return 结果
     */
    @Override
    public int insertEqmsCommissionOrder(EqmsCommissionOrder eqmsCommissionOrder)
    {
        eqmsCommissionOrder.setCreateTime(DateUtils.getNowDate());
        return eqmsCommissionOrderMapper.insertEqmsCommissionOrder(eqmsCommissionOrder);
    }

    /**
     * 修改EQMS委托单信息
     * 
     * @param eqmsCommissionOrder EQMS委托单信息
     * @return 结果
     */
    @Override
    public int updateEqmsCommissionOrder(EqmsCommissionOrder eqmsCommissionOrder)
    {
        eqmsCommissionOrder.setUpdateTime(DateUtils.getNowDate());
        return eqmsCommissionOrderMapper.updateEqmsCommissionOrder(eqmsCommissionOrder);
    }

    /**
     * 批量删除EQMS委托单信息
     * 
     * @param ids 需要删除的EQMS委托单信息主键
     * @return 结果
     */
    @Override
    public int deleteEqmsCommissionOrderByIds(Long[] ids)
    {
        return eqmsCommissionOrderMapper.deleteEqmsCommissionOrderByIds(ids);
    }

    /**
     * 删除EQMS委托单信息信息
     * 
     * @param id EQMS委托单信息主键
     * @return 结果
     */
    @Override
    public int deleteEqmsCommissionOrderById(Long id)
    {
        return eqmsCommissionOrderMapper.deleteEqmsCommissionOrderById(id);
    }

    /**
     * 接收外部系统EQMS数据
     * 
     * @param externalData 外部系统数据
     * @return 结果
     */
    @Override
    public int receiveExternalData(ExternalEqmsData externalData)
    {
        // 转换为EqmsCommissionOrder对象
        EqmsCommissionOrder eqmsCommissionOrder = new EqmsCommissionOrder();
        eqmsCommissionOrder.setCommissionNo(externalData.getCommissionNo());
        eqmsCommissionOrder.setPlanNo(externalData.getPlanNo());
        eqmsCommissionOrder.setStandardItemNo(externalData.getStandardItemNo());
        eqmsCommissionOrder.setEquipmentName(externalData.getEquipmentName());
        eqmsCommissionOrder.setProjectName(externalData.getProjectName());
        eqmsCommissionOrder.setExpectedStartDate(externalData.getExpectedStartDate());
        eqmsCommissionOrder.setExpectedEndDate(externalData.getExpectedEndDate());
        eqmsCommissionOrder.setRepairReason(externalData.getRepairReason());
        eqmsCommissionOrder.setConstructionTeamCode(externalData.getConstructionTeamCode());
        eqmsCommissionOrder.setConstructionTeamName(externalData.getConstructionTeamName());
        eqmsCommissionOrder.setProjectCategory(externalData.getProjectCategory());
        eqmsCommissionOrder.setCommissionDate(externalData.getCommissionDate());
        eqmsCommissionOrder.setCommissioner(externalData.getCommissioner());
        eqmsCommissionOrder.setInspectorName(externalData.getInspectorName());
        
        // 设置默认状态和同步状态
        eqmsCommissionOrder.setStatus("0"); // 正常状态
        eqmsCommissionOrder.setSyncStatus("1"); // 已接收状态
        
        // 设置同步消息
        eqmsCommissionOrder.setSyncMessage("外部系统数据接收成功");
        
        // 设置创建时间和更新时间
        eqmsCommissionOrder.setCreateTime(DateUtils.getNowDate());
        eqmsCommissionOrder.setUpdateTime(DateUtils.getNowDate());
        
        // 插入数据
        return eqmsCommissionOrderMapper.insertEqmsCommissionOrder(eqmsCommissionOrder);
    }
}