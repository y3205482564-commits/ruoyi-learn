-- ----------------------------
-- 22、检修项目表
-- ----------------------------
DROP TABLE IF EXISTS maintenance_project;
CREATE TABLE maintenance_project (
                                     project_id        BIGINT(20)      NOT NULL AUTO_INCREMENT    COMMENT '项目ID',
                                     project_code      VARCHAR(50)     NOT NULL                   COMMENT '项目编号',
                                     project_name      VARCHAR(200)    NOT NULL                   COMMENT '项目名称',
                                     project_type      VARCHAR(50)     DEFAULT ''                 COMMENT '项目类型',
                                     dept_id           BIGINT(20)      DEFAULT NULL               COMMENT '负责部门ID',
                                     team_id           BIGINT(20)      DEFAULT NULL               COMMENT '负责班组ID',
                                     project_leader    BIGINT(20)      DEFAULT NULL               COMMENT '项目负责人用户ID',

    -- 项目基本信息
                                     description       TEXT                                      COMMENT '项目描述',
                                     location          VARCHAR(500)    DEFAULT ''                 COMMENT '检修地点',
                                     priority          CHAR(1)         DEFAULT '1'                COMMENT '优先级（1低 2中 3高）',

    -- 时间安排
                                     plan_start_time   DATETIME                                  COMMENT '计划开始时间',
                                     plan_end_time     DATETIME                                  COMMENT '计划结束时间',
                                     actual_start_time DATETIME                                  COMMENT '实际开始时间',
                                     actual_end_time   DATETIME                                  COMMENT '实际结束时间',

    -- 状态管理
                                     status            VARCHAR(20)     DEFAULT 'draft'           COMMENT '状态（draft:草稿 published:已发布 assigned:已分配 in_progress:进行中 completed:已完成 cancelled:已取消）',
                                     progress          INT             DEFAULT 0                  COMMENT '进度百分比',

    -- 资源信息
                                     budget_amount     DECIMAL(15,2)   DEFAULT 0.00              COMMENT '预算金额',
                                     actual_amount     DECIMAL(15,2)   DEFAULT 0.00              COMMENT '实际金额',
                                     man_hours         DECIMAL(8,2)    DEFAULT 0.00              COMMENT '计划工时',
                                     actual_man_hours  DECIMAL(8,2)    DEFAULT 0.00              COMMENT '实际工时',

    -- 安全信息
                                     safety_level      VARCHAR(20)     DEFAULT 'general'         COMMENT '安全等级（general:一般 important:重要 critical:关键）',
                                     risk_assessment   TEXT                                      COMMENT '风险评估',

                                     del_flag          CHAR(1)         DEFAULT '0'               COMMENT '删除标志（0存在 2删除）',
                                     create_by         VARCHAR(64)     DEFAULT ''                COMMENT '创建者',
                                     create_time       DATETIME                                 COMMENT '创建时间',
                                     update_by         VARCHAR(64)     DEFAULT ''                COMMENT '更新者',
                                     update_time       DATETIME                                 COMMENT '更新时间',
                                     remark            VARCHAR(500)    DEFAULT NULL              COMMENT '备注',
                                     PRIMARY KEY (project_id),
                                     UNIQUE KEY idx_project_code (project_code),
                                     KEY idx_dept_id (dept_id),
                                     KEY idx_team_id (team_id),
                                     KEY idx_status (status),
                                     KEY idx_plan_time (plan_start_time, plan_end_time)
) ENGINE=INNODB AUTO_INCREMENT=1 COMMENT = '检修项目表';

-- ----------------------------
-- 23、检修任务表
-- ----------------------------
DROP TABLE IF EXISTS maintenance_task;
CREATE TABLE maintenance_task (
                                  task_id           BIGINT(20)      NOT NULL AUTO_INCREMENT    COMMENT '任务ID',
                                  project_id        BIGINT(20)      NOT NULL                   COMMENT '项目ID',
                                  task_code         VARCHAR(50)     NOT NULL                   COMMENT '任务编号',
                                  task_name         VARCHAR(200)    NOT NULL                   COMMENT '任务名称',
                                  task_type         VARCHAR(50)     DEFAULT ''                 COMMENT '任务类型',

    -- 分配信息
                                  assigned_team_id  BIGINT(20)      DEFAULT NULL               COMMENT '分配班组ID',
                                  assigned_user_id  BIGINT(20)      DEFAULT NULL               COMMENT '分配人员用户ID',
                                  assigner_id       BIGINT(20)      DEFAULT NULL               COMMENT '分配人用户ID',

    -- 任务内容
                                  description       TEXT                                      COMMENT '任务描述',
                                  requirements      TEXT                                      COMMENT '任务要求',
                                  check_items       TEXT                                      COMMENT '检查项目',

    -- 时间安排
                                  plan_start_time   DATETIME                                  COMMENT '计划开始时间',
                                  plan_end_time     DATETIME                                  COMMENT '计划结束时间',
                                  actual_start_time DATETIME                                  COMMENT '实际开始时间',
                                  actual_end_time   DATETIME                                  COMMENT '实际结束时间',

    -- 状态管理
                                  status            VARCHAR(20)     DEFAULT 'pending'         COMMENT '状态（pending:待分配 assigned:已分配 in_progress:进行中 completed:已完成 cancelled:已取消）',
                                  progress          INT             DEFAULT 0                  COMMENT '进度百分比',

    -- 执行信息
                                  work_hours        DECIMAL(6,2)    DEFAULT 0.00              COMMENT '预计工时',
                                  actual_hours      DECIMAL(6,2)    DEFAULT 0.00              COMMENT '实际工时',
                                  result_description TEXT                                     COMMENT '执行结果描述',
                                  quality_check     CHAR(1)         DEFAULT '0'               COMMENT '质量检查（0未检查 1合格 2不合格）',

    -- 优先级和紧急程度
                                  priority          CHAR(1)         DEFAULT '1'               COMMENT '优先级（1低 2中 3高）',
                                  urgency           CHAR(1)         DEFAULT '0'               COMMENT '紧急程度（0一般 1紧急 2特急）',

                                  del_flag          CHAR(1)         DEFAULT '0'               COMMENT '删除标志（0存在 2删除）',
                                  create_by         VARCHAR(64)     DEFAULT ''                COMMENT '创建者',
                                  create_time       DATETIME                                 COMMENT '创建时间',
                                  update_by         VARCHAR(64)     DEFAULT ''                COMMENT '更新者',
                                  update_time       DATETIME                                 COMMENT '更新时间',
                                  remark            VARCHAR(500)    DEFAULT NULL              COMMENT '备注',
                                  PRIMARY KEY (task_id),
                                  UNIQUE KEY idx_task_code (task_code),
                                  KEY idx_project_id (project_id),
                                  KEY idx_assigned_team (assigned_team_id),
                                  KEY idx_assigned_user (assigned_user_id),
                                  KEY idx_status (status)
) ENGINE=INNODB AUTO_INCREMENT=1 COMMENT = '检修任务表';

-- ----------------------------
-- 26、任务分配记录表
-- ----------------------------
DROP TABLE IF EXISTS task_assignment;
CREATE TABLE task_assignment (
                                 assignment_id     BIGINT(20)      NOT NULL AUTO_INCREMENT    COMMENT '分配记录ID',
                                 task_id           BIGINT(20)      NOT NULL                   COMMENT '任务ID',
                                 assigner_id       BIGINT(20)      NOT NULL                   COMMENT '分配人ID',
                                 assignee_type     VARCHAR(10)     DEFAULT 'user'            COMMENT '分配类型（user:用户 team:班组）',
                                 assignee_id       BIGINT(20)      NOT NULL                   COMMENT '被分配对象ID',

                                 assignment_time   DATETIME                                  COMMENT '分配时间',
                                 deadline          DATETIME                                  COMMENT '截止时间',
                                 instructions      VARCHAR(1000)   DEFAULT ''                COMMENT '分配说明',

                                 status            VARCHAR(20)     DEFAULT 'active'          COMMENT '状态（active:有效 cancelled:已取消 completed:已完成）',

                                 create_by         VARCHAR(64)     DEFAULT ''                COMMENT '创建者',
                                 create_time       DATETIME                                 COMMENT '创建时间',
                                 update_by         VARCHAR(64)     DEFAULT ''                COMMENT '更新者',
                                 update_time       DATETIME                                 COMMENT '更新时间',
                                 PRIMARY KEY (assignment_id),
                                 KEY idx_task_id (task_id),
                                 KEY idx_assignee (assignee_type, assignee_id),
                                 KEY idx_assigner (assigner_id)
) ENGINE=INNODB AUTO_INCREMENT=1 COMMENT = '任务分配记录表';

-- ----------------------------
-- 27、任务执行记录表
-- ----------------------------
DROP TABLE IF EXISTS task_execution;
CREATE TABLE task_execution (
                                execution_id      BIGINT(20)      NOT NULL AUTO_INCREMENT    COMMENT '执行记录ID',
                                task_id           BIGINT(20)      NOT NULL                   COMMENT '任务ID',
                                user_id           BIGINT(20)      NOT NULL                   COMMENT '执行人ID',

                                start_time        DATETIME                                  COMMENT '开始时间',
                                end_time          DATETIME                                  COMMENT '结束时间',
                                actual_hours      DECIMAL(6,2)    DEFAULT 0.00              COMMENT '实际工时',

                                work_content      TEXT                                      COMMENT '工作内容',
                                materials_used    VARCHAR(1000)   DEFAULT ''                COMMENT '使用材料',
                                problems_found    VARCHAR(1000)   DEFAULT ''                COMMENT '发现问题',
                                solutions         VARCHAR(1000)   DEFAULT ''                COMMENT '解决方案',

                                status            VARCHAR(20)     DEFAULT 'in_progress'     COMMENT '状态（in_progress:进行中 completed:已完成 paused:暂停）',

                                create_by         VARCHAR(64)     DEFAULT ''                COMMENT '创建者',
                                create_time       DATETIME                                 COMMENT '创建时间',
                                update_by         VARCHAR(64)     DEFAULT ''                COMMENT '更新者',
                                update_time       DATETIME                                 COMMENT '更新时间',
                                PRIMARY KEY (execution_id),
                                KEY idx_task_id (task_id),
                                KEY idx_user_id (user_id),
                                KEY idx_time (start_time, end_time)
) ENGINE=INNODB AUTO_INCREMENT=1 COMMENT = '任务执行记录表';