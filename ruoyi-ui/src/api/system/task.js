import request from '@/utils/request'

// 查询检修任务列表
export function listTask(query) {
  return request({
    url: '/system/task/list',
    method: 'get',
    params: query
  })
}

// 查询检修任务详细
export function getTask(taskId) {
  return request({
    url: '/system/task/' + taskId,
    method: 'get'
  })
}

// 新增检修任务
export function addTask(data) {
  return request({
    url: '/system/task',
    method: 'post',
    data: data
  })
}

// 修改检修任务
export function updateTask(data) {
  return request({
    url: '/system/task',
    method: 'put',
    data: data
  })
}

// 删除检修任务
export function delTask(taskId) {
  return request({
    url: '/system/task/' + taskId,
    method: 'delete'
  })
}
