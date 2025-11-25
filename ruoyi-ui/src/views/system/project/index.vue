<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="项目编号" prop="projectCode">
        <el-input
          v-model="queryParams.projectCode"
          placeholder="请输入项目编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="项目名称" prop="projectName">
        <el-input
          v-model="queryParams.projectName"
          placeholder="请输入项目名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="负责部门ID" prop="deptId">
        <el-input
          v-model="queryParams.deptId"
          placeholder="请输入负责部门ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="负责班组ID" prop="teamId">
        <el-input
          v-model="queryParams.teamId"
          placeholder="请输入负责班组ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="项目负责人用户ID" prop="projectLeader">
        <el-input
          v-model="queryParams.projectLeader"
          placeholder="请输入项目负责人用户ID"
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
      <el-form-item label="预算金额" prop="budgetAmount">
        <el-input
          v-model="queryParams.budgetAmount"
          placeholder="请输入预算金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="实际金额" prop="actualAmount">
        <el-input
          v-model="queryParams.actualAmount"
          placeholder="请输入实际金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="计划工时" prop="manHours">
        <el-input
          v-model="queryParams.manHours"
          placeholder="请输入计划工时"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="实际工时" prop="actualManHours">
        <el-input
          v-model="queryParams.actualManHours"
          placeholder="请输入实际工时"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="安全等级" prop="safetyLevel">
        <el-input
          v-model="queryParams.safetyLevel"
          placeholder="请输入安全等级"
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
          v-hasPermi="['system:project:add']"
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
          v-hasPermi="['system:project:edit']"
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
          v-hasPermi="['system:project:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:project:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="projectList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="项目ID" align="center" prop="projectId" />
      <el-table-column label="项目编号" align="center" prop="projectCode" />
      <el-table-column label="项目名称" align="center" prop="projectName" />
      <el-table-column label="项目类型" align="center" prop="projectType" />
      <el-table-column label="负责部门ID" align="center" prop="deptId" />
      <el-table-column label="负责班组ID" align="center" prop="teamId" />
      <el-table-column label="项目负责人用户ID" align="center" prop="projectLeader" />
      <el-table-column label="项目描述" align="center" prop="description" />
      <el-table-column label="检修地点" align="center" prop="location" />
      <el-table-column label="优先级" align="center" prop="priority" />
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
      <el-table-column label="预算金额" align="center" prop="budgetAmount" />
      <el-table-column label="实际金额" align="center" prop="actualAmount" />
      <el-table-column label="计划工时" align="center" prop="manHours" />
      <el-table-column label="实际工时" align="center" prop="actualManHours" />
      <el-table-column label="安全等级" align="center" prop="safetyLevel" />
      <el-table-column label="风险评估" align="center" prop="riskAssessment" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:project:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:project:remove']"
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

    <!-- 添加或修改检修项目对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="项目编号" prop="projectCode">
          <el-input v-model="form.projectCode" placeholder="请输入项目编号" />
        </el-form-item>
        <el-form-item label="项目名称" prop="projectName">
          <el-input v-model="form.projectName" placeholder="请输入项目名称" />
        </el-form-item>
        <el-form-item label="负责部门ID" prop="deptId">
          <el-input v-model="form.deptId" placeholder="请输入负责部门ID" />
        </el-form-item>
        <el-form-item label="负责班组ID" prop="teamId">
          <el-input v-model="form.teamId" placeholder="请输入负责班组ID" />
        </el-form-item>
        <el-form-item label="项目负责人用户ID" prop="projectLeader">
          <el-input v-model="form.projectLeader" placeholder="请输入项目负责人用户ID" />
        </el-form-item>
        <el-form-item label="项目描述" prop="description">
          <el-input v-model="form.description" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="检修地点" prop="location">
          <el-input v-model="form.location" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="优先级" prop="priority">
          <el-input v-model="form.priority" placeholder="请输入优先级" />
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
        <el-form-item label="预算金额" prop="budgetAmount">
          <el-input v-model="form.budgetAmount" placeholder="请输入预算金额" />
        </el-form-item>
        <el-form-item label="实际金额" prop="actualAmount">
          <el-input v-model="form.actualAmount" placeholder="请输入实际金额" />
        </el-form-item>
        <el-form-item label="计划工时" prop="manHours">
          <el-input v-model="form.manHours" placeholder="请输入计划工时" />
        </el-form-item>
        <el-form-item label="实际工时" prop="actualManHours">
          <el-input v-model="form.actualManHours" placeholder="请输入实际工时" />
        </el-form-item>
        <el-form-item label="安全等级" prop="safetyLevel">
          <el-input v-model="form.safetyLevel" placeholder="请输入安全等级" />
        </el-form-item>
        <el-form-item label="风险评估" prop="riskAssessment">
          <el-input v-model="form.riskAssessment" type="textarea" placeholder="请输入内容" />
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
import { listProject, getProject, delProject, addProject, updateProject } from "@/api/system/project"

export default {
  name: "Project",
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
      // 检修项目表格数据
      projectList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        projectCode: null,
        projectName: null,
        projectType: null,
        deptId: null,
        teamId: null,
        projectLeader: null,
        description: null,
        location: null,
        priority: null,
        planStartTime: null,
        planEndTime: null,
        actualStartTime: null,
        actualEndTime: null,
        status: null,
        progress: null,
        budgetAmount: null,
        actualAmount: null,
        manHours: null,
        actualManHours: null,
        safetyLevel: null,
        riskAssessment: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        projectCode: [
          { required: true, message: "项目编号不能为空", trigger: "blur" }
        ],
        projectName: [
          { required: true, message: "项目名称不能为空", trigger: "blur" }
        ],
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询检修项目列表 */
    getList() {
      this.loading = true
      listProject(this.queryParams).then(response => {
        this.projectList = response.rows
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
        projectId: null,
        projectCode: null,
        projectName: null,
        projectType: null,
        deptId: null,
        teamId: null,
        projectLeader: null,
        description: null,
        location: null,
        priority: null,
        planStartTime: null,
        planEndTime: null,
        actualStartTime: null,
        actualEndTime: null,
        status: null,
        progress: null,
        budgetAmount: null,
        actualAmount: null,
        manHours: null,
        actualManHours: null,
        safetyLevel: null,
        riskAssessment: null,
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
      this.ids = selection.map(item => item.projectId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset()
      this.open = true
      this.title = "添加检修项目"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const projectId = row.projectId || this.ids
      getProject(projectId).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改检修项目"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.projectId != null) {
            updateProject(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addProject(this.form).then(response => {
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
      const projectIds = row.projectId || this.ids
      this.$modal.confirm('是否确认删除检修项目编号为"' + projectIds + '"的数据项？').then(function() {
        return delProject(projectIds)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("删除成功")
      }).catch(() => {})
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/project/export', {
        ...this.queryParams
      }, `project_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
