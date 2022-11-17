<template>
  <div class="all">
    <div class="body_title">
      <h1 class="title">心理知识查询</h1>
      <div class="search">
        <input class="search_input" type="text" placeholder="请输入想要查询的心理知识" />
        <el-button icon="el-icon-search" circle></el-button>
      </div>
      <div class="search_codes">
        <el-select v-model="select" slot="prepend" placeholder="请选择">
          <el-option label="餐厅名" value="1"></el-option>
          <el-option label="订单号" value="2"></el-option>
          <el-option label="用户电话" value="3"></el-option>
        </el-select>
      </div>
    </div>



    <div class="body_views">
      <div class="body_views_view">
          views
      </div>
      <div class="body_views_papers">
        <div class="body_views_papers_li">
          <Paper />
        </div>
      </div>
    </div>

    <div class="footer">
      <el-button-group class="footer_button">
        <el-button type="primary" icon="el-icon-arrow-left">上一页</el-button>
        <el-button type="primary">下一页<i class="el-icon-arrow-right el-icon--right"></i></el-button>
      </el-button-group>
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
      select: ''
    }
  }
}
</script>

<style scoped>
  div{
    display: block;
  }
  .all{
    width: 100%;
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
    width: 60%;
    background-color: white;
    border-radius: 4px;
  }
  .search_input{
    font: inherit;
    letter-spacing: inherit;
    color: currentcolor;
    padding: 4px 5px 5px;
    box-sizing: content-box;
    background: none;
    height: 2em;
    width: 90%;
    margin: 10px 4px 10px;
    border-radius: 4px;
    border: 2px solid #B3C0D1;
  }

  
  .body_views{
    box-sizing: border-box;
    display: flex;
    -webkit-box-pack: center;
    justify-content: center;
  }
  .body_views_view{
    flex: 1;
    text-align: center;
    padding: 0px;
    margin: 0 auto;
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