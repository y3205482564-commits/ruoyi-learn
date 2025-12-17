import request from '@/utils/request'

// 查询审批节点列表
export function listNodes(query) {
  return request({
    url: '/system/nodes/list',
    method: 'get',
    params: query
  })
}

// 查询审批节点详细
export function getNodes(id) {
  return request({
    url: '/system/nodes/' + id,
    method: 'get'
  })
}

// 新增审批节点
export function addNodes(data) {
  return request({
    url: '/system/nodes',
    method: 'post',
    data: data
  })
}

// 修改审批节点
export function updateNodes(data) {
  return request({
    url: '/system/nodes',
    method: 'put',
    data: data
  })
}

// 删除审批节点
export function delNodes(id) {
  return request({
    url: '/system/nodes/' + id,
    method: 'delete'
  })
}
