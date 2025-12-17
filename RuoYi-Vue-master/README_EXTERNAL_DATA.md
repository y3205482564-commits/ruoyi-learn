# 外部系统数据接收功能

## 功能说明

本系统提供了接收外部系统（EQMS系统）数据的功能，可以将外部系统的委托单数据自动导入到本系统中。

## 已实现功能

1. **数据接收接口** - 接收外部系统数据
2. **数据转换处理** - 将外部数据转换为系统内部格式
3. **状态自动管理** - 自动设置数据状态和同步状态
4. **日志记录** - 记录数据接收过程
5. **测试功能** - 提供测试接口和测试工具

## 文件结构

```
ruoyi-system/
├── src/main/java/com/ruoyi/system/
│   ├── controller/
│   │   ├── EqmsCommissionOrderController.java     # 原有控制器（已扩展）
│   │   └── ExternalDataController.java          # 外部数据控制器（新增）
│   ├── domain/
│   │   ├── EqmsCommissionOrder.java              # 原有实体类
│   │   └── vo/
│   │       └── ExternalEqmsData.java             # 外部数据传输对象（新增）
│   ├── service/
│   │   ├── IEqmsCommissionOrderService.java      # 原有服务接口（已扩展）
│   │   └── impl/
│   │       └── EqmsCommissionOrderServiceImpl.java # 原有服务实现（已扩展）
│   └── util/
│       └── ExternalDataTestUtil.java             # 测试工具类（新增）
├── external_data_example.json                     # 示例数据文件
├── external_system_api.md                         # API文档
├── test_external_data.py                          # 测试脚本
└── README_EXTERNAL_DATA.md                        # 本说明文件
```

## 快速开始

### 1. 启动系统

确保RuoYi-Vue系统已经正常启动。

### 2. 测试功能

#### 方法一：使用测试接口

访问以下URL进行测试：
```
POST http://localhost:8080/system/external/example
```

#### 方法二：使用Postman

1. 打开Postman
2. 设置请求方法为POST
3. 请求URL：`http://localhost:8080/system/eqmsorder/external/receive`
4. 设置Headers：`Content-Type: application/json`
5. 在Body中选择raw JSON格式，粘贴示例数据
6. 发送请求并查看响应

#### 方法三：使用测试脚本

```bash
python test_external_data.py
```

### 3. 查看结果

- 成功：返回状态码200，数据保存到数据库
- 失败：返回相应的错误信息

## API接口详情

### 接收外部系统数据

**接口：** `POST /system/eqmsorder/external/receive`

**功能：** 接收外部系统EQMS数据并保存到数据库

**请求参数：**
```json
{
  "commissionNo": "委托单编号",
  "planNo": "计划编号",
  "standardItemNo": "标准项目编号",
  "equipmentName": "设备名称",
  "projectName": "工程项目名称",
  "expectedStartDate": "预计施工日期",
  "expectedEndDate": "预计完工日期",
  "repairReason": "请修原因",
  "constructionTeamCode": "施工班代码",
  "constructionTeamName": "施工班名称",
  "projectCategory": "项目类别",
  "commissionDate": "委托日期",
  "commissioner": "委托人",
  "inspectorName": "点检姓名",
  "externalSystemId": "外部系统标识",
  "dataSource": "数据来源"
}
```

**响应示例：**
```json
{
    "code": 200,
    "msg": "操作成功",
    "data": 1
}
```

## 数据字段说明

| 字段名 | 说明 | 类型 | 必填 |
|--------|------|------|------|
| commissionNo | 委托单编号 | String | 是 |
| planNo | 计划编号 | String | 是 |
| standardItemNo | 标准项目编号 | String | 是 |
| equipmentName | 设备名称 | String | 是 |
| projectName | 工程项目名称 | String | 是 |
| expectedStartDate | 预计施工日期 | Date | 是 |
| expectedEndDate | 预计完工日期 | Date | 是 |
| repairReason | 请修原因 | String | 是 |
| constructionTeamCode | 施工班代码 | String | 是 |
| constructionTeamName | 施工班名称 | String | 是 |
| projectCategory | 项目类别 | String | 是 |
| commissionDate | 委托日期 | Date | 是 |
| commissioner | 委托人 | String | 是 |
| inspectorName | 点检姓名 | String | 是 |
| externalSystemId | 外部系统标识 | String | 是 |
| dataSource | 数据来源 | String | 是 |

## 数据处理流程

1. **接收数据** - 通过HTTP POST接口接收外部系统数据
2. **数据验证** - 验证数据格式和必填字段
3. **数据转换** - 将外部数据转换为系统内部格式
4. **数据保存** - 保存到数据库
5. **状态设置** - 设置数据状态为"正常"，同步状态为"已接收"
6. **日志记录** - 记录数据接收日志

## 扩展建议

1. **批量处理** - 可以扩展支持批量数据接收
2. **数据验证规则** - 可以添加更复杂的数据验证规则
3. **异步处理** - 对于大量数据，可以考虑异步处理
4. **监控告警** - 添加数据接收监控和告警机制
5. **API安全** - 添加API密钥验证机制

## 注意事项

1. 确保系统已经正常启动
2. 检查数据库连接是否正常
3. 确保用户有相应的权限
4. 日期格式必须为 `yyyy-MM-dd`
5. 所有字段都是必填的

## 故障排除

1. **连接失败** - 检查系统是否正常启动
2. **权限不足** - 检查用户权限设置
3. **数据格式错误** - 检查JSON格式和字段类型
4. **数据库错误** - 检查数据库配置和连接

## 技术支持

如遇到问题，请检查：
1. 系统日志
2. 数据库日志
3. 网络连接
4. 权限设置