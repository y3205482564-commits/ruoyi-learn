import request from '@/utils/request'

// 查询审批流程定义列表
export function listProcesses(query) {
  return request({
    url: '/system/processes/list',
    method: 'get',
    params: query
  })
}

// 查询审批流程定义详细
export function getProcesses(id) {
  return request({
    url: '/system/processes/' + id,
    method: 'get'
  })
}

// 新增审批流程定义
export function addProcesses(data) {
  return request({
    url: '/system/processes',
    method: 'post',
    data: data
  })
}

// 修改审批流程定义
export function updateProcesses(data) {
  return request({
    url: '/system/processes',
    method: 'put',
    data: data
  })
}

// 删除审批流程定义
export function delProcesses(id) {
  return request({
    url: '/system/processes/' + id,
    method: 'delete'
  })
}
