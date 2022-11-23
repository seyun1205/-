<template>
  <div>
    <el-form ref="loginForm"
             element-loading-text="登录中..."
             element-loading-spinner="el-icon-loading"
             element-loading-background="element-loading-background"
             :rules="rules"
             :model="loginForm"
             label-width="80px"
             class="loginContainer">
      <H3 class="loginTitle">系统登录</H3>
      <el-form-item label-width=“0px” prop="username">
        <el-input type="text" auto-complete="false" v-model="loginForm.username"
                  placeholder="请输入用户名"></el-input>
      </el-form-item>
      <el-form-item label-width=“0px” prop="password">
        <el-input type="password" auto-complete="false" v-model="loginForm.password"
                  placehplder="请输入密码"></el-input>
      </el-form-item>
      <el-form-item label="选择身份" prop="identify">
        <el-select v-model="loginForm.identify"
            placeholder="please select your zone">
          <el-option label="大学生" value="1" />
          <el-option label="咨询师" value="2" />
          <el-option label="管理员" value="3" />
        </el-select>
      </el-form-item>
      <el-button type="primary" style="width: 100%;margin-top: 20px" @click="submitLogin">登录</el-button>
    </el-form>
  </div>
</template>

<script>

export default {
  name: "login",
  data() {
    return {
      loginForm: {
        username: '',
        password: '',
        identify: null
      },
      rules: {
        username: [{required: true, message: '请输入用户名', trigger: ['blur','change']}],
        password: [{required: true, message: '请输入密码', trigger: ['blur','change']}],
        identify: [{required: true, message: '请输入角色', trigger: 'blur'}]
      }
    }
  },
  mounted() {
    let split = window.location.search.split('=')

    console.log(decodeURI(split[1]))
    if (split.length >= 2 && split[1]) {
      let userInfo = JSON.parse(decodeURI(split[1]))
      console.log(userInfo)
      window.sessionStorage.setItem('userInfo', JSON.stringify(userInfo));
      if (this.loginForm.identify == 3) {
        this.$router.push('/admin' );
      }else {
        this.$router.push('/home' );
      }
    }


  },
  methods: {
    submitLogin() {
      this.$refs.loginForm.validate((valid) => {
        if (valid) {
          this.getRequest('/api/user/login?username='+this.loginForm.username+"&password="+this.loginForm.password+"&identify="+this.loginForm.identify).then((res)=>{
            if (res.data.r){
              window.sessionStorage.setItem('userInfo', JSON.stringify(res.data.r));
              if (this.loginForm.identify == 3) {
                this.$router.push('/admin' );
              }else {
                this.$router.push('/home' );
              }
            }else {
              this.$message.error(res.data.message);
            }

          })

        } else {
          this.$message.error('请输入所有字段!');
          return false;
        }
      });
    }
  }
}


</script>

<style scoped>
.loginContainer {
  border-radius: 15px;
  background-clip: padding-box;
  margin: 180px auto;
  width: 350px;
  padding: 15px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #ded9d9;
}

.loginTitle {
  margin: 0px auto 40px auto;
  text-align: center;
}
</style>