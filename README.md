高校志愿信息整合平台——基于SpringBoot的数据分析系统

university--是系统的后端

vue-demo-lausoar--是系统的前端

web--是后台管理系统的前端

系统软硬件平台

系统开发平台

1．软件环境
	开发环境：Windows操作系统：微软，Windows10

1.	后端服务器开发：Java语言

2.	后端框架：Spring Boot，MyBatis-Plus，JWT

3.	前端开发：HTML，CSS，JavaScript

4.	前端框架：Vue，Bootstrap

5.	数据库：MySQL

6.	测试工具：Postman

	开发软件：

Microsoft  公司的Visual Studio （version 1.65）。用于编写前端页面。
官方网站：https://www.microsoft.com/zh-cn/

JetBrains 公司的IntelliJ IDEA 2022.3.2 x64。用于后端程序的编写。
官方网站：https://www.jetbrains.com/zh-cn/

香港卓软数码科技有限公司的NAVICAT for MySQL（10.1.7）。用于建立数据库。
官方网站：https://www.ruanfujia.com/vendor/185000/

Java：1.8.0_111
Postman：Postman for Windows Version 10.12.11

	第三方工具：

ECHARTS   实现了扇形分析图，柱状分析图等。
官方网站：https://echarts.apache.org/zh/index.html

Bootstrap  引入bootstrap框架，完善网页结构。
官方网站：https://v2.bootcss.com/ 

ICOMOON   引用图标小组件美化页面。
官方网站：https://icomoon.io/

Element UI  前端框架。
官方网站：https://element.eleme.cn/#/zh-CN 

2．数据库：	

MySQL  厂家：Oracle 版本：5.5.36

3.  硬件环境

电脑型号：拯救者Y7000 2021

电脑厂家：联想

CPU： 11th Gen Intel(R) Core(TM) i5-11400H @ 2.70GHz   2.69 GHz

内存：16.0 GB

2.2.2 系统运行平台

1.	本地服务器运行平台

系统版本：GNU/Linux CentOS Linux 7.9.2009 (Core) build 3.10.0-1160.25.1.el7.x86_64

CPU信息：Intel(R) Xeon(R) CPU E5-2682 v4 @ 2.50GHz。1个物理CPU，1个物理核心，1个逻辑CPU。

运行内存：2G

环境需求：tomcat9, nginx1.20, MySQL5.6，node.js

2.	网站服务器运行平台

本网站放置在了谷歌浏览器上，该系统的后台管理网站运行软件可使用主流浏览器访问，硬件没有硬性要求。

部署环境：阿里云 通用计算型CentOS、7.8、 64位。

2.3	关键技术

1.	开发技术

本网站的开发主要使用了Vue框架、Bootstrap框架、Spring Boot框架、MySQL数据库、MyBatis-Plus、Spring Security、JWT等语言和技术来帮助搭建网站。

2.	理论技术

本网站主要运用的是阿里云来实现网站上线和容器化部署。

3.	网站关键技术

本网站使用了Spring Boot、 JWT、Spring Security、Vue、Element-UI等技术。

Spring boot是一个基于java编程语言的开源框架，它是spring framework 的一种扩展，使spring应用程序的开发变得更快、更容易。它是一个非常流行和实用的java开发框架，在企业级应用程序的开发中获得了广泛的应用。Spring Boot框架的核心就是自动配置，只要存在相应的jar包，Spring就可自动配置，能够快速搭建Java应用程序，主要拥有以下几点优势：

	简单：spring boot通过自动配置（auto-configuration）和约定大于配置（convention over configuration）等方式，在很大程度上节省了开发人员的时间和精力。

	快速启动：由于使用了内嵌的tomcat，spring boot应用程序的启动速度非常快，并且也不需要额外安装和配置其他服务器。

	可扩展：spring boot提供了大量的插件和扩展，可以方便地与其他技术栈集成。

	易于测试：spring boot应用程序的各个组件可以被解耦合，因此可以更轻松地编写单元测试和集成测试。

 

