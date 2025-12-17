import request from '@/utils/request'

// 查询审批任务列表
export function listTasks(query) {
  return request({
    url: '/system/tasks/list',
    method: 'get',
    params: query
  })
}

// 查询审批任务详细
export function getTasks(id) {
  return request({
    url: '/system/tasks/' + id,
    method: 'get'
  })
}

// 新增审批任务
export function addTasks(data) {
  return request({
    url: '/system/tasks',
    method: 'post',
    data: data
  })
}

// 修改审批任务
export function updateTasks(data) {
  return request({
    url: '/system/tasks',
    method: 'put',
    data: data
  })
}

// 删除审批任务
export function delTasks(id) {
  return request({
    url: '/system/tasks/' + id,
    method: 'delete'
  })
}
