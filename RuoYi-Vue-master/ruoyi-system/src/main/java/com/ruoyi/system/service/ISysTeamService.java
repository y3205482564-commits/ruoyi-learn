package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysTeam;

/**
 * 班组信息Service接口
 * 
 * @author ruoyi
 * @date 2025-11-26
 */
public interface ISysTeamService 
{
    /**
     * 查询班组信息
     * 
     * @param teamId 班组信息主键
     * @return 班组信息
     */
    public SysTeam selectSysTeamByTeamId(Long teamId);

    /**
     * 查询班组信息列表
     * 
     * @param sysTeam 班组信息
     * @return 班组信息集合
     */
    public List<SysTeam> selectSysTeamList(SysTeam sysTeam);

    /**
     * 新增班组信息
     * 
     * @param sysTeam 班组信息
     * @return 结果
     */
    public int insertSysTeam(SysTeam sysTeam);

    /**
     * 修改班组信息
     * 
     * @param sysTeam 班组信息
     * @return 结果
     */
    public int updateSysTeam(SysTeam sysTeam);

    /**
     * 批量删除班组信息
     * 
     * @param teamIds 需要删除的班组信息主键集合
     * @return 结果
     */
    public int deleteSysTeamByTeamIds(Long[] teamIds);

    /**
     * 删除班组信息信息
     * 
     * @param teamId 班组信息主键
     * @return 结果
     */
    public int deleteSysTeamByTeamId(Long teamId);
}
