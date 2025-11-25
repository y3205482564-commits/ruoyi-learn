<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="任务ID" prop="taskId">
        <el-input
          v-model="queryParams.taskId"
          placeholder="请输入任务ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="分配人ID" prop="assignerId">
        <el-input
          v-model="queryParams.assignerId"
          placeholder="请输入分配人ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="被分配对象ID" prop="assigneeId">
        <el-input
          v-model="queryParams.assigneeId"
          placeholder="请输入被分配对象ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="分配时间" prop="assignmentTime">
        <el-date-picker clearable
          v-model="queryParams.assignmentTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择分配时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="截止时间" prop="deadline">
        <el-date-picker clearable
          v-model="queryParams.deadline"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择截止时间">
        </el-date-picker>
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
          v-hasPermi="['system:assignment:add']"
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
          v-hasPermi="['system:assignment:edit']"
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
          v-hasPermi="['system:assignment:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:assignment:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="assignmentList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="分配记录ID" align="center" prop="assignmentId" />
      <el-table-column label="任务ID" align="center" prop="taskId" />
      <el-table-column label="分配人ID" align="center" prop="assignerId" />
      <el-table-column label="分配类型" align="center" prop="assigneeType" />
      <el-table-column label="被分配对象ID" align="center" prop="assigneeId" />
      <el-table-column label="分配时间" align="center" prop="assignmentTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.assignmentTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="截止时间" align="center" prop="deadline" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.deadline, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="分配说明" align="center" prop="instructions" />
      <el-table-column label="状态" align="center" prop="status" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:assignment:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:assignment:remove']"
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

    <!-- 添加或修改任务分配记录对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="任务ID" prop="taskId">
          <el-input v-model="form.taskId" placeholder="请输入任务ID" />
        </el-form-item>
        <el-form-item label="分配人ID" prop="assignerId">
          <el-input v-model="form.assignerId" placeholder="请输入分配人ID" />
        </el-form-item>
        <el-form-item label="被分配对象ID" prop="assigneeId">
          <el-input v-model="form.assigneeId" placeholder="请输入被分配对象ID" />
        </el-form-item>
        <el-form-item label="分配时间" prop="assignmentTime">
          <el-date-picker clearable
            v-model="form.assignmentTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择分配时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="截止时间" prop="deadline">
          <el-date-picker clearable
            v-model="form.deadline"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择截止时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="分配说明" prop="instructions">
          <el-input v-model="form.instructions" type="textarea" placeholder="请输入内容" />
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
import { listAssignment, getAssignment, delAssignment, addAssignment, updateAssignment } from "@/api/system/assignment"

export default {
  name: "Assignment",
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
      // 任务分配记录表格数据
      assignmentList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        taskId: null,
        assignerId: null,
        assigneeType: null,
        assigneeId: null,
        assignmentTime: null,
        deadline: null,
        instructions: null,
        status: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        taskId: [
          { required: true, message: "任务ID不能为空", trigger: "blur" }
        ],
        assignerId: [
          { required: true, message: "分配人ID不能为空", trigger: "blur" }
        ],
        assigneeId: [
          { required: true, message: "被分配对象ID不能为空", trigger: "blur" }
        ],
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询任务分配记录列表 */
    getList() {
      this.loading = true
      listAssignment(this.queryParams).then(response => {
        this.assignmentList = response.rows
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
        assignmentId: null,
        taskId: null,
        assignerId: null,
        assigneeType: null,
        assigneeId: null,
        assignmentTime: null,
        deadline: null,
        instructions: null,
        status: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null
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
      this.ids = selection.map(item => item.assignmentId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset()
      this.open = true
      this.title = "添加任务分配记录"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const assignmentId = row.assignmentId || this.ids
      getAssignment(assignmentId).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改任务分配记录"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.assignmentId != null) {
            updateAssignment(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addAssignment(this.form).then(response => {
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
      const assignmentIds = row.assignmentId || this.ids
      this.$modal.confirm('是否确认删除任务分配记录编号为"' + assignmentIds + '"的数据项？').then(function() {
        return delAssignment(assignmentIds)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("删除成功")
      }).catch(() => {})
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/assignment/export', {
        ...this.queryParams
      }, `assignment_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
