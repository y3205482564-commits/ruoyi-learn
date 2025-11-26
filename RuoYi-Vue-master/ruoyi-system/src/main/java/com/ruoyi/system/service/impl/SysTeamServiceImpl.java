package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysTeamMapper;
import com.ruoyi.system.domain.SysTeam;
import com.ruoyi.system.service.ISysTeamService;

/**
 * 班组信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-11-26
 */
@Service
public class SysTeamServiceImpl implements ISysTeamService 
{
    @Autowired
    private SysTeamMapper sysTeamMapper;

    /**
     * 查询班组信息
     * 
     * @param teamId 班组信息主键
     * @return 班组信息
     */
    @Override
    public SysTeam selectSysTeamByTeamId(Long teamId)
    {
        return sysTeamMapper.selectSysTeamByTeamId(teamId);
    }

    /**
     * 查询班组信息列表
     * 
     * @param sysTeam 班组信息
     * @return 班组信息
     */
    @Override
    public List<SysTeam> selectSysTeamList(SysTeam sysTeam)
    {
        return sysTeamMapper.selectSysTeamList(sysTeam);
    }

    /**
     * 新增班组信息
     * 
     * @param sysTeam 班组信息
     * @return 结果
     */
    @Override
    public int insertSysTeam(SysTeam sysTeam)
    {
        sysTeam.setCreateTime(DateUtils.getNowDate());
        return sysTeamMapper.insertSysTeam(sysTeam);
    }

    /**
     * 修改班组信息
     * 
     * @param sysTeam 班组信息
     * @return 结果
     */
    @Override
    public int updateSysTeam(SysTeam sysTeam)
    {
        sysTeam.setUpdateTime(DateUtils.getNowDate());
        return sysTeamMapper.updateSysTeam(sysTeam);
    }

    /**
     * 批量删除班组信息
     * 
     * @param teamIds 需要删除的班组信息主键
     * @return 结果
     */
    @Override
    public int deleteSysTeamByTeamIds(Long[] teamIds)
    {
        return sysTeamMapper.deleteSysTeamByTeamIds(teamIds);
    }

    /**
     * 删除班组信息信息
     * 
     * @param teamId 班组信息主键
     * @return 结果
     */
    @Override
    public int deleteSysTeamByTeamId(Long teamId)
    {
        return sysTeamMapper.deleteSysTeamByTeamId(teamId);
    }
}
