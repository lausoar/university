<template>
    <body id="poster">
        <el-form class="login-container" label-position="left" :model="form" label-width="0px">
            <h3 class="login_title">
                登录
                <el-button  @click="toRegister()">点我注册</el-button>
            </h3>
            <el-form-item label="" >
              <el-input type="text" v-model="loginform.loginName" autocomplete="off" placeholder="账号"></el-input>
            </el-form-item>
            <el-form-item label="">
              <el-input type="password" v-model="loginform.password" autocomplete="off" placeholder="密码"></el-input>
            </el-form-item>
            
            <el-form-item>
              <el-button type="primary" style="width: 100%;background: #505458;border: none;" v-on:click="Login()">登录</el-button>
            </el-form-item>
        </el-form>
    </body>
</template>

<script>
export default {
    name: 'myLogin',

    data() {
      return {
        loginform: {
            loginName: '',
            password: ''
        }
      }
    },
    methods: {
        Login() {
            this.axios.post('http://localhost:7012/sys-user/login',this.loginform).then((resp)=>{
                let data = resp.data;
                if(data.success){
                    this.loginform = {};
                    this.$message({
                        showClose: true,
                        message: '欢迎您，'+ data.content.name +'登录成功！',
                        type: 'success'
                    });
                    this.$router.push({path:'/myCenter'})
                }
            })
        
      },
      toRegister(){
        this.$router.push({path:'/myRegister'})
      },
    }
};
</script>

<style lang="css" scoped>
 #poster{
    background-position: center;
    height: 100%;
    width: 100%;
    background-size: cover;
    position: fixed;
 }
 body{
    margin: 0px;
    padding: 0px;
 }
 .login-container{
    border-radius: 15px;
    background-clip: padding-box;
    margin: 90px auto;
    width: 350px;
    padding: 35px 35px 15px 35px;
    background-color: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
 }
 .login_title{
    margin: 0px auto 40px auto;
    text-align: center;
    color: #505458;
 }
</style>