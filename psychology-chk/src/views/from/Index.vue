<template>
  <div class="all">

    <personal/>
    <separator />
    <Carsoual />


    <div class="body" >

      <el-row class="body_choose" :gutter="10">
        <el-col :xs="8" :sm="6" :md="4" :lg="3" :xl="1">
          <div  @click="totest" class="grid-content bg-purple">
            <div class="body_choose_test">
              <el-popover
                      placement="top-start"
                      title="心理测试"
                      width="200"
                      trigger="hover"
                      content="心理测试是一种比较先进的测试方法，它是指通过一系列手段，将人的某些心理特征数量化，来衡量个体心理因素水平和个体心理差异差异的一种科学测量方法。">
                <span class="test_link" slot="reference">-心理测试-</span>
              </el-popover>
            </div>
          </div>
        </el-col>
        <el-col :xs="4" :sm="6" :md="8" :lg="9" :xl="11">
          <div @click="toknowledge" class="grid-content bg-purple-light">
            <div class="body_choose_knowledge" >
              <el-popover
                      placement="top-start"
                      title="心理知识"
                      width="200"
                      trigger="hover"
                      content="一些关于心理健康的小知识，多多了解心理知识，有效预防心理疾病。">
                <span class="knowledge_link" slot="reference">-心理知识-</span>
              </el-popover>
            </div>
          </div>
        </el-col>
        <el-col :xs="4" :sm="6" :md="8" :lg="9" :xl="11">
          <div @click="tohelp" class="grid-content bg-purple">
            <div class="body_choose_help" >
              <el-popover
                      placement="top-start"
                      title="心理咨询"
                      width="200"
                      trigger="hover"
                      content="心理咨询（counseling）是指运用心理学的方法，对心理适应方面出现问题并企求解决问题的求询者提供心理援助的过程。需要解决问题并前来寻求帮助者称为来访者或者咨客，提供帮助的咨询专家称为咨询者。">
                <span class="help_link" slot="reference">-心理咨询-</span>
              </el-popover>
            </div>
          </div>
        </el-col>
        <el-col :xs="8" :sm="6" :md="4" :lg="3" :xl="1">
          <div @click="tocomment" class="grid-content bg-purple-light">
            <div class="body_choose_comment" >
              <el-popover
                      placement="top-start"
                      title="留言板"
                      width="200"
                      trigger="hover"
                      content="有什么意见可在此留言。">
                <span class="comment_link" slot="reference">-留言板-</span>
              </el-popover>
            </div>
          </div>
        </el-col>
      </el-row>
    </div>
  </div>

</template>

<script>
import personal from '@/components/personal.vue'
import Carsoual from '@/components/Carsoual.vue'
import separator from '@/components/separator.vue'
  export default {
    components: {
      personal,
      Carsoual,
      separator
    },
    methods:{
      totest(){
        this.$router.push('/test')
      },
      toknowledge(){
        this.$router.push('/knowledge')
      },
      tohelp(){
        this.$router.push('/help')
      },
      tocomment(){
        this.$router.push('/comment')
      },
    }
  }
</script>


<style>

  .all{
    height: 100%;
  }
  .exit_btn{
    margin-left: 200px;
    border: none;
    padding: 10px 12px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 14px;
    border-radius: 4px;
    border: 2px solid #B3C0D1;
    
    transition-duration: 0.4s
  }
  .exit_btn:hover{
    background-color: #f44336;
    color: white;
  }
  .exit_btn span {
    cursor: pointer;
    display: inline-block;
    position: relative;
    transition: 0.5s;
  }

  .body_choose {
    margin:15px;
    padding: 0;
    text-align: center;
    vertical-align: middle;

  }

  .body_choose_test{
    margin: 0 auto;
    padding: 20px;
    height: 120px;
  }

  .body_choose_knowledge{
    margin: 0 auto;
    padding: 20px;
    height: 170px;
  }

  .body_choose_help{
    margin: 0 auto;
    padding: 20px;
    height: 140px;
  }

  .body_choose_comment{
    margin: 0 auto;
    padding: 20px;
    height: 150px;
  }

  .el-col {
    border-radius: 4px;
  }
  .bg-purple-dark {
    background: #99a9bf;
  }
  .bg-purple {
    background: #d3dce6;
  }
  .bg-purple-light {
    background: #e5e9f2;
  }
  .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }
</style>
