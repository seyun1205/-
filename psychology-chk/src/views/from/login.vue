<template class="l">
    <div id="building">
            <div class="login" id="login">
            <p>Login</p>
            <input id="username" type="text" placeholder="学号" v-model="loginFrom.username">
            <input id="password" type="password" placeholder="密码" v-model="loginFrom.password">
            <input type="submit" class="btn" value="注 册" @click="toregister">
            <input type="submit" class="btn" value="登 录" @click="login">
            </div> 
    </div>

</template>

<script>
export default {
    data(){
        return {
            loginFrom:{
                username:'',
                password:''
            }
        }
    },
    methods:{

        async login(){
            // console.log(this.loginFrom);
            const { username, password} = this.loginFrom
            const res = await this.axios({
                url: '/api/login',
                method: 'POST',
                params: {
                    username,
                    password
                }
            })
            if(res.data.msg === '密码错误！') {
                this.$message.error('密码错误！');
                return
            }else if(res.data.msg === '用户名不存在！') {
                this.$message.error('用户名不存在!');
                return
            } else {
                localStorage.setItem('username', username)
                if(res.data.user.identify === 1) {
                // 普通用户
                    this.$message.success('登录成功');
                    this.$router.push('/index')
                } else if(res.data.user.identify === 2) {
                    this.$message.success('欢迎您，咨询师');
                } else if(res.data.user.identify === 3) {
                    this.$message.success('欢迎您，管理员');
                    this.$router.push('/manage')
                } else {
                    this.$message.error('登录失败')
                }
            }
           
            
            // this.axios.post('/api/login',{
            //      params: {
            //         username,  
            //         password
            //      }
            // }).then((resp) =>{
            //     console.log(resp);
            //     let data = resp.data;
            //     if(data.success){
            //         this.loginFrom={}
            //         this.$message({
            //         message: '登录成功！欢迎你，'+this.loginFrom.username,
            //         type: 'success',
            //         });
            //         this.$router.push('/index')
            //     }
            // })

        //     this.$refs[formName].validate((valid) => {
        //   if(valid){
        //     alert("注册成功！")
        //   }
        //   else {console.log("error");return false;}
        // })
       
        },
        toregister(){
            this.$router.push('/register')
        }
    }
}
</script>

<style scoped>
 * {
    user-select: none;
    /* 无法选中，整体感更强 */
}

#building {
    background: url("../../assets/background.jpg") ;
    width:100%;
    height:100%;
    position: fixed;
    background-size: 100% 100%;
    margin-top: -0.5%;
    margin-left: -0.5%;
}

.login {
    position: absolute;
    top: 50%;
    margin-top: -200px;
    left: 50%;
    margin-left: -200px;
    /* absolute居中的一种方法 */
    background-color: whitesmoke;
    width: 400px;
    height: 400px;
    border-radius: 25px;
    text-align: center;
    padding: 5px 40px;
    box-sizing: border-box;
    /* 这样padding就不会影响大小 */
}

p {
    font-size: 42px;
    font-weight: 600;
}

input {
    background-color: whitesmoke;
    width: 100%;
    height: 48px;
    margin-bottom: 10px;
    border: none;
    border-bottom: 2px solid silver;
    /* 下面的会覆盖上面的步伐 */
    outline: none;
    font-size: 22px;
}

.btn {
    background-color: #59c2c5;
    width: 34%;
    height: 45px;
    border-radius: 8px;
    margin-top: 40px;
    margin-left: 8%;
    font-size: 24px;
    font-weight: 600;
    color: white;
}

.btn:hover {
    background-color: #59c2a0;
}
</style>
