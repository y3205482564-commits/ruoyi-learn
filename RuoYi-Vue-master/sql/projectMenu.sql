-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('检修项目', '3', '1', 'project', 'system/project/index', 1, 0, 'C', '0', '0', 'system:project:list', '#', 'admin', sysdate(), '', null, '检修项目菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('检修项目查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'system:project:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('检修项目新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'system:project:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('检修项目修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'system:project:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('检修项目删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'system:project:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('检修项目导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'system:project:export',       '#', 'admin', sysdate(), '', null, '');