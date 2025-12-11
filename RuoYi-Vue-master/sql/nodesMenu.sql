-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('审批节点', '3', '1', 'nodes', 'system/nodes/index', 1, 0, 'C', '0', '0', 'system:nodes:list', '#', 'admin', sysdate(), '', null, '审批节点菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('审批节点查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'system:nodes:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('审批节点新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'system:nodes:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('审批节点修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'system:nodes:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('审批节点删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'system:nodes:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('审批节点导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'system:nodes:export',       '#', 'admin', sysdate(), '', null, '');