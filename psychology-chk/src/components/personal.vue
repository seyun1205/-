<template>
    <div class="header">
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
        <!-- <div class="header_right_login"> -->
          <button  class="exit_btn">
            <span @click="exitLogin">退出</span>
          </button>
        <!-- </div> -->
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
    margin-top: -12px;
  }
  .header_words{
    position: absolute;
    right: 110px;
    top:15%;
  }

  .header_right{
    margin: 0 auto;
    padding: 0;
    position: absolute;
    right:10px;
    top:25%;
  }
  .username {
    color: rgb(30, 27, 27);
    font-size: 26px;
    font-weight: 700;
  }
  .exit_btn{
    margin-left: -80%;
    margin-top: 4px;
    border: none;
    text-align: center;
    text-decoration: none;
    display: inline-block;
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
</style>
