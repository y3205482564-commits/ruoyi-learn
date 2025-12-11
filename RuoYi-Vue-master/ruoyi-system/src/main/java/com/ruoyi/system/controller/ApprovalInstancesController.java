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
import com.ruoyi.system.domain.ApprovalInstances;
import com.ruoyi.system.service.IApprovalInstancesService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 审批实例Controller
 * 
 * @author ruoyi
 * @date 2025-12-11
 */
@RestController
@RequestMapping("/system/instances")
public class ApprovalInstancesController extends BaseController
{
    @Autowired
    private IApprovalInstancesService approvalInstancesService;

    /**
     * 查询审批实例列表
     */
    @PreAuthorize("@ss.hasPermi('system:instances:list')")
    @GetMapping("/list")
    public TableDataInfo list(ApprovalInstances approvalInstances)
    {
        startPage();
        List<ApprovalInstances> list = approvalInstancesService.selectApprovalInstancesList(approvalInstances);
        return getDataTable(list);
    }

    /**
     * 导出审批实例列表
     */
    @PreAuthorize("@ss.hasPermi('system:instances:export')")
    @Log(title = "审批实例", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ApprovalInstances approvalInstances)
    {
        List<ApprovalInstances> list = approvalInstancesService.selectApprovalInstancesList(approvalInstances);
        ExcelUtil<ApprovalInstances> util = new ExcelUtil<ApprovalInstances>(ApprovalInstances.class);
        util.exportExcel(response, list, "审批实例数据");
    }

    /**
     * 获取审批实例详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:instances:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(approvalInstancesService.selectApprovalInstancesById(id));
    }

    /**
     * 新增审批实例
     */
    @PreAuthorize("@ss.hasPermi('system:instances:add')")
    @Log(title = "审批实例", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ApprovalInstances approvalInstances)
    {
        return toAjax(approvalInstancesService.insertApprovalInstances(approvalInstances));
    }

    /**
     * 修改审批实例
     */
    @PreAuthorize("@ss.hasPermi('system:instances:edit')")
    @Log(title = "审批实例", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ApprovalInstances approvalInstances)
    {
        return toAjax(approvalInstancesService.updateApprovalInstances(approvalInstances));
    }

    /**
     * 删除审批实例
     */
    @PreAuthorize("@ss.hasPermi('system:instances:remove')")
    @Log(title = "审批实例", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(approvalInstancesService.deleteApprovalInstancesByIds(ids));
    }
}
