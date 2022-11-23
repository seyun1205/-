<template>
                <el-table :data="tableData"  stripe>
              <el-table-column prop="sno" label="编号" width="120">
              </el-table-column>
              <el-table-column prop="question" label="题目" width="500">
              </el-table-column>
              <el-table-column prop="" label="操作">
                <el-button type="danger">删除<i class="el-icon-remove-outline"></i></el-button>
                <el-button type="primary">修改<i class="el-icon-view"></i></el-button>
              </el-table-column>
            </el-table>
</template>

<script>


export default {
    data() {
        const item = {
             sno:'1',
             question:'平常感兴趣的事我不照样感兴趣。',
            };
        return {
            tableData: Array(10).fill(item)
        }
    }
}
</script>
