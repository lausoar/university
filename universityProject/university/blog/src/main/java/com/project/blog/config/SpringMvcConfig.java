package com.project.blog.config;

import com.project.blog.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {

    @Resource
    LoginInterceptor loginInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                //允许直接访问的接口
                .excludePathPatterns(
                        "/sysUser/login",
                        "/sysUser/register",
//                        "/article/page",
//                        "/article/detail",
//
//                        //TODO 开发暂时允许访问
//                        "/sysUser/list",
//                        "/sysUser/getById",
//                        "/sysUser/page",
//                        "/category/**",
//                        "/sysUser/save",
//                        "/sysRole/**",
//                        //放行全部
//                        "/**",

//                        "/article/**",
                        "/article/uPage",
                        "/article/uDetail",
                        "/views"

//                        "/swagger-ui/**",
//                        "/swagger-ui.html",
//                        "/swagger-resources/**",
//                        "/images/**",
//                        "/webjars/**",
//                        "/v2/api-docs",
//                        "/configuration/ui",
//                        "/configuration/security",
//                        "/doc.html"

                );

    }


}
