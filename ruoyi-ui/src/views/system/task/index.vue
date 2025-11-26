<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="项目ID" prop="projectId">
        <el-input
          v-model="queryParams.projectId"
          placeholder="请输入项目ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="任务编号" prop="taskCode">
        <el-input
          v-model="queryParams.taskCode"
          placeholder="请输入任务编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="任务名称" prop="taskName">
        <el-input
          v-model="queryParams.taskName"
          placeholder="请输入任务名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="分配班组ID" prop="assignedTeamId">
        <el-input
          v-model="queryParams.assignedTeamId"
          placeholder="请输入分配班组ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="分配人员用户ID" prop="assignedUserId">
        <el-input
          v-model="queryParams.assignedUserId"
          placeholder="请输入分配人员用户ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="分配人用户ID" prop="assignerId">
        <el-input
          v-model="queryParams.assignerId"
          placeholder="请输入分配人用户ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="计划开始时间" prop="planStartTime">
        <el-date-picker clearable
          v-model="queryParams.planStartTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择计划开始时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="计划结束时间" prop="planEndTime">
        <el-date-picker clearable
          v-model="queryParams.planEndTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择计划结束时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="实际开始时间" prop="actualStartTime">
        <el-date-picker clearable
          v-model="queryParams.actualStartTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择实际开始时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="实际结束时间" prop="actualEndTime">
        <el-date-picker clearable
          v-model="queryParams.actualEndTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择实际结束时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="进度百分比" prop="progress">
        <el-input
          v-model="queryParams.progress"
          placeholder="请输入进度百分比"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="预计工时" prop="workHours">
        <el-input
          v-model="queryParams.workHours"
          placeholder="请输入预计工时"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="实际工时" prop="actualHours">
        <el-input
          v-model="queryParams.actualHours"
          placeholder="请输入实际工时"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="质量检查" prop="qualityCheck">
        <el-input
          v-model="queryParams.qualityCheck"
          placeholder="请输入质量检查"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="优先级" prop="priority">
        <el-input
          v-model="queryParams.priority"
          placeholder="请输入优先级"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="紧急程度" prop="urgency">
        <el-input
          v-model="queryParams.urgency"
          placeholder="请输入紧急程度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:task:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:task:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:task:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:task:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="taskList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="任务ID" align="center" prop="taskId" />
      <el-table-column label="项目ID" align="center" prop="projectId" />
      <el-table-column label="任务编号" align="center" prop="taskCode" />
      <el-table-column label="任务名称" align="center" prop="taskName" />
      <el-table-column label="任务类型" align="center" prop="taskType" />
      <el-table-column label="分配班组ID" align="center" prop="assignedTeamId" />
      <el-table-column label="分配人员用户ID" align="center" prop="assignedUserId" />
      <el-table-column label="分配人用户ID" align="center" prop="assignerId" />
      <el-table-column label="任务描述" align="center" prop="description" />
      <el-table-column label="任务要求" align="center" prop="requirements" />
      <el-table-column label="检查项目" align="center" prop="checkItems" />
      <el-table-column label="计划开始时间" align="center" prop="planStartTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.planStartTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="计划结束时间" align="center" prop="planEndTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.planEndTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="实际开始时间" align="center" prop="actualStartTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.actualStartTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="实际结束时间" align="center" prop="actualEndTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.actualEndTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="状态" align="center" prop="status" />
      <el-table-column label="进度百分比" align="center" prop="progress" />
      <el-table-column label="预计工时" align="center" prop="workHours" />
      <el-table-column label="实际工时" align="center" prop="actualHours" />
      <el-table-column label="执行结果描述" align="center" prop="resultDescription" />
      <el-table-column label="质量检查" align="center" prop="qualityCheck" />
      <el-table-column label="优先级" align="center" prop="priority" />
      <el-table-column label="紧急程度" align="center" prop="urgency" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:task:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:task:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改检修任务对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="项目ID" prop="projectId">
          <el-input v-model="form.projectId" placeholder="请输入项目ID" />
        </el-form-item>
        <el-form-item label="任务编号" prop="taskCode">
          <el-input v-model="form.taskCode" placeholder="请输入任务编号" />
        </el-form-item>
        <el-form-item label="任务名称" prop="taskName">
          <el-input v-model="form.taskName" placeholder="请输入任务名称" />
        </el-form-item>
        <el-form-item label="分配班组ID" prop="assignedTeamId">
          <el-input v-model="form.assignedTeamId" placeholder="请输入分配班组ID" />
        </el-form-item>
        <el-form-item label="分配人员用户ID" prop="assignedUserId">
          <el-input v-model="form.assignedUserId" placeholder="请输入分配人员用户ID" />
        </el-form-item>
        <el-form-item label="分配人用户ID" prop="assignerId">
          <el-input v-model="form.assignerId" placeholder="请输入分配人用户ID" />
        </el-form-item>
        <el-form-item label="任务描述" prop="description">
          <el-input v-model="form.description" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="任务要求" prop="requirements">
          <el-input v-model="form.requirements" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="检查项目" prop="checkItems">
          <el-input v-model="form.checkItems" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="计划开始时间" prop="planStartTime">
          <el-date-picker clearable
            v-model="form.planStartTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择计划开始时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="计划结束时间" prop="planEndTime">
          <el-date-picker clearable
            v-model="form.planEndTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择计划结束时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="实际开始时间" prop="actualStartTime">
          <el-date-picker clearable
            v-model="form.actualStartTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择实际开始时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="实际结束时间" prop="actualEndTime">
          <el-date-picker clearable
            v-model="form.actualEndTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择实际结束时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="进度百分比" prop="progress">
          <el-input v-model="form.progress" placeholder="请输入进度百分比" />
        </el-form-item>
        <el-form-item label="预计工时" prop="workHours">
          <el-input v-model="form.workHours" placeholder="请输入预计工时" />
        </el-form-item>
        <el-form-item label="实际工时" prop="actualHours">
          <el-input v-model="form.actualHours" placeholder="请输入实际工时" />
        </el-form-item>
        <el-form-item label="执行结果描述" prop="resultDescription">
          <el-input v-model="form.resultDescription" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="质量检查" prop="qualityCheck">
          <el-input v-model="form.qualityCheck" placeholder="请输入质量检查" />
        </el-form-item>
        <el-form-item label="优先级" prop="priority">
          <el-input v-model="form.priority" placeholder="请输入优先级" />
        </el-form-item>
        <el-form-item label="紧急程度" prop="urgency">
          <el-input v-model="form.urgency" placeholder="请输入紧急程度" />
        </el-form-item>
        <el-form-item label="删除标志" prop="delFlag">
          <el-input v-model="form.delFlag" placeholder="请输入删除标志" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listTask, getTask, delTask, addTask, updateTask } from "@/api/system/task"

export default {
  name: "Task",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 检修任务表格数据
      taskList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        projectId: null,
        taskCode: null,
        taskName: null,
        taskType: null,
        assignedTeamId: null,
        assignedUserId: null,
        assignerId: null,
        description: null,
        requirements: null,
        checkItems: null,
        planStartTime: null,
        planEndTime: null,
        actualStartTime: null,
        actualEndTime: null,
        status: null,
        progress: null,
        workHours: null,
        actualHours: null,
        resultDescription: null,
        qualityCheck: null,
        priority: null,
        urgency: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        projectId: [
          { required: true, message: "项目ID不能为空", trigger: "blur" }
        ],
        taskCode: [
          { required: true, message: "任务编号不能为空", trigger: "blur" }
        ],
        taskName: [
          { required: true, message: "任务名称不能为空", trigger: "blur" }
        ],
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询检修任务列表 */
    getList() {
      this.loading = true
      listTask(this.queryParams).then(response => {
        this.taskList = response.rows
        this.total = response.total
        this.loading = false
      })
    },
    // 取消按钮
    cancel() {
      this.open = false
      this.reset()
    },
    // 表单重置
    reset() {
      this.form = {
        taskId: null,
        projectId: null,
        taskCode: null,
        taskName: null,
        taskType: null,
        assignedTeamId: null,
        assignedUserId: null,
        assignerId: null,
        description: null,
        requirements: null,
        checkItems: null,
        planStartTime: null,
        planEndTime: null,
        actualStartTime: null,
        actualEndTime: null,
        status: null,
        progress: null,
        workHours: null,
        actualHours: null,
        resultDescription: null,
        qualityCheck: null,
        priority: null,
        urgency: null,
        delFlag: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null
      }
      this.resetForm("form")
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1
      this.getList()
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm")
      this.handleQuery()
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.taskId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset()
      this.open = true
      this.title = "添加检修任务"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const taskId = row.taskId || this.ids
      getTask(taskId).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改检修任务"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.taskId != null) {
            updateTask(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addTask(this.form).then(response => {
              this.$modal.msgSuccess("新增成功")
              this.open = false
              this.getList()
            })
          }
        }
      })
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const taskIds = row.taskId || this.ids
      this.$modal.confirm('是否确认删除检修任务编号为"' + taskIds + '"的数据项？').then(function() {
        return delTask(taskIds)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("删除成功")
      }).catch(() => {})
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/task/export', {
        ...this.queryParams
      }, `task_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
