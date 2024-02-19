package com.project.blog.utils;

import com.project.blog.dto.SysUserDTO;

public class UserThreadLocal {
    /**
     * 构造函数私有
     */
    private UserThreadLocal() {
    }

    //线程变量隔离
    private static final ThreadLocal<SysUserDTO> USER_INFO_THREAD_LOCAL =
            new ThreadLocal<>();

    /**
     * 清除用户信息
     */
    public static void clear() {
        USER_INFO_THREAD_LOCAL.remove();
    }

    /**
     * 存储用户信息
     */
    public static void set(SysUserDTO sysUserDTO) {
        USER_INFO_THREAD_LOCAL.set(sysUserDTO);
    }

    /**
     * 获取当前用户信息
     */
    public static SysUserDTO getCurrentUser() {
        return USER_INFO_THREAD_LOCAL.get();
    }
}
