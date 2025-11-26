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
import com.ruoyi.system.domain.SysTeam;
import com.ruoyi.system.service.ISysTeamService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 班组信息Controller
 * 
 * @author ruoyi
 * @date 2025-11-26
 */
@RestController
@RequestMapping("/system/team")
public class SysTeamController extends BaseController
{
    @Autowired
    private ISysTeamService sysTeamService;

    /**
     * 查询班组信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:team:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysTeam sysTeam)
    {
        startPage();
        List<SysTeam> list = sysTeamService.selectSysTeamList(sysTeam);
        return getDataTable(list);
    }

    /**
     * 导出班组信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:team:export')")
    @Log(title = "班组信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysTeam sysTeam)
    {
        List<SysTeam> list = sysTeamService.selectSysTeamList(sysTeam);
        ExcelUtil<SysTeam> util = new ExcelUtil<SysTeam>(SysTeam.class);
        util.exportExcel(response, list, "班组信息数据");
    }

    /**
     * 获取班组信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:team:query')")
    @GetMapping(value = "/{teamId}")
    public AjaxResult getInfo(@PathVariable("teamId") Long teamId)
    {
        return success(sysTeamService.selectSysTeamByTeamId(teamId));
    }

    /**
     * 新增班组信息
     */
    @PreAuthorize("@ss.hasPermi('system:team:add')")
    @Log(title = "班组信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysTeam sysTeam)
    {
        return toAjax(sysTeamService.insertSysTeam(sysTeam));
    }

    /**
     * 修改班组信息
     */
    @PreAuthorize("@ss.hasPermi('system:team:edit')")
    @Log(title = "班组信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysTeam sysTeam)
    {
        return toAjax(sysTeamService.updateSysTeam(sysTeam));
    }

    /**
     * 删除班组信息
     */
    @PreAuthorize("@ss.hasPermi('system:team:remove')")
    @Log(title = "班组信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{teamIds}")
    public AjaxResult remove(@PathVariable Long[] teamIds)
    {
        return toAjax(sysTeamService.deleteSysTeamByTeamIds(teamIds));
    }
}
