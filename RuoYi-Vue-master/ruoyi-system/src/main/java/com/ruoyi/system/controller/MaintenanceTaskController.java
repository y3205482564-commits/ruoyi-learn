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
import com.ruoyi.system.domain.MaintenanceTask;
import com.ruoyi.system.service.IMaintenanceTaskService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 检修任务Controller
 * 
 * @author ruoyi
 * @date 2025-11-26
 */
@RestController
@RequestMapping("/system/task")
public class MaintenanceTaskController extends BaseController
{
    @Autowired
    private IMaintenanceTaskService maintenanceTaskService;

    /**
     * 查询检修任务列表
     */
    @PreAuthorize("@ss.hasPermi('system:task:list')")
    @GetMapping("/list")
    public TableDataInfo list(MaintenanceTask maintenanceTask)
    {
        startPage();
        List<MaintenanceTask> list = maintenanceTaskService.selectMaintenanceTaskList(maintenanceTask);
        return getDataTable(list);
    }

    /**
     * 导出检修任务列表
     */
    @PreAuthorize("@ss.hasPermi('system:task:export')")
    @Log(title = "检修任务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MaintenanceTask maintenanceTask)
    {
        List<MaintenanceTask> list = maintenanceTaskService.selectMaintenanceTaskList(maintenanceTask);
        ExcelUtil<MaintenanceTask> util = new ExcelUtil<MaintenanceTask>(MaintenanceTask.class);
        util.exportExcel(response, list, "检修任务数据");
    }

    /**
     * 获取检修任务详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:task:query')")
    @GetMapping(value = "/{taskId}")
    public AjaxResult getInfo(@PathVariable("taskId") Long taskId)
    {
        return success(maintenanceTaskService.selectMaintenanceTaskByTaskId(taskId));
    }

    /**
     * 新增检修任务
     */
    @PreAuthorize("@ss.hasPermi('system:task:add')")
    @Log(title = "检修任务", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MaintenanceTask maintenanceTask)
    {
        return toAjax(maintenanceTaskService.insertMaintenanceTask(maintenanceTask));
    }

    /**
     * 修改检修任务
     */
    @PreAuthorize("@ss.hasPermi('system:task:edit')")
    @Log(title = "检修任务", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MaintenanceTask maintenanceTask)
    {
        return toAjax(maintenanceTaskService.updateMaintenanceTask(maintenanceTask));
    }

    /**
     * 删除检修任务
     */
    @PreAuthorize("@ss.hasPermi('system:task:remove')")
    @Log(title = "检修任务", businessType = BusinessType.DELETE)
	@DeleteMapping("/{taskIds}")
    public AjaxResult remove(@PathVariable Long[] taskIds)
    {
        return toAjax(maintenanceTaskService.deleteMaintenanceTaskByTaskIds(taskIds));
    }
}
