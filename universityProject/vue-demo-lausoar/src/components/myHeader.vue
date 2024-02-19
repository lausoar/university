<template>
    <div style="margin-top: 20px;">
        <nav class="navbar navbar-expand-lg navbar-dark fixed-top" style="background-color: #9cdbf7;">
            <div class="container">
                <router-link to="/myHome" class="navbar-brand">
                  <img src="../images/logo-123.png" alt="logo">
                </router-link>
                <!-- <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navmenu">
                    <span class="navbar-toggler-icon"></span>
                </button> -->
                <div class="collapse navbar-collapse" id="navmenu" >
                  <nav class="nav nav-pills flex-column flex-sm-row">
                    <router-link class="flex-sm-fill text-sm-center nav-link" active-class="active" aria-current="page" to="/myHome">首页浏览</router-link>
                    <router-link class="flex-sm-fill text-sm-center nav-link" active-class="active" to="/china" >高校地图</router-link>
                    <!-- <router-link class="flex-sm-fill text-sm-center nav-link" active-class="active" to="/myAnalysis">数据展示</router-link> -->
                    <a href="http://www.analysis.lausoar.com:8088/" class="flex-sm-fill text-sm-center nav-link" active-class="active" target="_blank">数据展示</a>
                    <router-link class="flex-sm-fill text-sm-center nav-link" active-class="active" to="/myCenter">个人中心</router-link>
                  </nav>
                    <ul class="navbar-nav ms-auto">
                        <!--margin start = margin left-->
                        <li class="nav-item">
                            <!-- <div class="nav-link"><router-link to="/myLogin" class="glyphicon glyphicon-log-in"> 登录/注册</router-link></div> -->
                            <el-dropdown :hide-on-click="false">
                              <span class="el-dropdown-link">
                                <i class="el-icon-s-custom"></i>
                              </span>
                              <el-dropdown-menu slot="dropdown" style="width: 200px;">
                                <p style="text-align: center;">亲爱的用户，请先登录！</p>
                                <a href="http://www.maguichi.xyz:8082/#/login" class="glyphicon glyphicon-log-in"><el-button type="primary" to="/myLogin" style="margin-left: 20px;">登录</el-button></a>
                                <a href="http://www.maguichi.xyz:8082/#/register" class="glyphicon glyphicon-log-in"><el-button type="primary" to="/myLogin" style="margin-left: 20px;">注册</el-button></a>
                              </el-dropdown-menu>
                            </el-dropdown>
                        </li>
                        <!-- <li class="nav-item">
                            <div class="nav-link"><router-link to="/myRegister" class="glyphicon glyphicon-log-in"> 注册</router-link></div>
                        </li> -->
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</template>

<script>
export default {
    name: 'myHeader',

    data() {
    },

    mounted() {
        
    },

    methods: {

    },
};
</script>

<style lang="css" scoped>
.nav {
    padding-left: 185px;
    text-align: center;
    margin:auto;
}
.el-dropdown-link {
    cursor: pointer;
    color: #409EFF;
  }
  .el-icon-arrow-down {
    font-size: 12px;
  }
  .el-dropdown {
    font-size: 20px;
}
</style>