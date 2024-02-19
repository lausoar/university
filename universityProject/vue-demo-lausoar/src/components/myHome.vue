<template>
    <div>
<!-- 轮播图开始 -->
        <el-carousel :interval="4000" type="card" height="300px" style="margin-top: 30px;">
            <el-carousel-item v-for="item in tubox" :key="item.id">
              <img :src="item.tu" class="tu">
              <h3 class="medium">{{ item }}</h3>
            </el-carousel-item>
        </el-carousel>
<!-- 轮播图结束 -->
<!-- 第一模块开始 -->
        <section class="p-5">
            <div class="container">
                <div class="row align-items-center justify-content-between">
                    <div class="col-md">
                        <img src="../images/4.jpg" alt="1" class="img-fluid" />
                    </div>
                    <div class="col-md p-5">
                        <h2 style="font-size: 35px;font-weight: 700;">平台介绍</h2>
                        <p class="lead" style="font-size: 25px;">
                            高校中国网
                        </p>
                        <p style="font-size: 20px;">
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;在高考考生填报志愿时所思考的所有因素中，地域环境的考虑
                            因素通常会在每一个考生的高校衡量标准内。高校中国网站汇
                            总大陆所有高校的地域信息，立志于通过数据可视化的方式，
                            向考生展示不同省级、区级地区的高校信息，简便考生在，
                            就地理因素的考虑内，选择出最适合自己的那个梦中情校。
                        </p>
                        <router-link to="/china" class="btn btn-light">查看更多</router-link>
                    </div>
                </div>
            </div>
        </section>
<!-- 第一模块结束 -->

<!-- 功能描述模块开始 -->
        <section class="p-5" style="background-color: #f5f5f5;">
            <div class="container">
                <h2 class="text-center">功能介绍</h2>
                <p class="lead text-center">
                    Lorem ipsum, dolor sit amet consectetur adipisicing elit.
                    Hic, unde?
                </p>
                <div class="row g-4" >
                    <div class="col-md-6 col-lg-3">
                        <div class="card bg-light">
                            <div class="card-body text-center">
                                <!-- <img src="img/01-man.jpeg" class="mb-3 rounded-circle"/> -->
                                <!-- <h3 class="card-title">张三</h3> -->
                                <svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" fill="currentColor" class="bi bi-pin-map" viewBox="0 0 16 16">
                                  <path fill-rule="evenodd" d="M3.1 11.2a.5.5 0 0 1 .4-.2H6a.5.5 0 0 1 0 1H3.75L1.5 15h13l-2.25-3H10a.5.5 0 0 1 0-1h2.5a.5.5 0 0 1 .4.2l3 4a.5.5 0 0 1-.4.8H.5a.5.5 0 0 1-.4-.8l3-4z"/>
                                  <path fill-rule="evenodd" d="M8 1a3 3 0 1 0 0 6 3 3 0 0 0 0-6zM4 4a4 4 0 1 1 4.5 3.969V13.5a.5.5 0 0 1-1 0V7.97A4 4 0 0 1 4 3.999z"/>
                                </svg>
                                <p class="card-text" style="font-size: 17px;line-height:25px;margin-top: 15px;">
                                    用户通过点击屏幕上的地图，所
                                    点击到的范围会自动显示出该区
                                    域的高校信息。在便捷得知所有
                                    学校地域的准确信息外，用户
                                    还能更为直观的感受目标学校与
                                    家乡的距离，让恋家的考生不再
                                    远离家乡。
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-3">
                        <div class="card bg-light">
                            <div class="card-body text-center">
                                <!-- <img src="img/02-man.jpeg" class="mb-3 rounded-circle"/> -->
                                <!-- <h3 class="card-title">张三</h3> -->
                                <svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" fill="currentColor" class="bi bi-bar-chart-line-fill" viewBox="0 0 16 16">
                                  <path d="M11 2a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v12h.5a.5.5 0 0 1 0 1H.5a.5.5 0 0 1 0-1H1v-3a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v3h1V7a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v7h1V2z"/>
                                </svg>
                                <p class="card-text" style="font-size: 17px;line-height:30px;margin-top: 15px;">
                                    网站运用数据可视化技术，将大
                                    陆范围内大学的地区、排名、考
                                    分等信息以图标的形式展示，用
                                    户根据更为精准、直观的地区信
                                    息，对所选择的学校有更深入的
                                    了解。
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-3">
                        <div class="card bg-light">
                            <div class="card-body text-center">
                                <!-- <img src="img/03-man.jpeg" class="mb-3 rounded-circle"/> -->
                                <!-- <h3 class="card-title">张三</h3> -->
                                <svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" fill="currentColor" class="bi bi-heart-fill" viewBox="0 0 16 16">
                                  <path fill-rule="evenodd" d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z"/>
                                </svg>
                                <p class="card-text" style="font-size: 17px;line-height:30px;margin-top: 15px;">
                                    在进行个人账号的注册、登陆后，
                                    每一个所标记过的地区、高校信
                                    息都会在“个人中心”中记录，
                                    用户可以查看历史记录，从而确
                                    认自身实际的理想地域与高校。
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-3">
                        <div class="card bg-light">
                            <div class="card-body text-center">
                                <!-- <img src="img/03-man.jpeg" class="mb-3 rounded-circle"/> -->
                                <!-- <h3 class="card-title">张三</h3> -->
                                <svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" fill="currentColor" class="bi bi-chat-square-text" viewBox="0 0 16 16">
                                  <path d="M14 1a1 1 0 0 1 1 1v8a1 1 0 0 1-1 1h-2.5a2 2 0 0 0-1.6.8L8 14.333 6.1 11.8a2 2 0 0 0-1.6-.8H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v8a2 2 0 0 0 2 2h2.5a1 1 0 0 1 .8.4l1.9 2.533a1 1 0 0 0 1.6 0l1.9-2.533a1 1 0 0 1 .8-.4H14a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
                                  <path d="M3 3.5a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zM3 6a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9A.5.5 0 0 1 3 6zm0 2.5a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5z"/>
                                </svg>
                                <p class="card-text" style="font-size: 17px;line-height:25px;margin-top: 15px;">
                                    每一个高校都将拥有一个私有的
                                    信息交流平台，仅官方认证过的
                                    在读生或毕业生可以发布该高校
                                    的信息，通过学长学姐们的专业
                                    宣传和解答，用户会对该校有更
                                    多元的了解认知，从而丰富对其
                                    的看法。
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
<!-- 功能描述模块结束 -->
<!-- 图文说明模块开始 -->
        <section class="p-5">
            <div class="container">
                <div class="row g-4">
                    <!--gap-->
                    <div class="col-md">
                        <div class="">
                            <div class="card-body text-center">
                                <img src="../images/maps-1.jpg" style="float:left;width: 370px;height: 308px;"> 
                                <div class="card-text">
                                    中国有34个省级行政区，
                                    283个地级市，
                                    374个县级市，
                                    共计拥有3012所高校。
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md">
                        <div class="">
                            <div class="card-body text-center">
                                <div class="card-title" style="font-weight: 700;font-size: 23px;">城市GDP排行：</div>
                                <div class="card-text">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-symmetry-horizontal" viewBox="0 0 16 16">
                                      <path d="M13.5 7a.5.5 0 0 0 .24-.939l-11-6A.5.5 0 0 0 2 .5v6a.5.5 0 0 0 .5.5h11zm.485 2.376a.5.5 0 0 1-.246.563l-11 6A.5.5 0 0 1 2 15.5v-6a.5.5 0 0 1 .5-.5h11a.5.5 0 0 1 .485.376zM11.539 10H3v4.658L11.54 10z"/>
                                    </svg>上海<br>
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-symmetry-horizontal" viewBox="0 0 16 16">
                                      <path d="M13.5 7a.5.5 0 0 0 .24-.939l-11-6A.5.5 0 0 0 2 .5v6a.5.5 0 0 0 .5.5h11zm.485 2.376a.5.5 0 0 1-.246.563l-11 6A.5.5 0 0 1 2 15.5v-6a.5.5 0 0 1 .5-.5h11a.5.5 0 0 1 .485.376zM11.539 10H3v4.658L11.54 10z"/>
                                    </svg>北京<br>
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-symmetry-horizontal" viewBox="0 0 16 16">
                                      <path d="M13.5 7a.5.5 0 0 0 .24-.939l-11-6A.5.5 0 0 0 2 .5v6a.5.5 0 0 0 .5.5h11zm.485 2.376a.5.5 0 0 1-.246.563l-11 6A.5.5 0 0 1 2 15.5v-6a.5.5 0 0 1 .5-.5h11a.5.5 0 0 1 .485.376zM11.539 10H3v4.658L11.54 10z"/>
                                    </svg>深圳<br>
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-symmetry-horizontal" viewBox="0 0 16 16">
                                      <path d="M13.5 7a.5.5 0 0 0 .24-.939l-11-6A.5.5 0 0 0 2 .5v6a.5.5 0 0 0 .5.5h11zm.485 2.376a.5.5 0 0 1-.246.563l-11 6A.5.5 0 0 1 2 15.5v-6a.5.5 0 0 1 .5-.5h11a.5.5 0 0 1 .485.376zM11.539 10H3v4.658L11.54 10z"/>
                                    </svg>重庆<br>
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-symmetry-horizontal" viewBox="0 0 16 16">
                                      <path d="M13.5 7a.5.5 0 0 0 .24-.939l-11-6A.5.5 0 0 0 2 .5v6a.5.5 0 0 0 .5.5h11zm.485 2.376a.5.5 0 0 1-.246.563l-11 6A.5.5 0 0 1 2 15.5v-6a.5.5 0 0 1 .5-.5h11a.5.5 0 0 1 .485.376zM11.539 10H3v4.658L11.54 10z"/>
                                    </svg>广州
                                    <div class="card-title" style="font-weight: 700;font-size: 23px;">城市人才吸引力排名：</div>
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-symmetry-horizontal" viewBox="0 0 16 16">
                                      <path d="M13.5 7a.5.5 0 0 0 .24-.939l-11-6A.5.5 0 0 0 2 .5v6a.5.5 0 0 0 .5.5h11zm.485 2.376a.5.5 0 0 1-.246.563l-11 6A.5.5 0 0 1 2 15.5v-6a.5.5 0 0 1 .5-.5h11a.5.5 0 0 1 .485.376zM11.539 10H3v4.658L11.54 10z"/>
                                    </svg>北京<br>
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-symmetry-horizontal" viewBox="0 0 16 16">
                                      <path d="M13.5 7a.5.5 0 0 0 .24-.939l-11-6A.5.5 0 0 0 2 .5v6a.5.5 0 0 0 .5.5h11zm.485 2.376a.5.5 0 0 1-.246.563l-11 6A.5.5 0 0 1 2 15.5v-6a.5.5 0 0 1 .5-.5h11a.5.5 0 0 1 .485.376zM11.539 10H3v4.658L11.54 10z"/>
                                    </svg>杭州<br>
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-symmetry-horizontal" viewBox="0 0 16 16">
                                      <path d="M13.5 7a.5.5 0 0 0 .24-.939l-11-6A.5.5 0 0 0 2 .5v6a.5.5 0 0 0 .5.5h11zm.485 2.376a.5.5 0 0 1-.246.563l-11 6A.5.5 0 0 1 2 15.5v-6a.5.5 0 0 1 .5-.5h11a.5.5 0 0 1 .485.376zM11.539 10H3v4.658L11.54 10z"/>
                                    </svg>上海<br>
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-symmetry-horizontal" viewBox="0 0 16 16">
                                      <path d="M13.5 7a.5.5 0 0 0 .24-.939l-11-6A.5.5 0 0 0 2 .5v6a.5.5 0 0 0 .5.5h11zm.485 2.376a.5.5 0 0 1-.246.563l-11 6A.5.5 0 0 1 2 15.5v-6a.5.5 0 0 1 .5-.5h11a.5.5 0 0 1 .485.376zM11.539 10H3v4.658L11.54 10z"/>
                                    </svg>深圳<br>
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-symmetry-horizontal" viewBox="0 0 16 16">
                                      <path d="M13.5 7a.5.5 0 0 0 .24-.939l-11-6A.5.5 0 0 0 2 .5v6a.5.5 0 0 0 .5.5h11zm.485 2.376a.5.5 0 0 1-.246.563l-11 6A.5.5 0 0 1 2 15.5v-6a.5.5 0 0 1 .5-.5h11a.5.5 0 0 1 .485.376zM11.539 10H3v4.658L11.54 10z"/>
                                    </svg>广州
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md">
                        <div class="">
                            <div class="card-body text-center">
                                <div class="card-title" style="font-weight: 700;font-size: 23px;">城市高校数量排名：</div>
                                <div class="card-text">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-symmetry-horizontal" viewBox="0 0 16 16">
                                      <path d="M13.5 7a.5.5 0 0 0 .24-.939l-11-6A.5.5 0 0 0 2 .5v6a.5.5 0 0 0 .5.5h11zm.485 2.376a.5.5 0 0 1-.246.563l-11 6A.5.5 0 0 1 2 15.5v-6a.5.5 0 0 1 .5-.5h11a.5.5 0 0 1 .485.376zM11.539 10H3v4.658L11.54 10z"/>
                                    </svg>北京<br>
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-symmetry-horizontal" viewBox="0 0 16 16">
                                      <path d="M13.5 7a.5.5 0 0 0 .24-.939l-11-6A.5.5 0 0 0 2 .5v6a.5.5 0 0 0 .5.5h11zm.485 2.376a.5.5 0 0 1-.246.563l-11 6A.5.5 0 0 1 2 15.5v-6a.5.5 0 0 1 .5-.5h11a.5.5 0 0 1 .485.376zM11.539 10H3v4.658L11.54 10z"/>
                                    </svg>武汉<br>
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-symmetry-horizontal" viewBox="0 0 16 16">
                                      <path d="M13.5 7a.5.5 0 0 0 .24-.939l-11-6A.5.5 0 0 0 2 .5v6a.5.5 0 0 0 .5.5h11zm.485 2.376a.5.5 0 0 1-.246.563l-11 6A.5.5 0 0 1 2 15.5v-6a.5.5 0 0 1 .5-.5h11a.5.5 0 0 1 .485.376zM11.539 10H3v4.658L11.54 10z"/>
                                    </svg>广州<br>
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-symmetry-horizontal" viewBox="0 0 16 16">
                                      <path d="M13.5 7a.5.5 0 0 0 .24-.939l-11-6A.5.5 0 0 0 2 .5v6a.5.5 0 0 0 .5.5h11zm.485 2.376a.5.5 0 0 1-.246.563l-11 6A.5.5 0 0 1 2 15.5v-6a.5.5 0 0 1 .5-.5h11a.5.5 0 0 1 .485.376zM11.539 10H3v4.658L11.54 10z"/>
                                    </svg>重庆<br>
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-symmetry-horizontal" viewBox="0 0 16 16">
                                      <path d="M13.5 7a.5.5 0 0 0 .24-.939l-11-6A.5.5 0 0 0 2 .5v6a.5.5 0 0 0 .5.5h11zm.485 2.376a.5.5 0 0 1-.246.563l-11 6A.5.5 0 0 1 2 15.5v-6a.5.5 0 0 1 .5-.5h11a.5.5 0 0 1 .485.376zM11.539 10H3v4.658L11.54 10z"/>
                                    </svg>上海<br>
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-symmetry-horizontal" viewBox="0 0 16 16">
                                      <path d="M13.5 7a.5.5 0 0 0 .24-.939l-11-6A.5.5 0 0 0 2 .5v6a.5.5 0 0 0 .5.5h11zm.485 2.376a.5.5 0 0 1-.246.563l-11 6A.5.5 0 0 1 2 15.5v-6a.5.5 0 0 1 .5-.5h11a.5.5 0 0 1 .485.376zM11.539 10H3v4.658L11.54 10z"/>
                                    </svg>西安<br>
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-symmetry-horizontal" viewBox="0 0 16 16">
                                      <path d="M13.5 7a.5.5 0 0 0 .24-.939l-11-6A.5.5 0 0 0 2 .5v6a.5.5 0 0 0 .5.5h11zm.485 2.376a.5.5 0 0 1-.246.563l-11 6A.5.5 0 0 1 2 15.5v-6a.5.5 0 0 1 .5-.5h11a.5.5 0 0 1 .485.376zM11.539 10H3v4.658L11.54 10z"/>
                                    </svg>郑州<br>
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-symmetry-horizontal" viewBox="0 0 16 16">
                                      <path d="M13.5 7a.5.5 0 0 0 .24-.939l-11-6A.5.5 0 0 0 2 .5v6a.5.5 0 0 0 .5.5h11zm.485 2.376a.5.5 0 0 1-.246.563l-11 6A.5.5 0 0 1 2 15.5v-6a.5.5 0 0 1 .5-.5h11a.5.5 0 0 1 .485.376zM11.539 10H3v4.658L11.54 10z"/>
                                    </svg>成都<br>
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-symmetry-horizontal" viewBox="0 0 16 16">
                                      <path d="M13.5 7a.5.5 0 0 0 .24-.939l-11-6A.5.5 0 0 0 2 .5v6a.5.5 0 0 0 .5.5h11zm.485 2.376a.5.5 0 0 1-.246.563l-11 6A.5.5 0 0 1 2 15.5v-6a.5.5 0 0 1 .5-.5h11a.5.5 0 0 1 .485.376zM11.539 10H3v4.658L11.54 10z"/>
                                    </svg>长沙<br>
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-symmetry-horizontal" viewBox="0 0 16 16">
                                      <path d="M13.5 7a.5.5 0 0 0 .24-.939l-11-6A.5.5 0 0 0 2 .5v6a.5.5 0 0 0 .5.5h11zm.485 2.376a.5.5 0 0 1-.246.563l-11 6A.5.5 0 0 1 2 15.5v-6a.5.5 0 0 1 .5-.5h11a.5.5 0 0 1 .485.376zM11.539 10H3v4.658L11.54 10z"/>
                                    </svg>天津<br>
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-symmetry-horizontal" viewBox="0 0 16 16">
                                      <path d="M13.5 7a.5.5 0 0 0 .24-.939l-11-6A.5.5 0 0 0 2 .5v6a.5.5 0 0 0 .5.5h11zm.485 2.376a.5.5 0 0 1-.246.563l-11 6A.5.5 0 0 1 2 15.5v-6a.5.5 0 0 1 .5-.5h11a.5.5 0 0 1 .485.376zM11.539 10H3v4.658L11.54 10z"/>
                                    </svg>合肥<br>
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-symmetry-horizontal" viewBox="0 0 16 16">
                                      <path d="M13.5 7a.5.5 0 0 0 .24-.939l-11-6A.5.5 0 0 0 2 .5v6a.5.5 0 0 0 .5.5h11zm.485 2.376a.5.5 0 0 1-.246.563l-11 6A.5.5 0 0 1 2 15.5v-6a.5.5 0 0 1 .5-.5h11a.5.5 0 0 1 .485.376zM11.539 10H3v4.658L11.54 10z"/>
                                    </svg>南昌
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
<!-- 图文说明模块结束 -->
<!-- 底部开始 -->
        <section class="p-5 text-white" style="background-color: #000;">
            <div class="container">
                <div class="row g-4">
                    <!--gap-->
                    <div class="col-md">
                        <div class="card text-light" style="background-color: rgb(0, 0, 0);">
                            <div class="card-body text-center">
                                <!-- <a href="https://www.baidu.com"><img src="../images/logo-111.png" alt="logo"></a> -->
                                <router-link to="/myHome"><img src="../images/logo-111.png" alt="logo" style="width: 200px; height: 105px;"></router-link>
                            </div>
                        </div>
                    </div>
                    <div class="col-md">
                        <div class="card text-light" style="background-color: rgb(0, 0, 0);">
                            <div class="card-body text-center">
                                <div class="card-text">
                                    高校中国网站，
                                    一个立足于帮助广大高考考生了解
                                    高校地域信息的网站。通过大数据信息和可视化技
                                    术让用户直观地了解全面的高校地理位置信息，并
                                    通过官方学生解答，完善高校认知
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md">
                        <div class="card text-light" style="background-color:rgb(0, 0, 0);">
                            <div class="card-body text-center">
                                <div class="card-title">联系我们</div>
                                <div class="card-text">
                                    <div>
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-telephone" viewBox="0 0 16 16">
                                          <path d="M3.654 1.328a.678.678 0 0 0-1.015-.063L1.605 2.3c-.483.484-.661 1.169-.45 1.77a17.568 17.568 0 0 0 4.168 6.608 17.569 17.569 0 0 0 6.608 4.168c.601.211 1.286.033 1.77-.45l1.034-1.034a.678.678 0 0 0-.063-1.015l-2.307-1.794a.678.678 0 0 0-.58-.122l-2.19.547a1.745 1.745 0 0 1-1.657-.459L5.482 8.062a1.745 1.745 0 0 1-.46-1.657l.548-2.19a.678.678 0 0 0-.122-.58L3.654 1.328zM1.884.511a1.745 1.745 0 0 1 2.612.163L6.29 2.98c.329.423.445.974.315 1.494l-.547 2.19a.678.678 0 0 0 .178.643l2.457 2.457a.678.678 0 0 0 .644.178l2.189-.547a1.745 1.745 0 0 1 1.494.315l2.306 1.794c.829.645.905 1.87.163 2.611l-1.034 1.034c-.74.74-1.846 1.065-2.877.702a18.634 18.634 0 0 1-7.01-4.42 18.634 18.634 0 0 1-4.42-7.009c-.362-1.03-.037-2.137.703-2.877L1.885.511z"/>
                                        </svg>
                                        电话：19946071507
                                    </div>
                                    <div>
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-envelope-at" viewBox="0 0 16 16">
                                          <path d="M2 2a2 2 0 0 0-2 2v8.01A2 2 0 0 0 2 14h5.5a.5.5 0 0 0 0-1H2a1 1 0 0 1-.966-.741l5.64-3.471L8 9.583l7-4.2V8.5a.5.5 0 0 0 1 0V4a2 2 0 0 0-2-2H2Zm3.708 6.208L1 11.105V5.383l4.708 2.825ZM1 4.217V4a1 1 0 0 1 1-1h12a1 1 0 0 1 1 1v.217l-7 4.2-7-4.2Z"/>
                                          <path d="M14.247 14.269c1.01 0 1.587-.857 1.587-2.025v-.21C15.834 10.43 14.64 9 12.52 9h-.035C10.42 9 9 10.36 9 12.432v.214C9 14.82 10.438 16 12.358 16h.044c.594 0 1.018-.074 1.237-.175v-.73c-.245.11-.673.18-1.18.18h-.044c-1.334 0-2.571-.788-2.571-2.655v-.157c0-1.657 1.058-2.724 2.64-2.724h.04c1.535 0 2.484 1.05 2.484 2.326v.118c0 .975-.324 1.39-.639 1.39-.232 0-.41-.148-.41-.42v-2.19h-.906v.569h-.03c-.084-.298-.368-.63-.954-.63-.778 0-1.259.555-1.259 1.4v.528c0 .892.49 1.434 1.26 1.434.471 0 .896-.227 1.014-.643h.043c.118.42.617.648 1.12.648Zm-2.453-1.588v-.227c0-.546.227-.791.573-.791.297 0 .572.192.572.708v.367c0 .573-.253.744-.564.744-.354 0-.581-.215-.581-.8Z"/>
                                        </svg> 邮箱： lausoar@163.com
                                    </div>
                                    <div>
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-geo-alt" viewBox="0 0 16 16">
                                          <path d="M12.166 8.94c-.524 1.062-1.234 2.12-1.96 3.07A31.493 31.493 0 0 1 8 14.58a31.481 31.481 0 0 1-2.206-2.57c-.726-.95-1.436-2.008-1.96-3.07C3.304 7.867 3 6.862 3 6a5 5 0 0 1 10 0c0 .862-.305 1.867-.834 2.94zM8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10z"/>
                                          <path d="M8 8a2 2 0 1 1 0-4 2 2 0 0 1 0 4zm0 1a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
                                        </svg> 地址：<a href="https://www.lixin.edu.cn/" style="text-decoration: none; color: white;">上海立信会计金融学院</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <footer class=" text-white text-center" style="height: 30px !important; padding-top: 2px; background-color:#9cdbf7;">
            <div class="container">
                <h6 class="">Copyright &copy; 2023 高校志愿信息整合平台</h6>
            </div>
            <div class="button">
                <a href="https://beian.miit.gov.cn" target="_blank">皖ICP备2023004922号-1</a>
            </div>
        </footer>
<!-- 底部结束 -->
    </div>
</template>

<script>

export default {
    name: 'MyHome',

    data() {
        return {
            tubox: [
            { id: 0, tu: require("../images/1.jpg") }, 
            { id: 1, tu: require("../images/2.jpg") },
            { id: 2, tu: require("../images/3.jpg") },
            { id: 3, tu: require("../images/4.jpg") },
        ]
        }
    },

    mounted() {
        
    },

    methods: {
        gotolink(){
 
        //点击跳转至上次浏览页面
        // this.$router.go(-1)

        //指定跳转地址
        this.$router.replace('/china')
        }
    },
};
</script>

<style lang="css" scoped>
.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}
.tu {
  width: 100%;
  height: 100%;
}
.button {
    background-color: #9cdbf7;
}
.button a {
    text-decoration: none;
    color:#fff;
}

</style>