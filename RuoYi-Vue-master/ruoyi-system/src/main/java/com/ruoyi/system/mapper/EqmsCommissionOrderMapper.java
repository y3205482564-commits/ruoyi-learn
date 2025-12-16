package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.EqmsCommissionOrder;

/**
 * EQMS委托单信息Mapper接口
 * 
 * @author ruoyi
 * @date 2025-12-16
 */
public interface EqmsCommissionOrderMapper 
{
    /**
     * 查询EQMS委托单信息
     * 
     * @param id EQMS委托单信息主键
     * @return EQMS委托单信息
     */
    public EqmsCommissionOrder selectEqmsCommissionOrderById(Long id);

    /**
     * 查询EQMS委托单信息列表
     * 
     * @param eqmsCommissionOrder EQMS委托单信息
     * @return EQMS委托单信息集合
     */
    public List<EqmsCommissionOrder> selectEqmsCommissionOrderList(EqmsCommissionOrder eqmsCommissionOrder);

    /**
     * 新增EQMS委托单信息
     * 
     * @param eqmsCommissionOrder EQMS委托单信息
     * @return 结果
     */
    public int insertEqmsCommissionOrder(EqmsCommissionOrder eqmsCommissionOrder);

    /**
     * 修改EQMS委托单信息
     * 
     * @param eqmsCommissionOrder EQMS委托单信息
     * @return 结果
     */
    public int updateEqmsCommissionOrder(EqmsCommissionOrder eqmsCommissionOrder);

    /**
     * 删除EQMS委托单信息
     * 
     * @param id EQMS委托单信息主键
     * @return 结果
     */
    public int deleteEqmsCommissionOrderById(Long id);

    /**
     * 批量删除EQMS委托单信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEqmsCommissionOrderByIds(Long[] ids);
}
