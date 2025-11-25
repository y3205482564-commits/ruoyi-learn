import request from '@/utils/request'

// 查询任务分配记录列表
export function listAssignment(query) {
  return request({
    url: '/system/assignment/list',
    method: 'get',
    params: query
  })
}

// 查询任务分配记录详细
export function getAssignment(assignmentId) {
  return request({
    url: '/system/assignment/' + assignmentId,
    method: 'get'
  })
}

// 新增任务分配记录
export function addAssignment(data) {
  return request({
    url: '/system/assignment',
    method: 'post',
    data: data
  })
}

// 修改任务分配记录
export function updateAssignment(data) {
  return request({
    url: '/system/assignment',
    method: 'put',
    data: data
  })
}

// 删除任务分配记录
export function delAssignment(assignmentId) {
  return request({
    url: '/system/assignment/' + assignmentId,
    method: 'delete'
  })
}
