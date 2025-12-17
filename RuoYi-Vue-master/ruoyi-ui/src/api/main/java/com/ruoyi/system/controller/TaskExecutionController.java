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
import com.ruoyi.system.domain.TaskExecution;
import com.ruoyi.system.service.ITaskExecutionService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 任务执行记录Controller
 * 
 * @author ruoyi
 * @date 2025-11-26
 */
@RestController
@RequestMapping("/system/execution")
public class TaskExecutionController extends BaseController
{
    @Autowired
    private ITaskExecutionService taskExecutionService;

    /**
     * 查询任务执行记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:execution:list')")
    @GetMapping("/list")
    public TableDataInfo list(TaskExecution taskExecution)
    {
        startPage();
        List<TaskExecution> list = taskExecutionService.selectTaskExecutionList(taskExecution);
        return getDataTable(list);
    }

    /**
     * 导出任务执行记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:execution:export')")
    @Log(title = "任务执行记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TaskExecution taskExecution)
    {
        List<TaskExecution> list = taskExecutionService.selectTaskExecutionList(taskExecution);
        ExcelUtil<TaskExecution> util = new ExcelUtil<TaskExecution>(TaskExecution.class);
        util.exportExcel(response, list, "任务执行记录数据");
    }

    /**
     * 获取任务执行记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:execution:query')")
    @GetMapping(value = "/{executionId}")
    public AjaxResult getInfo(@PathVariable("executionId") Long executionId)
    {
        return success(taskExecutionService.selectTaskExecutionByExecutionId(executionId));
    }

    /**
     * 新增任务执行记录
     */
    @PreAuthorize("@ss.hasPermi('system:execution:add')")
    @Log(title = "任务执行记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TaskExecution taskExecution)
    {
        return toAjax(taskExecutionService.insertTaskExecution(taskExecution));
    }

    /**
     * 修改任务执行记录
     */
    @PreAuthorize("@ss.hasPermi('system:execution:edit')")
    @Log(title = "任务执行记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TaskExecution taskExecution)
    {
        return toAjax(taskExecutionService.updateTaskExecution(taskExecution));
    }

    /**
     * 删除任务执行记录
     */
    @PreAuthorize("@ss.hasPermi('system:execution:remove')")
    @Log(title = "任务执行记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{executionIds}")
    public AjaxResult remove(@PathVariable Long[] executionIds)
    {
        return toAjax(taskExecutionService.deleteTaskExecutionByExecutionIds(executionIds));
    }
}
