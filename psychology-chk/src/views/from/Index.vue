<template>
  <div>
    <div class="header">
  <!--    <h1>这里写主页</h1>-->
      <div class="header_left">
        <img src="@/assets/logo.png" class="header_left_logo">
      </div>
      <div class="header_right">
  <!--  这里显示登录信息-->
        <div class="header_right_login">
          <span>欢迎您使用本网站~</span>
          <input type="submit" class="exit_btn" value="退出登录" />
        </div>
      </div>
    </div>

    <div class="body">
      <div class="body_show_pictures">
        <img src="@/assets/leaves.jpg" class="show_picture" >
      </div>
      <div class="body_choose">
        <div class="body_choose_test">
          <a href="test" class="test_link">心理测试</a>
        </div>
        <div class="body_choose_knowledge">

        </div>
        <div class="body_choose_help">

        </div>
        <div class="body_choose_comment">

        </div>
      </div>
    </div>
  </div>

</template>

<script>
export default {

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
  .header_right{
    margin: 0 auto;
    padding: 0;
    position: absolute;
    right:10px;
    top:35%;
  }
  .exit_btn{
    margin-left: 15px;
  }
  .body_show_pictures{
    margin: 0 auto;
    padding:0;
  }
  .show_picture{
    width:100%;
  }
  .body_choose{
    margin: 0 auto;
    padding:0px;
    position: relative;
  }
  .body_choose_test{
    width:
  }
</style>
