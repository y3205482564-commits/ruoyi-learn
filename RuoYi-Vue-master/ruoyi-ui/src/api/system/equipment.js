import request from '@/utils/request'

// 查询空间设备列表
export function listEquipment(query) {
  return request({
    url: '/system/equipment/list',
    method: 'get',
    params: query
  })
}

// 查询空间设备详细
export function getEquipment(equipmentId) {
  return request({
    url: '/system/equipment/' + equipmentId,
    method: 'get'
  })
}

// 新增空间设备
export function addEquipment(data) {
  return request({
    url: '/system/equipment',
    method: 'post',
    data: data
  })
}

// 修改空间设备
export function updateEquipment(data) {
  return request({
    url: '/system/equipment',
    method: 'put',
    data: data
  })
}

// 删除空间设备
export function delEquipment(equipmentId) {
  return request({
    url: '/system/equipment/' + equipmentId,
    method: 'delete'
  })
}
