# 外部系统数据接收API文档

## 功能概述

本系统提供了接收外部系统（EQMS系统）数据的功能，可以将外部系统的委托单数据自动导入到本系统中。

## API接口

### 1. 接收外部系统数据

**接口地址：** `POST /system/eqmsorder/external/receive`

**请求参数：** JSON格式，包含以下字段：

| 字段名 | 类型 | 必填 | 说明 |
|--------|------|------|------|
| commissionNo | String | 是 | 委托单编号 |
| planNo | String | 是 | 计划编号 |
| standardItemNo | String | 是 | 标准项目编号 |
| equipmentName | String | 是 | 设备名称 |
| projectName | String | 是 | 工程项目名称 |
| expectedStartDate | Date | 是 | 预计施工日期 |
| expectedEndDate | Date | 是 | 预计完工日期 |
| repairReason | String | 是 | 请修原因 |
| constructionTeamCode | String | 是 | 施工班代码 |
| constructionTeamName | String | 是 | 施工班名称 |
| projectCategory | String | 是 | 项目类别 |
| commissionDate | Date | 是 | 委托日期 |
| commissioner | String | 是 | 委托人 |
| inspectorName | String | 是 | 点检姓名 |
| externalSystemId | String | 是 | 外部系统标识 |
| dataSource | String | 是 | 数据来源 |

**响应示例：**
```json
{
    "code": 200,
    "msg": "操作成功",
    "data": 1
}
```

### 2. 测试示例数据

**接口地址：** `POST /system/external/example`

**说明：** 此接口用于测试外部数据接收功能，会自动创建示例数据并调用接收接口。

## 数据处理流程

1. **数据验证：** 系统会对接收到的数据进行基本验证
2. **数据转换：** 将外部数据格式转换为系统内部数据格式
3. **数据保存：** 将转换后的数据保存到数据库
4. **状态设置：** 自动设置数据状态为"正常"，同步状态为"已接收"
5. **记录日志：** 记录数据接收日志

## 示例数据

### 单条数据示例
```json
{
  "commissionNo": "EXT202512170002",
  "planNo": "PLAN202512170002",
  "standardItemNo": "STD202512170002",
  "equipmentName": "高压泵",
  "projectName": "泵站维修项目",
  "expectedStartDate": "2025-12-20",
  "expectedEndDate": "2025-12-25",
  "repairReason": "泵体磨损需要更换",
  "constructionTeamCode": "TEAM002",
  "constructionTeamName": "维修二班",
  "projectCategory": "机械维修",
  "commissionDate": "2025-12-17",
  "commissioner": "王五",
  "inspectorName": "赵六",
  "externalSystemId": "EQMS_SYSTEM_002",
  "dataSource": "EQMS外部系统"
}
```

## 测试方法

### 1. 使用Postman测试

1. 启动系统
2. 打开Postman
3. 设置请求方法为POST
4. 请求URL：`http://localhost:8080/system/eqmsorder/external/receive`
5. 设置Headers：`Content-Type: application/json`
6. 在Body中选择raw JSON格式，粘贴示例数据
7. 发送请求并查看响应

### 2. 使用curl测试

```bash
curl -X POST http://localhost:8080/system/eqmsorder/external/receive \
  -H "Content-Type: application/json" \
  -d @external_data_example.json
```

### 3. 使用测试接口

访问：`POST http://localhost:8080/system/external/example`

## 注意事项

1. **数据格式：** 日期格式必须为 `yyyy-MM-dd`
2. **必填字段：** 所有字段都是必填的
3. **数据验证：** 系统会对数据进行基本验证，不符合要求的数据会被拒绝
4. **重复处理：** 如果委托单编号已存在，系统会拒绝重复导入
5. **权限控制：** 需要相应的权限才能调用此接口

## 错误处理

| 错误码 | 说明 |
|--------|------|
| 400 | 请求数据格式错误 |
| 403 | 权限不足 |
| 500 | 服务器内部错误 |

## 扩展功能

系统支持以下扩展功能：

1. **批量数据接收：** 可以一次性接收多条外部系统数据
2. **数据验证：** 支持自定义数据验证规则
3. **数据转换：** 支持自定义数据转换逻辑
4. **日志记录：** 详细记录数据接收过程
5. **状态管理：** 自动管理数据同步状态

## 开发建议

1. **安全性：** 在实际部署时，建议添加API密钥验证
2. **性能：** 对于大量数据接收，建议采用异步处理方式
3. **监控：** 建议添加数据接收监控和告警机制
4. **扩展性：** 考虑支持多种外部系统的数据格式