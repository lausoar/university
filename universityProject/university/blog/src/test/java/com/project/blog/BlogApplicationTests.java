package com.project.blog;

import cn.hutool.crypto.SecureUtil;
import com.project.blog.entity.SysUser;
import com.project.blog.enums.RoleType;
import com.project.blog.mapper.SysUserMapper;
import com.project.blog.utils.JwtUtils;
import com.project.blog.utils.Utils;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BlogApplicationTests {

    @Autowired
    private SysUserMapper userMapper;



    @Test
    void contextLoads() {

        List<SysUser> users = userMapper.selectList(null);

        users.forEach(System.out::println);

    }

    @Test
    void testJwt() {
        SysUser user = new SysUser();
        user.setId(1);
        user.setUsername("张三");
        user.setRoleType(RoleType.ROLE_USER);
        System.out.println(JwtUtils.generateToken(user));
    }



    @Test
    void test2Jwt() {
        SysUser user = new SysUser();
        user.setId(1);
        user.setUsername("张三");
        user.setRoleType(RoleType.ROLE_ADMIN);

        System.out.println(JwtUtils.generateToken(user));
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlVHlwZSI6IlJPTEVfQURNSU4iLCJleHAiOjE2NzczOTk4ODgsInVzZXJJZCI6MSwiaWF0IjoxNjc3Mzk3Mjk2LCJlbWFpbCI6bnVsbCwianRpIjoidG9rZW5JZCIsInVzZXJuYW1lIjoi5byg5LiJIn0.8aAWWrG7TqQIqs4ywUlj2xOIhjyPA7O823naWsS1g0M";
        Claims claims = JwtUtils.verifyJwt(token);

    }


    @Test
    void testPassword1(){
        String password = "12345678";
        System.out.println(SecureUtil.md5(password));
    }

    @Test
    void testPassword2(){
        String password = "12345678";
        String salt = Utils.salt();
        System.out.println(SecureUtil.md5(password+salt));
    }
}
