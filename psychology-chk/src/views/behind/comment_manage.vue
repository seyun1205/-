<template>
    <el-container style="min-height: 100vh">
      <daohang/>
      <el-container>
        <el-header style="text-align: right; font-size: 12px; border-bottom: 1px solid #ccc; line-height: 60px;">
          <span class="btn1">管理员</span>
          <el-button type="primary" @click="toin" class="btn">退出</el-button>
        </el-header>
        
        <el-main>
          <div>
            <el-breadcrumb separator="/">
              <el-breadcrumb-item>留言板管理</el-breadcrumb-item>
            </el-breadcrumb>
          </div>
        </el-main>

        <el-main>
          <div style="margin:10px 0">
            <el-input style="width:200px" placeholder="请输入您要搜索的账号" suffix-icon="el-icon-search"></el-input>
            <el-button class="ml-5" type="primary">搜索</el-button>
        </div>
          <router-view></router-view>
          <div style="padding:10px 0">
          </div>
        </el-main>

      </el-container>
    </el-container>
    </template>
    
    <script>
    import daohang from '../../components/daohang.vue'
    export default {
      data(){
        const item = {
            date: '2016-05-02',
            name: '王小虎',
            address: '上海市普陀区金沙江路 1518 弄'
          };
          return {
            tableData: Array(10).fill(item),
            collapseBtnClass:'el-icon-s-fold',
            isCollapse:false,
            sideWidth:200
          }
      },
      components: {
        daohang,
    },
   
      methods:{
        toin(){
          this.$router.push('/login')
        },
      }
    }
    </script>
    
    <style scoped>
     .el-header {
        background-color: #ffffff;
        color: #333;
        line-height: 60px;
      }
      
      .el-aside {
        color: #333;
      }
      .btn{
        height: 35px;
        width: 60px;
        padding: 0;
       
      }
      .btn1{
        padding: 20px;
      }
    </style>
    