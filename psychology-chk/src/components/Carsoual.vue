<template>
<!--    <el-carousel indicator-position="outside">-->
<!--      <el-carousel-item >-->
<!--        <img src="@/assets/leaves.jpg" alt="">-->
<!--      </el-carousel-item>-->
<!--      <el-carousel-item >-->
<!--        <img src="@/assets/background.jpg" alt="">-->
<!--      </el-carousel-item>-->
<!--    </el-carousel>-->

    <el-carousel :interval="4000" type="card" height="360px" width="700px">
      <el-carousel-item v-for="item in 4" :key="item">
        <h3 class="medium">{{ item }}</h3>
      </el-carousel-item>
    </el-carousel>
  </template>


  <style>
      .el-carousel{
          padding-top:20px;
          padding-left: 15px;
      }
    .el-carousel__item h3 {
      color: #ffffff;
      font-size: 18px;
      opacity: 0.75;
      line-height: 356px;
      margin: 0;
      border-radius: 20px;
      border: 2px solid #B3C0D1;
      text-align: center;
    }

    .el-carousel__item {
      width: 700px;
      height: 100%;
    }

    .el-carousel__item:nth-child(2n) {
      background-image: url("../assets/index_03.webp");
      background-color: #fff;
    }

    .el-carousel__item:nth-child(2n+1) {
      background-image: url("../assets/index_01.webp");
      background-color: #fff;
    }


  </style>
