-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('空间区域', '3', '1', 'area', 'system/area/index', 1, 0, 'C', '0', '0', 'system:area:list', '#', 'admin', sysdate(), '', null, '空间区域菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('空间区域查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'system:area:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('空间区域新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'system:area:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('空间区域修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'system:area:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('空间区域删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'system:area:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('空间区域导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'system:area:export',       '#', 'admin', sysdate(), '', null, '');