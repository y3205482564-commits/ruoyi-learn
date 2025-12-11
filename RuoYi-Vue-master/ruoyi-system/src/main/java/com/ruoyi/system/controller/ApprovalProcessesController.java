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
import com.ruoyi.system.domain.ApprovalProcesses;
import com.ruoyi.system.service.IApprovalProcessesService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 审批流程定义Controller
 * 
 * @author ruoyi
 * @date 2025-12-11
 */
@RestController
@RequestMapping("/system/processes")
public class ApprovalProcessesController extends BaseController
{
    @Autowired
    private IApprovalProcessesService approvalProcessesService;

    /**
     * 查询审批流程定义列表
     */
    @PreAuthorize("@ss.hasPermi('system:processes:list')")
    @GetMapping("/list")
    public TableDataInfo list(ApprovalProcesses approvalProcesses)
    {
        startPage();
        List<ApprovalProcesses> list = approvalProcessesService.selectApprovalProcessesList(approvalProcesses);
        return getDataTable(list);
    }

    /**
     * 导出审批流程定义列表
     */
    @PreAuthorize("@ss.hasPermi('system:processes:export')")
    @Log(title = "审批流程定义", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ApprovalProcesses approvalProcesses)
    {
        List<ApprovalProcesses> list = approvalProcessesService.selectApprovalProcessesList(approvalProcesses);
        ExcelUtil<ApprovalProcesses> util = new ExcelUtil<ApprovalProcesses>(ApprovalProcesses.class);
        util.exportExcel(response, list, "审批流程定义数据");
    }

    /**
     * 获取审批流程定义详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:processes:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(approvalProcessesService.selectApprovalProcessesById(id));
    }

    /**
     * 新增审批流程定义
     */
    @PreAuthorize("@ss.hasPermi('system:processes:add')")
    @Log(title = "审批流程定义", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ApprovalProcesses approvalProcesses)
    {
        return toAjax(approvalProcessesService.insertApprovalProcesses(approvalProcesses));
    }

    /**
     * 修改审批流程定义
     */
    @PreAuthorize("@ss.hasPermi('system:processes:edit')")
    @Log(title = "审批流程定义", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ApprovalProcesses approvalProcesses)
    {
        return toAjax(approvalProcessesService.updateApprovalProcesses(approvalProcesses));
    }

    /**
     * 删除审批流程定义
     */
    @PreAuthorize("@ss.hasPermi('system:processes:remove')")
    @Log(title = "审批流程定义", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(approvalProcessesService.deleteApprovalProcessesByIds(ids));
    }
}
