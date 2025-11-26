package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysTeamMember;

/**
 * 班组成员关联Mapper接口
 * 
 * @author ruoyi
 * @date 2025-11-26
 */
public interface SysTeamMemberMapper 
{
    /**
     * 查询班组成员关联
     * 
     * @param id 班组成员关联主键
     * @return 班组成员关联
     */
    public SysTeamMember selectSysTeamMemberById(Long id);

    /**
     * 查询班组成员关联列表
     * 
     * @param sysTeamMember 班组成员关联
     * @return 班组成员关联集合
     */
    public List<SysTeamMember> selectSysTeamMemberList(SysTeamMember sysTeamMember);

    /**
     * 新增班组成员关联
     * 
     * @param sysTeamMember 班组成员关联
     * @return 结果
     */
    public int insertSysTeamMember(SysTeamMember sysTeamMember);

    /**
     * 修改班组成员关联
     * 
     * @param sysTeamMember 班组成员关联
     * @return 结果
     */
    public int updateSysTeamMember(SysTeamMember sysTeamMember);

    /**
     * 删除班组成员关联
     * 
     * @param id 班组成员关联主键
     * @return 结果
     */
    public int deleteSysTeamMemberById(Long id);

    /**
     * 批量删除班组成员关联
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysTeamMemberByIds(Long[] ids);
}
