<template>
  <div id="gl">
    <el-container style="min-height: 100vh">
      <el-aside :width="sideWidth+'px'" style="background-color: rgb(238, 241, 246);">
        <el-menu :default-openeds="['1', '5']" style="height:100%;overflow-x: hidden;"
        background-color="rgb(48,65,86)"
                text-color="#fff"
                active-text-color="rgb(107,142,35)"
                :collapse-transition="false"
                :collapse="isCollapse"
                 @open="handleOpen"
                 @close="handleClose"
                 :router="true"
                 >
         <div style="height:60px; line-height:60px; text-align:center">
          <b style="color:white">后台管理系统</b>
        </div>         

        <el-menu-item index="/user1" @click="goTo('/user1')">用户管理</el-menu-item>
            <el-menu-item index="/test2" @click="goTo('/test2')">题库管理</el-menu-item>
            <el-menu-item index="/kowledge" @click="goTo('/kowledge')">心理知识管理</el-menu-item>
            <el-menu-item index="/comment" @click="goTo('/comment')">留言板管理</el-menu-item>
            <el-menu-item index="/help" @click="goTo('/help')">咨询管理</el-menu-item>

        <!-- <el-submenu index="/user1" @click="goTo('/user1')">
            <template slot="title">
              <i class="el-icon-message"></i>
                <span slot="title">用户管理</span>
            </template>
          </el-submenu>

          <el-submenu index="/test2" @click="goTo('/test2')">
            <template slot="title"><i class="el-icon-menu"></i>
                <span slot="title">题库管理</span>
            </template>
          </el-submenu>

          <el-submenu index="owledge" @click="goTo('owledge')">
            <template slot="title"><i class="el-icon-setting"></i>
                <span slot="title">心理知识管理</span>
            </template>
          </el-submenu>

          <el-submenu index="/comment" @click="goTo('/comment')">
            <template slot="title"><i class="el-icon-menu"></i>
                <span slot="title">留言板管理</span>
            </template>
          </el-submenu>
          <el-submenu index="/help" @click="goTo('/help')">
            <template slot="title"><i class="el-icon-menu"></i>
                <span slot="title">咨询管理</span>
            </template>
          </el-submenu> -->
        </el-menu>
      </el-aside>
      
      <el-container>
        <el-header style="text-align: right; font-size: 12px; border-bottom: 1px solid #ccc; line-height: 60px;">
          <!-- <div style="flex: 1; font-size: 20px">
            <span :class="collapseBtnClass" style="curser:pointer" @click="collapse"></span>
          </div> -->
          <el-dropdown>
            <i class="el-icon-setting" style="margin-right: 15px"></i>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>查看</el-dropdown-item>
              <el-dropdown-item>新增</el-dropdown-item>
              <el-dropdown-item>删除</el-dropdown-item>
              <el-dropdown-item>修改</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
          <span>管理员</span>
        </el-header>
        
        <el-main>
          <!-- <router-view></router-view> -->
          <div>
            <el-breadcrumb separator="/">
              <el-breadcrumb-item :to="{path:'/'}">首页</el-breadcrumb-item>
              <el-breadcrumb-item>用户管理</el-breadcrumb-item>
            </el-breadcrumb>
          </div>
        </el-main>

        <el-main>
          <div style="margin:10px 0">
            <el-input style="width:200px" placeholder="请输入您要搜索的内容" suffix-icon="el-icon-search"></el-input>
            <el-button class="ml-5" type="primary">搜索</el-button>
          </div>

          <div style="margin:10px 0">
            <el-button type="primary">新增<i class="el-icon-circle-plus-outline"></i></el-button>
        </div>
          <el-table :data="tableData"  stripe>
            <el-table-column prop="date" label="日期" width="140">
            </el-table-column>
            <el-table-column prop="name" label="姓名" width="120">
            </el-table-column>
            <el-table-column prop="address" label="地址">
            </el-table-column>
            <el-table-column prop="" label="操作">
              <el-button type="danger">删除<i class="el-icon-remove-outline"></i></el-button>
              <el-button type="primary">修改<i class="el-icon-view"></i></el-button>
            </el-table-column>
          </el-table>
          <div style="padding:10px 0">
            <el-pagination
              @size-change="handleSizeChange"
              @current-change="handleCurrentChange"
              :current-page="currentPage4"
              :page-sizes="[5,10,15,20]"
              :page-size="10"
              layout="total,sizes,prev,pager,next,jumper"
              :total="400">
            </el-pagination>
          </div>
        </el-main>

      </el-container>
    </el-container>
  </div>
    </template>

    
<script>
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
      methods:{
        collapse(){ //点击收缩按钮触发
          this.isCollapse=!this.isCollapse
          if(this.isCollapse){  //收缩
            this.sideWidth=64
            this.collapseBtnClass='el-icon-s-unfold'
            this.logoTextShow=false
          }else{  //展开
            this.sideWidth=200
            this.collapseBenClass='el-icon-s-fold'
            this.logoTextShow=true
          }
        },
        handleOpen(key,keyPath){
          console.log(key,keyPath);
        },
        handleClose(key,keyPath){
          console.log(key,keyPath);
        },
        goTo(path){
          this.$router.push(path);
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
    </style>
    