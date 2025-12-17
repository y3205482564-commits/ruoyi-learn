# 测试示例数据
curl -X POST http://localhost:8080/system/external/example
/**
 * 外部系统数据接收API调用示例
 * 使用JavaScript/Node.js调用API
 */

const axios = require('axios');

// 服务器地址
const BASE_URL = 'http://localhost:8080';

// 示例数据
const exampleData = {
    commissionNo: "EXT_JS_001",
    planNo: "PLAN_JS_001",
    standardItemNo: "STD_JS_001",
    equipmentName: "JavaScript测试设备",
    projectName: "JavaScript测试项目",
    expectedStartDate: "2025-12-17",
    expectedEndDate: "2025-12-20",
    repairReason: "JavaScript脚本测试",
    constructionTeamCode: "TEAM_JS",
    constructionTeamName: "JavaScript测试班",
    projectCategory: "测试类",
    commissionDate: "2025-12-17",
    commissioner: "JavaScript测试员",
    inspectorName: "JavaScript检查员",
    externalSystemId: "JS_SYSTEM_001",
    dataSource: "JavaScript测试系统"
};

// API调用函数
async function callExternalDataAPI() {
    try {
        console.log('=== 外部系统数据接收API调用示例 ===');
        console.log('请求URL:', `${BASE_URL}/system/eqmsorder/external/receive`);
        console.log('请求数据:', JSON.stringify(exampleData, null, 2));
        
        // 发送POST请求
        const response = await axios.post(
            `${BASE_URL}/system/eqmsorder/external/receive`,
            exampleData,
            {
                headers: {
                    'Content-Type': 'application/json'
                }
            }
        );
        
        console.log('\n=== 响应结果 ===');
        console.log('状态码:', response.status);
        console.log('响应数据:', response.data);
        
        if (response.data.code === 200) {
            console.log('✅ API调用成功！数据已接收并保存到数据库');
        } else {
            console.log('❌ API调用失败:', response.data.msg);
        }
        
    } catch (error) {
        console.error('❌ API调用异常:', error.message);
        if (error.response) {
            console.error('错误状态码:', error.response.status);
            console.error('错误信息:', error.response.data);
        }
    }
}

// 批量数据调用示例
async function callBatchDataAPI() {
    console.log('\n=== 批量数据接收API调用示例 ===');
    
    const batchData = [
        exampleData,
        {
            ...exampleData,
            commissionNo: "EXT_JS_002",
            planNo: "PLAN_JS_002",
            equipmentName: "JavaScript测试设备2",
            commissioner: "JavaScript测试员2"
        },
        {
            ...exampleData,
            commissionNo: "EXT_JS_003",
            planNo: "PLAN_JS_003",
            equipmentName: "JavaScript测试设备3",
            commissioner: "JavaScript测试员3"
        }
    ];
    
    for (let i = 0; i < batchData.length; i++) {
        console.log(`\n--- 处理第 ${i + 1} 条数据 ---`);
        
        try {
            const response = await axios.post(
                `${BASE_URL}/system/eqmsorder/external/receive`,
                batchData[i],
                {
                    headers: {
                        'Content-Type': 'application/json'
                    }
                }
            );
            
            console.log(`✅ 第 ${i + 1} 条数据处理成功`);
            
        } catch (error) {
            console.error(`❌ 第 ${i + 1} 条数据处理失败:`, error.message);
        }
    }
}

// 测试接口调用示例
async function callTestAPI() {
    console.log('\n=== 测试接口调用示例 ===');
    
    try {
        const response = await axios.post(`${BASE_URL}/system/external/example`);
        
        console.log('状态码:', response.status);
        console.log('响应数据:', response.data);
        
        if (response.data.code === 200) {
            console.log('✅ 测试接口调用成功！');
        } else {
            console.log('❌ 测试接口调用失败:', response.data.msg);
        }
        
    } catch (error) {
        console.error('❌ 测试接口调用异常:', error.message);
    }
}

// 主函数
async function main() {
    console.log('开始执行API调用示例...\n');
    
    // 单条数据调用
    await callExternalDataAPI();
    
    // 批量数据调用
    await callBatchDataAPI();
    
    // 测试接口调用
    await callTestAPI();
    
    console.log('\n=== 所有API调用示例执行完成 ===');
}

// 如果直接运行此脚本
if (require.main === module) {
    // 检查是否安装了axios
    try {
        require('axios');
        main();
    } catch (error) {
        console.error('❌ 请先安装axios依赖:');
        console.error('   npm install axios');
        console.error('   或者使用以下命令安装:');
        console.error('   npm install axios --save');
    }
}

module.exports = {
    callExternalDataAPI,
    callBatchDataAPI,
    callTestAPI
};