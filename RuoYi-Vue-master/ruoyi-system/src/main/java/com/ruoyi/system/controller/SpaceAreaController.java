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
import com.ruoyi.system.domain.SpaceArea;
import com.ruoyi.system.service.ISpaceAreaService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 空间区域Controller
 * 
 * @author ruoyi
 * @date 2025-11-26
 */
@RestController
@RequestMapping("/system/area")
public class SpaceAreaController extends BaseController
{
    @Autowired
    private ISpaceAreaService spaceAreaService;

    /**
     * 查询空间区域列表
     */
    @PreAuthorize("@ss.hasPermi('system:area:list')")
    @GetMapping("/list")
    public TableDataInfo list(SpaceArea spaceArea)
    {
        startPage();
        List<SpaceArea> list = spaceAreaService.selectSpaceAreaList(spaceArea);
        return getDataTable(list);
    }

    /**
     * 导出空间区域列表
     */
    @PreAuthorize("@ss.hasPermi('system:area:export')")
    @Log(title = "空间区域", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SpaceArea spaceArea)
    {
        List<SpaceArea> list = spaceAreaService.selectSpaceAreaList(spaceArea);
        ExcelUtil<SpaceArea> util = new ExcelUtil<SpaceArea>(SpaceArea.class);
        util.exportExcel(response, list, "空间区域数据");
    }

    /**
     * 获取空间区域详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:area:query')")
    @GetMapping(value = "/{areaId}")
    public AjaxResult getInfo(@PathVariable("areaId") Long areaId)
    {
        return success(spaceAreaService.selectSpaceAreaByAreaId(areaId));
    }

    /**
     * 新增空间区域
     */
    @PreAuthorize("@ss.hasPermi('system:area:add')")
    @Log(title = "空间区域", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SpaceArea spaceArea)
    {
        return toAjax(spaceAreaService.insertSpaceArea(spaceArea));
    }

    /**
     * 修改空间区域
     */
    @PreAuthorize("@ss.hasPermi('system:area:edit')")
    @Log(title = "空间区域", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SpaceArea spaceArea)
    {
        return toAjax(spaceAreaService.updateSpaceArea(spaceArea));
    }

    /**
     * 删除空间区域
     */
    @PreAuthorize("@ss.hasPermi('system:area:remove')")
    @Log(title = "空间区域", businessType = BusinessType.DELETE)
	@DeleteMapping("/{areaIds}")
    public AjaxResult remove(@PathVariable Long[] areaIds)
    {
        return toAjax(spaceAreaService.deleteSpaceAreaByAreaIds(areaIds));
    }
}
