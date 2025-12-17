#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
外部系统数据接收测试脚本
"""

import requests
import json
import time

# 服务器地址
BASE_URL = "http://localhost:8080"

def test_external_data_receive():
    """测试外部数据接收接口"""
    
    # 示例数据
    example_data = {
        "commissionNo": "EXT202512170006",
        "planNo": "PLAN202512170006",
        "standardItemNo": "STD202512170006",
        "equipmentName": "测试设备Python",
        "projectName": "Python测试项目",
        "expectedStartDate": "2025-12-17",
        "expectedEndDate": "2025-12-20",
        "repairReason": "Python脚本测试",
        "constructionTeamCode": "TEAM_PY",
        "constructionTeamName": "Python测试班",
        "projectCategory": "测试类",
        "commissionDate": "2025-12-17",
        "commissioner": "测试员",
        "inspectorName": "检查员",
        "externalSystemId": "PYTHON_TEST_001",
        "dataSource": "Python测试系统"
    }
    
    # 发送请求
    url = f"{BASE_URL}/system/eqmsorder/external/receive"
    headers = {"Content-Type": "application/json"}
    
    try:
        print("开始测试外部数据接收接口...")
        print(f"请求URL: {url}")
        print(f"请求数据: {json.dumps(example_data, ensure_ascii=False, indent=2)}")
        
        response = requests.post(url, headers=headers, json=example_data)
        
        print(f"响应状态码: {response.status_code}")
        print(f"响应内容: {response.text}")
        
        if response.status_code == 200:
            print("✅ 测试成功！")
            result = response.json()
            if result.get('code') == 200:
                print("✅ 数据接收成功！")
                return True
            else:
                print(f"❌ 业务失败: {result.get('msg', '未知错误')}")
                return False
        else:
            print(f"❌ HTTP请求失败: {response.status_code}")
            return False
            
    except requests.exceptions.RequestException as e:
        print(f"❌ 网络请求异常: {e}")
        return False

def test_example_endpoint():
    """测试示例数据接口"""
    
    url = f"{BASE_URL}/system/external/example"
    
    try:
        print("\n开始测试示例数据接口...")
        response = requests.post(url)
        
        print(f"响应状态码: {response.status_code}")
        print(f"响应内容: {response.text}")
        
        if response.status_code == 200:
            print("✅ 示例数据接口测试成功！")
            return True
        else:
            print(f"❌ 示例数据接口测试失败: {response.status_code}")
            return False
            
    except requests.exceptions.RequestException as e:
        print(f"❌ 网络请求异常: {e}")
        return False

def main():
    """主函数"""
    print("=" * 50)
    print("外部系统数据接收功能测试")
    print("=" * 50)
    
    # 测试外部数据接收
    success1 = test_external_data_receive()
    
    # 测试示例数据接口
    success2 = test_example_endpoint()
    
    print("\n" + "=" * 50)
    print("测试结果汇总:")
    print(f"外部数据接收接口: {'✅ 通过' if success1 else '❌ 失败'}")
    print(f"示例数据接口: {'✅ 通过' if success2 else '❌ 失败'}")
    
    if success1 and success2:
        print("🎉 所有测试通过！")
    else:
        print("⚠️ 部分测试失败，请检查系统配置")
    
    print("=" * 50)

if __name__ == "__main__":
    main()