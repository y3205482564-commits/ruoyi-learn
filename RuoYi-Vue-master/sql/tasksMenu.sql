-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('审批任务', '3', '1', 'tasks', 'system/tasks/index', 1, 0, 'C', '0', '0', 'system:tasks:list', '#', 'admin', sysdate(), '', null, '审批任务菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('审批任务查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'system:tasks:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('审批任务新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'system:tasks:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('审批任务修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'system:tasks:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('审批任务删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'system:tasks:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('审批任务导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'system:tasks:export',       '#', 'admin', sysdate(), '', null, '');