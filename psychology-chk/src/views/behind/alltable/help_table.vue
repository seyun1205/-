<template>
    <el-table :data="tableData"  stripe>
  <el-table-column prop="id" label="编号" width="100">
  </el-table-column>
  <el-table-column prop="user_id" label="用户编号" width="100">
  </el-table-column>
  <el-table-column prop="goodat" label="擅长科目" width="100">
  </el-table-column>
  <el-table-column prop="introduce" label="介绍">
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
 id:'1',
 user_id:'2',
 goodat:'社会心理学',
  introduce:'李四,男,副教授,南开大学社会心理学博士,天津医科大学心理健康教育中心测评部主任。从事大学生心理健康教育工作12年。主要咨询领域:大学生人际关系、压力管理等。'
};
return {
tableData: Array(10).fill(item)
}
}
}
</script>
