import request from '@/utils/request'

// 查询EQMS委托单信息列表
export function listEqmsorder(query) {
  return request({
    url: '/system/eqmsorder/list',
    method: 'get',
    params: query
  })
}

// 查询EQMS委托单信息详细
export function getEqmsorder(id) {
  return request({
    url: '/system/eqmsorder/' + id,
    method: 'get'
  })
}

// 新增EQMS委托单信息
export function addEqmsorder(data) {
  return request({
    url: '/system/eqmsorder',
    method: 'post',
    data: data
  })
}

// 修改EQMS委托单信息
export function updateEqmsorder(data) {
  return request({
    url: '/system/eqmsorder',
    method: 'put',
    data: data
  })
}

// 删除EQMS委托单信息
export function delEqmsorder(id) {
  return request({
    url: '/system/eqmsorder/' + id,
    method: 'delete'
  })
}
