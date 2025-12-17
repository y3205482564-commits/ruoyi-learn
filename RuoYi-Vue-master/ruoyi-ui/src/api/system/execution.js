import request from '@/utils/request'

// 查询任务执行记录列表
export function listExecution(query) {
  return request({
    url: '/system/execution/list',
    method: 'get',
    params: query
  })
}

// 查询任务执行记录详细
export function getExecution(executionId) {
  return request({
    url: '/system/execution/' + executionId,
    method: 'get'
  })
}

// 新增任务执行记录
export function addExecution(data) {
  return request({
    url: '/system/execution',
    method: 'post',
    data: data
  })
}

// 修改任务执行记录
export function updateExecution(data) {
  return request({
    url: '/system/execution',
    method: 'put',
    data: data
  })
}

// 删除任务执行记录
export function delExecution(executionId) {
  return request({
    url: '/system/execution/' + executionId,
    method: 'delete'
  })
}
