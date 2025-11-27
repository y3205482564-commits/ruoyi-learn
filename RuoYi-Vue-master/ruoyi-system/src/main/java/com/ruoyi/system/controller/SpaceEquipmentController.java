package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.system.domain.SpaceEquipment;
import com.ruoyi.system.service.ISpaceEquipmentService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 空间设备Controller
 * 
 * @author ruoyi
 * @date 2025-11-26
 */
@RestController
@RequestMapping("/system/equipment")
public class SpaceEquipmentController extends BaseController
{
    @Autowired
    private ISpaceEquipmentService spaceEquipmentService;

    /**
     * 查询空间设备列表
     */
    @PreAuthorize("@ss.hasPermi('system:equipment:list')")
    @GetMapping("/list")
    public TableDataInfo list(SpaceEquipment spaceEquipment)
    {
        startPage();
        List<SpaceEquipment> list = spaceEquipmentService.selectSpaceEquipmentList(spaceEquipment);
        return getDataTable(list);
    }

    /**
     * 导出空间设备列表
     */
    @PreAuthorize("@ss.hasPermi('system:equipment:export')")
    @Log(title = "空间设备", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SpaceEquipment spaceEquipment)
    {
        List<SpaceEquipment> list = spaceEquipmentService.selectSpaceEquipmentList(spaceEquipment);
        ExcelUtil<SpaceEquipment> util = new ExcelUtil<SpaceEquipment>(SpaceEquipment.class);
        util.exportExcel(response, list, "空间设备数据");
    }

    /**
     * 获取空间设备详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:equipment:query')")
    @GetMapping(value = "/{equipmentId}")
    public AjaxResult getInfo(@PathVariable("equipmentId") Long equipmentId)
    {
        return success(spaceEquipmentService.selectSpaceEquipmentByEquipmentId(equipmentId));
    }

    /**
     * 新增空间设备
     */
    @PreAuthorize("@ss.hasPermi('system:equipment:add')")
    @Log(title = "空间设备", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SpaceEquipment spaceEquipment)
    {
        return toAjax(spaceEquipmentService.insertSpaceEquipment(spaceEquipment));
    }

    /**
     * 修改空间设备
     */
    @PreAuthorize("@ss.hasPermi('system:equipment:edit')")
    @Log(title = "空间设备", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SpaceEquipment spaceEquipment)
    {
        return toAjax(spaceEquipmentService.updateSpaceEquipment(spaceEquipment));
    }

    /**
     * 删除空间设备
     */
    @PreAuthorize("@ss.hasPermi('system:equipment:remove')")
    @Log(title = "空间设备", businessType = BusinessType.DELETE)
	@DeleteMapping("/{equipmentIds}")
    public AjaxResult remove(@PathVariable Long[] equipmentIds)
    {
        return toAjax(spaceEquipmentService.deleteSpaceEquipmentByEquipmentIds(equipmentIds));
    }
}
