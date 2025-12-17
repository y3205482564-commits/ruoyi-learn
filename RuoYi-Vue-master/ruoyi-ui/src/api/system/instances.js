import request from '@/utils/request'

// 查询审批实例列表
export function listInstances(query) {
  return request({
    url: '/system/instances/list',
    method: 'get',
    params: query
  })
}

// 查询审批实例详细
export function getInstances(id) {
  return request({
    url: '/system/instances/' + id,
    method: 'get'
  })
}

// 新增审批实例
export function addInstances(data) {
  return request({
    url: '/system/instances',
    method: 'post',
    data: data
  })
}

// 修改审批实例
export function updateInstances(data) {
  return request({
    url: '/system/instances',
    method: 'put',
    data: data
  })
}

// 删除审批实例
export function delInstances(id) {
  return request({
    url: '/system/instances/' + id,
    method: 'delete'
  })
}
