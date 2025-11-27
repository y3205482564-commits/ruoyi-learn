-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('空间设备', '3', '1', 'equipment', 'system/equipment/index', 1, 0, 'C', '0', '0', 'system:equipment:list', '#', 'admin', sysdate(), '', null, '空间设备菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('空间设备查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'system:equipment:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('空间设备新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'system:equipment:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('空间设备修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'system:equipment:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('空间设备删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'system:equipment:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('空间设备导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'system:equipment:export',       '#', 'admin', sysdate(), '', null, '');