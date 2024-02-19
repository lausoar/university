package com.project.blog.serviceImpl;

import com.project.blog.entity.SysUser;
import com.project.blog.mapper.SysUserMapper;
import com.project.blog.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

}
