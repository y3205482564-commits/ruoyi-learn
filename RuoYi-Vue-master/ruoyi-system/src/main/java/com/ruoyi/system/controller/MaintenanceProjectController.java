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
import com.ruoyi.system.domain.MaintenanceProject;
import com.ruoyi.system.service.IMaintenanceProjectService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 检修项目Controller
 * 
 * @author ruoyi
 * @date 2025-11-26
 */
@RestController
@RequestMapping("/system/project")
public class MaintenanceProjectController extends BaseController
{
    @Autowired
    private IMaintenanceProjectService maintenanceProjectService;

    /**
     * 查询检修项目列表
     */
    @PreAuthorize("@ss.hasPermi('system:project:list')")
    @GetMapping("/list")
    public TableDataInfo list(MaintenanceProject maintenanceProject)
    {
        startPage();
        List<MaintenanceProject> list = maintenanceProjectService.selectMaintenanceProjectList(maintenanceProject);
        return getDataTable(list);
    }

    /**
     * 导出检修项目列表
     */
    @PreAuthorize("@ss.hasPermi('system:project:export')")
    @Log(title = "检修项目", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MaintenanceProject maintenanceProject)
    {
        List<MaintenanceProject> list = maintenanceProjectService.selectMaintenanceProjectList(maintenanceProject);
        ExcelUtil<MaintenanceProject> util = new ExcelUtil<MaintenanceProject>(MaintenanceProject.class);
        util.exportExcel(response, list, "检修项目数据");
    }

    /**
     * 获取检修项目详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:project:query')")
    @GetMapping(value = "/{projectId}")
    public AjaxResult getInfo(@PathVariable("projectId") Long projectId)
    {
        return success(maintenanceProjectService.selectMaintenanceProjectByProjectId(projectId));
    }

    /**
     * 新增检修项目
     */
    @PreAuthorize("@ss.hasPermi('system:project:add')")
    @Log(title = "检修项目", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MaintenanceProject maintenanceProject)
    {
        return toAjax(maintenanceProjectService.insertMaintenanceProject(maintenanceProject));
    }

    /**
     * 修改检修项目
     */
    @PreAuthorize("@ss.hasPermi('system:project:edit')")
    @Log(title = "检修项目", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MaintenanceProject maintenanceProject)
    {
        return toAjax(maintenanceProjectService.updateMaintenanceProject(maintenanceProject));
    }

    /**
     * 删除检修项目
     */
    @PreAuthorize("@ss.hasPermi('system:project:remove')")
    @Log(title = "检修项目", businessType = BusinessType.DELETE)
	@DeleteMapping("/{projectIds}")
    public AjaxResult remove(@PathVariable Long[] projectIds)
    {
        return toAjax(maintenanceProjectService.deleteMaintenanceProjectByProjectIds(projectIds));
    }
}
