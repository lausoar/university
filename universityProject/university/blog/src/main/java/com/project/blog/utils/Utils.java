package com.project.blog.utils;

import cn.hutool.crypto.SecureUtil;

import java.util.HashMap;
import java.util.Random;

public class Utils {

    //超级管理员可访问接口
    private final static String[] ROLE_ADMIN = {

            //文件上传和预览下载
            "/uploads",
//            "/views",
            "/wangeditorUploads",

            //文章管理
            "/article/delBatch",
            "/article/list",
            "/article/page",
            "/article/save",
            "/article/uDetail",
            "/article/uPage",

            //分类管理
            "/category/delBatch",
//            "/category/list",
            "/category/page",
            "/category/save",

            //菜单管理
            "/sysMenu/delBatch",
            "/sysMenu/list",
            "/sysMenu/page",
            "/sysMenu/save",

            //用户管理
            "/sysUser/delBatch",
            "/sysUser/list",
            "/sysUser/page",
            "/sysUser/save",
            "/sysUser/getById",

            //角色管理
            "/sysRole/delBatch",
            "/sysRole/list",
            "/sysRole/page",
            "/sysRole/save",
            "/sysRole/getByRoleId",
            "/sysRole/saveRoleMenu",


    };
    //普通用户可访问接口
    private final static String[] ROLE_USER = {

            //文件上传和预览下载
            "/uploads",
//            "/views",
            "/wangeditorUploads",

            //文章管理
            "/article/delBatch",
//            "/article/list",
            "/article/page",
            "/article/save",
            "/article/uDetail",
            "/article/uPage",

            //分类管理
            "/category/list",

            //用户新增保存
            "/sysUser/save",


    };

    private static char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /**
     * 自定义简单生成盐，是一个随机生成的长度为16的字符串，每一个字符是随机的十六进制字符
     */
    public static String salt() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(16);
        for (int i = 0; i < sb.capacity(); i++) {
            sb.append(hex[random.nextInt(16)]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String salt = salt();
        System.out.println(salt);
        //2e400f7fe59147f895338b4ee9011239
        System.out.println(SecureUtil.md5("getToken" + salt));
    }

    /**
     * 判断用户是否有该接口的访问权限
     * @param url
     * @param isRole
     * @return
     */
    public static boolean isRole(String url,String isRole){
        boolean isFlag = false;

        //需要和数据库中角色标识字段保持一致
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("ROLE_ADMIN",ROLE_ADMIN);
        hashMap.put("ROLE_USER",ROLE_USER);
        for (String s : (String[]) hashMap.get(isRole)) {
            if(url.contains(s)){
                isFlag = true;

            }
        }
        return  isFlag;

    }



}

