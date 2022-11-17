<template>
    <el-carousel indicator-position="outside">
      <el-carousel-item >
        <img src="@/assets/leaves.jpg" alt="">
      </el-carousel-item>
      <el-carousel-item >
        <img src="@/assets/background.jpg" alt="">
      </el-carousel-item>
    </el-carousel>
  </template>
  
  <style>
    .el-carousel__item h3 {
      color: #475669;
      font-size: 18px;
      opacity: 0.75;
      line-height: 300px;
      margin: 0;
    }
    
    .el-carousel__item:nth-child(2n) {
      background-color: #fff;
    }
    
    .el-carousel__item:nth-child(2n+1) {
      background-color: #fff;
    }
    img {
        width: 500px;
        height: 100%;
    }
    .el-carousel__item {
        text-align: center;
    }
  </style>