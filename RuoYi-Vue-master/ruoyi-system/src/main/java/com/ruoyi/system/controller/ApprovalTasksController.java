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
import com.ruoyi.system.domain.ApprovalTasks;
import com.ruoyi.system.service.IApprovalTasksService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 审批任务Controller
 * 
 * @author ruoyi
 * @date 2025-12-11
 */
@RestController
@RequestMapping("/system/tasks")
public class ApprovalTasksController extends BaseController
{
    @Autowired
    private IApprovalTasksService approvalTasksService;

    /**
     * 查询审批任务列表
     */
    @PreAuthorize("@ss.hasPermi('system:tasks:list')")
    @GetMapping("/list")
    public TableDataInfo list(ApprovalTasks approvalTasks)
    {
        startPage();
        List<ApprovalTasks> list = approvalTasksService.selectApprovalTasksList(approvalTasks);
        return getDataTable(list);
    }

    /**
     * 导出审批任务列表
     */
    @PreAuthorize("@ss.hasPermi('system:tasks:export')")
    @Log(title = "审批任务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ApprovalTasks approvalTasks)
    {
        List<ApprovalTasks> list = approvalTasksService.selectApprovalTasksList(approvalTasks);
        ExcelUtil<ApprovalTasks> util = new ExcelUtil<ApprovalTasks>(ApprovalTasks.class);
        util.exportExcel(response, list, "审批任务数据");
    }

    /**
     * 获取审批任务详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:tasks:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(approvalTasksService.selectApprovalTasksById(id));
    }

    /**
     * 新增审批任务
     */
    @PreAuthorize("@ss.hasPermi('system:tasks:add')")
    @Log(title = "审批任务", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ApprovalTasks approvalTasks)
    {
        return toAjax(approvalTasksService.insertApprovalTasks(approvalTasks));
    }

    /**
     * 修改审批任务
     */
    @PreAuthorize("@ss.hasPermi('system:tasks:edit')")
    @Log(title = "审批任务", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ApprovalTasks approvalTasks)
    {
        return toAjax(approvalTasksService.updateApprovalTasks(approvalTasks));
    }

    /**
     * 删除审批任务
     */
    @PreAuthorize("@ss.hasPermi('system:tasks:remove')")
    @Log(title = "审批任务", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(approvalTasksService.deleteApprovalTasksByIds(ids));
    }
}
