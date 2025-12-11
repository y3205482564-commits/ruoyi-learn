-- 审批流程定义表
CREATE TABLE approval_processes (
                                    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '流程ID',
                                    process_name VARCHAR(100) NOT NULL COMMENT '流程名称',
                                    process_code VARCHAR(50) NOT NULL UNIQUE COMMENT '流程编码',
                                    description TEXT COMMENT '流程描述',
                                    category VARCHAR(50) NOT NULL COMMENT '流程分类(如：请假、报销等)',
                                    version INT DEFAULT 1 COMMENT '流程版本',
                                    is_active TINYINT(1) DEFAULT 1 COMMENT '是否启用(1启用，0停用)',
                                    creator_id BIGINT NOT NULL COMMENT '创建人ID',
                                    min_approvers INT DEFAULT 1 COMMENT '最少审批人数',
                                    approval_strategy ENUM('sequential', 'parallel', 'anyone') DEFAULT 'sequential' COMMENT '审批策略',
                                    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                    FOREIGN KEY (creator_id) REFERENCES sys_user(user_id),
                                    INDEX idx_category_active (category, is_active)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='审批流程定义表';

-- 审批节点表
CREATE TABLE approval_nodes (
                                id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '节点ID',
                                process_id BIGINT NOT NULL COMMENT '所属流程ID',
                                node_name VARCHAR(100) NOT NULL COMMENT '节点名称',
                                node_order INT NOT NULL COMMENT '节点顺序(从1开始)',
                                approver_type ENUM('user', 'role', 'department', 'specific') NOT NULL COMMENT '审批人类型',
                                approver_value VARCHAR(255) NOT NULL COMMENT '审批人值(用户ID、角色等)',
                                is_required TINYINT(1) DEFAULT 1 COMMENT '是否必须审批',
                                can_delegate TINYINT(1) DEFAULT 0 COMMENT '是否允许转审',
                                timeout_hours INT DEFAULT 72 COMMENT '审批超时时间(小时)',
                                conditions JSON COMMENT '审批条件(JSON格式)',
                                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                FOREIGN KEY (process_id) REFERENCES approval_processes(id) ON DELETE CASCADE,
                                INDEX idx_process_order (process_id, node_order)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='审批节点表';

-- 审批实例表
CREATE TABLE approval_instances (
                                    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '实例ID',
                                    instance_no VARCHAR(50) NOT NULL UNIQUE COMMENT '审批单号',
                                    process_id BIGINT NOT NULL COMMENT '流程ID',
                                    title VARCHAR(200) NOT NULL COMMENT '审批标题',
                                    applicant_id BIGINT NOT NULL COMMENT '申请人ID',
                                    applicant_dept_id BIGINT COMMENT '申请人部门ID',
                                    form_data JSON NOT NULL COMMENT '表单数据(JSON格式)',
                                    attachments JSON COMMENT '附件信息',
                                    current_status ENUM('draft', 'pending', 'processing', 'approved', 'rejected', 'cancelled') DEFAULT 'draft' COMMENT '当前状态',
                                    current_node_id BIGINT COMMENT '当前节点ID',
                                    priority ENUM('low', 'normal', 'high', 'urgent') DEFAULT 'normal' COMMENT '优先级',
                                    submit_time TIMESTAMP NULL COMMENT '提交时间',
                                    complete_time TIMESTAMP NULL COMMENT '完成时间',
                                    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                    FOREIGN KEY (process_id) REFERENCES approval_processes(id),
                                    FOREIGN KEY (applicant_id) REFERENCES sys_user(user_id),
                                    FOREIGN KEY (applicant_dept_id) REFERENCES sys_dept(dept_id),
                                    FOREIGN KEY (current_node_id) REFERENCES approval_nodes(id),
                                    INDEX idx_applicant_status (applicant_id, current_status),
                                    INDEX idx_submit_time (submit_time)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='审批实例表';

-- 审批任务表
CREATE TABLE approval_tasks (
                                id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '任务ID',
                                instance_id BIGINT NOT NULL COMMENT '审批实例ID',
                                node_id BIGINT NOT NULL COMMENT '节点ID',
                                approver_id BIGINT NOT NULL COMMENT '审批人ID',
                                approver_type ENUM('primary', 'delegate') DEFAULT 'primary' COMMENT '审批人类型(主审/转审)',
                                original_approver_id BIGINT COMMENT '原审批人ID(转审时使用)',
                                status ENUM('pending', 'approved', 'rejected', 'delegated', 'expired') DEFAULT 'pending' COMMENT '任务状态',
                                due_time TIMESTAMP NULL COMMENT '截止时间',
                                assigned_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '分配时间',
                                handled_time TIMESTAMP NULL COMMENT '处理时间',
                                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                FOREIGN KEY (instance_id) REFERENCES approval_instances(id) ON DELETE CASCADE,
                                FOREIGN KEY (node_id) REFERENCES approval_nodes(id),
                                FOREIGN KEY (approver_id) REFERENCES sys_user(user_id),
                                FOREIGN KEY (original_approver_id) REFERENCES sys_user(user_id),
                                INDEX idx_approver_status (approver_id, status),
                                INDEX idx_instance_node (instance_id, node_id),
                                INDEX idx_due_time (due_time)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='审批任务表';

-- 审批记录表
CREATE TABLE approval_records (
                                  id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '记录ID',
                                  instance_id BIGINT NOT NULL COMMENT '审批实例ID',
                                  node_id BIGINT NOT NULL COMMENT '节点ID',
                                  task_id BIGINT COMMENT '对应任务ID',
                                  approver_id BIGINT NOT NULL COMMENT '审批人ID',
                                  action ENUM('submit', 'approve', 'reject', 'return', 'delegate', 'cancel') NOT NULL COMMENT '审批动作',
                                  comment TEXT COMMENT '审批意见',
                                  form_snapshot JSON COMMENT '表单快照',
                                  next_node_id BIGINT COMMENT '下一节点ID',
                                  operation_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '操作时间',
                                  ip_address VARCHAR(45) COMMENT '操作IP地址',
                                  user_agent VARCHAR(500) COMMENT '用户代理',
                                  FOREIGN KEY (instance_id) REFERENCES approval_instances(id) ON DELETE CASCADE,
                                  FOREIGN KEY (node_id) REFERENCES approval_nodes(id),
                                  FOREIGN KEY (task_id) REFERENCES approval_tasks(id),
                                  FOREIGN KEY (approver_id) REFERENCES sys_user(user_id),
                                  FOREIGN KEY (next_node_id) REFERENCES approval_nodes(id),
                                  INDEX idx_instance_operation (instance_id, operation_time),
                                  INDEX idx_approver_action (approver_id, action)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='审批记录表';