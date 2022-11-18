<template>
  <div class="all">
    <div class="body_title">
      <h1 class="title">心理知识查询</h1>
      <div class="search">
        <el-select class="search_codes" v-model="select" slot="prepend" placeholder="请选择">
          <el-option label="效应" value="1"></el-option>
          <el-option label="心理学" value="2"></el-option>
        </el-select>
        <input class="search_input" type="text" placeholder="请输入想要查询的心理知识" />
        <el-button icon="el-icon-search" circle></el-button>
      </div>


    </div>


    <div class="body_views">
      <div class="body_views_view">
        <el-row class="body_views_view_show1">
          <el-col :span="8" v-for="(o, index) in 1" :key="o" :offset="index > 0 ? 1 : 0">
            <el-card :body-style="{ padding: '2px' }">
              <img src="@/assets/totest.png" class="image">
              <div style="padding: 14px;">
                <span>前往心理测试</span>
                <div class="bottom clearfix">
                  <el-button type="text" class="button" @click="totest()">LetsGo >></el-button>
                </div>
              </div>
            </el-card>
          </el-col>
        </el-row>

        <el-row class="body_views_view_show2">
          <el-col :span="8" v-for="(o, index) in 1" :key="o" :offset="index > 0 ? 1 : 0">
            <el-card :body-style="{ padding: '2px' }">
              <img src="@/assets/tohelp.png" class="image">
              <div style="padding: 14px;">
                <span>前往心理咨询</span>
                <div class="bottom clearfix">
                  <el-button type="text" class="button" @click="tohelp()">LetsGo >></el-button>
                </div>
              </div>
            </el-card>
          </el-col>
        </el-row>
      </div>

      <div class="body_views_papers">
        <div class="body_views_papers_li">
          <Paper />
        </div>
      </div>
    </div>

    <div class="footer">
    </div>
  </div>
</template>

<script>
  import Paper from '@/components/Paper.vue'
  export default {
    name: "knowledge",
    components: {
      Paper
    },
    data() {
      return {
        input1: '',
        input2: '',
        input3: '',
        select: '',
      }
    },
    methods:{
      totest(){
        this.$router.push('/test')
      },
      tohelp(){
        this.$router.push('/help')
      },
    }
  }
</script>

<style scoped>
  div{
    display: block;
  }
  .all{
    height: 100%;
    background-image: radial-gradient(lightblue, white);
  }
  .body_title{
    margin: 0 auto;
    box-sizing: border-box;
    flex-direction: row;
    padding-top: 80px;
    text-align: center;
  }
  .title{
    text-align: center;
    padding: 0px;
    margin-bottom:20px;
  }
  .search{
    padding: 0px;
    margin: 0 auto;
    width: 75%;
    background-color: white;
    border-radius: 8px;
    position: relative;
  }
  .search_input{
    font: inherit;
    letter-spacing: inherit;
    color: currentcolor;
    padding: 4px 5px 5px;
    box-sizing: content-box;
    background: none;
    height: 2em;
    width: 85%;
    margin: 10px 10px 10px 20px;
    border-radius: 8px;
    border: 2px solid #B3C0D1;
  }
  .search_codes{
    width: 40px;
    height: 45px;
    text-align: center;
    padding: 0;
    margin: 12px 10px;
    position: absolute;
  }
  .body_views{
    box-sizing: border-box;
    display: flex;
    align-items: flex-start;
    justify-content: center;
    flex-direction: row;
    flex-wrap: wrap;
  }
  .body_views_view{
    flex: 1;
    text-align: center;
    width: 500px;
    height: 400px;
    position: relative;
  }
  .body_views_view_show1{
    width: 100%;
    margin-top:25px;
    margin-left:200px;
    padding: 0;
    text-align: center;
    position: absolute;
  }
  .body_views_view_show2{
    width: 100%;
    margin-top:100px;
    margin-left:480px;
    padding: 0;
    text-align: center;
  }
  .bottom {
    margin-top: 13px;
    line-height: 18px;
  }
  .button {
    padding: 0;
    float: right;
  }
  .image {
    width: 100%;
    display: block;
  }
  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both;
  }
  .body_views_papers{
    flex: 1;
    text-align: center;
    font-size: 14px;
  }
  .footer{
    margin-bottom: 10px;
    padding: 0;
    text-align: center;
    width: 100%;
  }
  .footer_button{
    text-align: center;
    padding: 0;
    margin: 0 auto;
  }
</style>
