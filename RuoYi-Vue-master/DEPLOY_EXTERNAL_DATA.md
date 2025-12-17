# 外部系统数据接收功能部署说明

## 部署前准备

### 1. 系统要求

- JDK 1.8+
- Maven 3.6+
- MySQL 5.7+
- Redis 6.0+ (可选，用于缓存)
- Spring Boot 2.5.15+

### 2. 环境配置

确保以下环境变量已正确配置：

```bash
# 数据库配置
spring.datasource.url=jdbc:mysql://localhost:3306/ruoyi?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8
spring.datasource.username=root
spring.datasource.password=123456

# Redis配置（可选）
spring.redis.host=localhost
spring.redis.port=6379
spring.redis.password=
```

### 3. 数据库表结构

确保 `eqms_commission_order` 表已创建，表结构如下：

```sql
CREATE TABLE `eqms_commission_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `commission_no` varchar(100) DEFAULT NULL COMMENT '委托单编号',
  `plan_no` varchar(100) DEFAULT NULL COMMENT '计划编号',
  `standard_item_no` varchar(100) DEFAULT NULL COMMENT '标准项目编号',
  `equipment_name` varchar(100) DEFAULT NULL COMMENT '设备名称',
  `project_name` varchar(100) DEFAULT NULL COMMENT '工程项目名称',
  `expected_start_date` date DEFAULT NULL COMMENT '预计施工日期',
  `expected_end_date` date DEFAULT NULL COMMENT '预计完工日期',
  `repair_reason` text COMMENT '请修原因',
  `construction_team_code` varchar(100) DEFAULT NULL COMMENT '施工班代码',
  `construction_team_name` varchar(100) DEFAULT NULL COMMENT '施工班名称',
  `project_category` varchar(100) DEFAULT NULL COMMENT '项目类别',
  `commission_date` date DEFAULT NULL COMMENT '委托日期',
  `commissioner` varchar(100) DEFAULT NULL COMMENT '委托人',
  `inspector_name` varchar(100) DEFAULT NULL COMMENT '点检姓名',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `sync_status` char(1) DEFAULT '0' COMMENT '同步状态（0未处理 1已接收 2处理中 3已完成 4失败）',
  `sync_time` datetime DEFAULT NULL COMMENT '同步时间',
  `sync_message` text COMMENT '同步消息',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='EQMS委托单信息';
```

## 部署步骤

### 1. 编译项目

```bash
# 进入项目根目录
cd D:\idea\ruoyi-test\RuoYi-Vue-master

# 编译项目
mvn clean compile
```

### 2. 运行项目

```bash
# 运行项目
mvn spring-boot:run

# 或者打包后运行
mvn clean package
java -jar ruoyi-admin.jar
```

### 3. 验证部署

#### 方法一：浏览器访问

1. 打开浏览器
2. 访问：`http://localhost:8080`
3. 使用默认账号密码登录：
   - 用户名：admin
   - 密码：admin123

#### 方法二：API测试

使用Postman或其他API工具测试：

```bash
# 测试示例数据接口
curl -X POST http://localhost:8080/system/external/example
```

## 功能测试

### 1. 单条数据接收测试

```bash
# 使用curl测试
curl -X POST http://localhost:8080/system/eqmsorder/external/receive \
  -H "Content-Type: application/json" \
  -d '{
    "commissionNo": "EXT_TEST_001",
    "planNo": "PLAN_TEST_001",
    "standardItemNo": "STD_TEST_001",
    "equipmentName": "测试设备",
    "projectName": "测试项目",
    "expectedStartDate": "2025-12-17",
    "expectedEndDate": "2025-12-20",
    "repairReason": "测试原因",
    "constructionTeamCode": "TEAM_TEST",
    "constructionTeamName": "测试班",
    "projectCategory": "测试类",
    "commissionDate": "2025-12-17",
    "commissioner": "测试员",
    "inspectorName": "检查员",
    "externalSystemId": "TEST_SYSTEM",
    "dataSource": "测试系统"
  }'
```

### 2. 批量数据接收测试

创建一个包含多条数据的JSON文件 `batch_test.json`：

```json
[
  {
    "commissionNo": "EXT_BATCH_001",
    "planNo": "PLAN_BATCH_001",
    "standardItemNo": "STD_BATCH_001",
    "equipmentName": "批量测试设备1",
    "projectName": "批量测试项目1",
    "expectedStartDate": "2025-12-17",
    "expectedEndDate": "2025-12-20",
    "repairReason": "批量测试原因1",
    "constructionTeamCode": "TEAM_BATCH_1",
    "constructionTeamName": "批量测试班1",
    "projectCategory": "测试类",
    "commissionDate": "2025-12-17",
    "commissioner": "批量测试员1",
    "inspectorName": "批量检查员1",
    "externalSystemId": "BATCH_SYSTEM_1",
    "dataSource": "批量测试系统"
  },
  {
    "commissionNo": "EXT_BATCH_002",
    "planNo": "PLAN_BATCH_002",
    "standardItemNo": "STD_BATCH_002",
    "equipmentName": "批量测试设备2",
    "projectName": "批量测试项目2",
    "expectedStartDate": "2025-12-17",
    "expectedEndDate": "2025-12-20",
    "repairReason": "批量测试原因2",
    "constructionTeamCode": "TEAM_BATCH_2",
    "constructionTeamName": "批量测试班2",
    "projectCategory": "测试类",
    "commissionDate": "2025-12-17",
    "commissioner": "批量测试员2",
    "inspectorName": "批量检查员2",
    "externalSystemId": "BATCH_SYSTEM_2",
    "dataSource": "批量测试系统"
  }
]
```

然后执行：

```bash
# 批量数据测试
curl -X POST http://localhost:8080/system/eqmsorder/external/receive \
  -H "Content-Type: application/json" \
  -d @batch_test.json
```

### 3. 数据库验证

登录数据库，查询数据是否正确保存：

```sql
-- 查询最近保存的数据
SELECT * FROM eqms_commission_order 
ORDER BY create_time DESC 
LIMIT 10;
```

## 配置说明

### 1. 日志配置

在 `logback-spring.xml` 中添加外部数据接收日志：

```xml
<logger name="com.ruoyi.system.controller.EqmsCommissionOrderController" level="INFO" additivity="false">
    <appender-ref ref="FILE"/>
</logger>
```

### 2. 权限配置

确保用户有 `system:eqmsorder:add` 权限，可以在 `sys_menu` 表中添加：

```sql
INSERT INTO `sys_menu` VALUES (NULL, '外部数据接收', '900', '3', '1', '0', 'system', 'external', 'ExternalDataController', 'system:external', '#', '1', '0', '0', '0', '接收外部系统数据', 'system', '1', '0', 'admin', '2025-12-17 10:00:00', '', '');
INSERT INTO `sys_menu` VALUES (NULL, '接收数据', '901', '3', '900', '1', 'system', 'external/receive', 'ExternalDataController', 'system:external:receive', '#', '1', '1', '0', '0', '接收外部系统数据', 'system', '1', '0', 'admin', '2025-12-17 10:00:00', '', '');
```

## 故障排除

### 1. 常见问题

#### 问题1：数据库连接失败
**症状：** 应用启动时数据库连接失败
**解决：** 检查数据库配置和连接参数

#### 问题2：权限不足
**症状：** 调用API时返回403错误
**解决：** 检查用户权限配置

#### 问题3：数据格式错误
**症状：** 接收数据时返回400错误
**解决：** 检查JSON格式和数据类型

#### 问题4：端口占用
**症状：** 应用启动失败，端口被占用
**解决：** 修改 `application.yml` 中的端口配置

### 2. 日志查看

查看应用日志：
```bash
# 查看实时日志
tail -f logs/ruoyi.log

# 查看错误日志
grep ERROR logs/ruoyi.log
```

## 性能优化

### 1. 数据库优化

```sql
-- 添加索引优化查询性能
ALTER TABLE `eqms_commission_order` ADD INDEX `idx_commission_no` (`commission_no`);
ALTER TABLE `eqms_commission_order` ADD INDEX `idx_plan_no` (`plan_no`);
ALTER TABLE `eqms_commission_order` ADD INDEX `idx_create_time` (`create_time`);
```

### 2. 缓存配置

在 `application.yml` 中添加缓存配置：

```yaml
spring:
  cache:
    type: redis
    redis:
      time-to-live: 3600000  # 1小时
      key-prefix: eqms:
```

## 安全建议

1. **API安全：** 添加API密钥验证机制
2. **数据验证：** 加强输入数据验证
3. **日志监控：** 添加安全日志监控
4. **权限控制：** 严格控制API访问权限
5. **数据加密：** 敏感数据加密存储

## 技术支持

如遇到问题，请检查：
1. 系统日志文件
2. 数据库日志
3. 网络连接状态
4. 权限配置
5. 数据库表结构