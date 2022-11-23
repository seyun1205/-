<template>
  <div id="gl">
    <el-container style="min-height: 100vh">
     
      <daohang/>
      <el-container>
        <el-header style="text-align: right; font-size: 12px; border-bottom: 1px solid #ccc; line-height: 60px;">
          <span class="btn1">管理员</span>
         <el-button type="primary" @click="toin" class="btn">退出</el-button>
        </el-header>
        
        <el-main>
          <router-view></router-view>
          <div>
            <el-breadcrumb separator="/">
              <!-- <el-breadcrumb-item :to="{path:'/'}">首页</el-breadcrumb-item> -->
              <el-breadcrumb-item>用户管理</el-breadcrumb-item>
            </el-breadcrumb>
          </div>
        </el-main>

        <el-main>
          <div style="margin:10px 0">
            <el-input style="width:200px" placeholder="请输入您要搜索的账号" suffix-icon="el-icon-search"></el-input>
            <el-button class="ml-5" type="primary">搜索</el-button>
            <el-button type="primary">新增<i class="el-icon-circle-plus-outline"></i></el-button>
        </div>
          <el-table :data="tableData"  stripe>
            <el-table-column prop="id" label="编号" width="140">
            </el-table-column>
            <el-table-column prop="username" label="账号" width="120">
            </el-table-column>
            <el-table-column prop="password" label="密码">
            </el-table-column>
            <el-table-column prop="" label="操作">
              <el-button type="danger">删除<i class="el-icon-remove-outline"></i></el-button>
              <el-button type="primary">修改<i class="el-icon-view"></i></el-button>
            </el-table-column>
          </el-table>
          <div style="padding:10px 0">
          </div>
        </el-main>

      </el-container>
    </el-container>
  </div>
    </template>
    
    <script>
import daohang from '../../components/daohang.vue'
    export default {
      data(){ 
        const item = {
            username: '0922201',
            password: '123456',
             id:1,
          };
          return {
            tableData: Array(10).fill(item),
            collapseBtnClass:'el-icon-s-fold',
            isCollapse:false,
            sideWidth:200,
           queryParams:{
              pageIndex:'1',
              pageSize:'10',
            }
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
    