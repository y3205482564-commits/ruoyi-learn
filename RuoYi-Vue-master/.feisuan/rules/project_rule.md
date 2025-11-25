
# 开发规范指南

为保证代码质量、可维护性、安全性与可扩展性，请在开发过程中严格遵循以下规范。

## 一、项目基本信息

- **工作目录**: `D:\idea\ruoyi-test\RuoYi-Vue-master`
- **代码作者**: 32054
- **操作系统**: Windows 11
- **构建工具**: Maven
- **SDK 版本**: JDK 1.8.0_462

## 二、目录结构

```
RuoYi-Vue-master
├── doc
├── ruoyi-admin
│   └── src
│       └── main
│           ├── java
│           │   └── com
│           │       └── ruoyi
│           │           └── web
│           │               ├── controller
│           │               │   ├── common
│           │               │   ├── monitor
│           │               │   ├── system
│           │               │   └── tool
│           │               └── core
│           │                   └── config
│           └── resources
│               ├── i18n
│               ├── META-INF
│               └── mybatis
├── ruoyi-common
│   └── src
│       └── main
│           └── java
│               └── com
│                   └── ruoyi
│                       └── common
│                           ├── annotation
│                           ├── config
│                           │   └── serializer
│                           ├── constant
│                           ├── core
│                           │   ├── controller
│                           │   ├── domain
│                           │   │   ├── entity
│                           │   │   └── model
│                           │   ├── page
│                           │   ├── redis
│                           │   └── text
│                           ├── enums
│                           ├── exception
│                           │   ├── base
│                           │   ├── file
│                           │   ├── job
│                           │   └── user
│                           ├── filter
│                           ├── utils
│                           │   ├── bean
│                           │   ├── file
│                           │   ├── html
│                           │   ├── http
│                           │   ├── ip
│                           │   ├── poi
│                           │   ├── reflect
│                           │   ├── sign
│                           │   ├── spring
│                           │   ├── sql
│                           │   └── uuid
│                           └── xss
├── ruoyi-framework
│   └── src
│       └── main
│           └── java
│               └── com
│                   └── ruoyi
│                       └── framework
│                           ├── aspectj
│                           ├── config
│                           │   └── properties
│                           ├── datasource
│                           ├── interceptor
│                           │   └── impl
│                           ├── manager
│                           │   └── factory
│                           ├── security
│                           │   ├── context
│                           │   ├── filter
│                           │   └── handle
│                           └── web
│                               ├── domain
│                               │   └── server
│                               ├── exception
│                               └── service
├── ruoyi-generator
│   └── src
│       └── main
│           ├── java
│           │   └── com
│           │       └── ruoyi
│           │           └── generator
│           │               ├── config
│           │               ├── controller
│           │               ├── domain
│           │               ├── mapper
│           │               ├── service
│           │               └── util
│           └── resources
│               ├── mapper
│               │   └── generator
│               └── vm
│                   ├── java
│                   ├── js
│                   ├── sql
│                   ├── vue
│                   │   └── v3
│                   └── xml
├── ruoyi-quartz
│   └── src
│       └── main
│           ├── java
│           │   └── com
│           │       └── ruoyi
│           │           └── quartz
│           │               ├── config
│           │               ├── controller
│           │               ├── domain
│           │               ├── mapper
│           │               ├── service
│           │               │   └── impl
│           │               ├── task
│           │               └── util
│           └── resources
│               └── mapper
│                   └── quartz
├── ruoyi-system
│   └── src
│       └── main
│           ├── java
│           │   └── com
│           │       └── ruoyi
│           │           └── system
│           │               ├── domain
│           │               │   └── vo
│           │               ├── mapper
│           │               └── service
│           │                   └── impl
│           └── resources
│               └── mapper
│                   └── system
└── sql
```

## 三、技术栈要求

- **主框架**: Spring Boot 2.5.15
- **语言版本**: Java 1.8
- **核心依赖**:
  - `spring-boot-starter-web`
  - `spring-boot-starter-data-jpa` (注：实际项目使用 MyBatis)
  - `lombok`
  - `MyBatis`
  - `Druid`
  - `FastJSON2`
  - `Swagger3`
  - `PageHelper`
  - `Quartz`
  - `Kaptcha`
  - `Redis`
  - `JWT`

## 四、分层架构规范

| 层级        | 职责说明                         | 开发约束与注意事项                                               |
|-------------|----------------------------------|----------------------------------------------------------------|
| **Controller** | 处理 HTTP 请求与响应，定义 API 接口 | 不得直接访问数据库，必须通过 Service 层调用                  |
| **Service**    | 实现业务逻辑、事务管理与数据校验   | 必须通过 Mapper 层访问数据库；返回 DTO 而非 Entity（除非必要） |
| **Mapper**     | 数据库访问与持久化操作             | 使用 MyBatis XML 配置；避免 N+1 查询问题                      |
| **Entity**     | 映射数据库表结构                   | 不得直接返回给前端（需转换为 DTO）；包名统一为 `domain.entity` |

### 接口与实现分离

- 所有接口实现类需放在接口所在包下的 `impl` 子包中。

## 五、安全与性能规范

### 输入校验

- 使用 `@Valid` 与 JSR-303 校验注解（如 `@NotBlank`, `@Size` 等）
  - 注意：Spring Boot 2.5.15 中校验注解位于 `javax.validation.constraints.*`

- 禁止手动拼接 SQL 字符串，防止 SQL 注入攻击。

### 事务管理

- `@Transactional` 注解仅用于 **Service 层**方法。
- 避免在循环中频繁提交事务，影响性能。

## 六、代码风格规范

### 命名规范

| 类型       | 命名方式             | 示例                  |
|------------|----------------------|-----------------------|
| 类名       | UpperCamelCase       | `UserServiceImpl`     |
| 方法/变量  | lowerCamelCase       | `saveUser()`          |
| 常量       | UPPER_SNAKE_CASE     | `MAX_LOGIN_ATTEMPTS`  |

### 注释规范

- 所有类、方法、字段需添加 **Javadoc** 注释。

### 类型命名规范（阿里巴巴风格）

| 后缀 | 用途说明                     | 示例         |
|------|------------------------------|--------------|
| DTO  | 数据传输对象                 | `UserDTO`    |
| DO   | 数据库实体对象               | `UserDO`     |
| BO   | 业务逻辑封装对象             | `UserBO`     |
| VO   | 视图展示对象                 | `UserVO`     |
| Query| 查询参数封装对象             | `UserQuery`  |

### 实体类简化工具

- 使用 Lombok 注解替代手动编写 getter/setter/构造方法：
  - `@Data`
  - `@NoArgsConstructor`
  - `@AllArgsConstructor`

## 七、扩展性与日志规范

### 接口优先原则

- 所有业务逻辑通过接口定义（如 `UserService`），具体实现放在 `impl` 包中（如 `UserServiceImpl`）。

### 日志记录

- 使用 `@Slf4j` 注解代替 `System.out.println`

## 八、编码原则总结

| 原则       | 说明                                       |
|------------|--------------------------------------------|
| **SOLID**  | 高内聚、低耦合，增强可维护性与可扩展性     |
| **DRY**    | 避免重复代码，提高复用性                   |
| **KISS**   | 保持代码简洁易懂                           |
| **YAGNI**  | 不实现当前不需要的功能                     |
| **OWASP**  | 防范常见安全漏洞，如 SQL 注入、XSS 等      |

## 九、通用规则总结

- **统一包结构**：各模块按照 `com.ruoyi.module` 的结构组织。
- **MyBatis 配置**：使用 XML 配置映射文件，不推荐使用注解。
- **代码生成器**：使用 `ruoyi-generator` 模块进行代码自动生成。
- **数据库连接池**：使用 Druid 连接池。
- **日志配置**：使用 Logback 进行日志记录。
- **国际化支持**：支持多语言切换，资源文件位于 `resources/i18n` 目录下。
- **权限控制**：使用 Spring Security 实现权限控制。
- **定时任务**：基于 Quartz 实现定时任务调度。
- **验证码**：使用 Kaptcha 实现图形验证码功能。
- **文件上传**：使用 Commons IO 实现文件上传功能。
- **API 文档**：使用 Swagger3 提供 RESTful API 文档。
- **分页查询**：使用 PageHelper 插件实现分页查询。
- **缓存机制**：使用 Redis 实现缓存功能。
- **安全认证**：使用 JWT 实现 Token 认证。
- **异常处理**：统一异常处理机制，提升用户体验。
- **代码审查**：定期进行代码审查，确保代码质量和一致性。
