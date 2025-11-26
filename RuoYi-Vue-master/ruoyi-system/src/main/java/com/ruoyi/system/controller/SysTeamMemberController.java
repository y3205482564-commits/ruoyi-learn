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
import com.ruoyi.system.domain.SysTeamMember;
import com.ruoyi.system.service.ISysTeamMemberService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 班组成员关联Controller
 * 
 * @author ruoyi
 * @date 2025-11-26
 */
@RestController
@RequestMapping("/system/member")
public class SysTeamMemberController extends BaseController
{
    @Autowired
    private ISysTeamMemberService sysTeamMemberService;

    /**
     * 查询班组成员关联列表
     */
    @PreAuthorize("@ss.hasPermi('system:member:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysTeamMember sysTeamMember)
    {
        startPage();
        List<SysTeamMember> list = sysTeamMemberService.selectSysTeamMemberList(sysTeamMember);
        return getDataTable(list);
    }

    /**
     * 导出班组成员关联列表
     */
    @PreAuthorize("@ss.hasPermi('system:member:export')")
    @Log(title = "班组成员关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysTeamMember sysTeamMember)
    {
        List<SysTeamMember> list = sysTeamMemberService.selectSysTeamMemberList(sysTeamMember);
        ExcelUtil<SysTeamMember> util = new ExcelUtil<SysTeamMember>(SysTeamMember.class);
        util.exportExcel(response, list, "班组成员关联数据");
    }

    /**
     * 获取班组成员关联详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:member:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(sysTeamMemberService.selectSysTeamMemberById(id));
    }

    /**
     * 新增班组成员关联
     */
    @PreAuthorize("@ss.hasPermi('system:member:add')")
    @Log(title = "班组成员关联", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysTeamMember sysTeamMember)
    {
        return toAjax(sysTeamMemberService.insertSysTeamMember(sysTeamMember));
    }

    /**
     * 修改班组成员关联
     */
    @PreAuthorize("@ss.hasPermi('system:member:edit')")
    @Log(title = "班组成员关联", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysTeamMember sysTeamMember)
    {
        return toAjax(sysTeamMemberService.updateSysTeamMember(sysTeamMember));
    }

    /**
     * 删除班组成员关联
     */
    @PreAuthorize("@ss.hasPermi('system:member:remove')")
    @Log(title = "班组成员关联", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysTeamMemberService.deleteSysTeamMemberByIds(ids));
    }
}
