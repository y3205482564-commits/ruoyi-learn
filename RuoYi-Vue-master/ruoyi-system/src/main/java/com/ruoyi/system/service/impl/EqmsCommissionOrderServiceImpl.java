package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
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
}
