<template>
    <el-table :data="tableData"  stripe>
  <el-table-column prop="id" label="编号" width="100">
  </el-table-column>
  <el-table-column prop="from_user_id" label="发送编号" width="100">
  </el-table-column>
  <el-table-column prop="to_user_id" label="接收编号" width="100">
  </el-table-column>
  <el-table-column prop="message" label="聊天消息">
  </el-table-column>
  <el-table-column prop="create_time" label="聊天时间">
  </el-table-column>
  <el-table-column prop="" label="操作">
    <el-button type="danger">删除<i class="el-icon-remove-outline"></i></el-button>
  </el-table-column>
</el-table>
</template>

<script>


export default {
data() {
const item = {
 id:'1',
 from_user_id:'1',
 to_user_id:'2',
 message:'职场上的问题',
 create_time:'2022-11-07 23:50:42'
};
return {
tableData: Array(10).fill(item)
}
}
}
</script>
