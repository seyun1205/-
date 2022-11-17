<template>
    <div class="header">
  <!--    <h1>这里写主页</h1>-->
      <div class="header_left">
        <img src="@/assets/logo.png" class="header_left_logo">
      </div>
      <div class="header_words">
          <span>欢迎 
            <span class="username">{{ username }}</span>
            使用本网站~</span>
      </div>
      <!--  这里显示登录信息-->
      <div class="header_right">
        <div class="header_right_login">
          <button  class="exit_btn">
            <span @click="exitLogin">退出登录</span>
          </button>
        </div>
      </div>
    </div>
</template>

<script>

export default {
  name: "personal",
  data() {
    return {
      username: localStorage.getItem('username') ?? ''
    }
  },
  methods: {
    exitLogin() {
      localStorage.clear()
      this.$router.push('/login')
    }
  }
}
</script>

<style scoped>
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
  .username {
    color: red;
    font-size: 26px;
    font-weight: 700;
  }
</style>
