import request from '@/utils/request'

// 查询班组信息列表
export function listTeam(query) {
  return request({
    url: '/system/team/list',
    method: 'get',
    params: query
  })
}

// 查询班组信息详细
export function getTeam(teamId) {
  return request({
    url: '/system/team/' + teamId,
    method: 'get'
  })
}

// 新增班组信息
export function addTeam(data) {
  return request({
    url: '/system/team',
    method: 'post',
    data: data
  })
}

// 修改班组信息
export function updateTeam(data) {
  return request({
    url: '/system/team',
    method: 'put',
    data: data
  })
}

// 删除班组信息
export function delTeam(teamId) {
  return request({
    url: '/system/team/' + teamId,
    method: 'delete'
  })
}
