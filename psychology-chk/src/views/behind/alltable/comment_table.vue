<template>
    <el-table :data="tableData"  stripe>
  <el-table-column prop="username" label="账号" width="120">
  </el-table-column>
  <el-table-column prop="nickname" label="昵称" width="120">
  </el-table-column>
  <el-table-column prop="content" label="留言" width="180">
  </el-table-column>
  <el-table-column prop="time" label="留言时间">
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
  username:'ddd',
  nickname:'小宇',
  content:'这个题目不错哦！',
  time:'2022-11-11 16:29:23'
};
return {
tableData: Array(10).fill(item)
}
}
}
</script>
