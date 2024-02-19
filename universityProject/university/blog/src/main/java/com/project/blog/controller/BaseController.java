package com.project.blog.controller;

import com.project.blog.serviceImpl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @Autowired
    SysUserServiceImpl sysUserService;

    @Autowired
    CategoryServiceImpl categoryService;

    @Autowired
    ArticleServiceImpl articleService;

    @Autowired
    SysRoleServiceImpl sysRoleService;

    @Autowired
    SysMenuServiceImpl sysMenuService;

    @Autowired
    SysRoleMenuServiceImpl sysRoleMenuService;
}
