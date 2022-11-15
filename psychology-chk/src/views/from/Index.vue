<template>
  <div class="all">

    <div class="header">
  <!--    <h1>这里写主页</h1>-->
      <div class="header_left">
        <img src="@/assets/logo.png" class="header_left_logo">
      </div>
      <div class="header_words">
          <span>欢迎您使用本网站~</span>
      </div>
      <!--  这里显示登录信息-->
      <div class="header_right">
        <div class="header_right_login">
          <button  class="exit_btn">
            <span>退出登录</span>
          </button>
        </div>
      </div>
    </div>

    <div class="body">
      <div class="body_show_pictures">
        <img src="@/assets/leaves.jpg" class="show_picture" >
      </div>
      <div class="body_choose">
        <div class="body_choose_test" @click="totest">
          <span class="test_link" >心理测试</span>
        </div>
        <div class="body_choose_knowledge" @click="toknowledge">
          <span class="knowledge_link">心理知识</span>
        </div>
        <div class="body_choose_help" @click="tohelp">
          <span class="help_link">心理帮助</span>
        </div>
        <div class="body_choose_comment" @click="tocomment">
          <span class="comment_link">留言板</span>
        </div>
      </div>
    </div>
  </div>

</template>

<script>
  export default {
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

  .header{
    margin: 0 auto;
    padding:0px;
    position: relative;
  }
  .header_left{
    height: 100%;
  }
  .header_left_logo{
    width: 300px;
    height: 70px;
  }
  .header_words{
    position: absolute;
    right: 110px;
    top:35%;
  }

  .header_right{
    margin: 0 auto;
    padding: 0;
    position: absolute;
    right:10px;
    top:25%;
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
    webkit-transition-duration: 0.4s; /* Safari */
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

  .body_show_pictures{
    margin: 0 auto;
    padding:0;
  }
  .show_picture{
    width:100%;
  }

  .body_choose{
    padding:0;
    margin: 0 auto;
    position: relative;
    display:flex;
    justify-content:space-between;
  }
  .body_choose_test{
    width: 250px;
    height: 200px;
    text-align: center;
    display:flex;
    vertical-align: middle;
    background-image: radial-gradient(pink, white);
    box-shadow:0 0 50px 30px #ffffff inset;
    margin-left:10px ;
  }
  .test_link{
    margin:0 auto;
    padding:0;
    text-decoration:none;
    color: black;
    letter-spacing: 3px;
    font-size: 20px;
  }
  .body_choose_test:hover{

  }
  .body_choose_knowledge{
    width: 250px;
    height: 200px;
    text-align: center;
    vertical-align: middle;
    background-image: radial-gradient(lightblue, white);
    box-shadow:0 0 50px 30px #ffffff inset;
    position: absolute;
    left:27.5%;
    top:0%;
  }
  .knowledge_link{
    margin:0 auto;
    padding:0;
    text-decoration:none;
    color: black;
    letter-spacing: 3px;
    font-size: 20px;
  }
  .body_choose_help{
    width: 250px;
    height: 200px;
    text-align: center;
    vertical-align: middle;
    background-image: radial-gradient(lightgreen, white);
    box-shadow:0 0 50px 30px #ffffff inset;
    position: absolute;
    right:27.5%;
    top:0%;
  }
  .help_link{
    margin:0 auto;
    padding:0;
    text-decoration:none;
    color: black;
    letter-spacing: 3px;
    font-size: 20px;
  }
  .body_choose_comment{
    width: 250px;
    height: 200px;
    text-align: center;
    vertical-align: middle;
    background-image: radial-gradient(plum, white);
    box-shadow:0 0 50px 30px #ffffff inset;
    position: absolute;
    right:0.5%;
    top:0%;
  }
  .comment_link{
    margin:0 auto;
    padding:0;
    text-decoration:none;
    color: black;
    letter-spacing: 3px;
    font-size: 20px;
  }
</style>
