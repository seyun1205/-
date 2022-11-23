<template>
      <el-aside  style="background-color: rgb(238, 241, 246); width: 250px;">
        <el-menu :default-openeds="['1', '5']" style="height:100%;overflow-x: hidden;"
        background-color="rgb(48,65,86)" text-color="#fff" active-text-color="rgb(107,142,35)">
         <div style="height:60px; line-height:60px; text-align:center">
          <b style="color:white">后台管理系统</b>
        </div>         
          <el-menu-item index="/manage" @click="goTo('/manage')">用户管理</el-menu-item>
           <el-menu-item index="/help_manage" @click="goTo('/help_manage/htable')">咨询师管理</el-menu-item>
           <el-menu-item index="/test_manage" @click="goTo('/test_manage/ttable')">题库管理</el-menu-item>
           <el-menu-item index="/knowledge_manage" @click="goTo('/knowledge_manage/ktable')">心理知识管理</el-menu-item>
           <el-menu-item index="/comment_manage" @click="goTo('/comment_manage/ctable')">留言板管理</el-menu-item>
           <el-menu-item index="/record_manage" @click="goTo('/record_manage/rtable')">聊天记录管理</el-menu-item>
        </el-menu>
      </el-aside>
</template>
<script>

export default {
  name: "daohang",
  data() {
    return {}
  },
  methods: {
    goTo(path){
          this.$router.push(path);
        },
  }
}
</script>
<style scoped>
 .el-aside {
        color: #333;
      }
</style>