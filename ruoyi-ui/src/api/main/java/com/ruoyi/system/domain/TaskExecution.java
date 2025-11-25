package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 任务执行记录对象 task_execution
 * 
 * @author ruoyi
 * @date 2025-11-26
 */
public class TaskExecution extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 执行记录ID */
    private Long executionId;

    /** 任务ID */
    @Excel(name = "任务ID")
    private Long taskId;

    /** 执行人ID */
    @Excel(name = "执行人ID")
    private Long userId;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 实际工时 */
    @Excel(name = "实际工时")
    private BigDecimal actualHours;

    /** 工作内容 */
    @Excel(name = "工作内容")
    private String workContent;

    /** 使用材料 */
    @Excel(name = "使用材料")
    private String materialsUsed;

    /** 发现问题 */
    @Excel(name = "发现问题")
    private String problemsFound;

    /** 解决方案 */
    @Excel(name = "解决方案")
    private String solutions;

    /** 状态（in_progress:进行中 completed:已完成 paused:暂停） */
    @Excel(name = "状态", readConverterExp = "i=n_progress:进行中,c=ompleted:已完成,p=aused:暂停")
    private String status;

    public void setExecutionId(Long executionId) 
    {
        this.executionId = executionId;
    }

    public Long getExecutionId() 
    {
        return executionId;
    }

    public void setTaskId(Long taskId) 
    {
        this.taskId = taskId;
    }

    public Long getTaskId() 
    {
        return taskId;
    }

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }

    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }

    public void setActualHours(BigDecimal actualHours) 
    {
        this.actualHours = actualHours;
    }

    public BigDecimal getActualHours() 
    {
        return actualHours;
    }

    public void setWorkContent(String workContent) 
    {
        this.workContent = workContent;
    }

    public String getWorkContent() 
    {
        return workContent;
    }

    public void setMaterialsUsed(String materialsUsed) 
    {
        this.materialsUsed = materialsUsed;
    }

    public String getMaterialsUsed() 
    {
        return materialsUsed;
    }

    public void setProblemsFound(String problemsFound) 
    {
        this.problemsFound = problemsFound;
    }

    public String getProblemsFound() 
    {
        return problemsFound;
    }

    public void setSolutions(String solutions) 
    {
        this.solutions = solutions;
    }

    public String getSolutions() 
    {
        return solutions;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("executionId", getExecutionId())
            .append("taskId", getTaskId())
            .append("userId", getUserId())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("actualHours", getActualHours())
            .append("workContent", getWorkContent())
            .append("materialsUsed", getMaterialsUsed())
            .append("problemsFound", getProblemsFound())
            .append("solutions", getSolutions())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
