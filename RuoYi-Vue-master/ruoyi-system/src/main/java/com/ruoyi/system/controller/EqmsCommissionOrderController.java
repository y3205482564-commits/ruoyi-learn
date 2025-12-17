package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.system.domain.vo.ExternalEqmsData;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.EqmsCommissionOrder;
import com.ruoyi.system.service.IEqmsCommissionOrderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * EQMS委托单信息Controller
 * 
 * @author ruoyi
 * @date 2025-12-16
 */
@RestController
@RequestMapping("/system/eqmsorder")
public class EqmsCommissionOrderController extends BaseController
{
    @Autowired
    private IEqmsCommissionOrderService eqmsCommissionOrderService;

    /**
     * 查询EQMS委托单信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:eqmsorder:list')")
    @GetMapping("/list")
    public TableDataInfo list(EqmsCommissionOrder eqmsCommissionOrder)
    {
        startPage();
        List<EqmsCommissionOrder> list = eqmsCommissionOrderService.selectEqmsCommissionOrderList(eqmsCommissionOrder);
        return getDataTable(list);
    }

    /**
     * 导出EQMS委托单信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:eqmsorder:export')")
    @Log(title = "EQMS委托单信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EqmsCommissionOrder eqmsCommissionOrder)
    {
        List<EqmsCommissionOrder> list = eqmsCommissionOrderService.selectEqmsCommissionOrderList(eqmsCommissionOrder);
        ExcelUtil<EqmsCommissionOrder> util = new ExcelUtil<EqmsCommissionOrder>(EqmsCommissionOrder.class);
        util.exportExcel(response, list, "EQMS委托单信息数据");
    }

    /**
     * 获取EQMS委托单信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:eqmsorder:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(eqmsCommissionOrderService.selectEqmsCommissionOrderById(id));
    }

    /**
     * 新增EQMS委托单信息
     */
    @PreAuthorize("@ss.hasPermi('system:eqmsorder:add')")
    @Log(title = "EQMS委托单信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EqmsCommissionOrder eqmsCommissionOrder)
    {
        return toAjax(eqmsCommissionOrderService.insertEqmsCommissionOrder(eqmsCommissionOrder));
    }

    /**
     * 修改EQMS委托单信息
     */
    //@PreAuthorize("@ss.hasPermi('system:eqmsorder:edit')")
    @Log(title = "EQMS委托单信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EqmsCommissionOrder eqmsCommissionOrder)
    {
        return toAjax(eqmsCommissionOrderService.updateEqmsCommissionOrder(eqmsCommissionOrder));
    }

    /**
     * 删除EQMS委托单信息
     */
    @PreAuthorize("@ss.hasPermi('system:eqmsorder:remove')")
    @Log(title = "EQMS委托单信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(eqmsCommissionOrderService.deleteEqmsCommissionOrderByIds(ids));
    }

    /**
     * 接收外部系统EQMS数据
     */

    //@PreAuthorize("@ss.hasPermi('system:eqmsorder:add')")
    @Log(title = "外部系统数据接收", businessType = BusinessType.INSERT)
    @PostMapping("/external/receive")
    public AjaxResult receiveExternalData(@RequestBody ExternalEqmsData externalData)
    {
        return toAjax(eqmsCommissionOrderService.receiveExternalData(externalData));
    }
}