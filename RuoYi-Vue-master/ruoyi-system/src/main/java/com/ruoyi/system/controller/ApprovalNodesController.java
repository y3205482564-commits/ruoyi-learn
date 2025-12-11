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
import com.ruoyi.system.domain.ApprovalNodes;
import com.ruoyi.system.service.IApprovalNodesService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 审批节点Controller
 * 
 * @author ruoyi
 * @date 2025-12-11
 */
@RestController
@RequestMapping("/system/nodes")
public class ApprovalNodesController extends BaseController
{
    @Autowired
    private IApprovalNodesService approvalNodesService;

    /**
     * 查询审批节点列表
     */
    @PreAuthorize("@ss.hasPermi('system:nodes:list')")
    @GetMapping("/list")
    public TableDataInfo list(ApprovalNodes approvalNodes)
    {
        startPage();
        List<ApprovalNodes> list = approvalNodesService.selectApprovalNodesList(approvalNodes);
        return getDataTable(list);
    }

    /**
     * 导出审批节点列表
     */
    @PreAuthorize("@ss.hasPermi('system:nodes:export')")
    @Log(title = "审批节点", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ApprovalNodes approvalNodes)
    {
        List<ApprovalNodes> list = approvalNodesService.selectApprovalNodesList(approvalNodes);
        ExcelUtil<ApprovalNodes> util = new ExcelUtil<ApprovalNodes>(ApprovalNodes.class);
        util.exportExcel(response, list, "审批节点数据");
    }

    /**
     * 获取审批节点详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:nodes:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(approvalNodesService.selectApprovalNodesById(id));
    }

    /**
     * 新增审批节点
     */
    @PreAuthorize("@ss.hasPermi('system:nodes:add')")
    @Log(title = "审批节点", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ApprovalNodes approvalNodes)
    {
        return toAjax(approvalNodesService.insertApprovalNodes(approvalNodes));
    }

    /**
     * 修改审批节点
     */
    @PreAuthorize("@ss.hasPermi('system:nodes:edit')")
    @Log(title = "审批节点", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ApprovalNodes approvalNodes)
    {
        return toAjax(approvalNodesService.updateApprovalNodes(approvalNodes));
    }

    /**
     * 删除审批节点
     */
    @PreAuthorize("@ss.hasPermi('system:nodes:remove')")
    @Log(title = "审批节点", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(approvalNodesService.deleteApprovalNodesByIds(ids));
    }
}
