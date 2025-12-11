-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('审批实例', '3', '1', 'instances', 'system/instances/index', 1, 0, 'C', '0', '0', 'system:instances:list', '#', 'admin', sysdate(), '', null, '审批实例菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('审批实例查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'system:instances:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('审批实例新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'system:instances:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('审批实例修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'system:instances:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('审批实例删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'system:instances:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('审批实例导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'system:instances:export',       '#', 'admin', sysdate(), '', null, '');