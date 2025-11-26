package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysTeamMemberMapper;
import com.ruoyi.system.domain.SysTeamMember;
import com.ruoyi.system.service.ISysTeamMemberService;

/**
 * 班组成员关联Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-11-26
 */
@Service
public class SysTeamMemberServiceImpl implements ISysTeamMemberService 
{
    @Autowired
    private SysTeamMemberMapper sysTeamMemberMapper;

    /**
     * 查询班组成员关联
     * 
     * @param id 班组成员关联主键
     * @return 班组成员关联
     */
    @Override
    public SysTeamMember selectSysTeamMemberById(Long id)
    {
        return sysTeamMemberMapper.selectSysTeamMemberById(id);
    }

    /**
     * 查询班组成员关联列表
     * 
     * @param sysTeamMember 班组成员关联
     * @return 班组成员关联
     */
    @Override
    public List<SysTeamMember> selectSysTeamMemberList(SysTeamMember sysTeamMember)
    {
        return sysTeamMemberMapper.selectSysTeamMemberList(sysTeamMember);
    }

    /**
     * 新增班组成员关联
     * 
     * @param sysTeamMember 班组成员关联
     * @return 结果
     */
    @Override
    public int insertSysTeamMember(SysTeamMember sysTeamMember)
    {
        sysTeamMember.setCreateTime(DateUtils.getNowDate());
        return sysTeamMemberMapper.insertSysTeamMember(sysTeamMember);
    }

    /**
     * 修改班组成员关联
     * 
     * @param sysTeamMember 班组成员关联
     * @return 结果
     */
    @Override
    public int updateSysTeamMember(SysTeamMember sysTeamMember)
    {
        sysTeamMember.setUpdateTime(DateUtils.getNowDate());
        return sysTeamMemberMapper.updateSysTeamMember(sysTeamMember);
    }

    /**
     * 批量删除班组成员关联
     * 
     * @param ids 需要删除的班组成员关联主键
     * @return 结果
     */
    @Override
    public int deleteSysTeamMemberByIds(Long[] ids)
    {
        return sysTeamMemberMapper.deleteSysTeamMemberByIds(ids);
    }

    /**
     * 删除班组成员关联信息
     * 
     * @param id 班组成员关联主键
     * @return 结果
     */
    @Override
    public int deleteSysTeamMemberById(Long id)
    {
        return sysTeamMemberMapper.deleteSysTeamMemberById(id);
    }
}
