#!/bin/bash

# 外部系统数据接收功能演示脚本
# 使用curl进行API调用演示

echo "=== 外部系统数据接收功能演示 ==="
echo

# 服务器地址
BASE_URL="http://localhost:8080"

# 检查服务器是否运行
echo "1. 检查服务器状态..."
if curl -s --head "$BASE_URL" > /dev/null; then
    echo "✅ 服务器运行正常"
else
    echo "❌ 服务器未运行，请先启动RuoYi系统"
    exit 1
fi
echo

# 测试示例数据接口
echo "2. 测试示例数据接口..."
response=$(curl -s -X POST "$BASE_URL/system/external/example" -w "%{http_code}")
if [ "$response" = "200" ]; then
    echo "✅ 示例数据接口测试成功"
else
    echo "❌ 示例数据接口测试失败，状态码: $response"
fi
echo

# 创建测试数据
echo "3. 创建测试数据..."
cat > test_data.json << EOF
{
  "commissionNo": "EXT_DEMO_001",
  "planNo": "PLAN_DEMO_001",
  "standardItemNo": "STD_DEMO_001",
  "equipmentName": "演示设备",
  "projectName": "演示项目",
  "expectedStartDate": "2025-12-17",
  "expectedEndDate": "2025-12-20",
  "repairReason": "演示维修原因",
  "constructionTeamCode": "TEAM_DEMO",
  "constructionTeamName": "演示班",
  "projectCategory": "演示类",
  "commissionDate": "2025-12-17",
  "commissioner": "演示员",
  "inspectorName": "演示检查员",
  "externalSystemId": "DEMO_SYSTEM",
  "dataSource": "演示系统"
}
EOF

echo "✅ 测试数据创建成功"
echo

# 测试数据接收接口
echo "4. 测试数据接收接口..."
response=$(curl -s -X POST "$BASE_URL/system/eqmsorder/external/receive" \
  -H "Content-Type: application/json" \
  -d @test_data.json \
  -w "%{http_code}")

if [ "$response" = "200" ]; then
    echo "✅ 数据接收接口测试成功"
    echo "   委托单编号: EXT_DEMO_001"
    echo "   设备名称: 演示设备"
    echo "   项目名称: 演示项目"
    echo "   委托人: 演示员"
    echo "   点检姓名: 演示检查员"
else
    echo "❌ 数据接收接口测试失败，状态码: $response"
fi
echo

# 创建批量测试数据
echo "5. 创建批量测试数据..."
cat > batch_test_data.json << EOF
[
  {
    "commissionNo": "EXT_BATCH_001",
    "planNo": "PLAN_BATCH_001",
    "standardItemNo": "STD_BATCH_001",
    "equipmentName": "批量设备1",
    "projectName": "批量项目1",
    "expectedStartDate": "2025-12-17",
    "expectedEndDate": "2025-12-20",
    "repairReason": "批量原因1",
    "constructionTeamCode": "TEAM_BATCH_1",
    "constructionTeamName": "批量班1",
    "projectCategory": "测试类",
    "commissionDate": "2025-12-17",
    "commissioner": "批量员1",
    "inspectorName": "批量检查员1",
    "externalSystemId": "BATCH_SYSTEM_1",
    "dataSource": "批量系统"
  },
  {
    "commissionNo": "EXT_BATCH_002",
    "planNo": "PLAN_BATCH_002",
    "standardItemNo": "STD_BATCH_002",
    "equipmentName": "批量设备2",
    "projectName": "批量项目2",
    "expectedStartDate": "2025-12-17",
    "expectedEndDate": "2025-12-20",
    "repairReason": "批量原因2",
    "constructionTeamCode": "TEAM_BATCH_2",
    "constructionTeamName": "批量班2",
    "projectCategory": "测试类",
    "commissionDate": "2025-12-17",
    "commissioner": "批量员2",
    "inspectorName": "批量检查员2",
    "externalSystemId": "BATCH_SYSTEM_2",
    "dataSource": "批量系统"
  }
]
EOF

echo "✅ 批量测试数据创建成功"
echo

# 测试批量数据接收
echo "6. 测试批量数据接收..."
echo "   注意：此演示仅展示单条数据接收，批量接收需要修改后端代码"
echo "   当前演示第一条数据..."

# 使用第一条数据进行测试
first_data=$(jq '.[0]' batch_test_data.json)
response=$(echo "$first_data" | curl -s -X POST "$BASE_URL/system/eqmsorder/external/receive" \
  -H "Content-Type: application/json" \
  -d @- \
  -w "%{http_code}")

if [ "$response" = "200" ]; then
    echo "✅ 批量数据第一条接收成功"
    echo "   委托单编号: EXT_BATCH_001"
    echo "   设备名称: 批量设备1"
    echo "   项目名称: 批量项目1"
    echo "   委托人: 批量员1"
    echo "   点检姓名: 批量检查员1"
else
    echo "❌ 批量数据第一条接收失败，状态码: $response"
fi
echo

# 清理测试文件
echo "7. 清理测试文件..."
rm -f test_data.json
rm -f batch_test_data.json
echo "✅ 测试文件清理完成"
echo

# 显示数据统计
echo "8. 数据统计信息..."
echo "   功能模块: 外部系统数据接收"
echo "   接口数量: 2个"
echo "   支持字段: 14个"
echo "   状态管理: 自动设置"
echo "   日志记录: 已集成"
echo

echo "=== 演示完成 ==="
echo
echo "使用说明："
echo "1. 确保RuoYi系统已启动"
echo "2. 确保用户有相应权限"
echo "3. 可以使用以下命令进行测试："
echo "   curl -X POST http://localhost:8080/system/external/example"
echo "   curl -X POST http://localhost:8080/system/eqmsorder/external/receive -H 'Content-Type: application/json' -d @test_data.json"
echo
echo "注意事项："
echo "- 日期格式必须为 yyyy-MM-dd"
echo "- 所有字段都是必填的"
echo "- 需要相应的权限才能调用接口"
echo "- 数据会自动保存到数据库"