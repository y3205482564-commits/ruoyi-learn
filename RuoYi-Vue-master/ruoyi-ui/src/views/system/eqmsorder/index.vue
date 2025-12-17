<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="委托单编号" prop="commissionNo">
        <el-input
          v-model="queryParams.commissionNo"
          placeholder="请输入委托单编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="计划编号" prop="planNo">
        <el-input
          v-model="queryParams.planNo"
          placeholder="请输入计划编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="标准项目编号" prop="standardItemNo">
        <el-input
          v-model="queryParams.standardItemNo"
          placeholder="请输入标准项目编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="设备名称" prop="equipmentName">
        <el-input
          v-model="queryParams.equipmentName"
          placeholder="请输入设备名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="工程项目名称" prop="projectName">
        <el-input
          v-model="queryParams.projectName"
          placeholder="请输入工程项目名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="预计施工日期" prop="expectedStartDate">
        <el-date-picker clearable
          v-model="queryParams.expectedStartDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择预计施工日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="预计完工日期" prop="expectedEndDate">
        <el-date-picker clearable
          v-model="queryParams.expectedEndDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择预计完工日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="施工班代码" prop="constructionTeamCode">
        <el-input
          v-model="queryParams.constructionTeamCode"
          placeholder="请输入施工班代码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="施工班名称" prop="constructionTeamName">
        <el-input
          v-model="queryParams.constructionTeamName"
          placeholder="请输入施工班名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="项目类别" prop="projectCategory">
        <el-input
          v-model="queryParams.projectCategory"
          placeholder="请输入项目类别"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="委托日期" prop="commissionDate">
        <el-date-picker clearable
          v-model="queryParams.commissionDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择委托日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="委托人" prop="commissioner">
        <el-input
          v-model="queryParams.commissioner"
          placeholder="请输入委托人"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="点检姓名" prop="inspectorName">
        <el-input
          v-model="queryParams.inspectorName"
          placeholder="请输入点检姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="同步时间" prop="syncTime">
        <el-date-picker clearable
          v-model="queryParams.syncTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择同步时间">
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
          v-hasPermi="['system:eqmsorder:add']"
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
          v-hasPermi="['system:eqmsorder:edit']"
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
          v-hasPermi="['system:eqmsorder:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:eqmsorder:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="eqmsorderList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键ID" align="center" prop="id" />
      <el-table-column label="委托单编号" align="center" prop="commissionNo" />
      <el-table-column label="计划编号" align="center" prop="planNo" />
      <el-table-column label="标准项目编号" align="center" prop="standardItemNo" />
      <el-table-column label="设备名称" align="center" prop="equipmentName" />
      <el-table-column label="工程项目名称" align="center" prop="projectName" />
      <el-table-column label="预计施工日期" align="center" prop="expectedStartDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.expectedStartDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="预计完工日期" align="center" prop="expectedEndDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.expectedEndDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="请修原因" align="center" prop="repairReason" />
      <el-table-column label="施工班代码" align="center" prop="constructionTeamCode" />
      <el-table-column label="施工班名称" align="center" prop="constructionTeamName" />
      <el-table-column label="项目类别" align="center" prop="projectCategory" />
      <el-table-column label="委托日期" align="center" prop="commissionDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.commissionDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="委托人" align="center" prop="commissioner" />
      <el-table-column label="点检姓名" align="center" prop="inspectorName" />
      <el-table-column label="状态" align="center" prop="status" />
      <el-table-column label="同步状态" align="center" prop="syncStatus" />
      <el-table-column label="同步时间" align="center" prop="syncTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.syncTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="同步消息" align="center" prop="syncMessage" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:eqmsorder:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:eqmsorder:remove']"
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

    <!-- 添加或修改EQMS委托单信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="委托单编号" prop="commissionNo">
          <el-input v-model="form.commissionNo" placeholder="请输入委托单编号" />
        </el-form-item>
        <el-form-item label="计划编号" prop="planNo">
          <el-input v-model="form.planNo" placeholder="请输入计划编号" />
        </el-form-item>
        <el-form-item label="标准项目编号" prop="standardItemNo">
          <el-input v-model="form.standardItemNo" placeholder="请输入标准项目编号" />
        </el-form-item>
        <el-form-item label="设备名称" prop="equipmentName">
          <el-input v-model="form.equipmentName" placeholder="请输入设备名称" />
        </el-form-item>
        <el-form-item label="工程项目名称" prop="projectName">
          <el-input v-model="form.projectName" placeholder="请输入工程项目名称" />
        </el-form-item>
        <el-form-item label="预计施工日期" prop="expectedStartDate">
          <el-date-picker clearable
            v-model="form.expectedStartDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择预计施工日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="预计完工日期" prop="expectedEndDate">
          <el-date-picker clearable
            v-model="form.expectedEndDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择预计完工日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="请修原因" prop="repairReason">
          <el-input v-model="form.repairReason" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="施工班代码" prop="constructionTeamCode">
          <el-input v-model="form.constructionTeamCode" placeholder="请输入施工班代码" />
        </el-form-item>
        <el-form-item label="施工班名称" prop="constructionTeamName">
          <el-input v-model="form.constructionTeamName" placeholder="请输入施工班名称" />
        </el-form-item>
        <el-form-item label="项目类别" prop="projectCategory">
          <el-input v-model="form.projectCategory" placeholder="请输入项目类别" />
        </el-form-item>
        <el-form-item label="委托日期" prop="commissionDate">
          <el-date-picker clearable
            v-model="form.commissionDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择委托日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="委托人" prop="commissioner">
          <el-input v-model="form.commissioner" placeholder="请输入委托人" />
        </el-form-item>
        <el-form-item label="点检姓名" prop="inspectorName">
          <el-input v-model="form.inspectorName" placeholder="请输入点检姓名" />
        </el-form-item>
        <el-form-item label="同步时间" prop="syncTime">
          <el-date-picker clearable
            v-model="form.syncTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择同步时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="同步消息" prop="syncMessage">
          <el-input v-model="form.syncMessage" type="textarea" placeholder="请输入内容" />
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
import { listEqmsorder, getEqmsorder, delEqmsorder, addEqmsorder, updateEqmsorder } from "@/api/system/eqmsorder"

export default {
  name: "Eqmsorder",
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
      // EQMS委托单信息表格数据
      eqmsorderList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        commissionNo: null,
        planNo: null,
        standardItemNo: null,
        equipmentName: null,
        projectName: null,
        expectedStartDate: null,
        expectedEndDate: null,
        repairReason: null,
        constructionTeamCode: null,
        constructionTeamName: null,
        projectCategory: null,
        commissionDate: null,
        commissioner: null,
        inspectorName: null,
        status: null,
        syncStatus: null,
        syncTime: null,
        syncMessage: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        commissionNo: [
          { required: true, message: "委托单编号不能为空", trigger: "blur" }
        ],
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询EQMS委托单信息列表 */
    getList() {
      this.loading = true
      listEqmsorder(this.queryParams).then(response => {
        this.eqmsorderList = response.rows
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
        id: null,
        commissionNo: null,
        planNo: null,
        standardItemNo: null,
        equipmentName: null,
        projectName: null,
        expectedStartDate: null,
        expectedEndDate: null,
        repairReason: null,
        constructionTeamCode: null,
        constructionTeamName: null,
        projectCategory: null,
        commissionDate: null,
        commissioner: null,
        inspectorName: null,
        status: null,
        syncStatus: null,
        syncTime: null,
        syncMessage: null,
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
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset()
      this.open = true
      this.title = "添加EQMS委托单信息"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const id = row.id || this.ids
      getEqmsorder(id).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改EQMS委托单信息"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateEqmsorder(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addEqmsorder(this.form).then(response => {
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
      const ids = row.id || this.ids
      this.$modal.confirm('是否确认删除EQMS委托单信息编号为"' + ids + '"的数据项？').then(function() {
        return delEqmsorder(ids)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("删除成功")
      }).catch(() => {})
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/eqmsorder/export', {
        ...this.queryParams
      }, `eqmsorder_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
