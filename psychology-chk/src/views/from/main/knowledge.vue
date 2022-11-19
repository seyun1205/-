<template>
    <div class="body">
      <div class="body_title">
        <h1 class="title">心理知识查询</h1>
        <div class="search">
          <el-select class="search_codes" v-model="searchStr" clearable placeholder="推荐选择">
            <el-option class="search_codes_code" label="效应" value="效应"></el-option>
            <el-option class="search_codes_code" label="心理学" value="心理学"></el-option>
            <el-option class="search_codes_code" label="人" value="人"></el-option>
          </el-select>
          <input class="search_input" type="text" v-model="searchStr" placeholder="请输入想要查看的心理知识" />
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
            <ul v-for="(o, index) in 3">
              <li class="item" v-for="item in results" :key="item">
                <div class="desc">
                  <el-collapse  v-model="activeNames" @change="handleChange">
                    <el-collapse-item class="desc_title" :title="item.content_title" name="1" style="text-align: left;font-size: 18px">
                      <span class="desc_show">
                        {{ item.content }}
                      </span>
                    </el-collapse-item>
                  </el-collapse>
                </div>
              </li>

            </ul>
          </div>
        </div>
      </div>
    </div>
</template>

<script>
  export default {
    name: "knowledge",
    data() {
      return {
        input1: '123',
        input2: '',
        input3: '',
        select: '',
        searchStr:'',  //搜索关键词
        activeNames: ['“三明治效应”','2','3'],
        knowledgeFrom: [{
          kno: '01',
          content_title: '“三明治效应”',
          content: '在批评心理学中，人们把批评的内容夹在两个表扬之中从而使受批评者愉快地接受批评的现象，称之为三明治效应。',
        },
          {
          kno: '02',
          content_title: '“效应”',
          content: '称之为三明治效应。',
        },
        ]
      }
    },
    computed:{
      results(){    //关键词显示
        var knowledgeFrom=this.knowledgeFrom;
        if(this.searchStr==''){
          return knowledgeFrom;
        }
        var searchStr=this.searchStr.trim().toLocaleLowerCase();
        knowledgeFrom=knowledgeFrom.filter(function (ele) {
          if(ele.content.toLocaleLowerCase().indexOf(searchStr)!=-1){
            return ele;
          }
        });
        return knowledgeFrom;
      }
    },
    methods: {
      handleChange(val) {
        console.log(val);
      },
      totest(){
        this.$router.push('/test')
      },
      tohelp(){
        this.$router.push('/help')
      },

    }
  }
</script>s

<style scoped>

  div{
    display: block;
  }
  .body{
    padding: 10px;
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
    width: 70%;
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
    width: 80%;
    margin: 10px 10px 10px 150px;
    border-radius: 8px;
    border: 2px solid #B3C0D1;
  }
  .search_codes{
    padding: 0;
    width: 120px;
    margin: 12px 10px;
    position: absolute;
  }

  .search_codes_code{
    margin:5px;
    line-height: 20px;
    width: 100px;
  }
  .body_views{
    height: 100%;
    margin: 20px;
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
    height: 100%;
    position: relative;
  }

  .body_views_view_show1{
    width: 100%;
    margin-top:25px;
    margin-left:180px;
    padding: 0;
    text-align: center;
    position: absolute;
  }
  .body_views_view_show2{
    width: 100%;
    margin-top:100px;
    margin-left:460px;
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
    height: 100%;
    text-align: center;
    font-size: 14px;
  }

  li {
    list-style: none;
    display: flex;
    background-color: #fff;
    border: #59c2c5;
    width: 69%;
    margin-bottom: 10px;
    padding:12px;
    border-radius: 10px;
  }

  /* .desc_title 好像没有效果：*/
  .desc_title {
    text-align: left;
    font-size: 18px;
  }
  .desc{
    width: 440px;
    padding: 0;
    margin: 0 auto;
  }
  .desc_show {
    display: -webkit-box;   /*必须结合的属性,将对象作为弹性伸缩盒子模型显示*/
    /*-webkit-line-clamp: 5;  !*设置多少行*!*/
    -webkit-box-orient: vertical;   /*必须结合的属性,设置或检索伸缩盒对象的子元素的排列方式*/
    overflow: hidden;   /*文本会被修剪，并且剩余的部分不可见*/
    text-overflow: ellipsis;
  }

</style>
