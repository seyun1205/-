<template>
    <el-table :data="tableData"  stripe>
  <el-table-column prop="kno" label="编号" width="140">
  </el-table-column>
  <el-table-column prop="name" label="效应" width="140">
  </el-table-column>
  <el-table-column prop="content" label="内容">
  </el-table-column>
  <el-table-column prop="" label="操作" >
    <el-button type="danger">删除<i class="el-icon-remove-outline"></i></el-button>
    <el-button type="primary">修改<i class="el-icon-view"></i></el-button>
  </el-table-column>
</el-table>
</template>

<script>


export default {
data() {
const item = {
  kno:1,
  name:'三明治效应',
  content:'在批评心理学中，人们把批评的内容夹在两个表扬之中从而使受批评者愉快地接受批评的现象，称之为三明治效应。这种现象就如三明治，第一层总是认同、赏识、肯定、关爱对方的优点或积极面，中间这一层夹着建议、批评或不同观点，第三层总是鼓励、希望、信任、支持和帮助，使之后味无穷。比如：今天的汤真好喝，就是稍微咸了一点，下次清淡点我能连喝三大碗。'
};
return {
tableData: Array(10).fill(item)
}
}
}
</script>
