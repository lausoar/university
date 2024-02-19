<template>
    <div>
      <el-row class="tac">
            <el-col :span="12" id="left">
              <h5>个人中心</h5>
              <el-menu default-active="2" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose" background-color="#545c64" text-color="#fff" active-text-color="#ffd04b" router='true'>
                <!-- 第一部分开始 -->
                <el-menu-item index="/myCenter/myTest">
                  <i class="el-icon-s-tools"></i>
                  <span slot="title">学校官网</span>
                </el-menu-item>
                <el-menu-item index="/myCenter/myPicture">
                  <i class="el-icon-help"></i>
                  <span slot="title">校园图片</span>
                </el-menu-item>
                <el-menu-item index="/myCenter/myOption">
                  <i class="el-icon-s-platform"></i>
                  <span slot="title">数据分析</span>
                </el-menu-item>
                <!-- 第一部分结束 -->
                <!-- 第二部分开始 -->
                <el-menu-item index="/myCenter/myChat">
                  <a href="http://www.maguichi.xyz:8082/#/login" style="text-decoration: none; color: white;">
                  <i class="el-icon-menu"></i>
                  <span slot="title">交流专区</span></a>
                </el-menu-item>
                <!-- 第二部分结束 -->
                <!-- 第三部分开始 -->
                <!-- <el-menu-item index="/myCenter">
                  <i class="el-icon-document"></i>
                  <span slot="title">导航三</span>
                </el-menu-item> -->
                <!-- 第三部分结束 -->
                <!-- 第四部分开始 -->
                <!-- <el-menu-item index="/myCenter/myLast">
                  <i class="el-icon-s-data"></i>
                  <span slot="title">认证</span>
                </el-menu-item> -->
                <!-- 第四部分结束 -->
              </el-menu>
            </el-col>
            <router-view></router-view>
      </el-row>
    </div>
    
</template>

<script>

export default {
    name: 'myCenter',

    data() {

        return {
        };
    },

    mounted() {
        
    },

    methods: {
        handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      }
    },
};
</script>

<style lang="css" scoped>
.tac {
    width: 500px;
}
h5 {
    color: #fff;
    background-color:#545c64;
    text-align: center;
    margin-bottom: auto;
    line-height: 60px;
    height: 60px;
    width: 249.5px;
}
#left {
  background-color:#545c64;
  height: 650px!important;
}

</style>