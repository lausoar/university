//package com.project.blog.controller;
//
//import com.project.blog.common.Result;
//import com.project.blog.entity.SysUser;
//import com.project.blog.mapper.SysUserMapper;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiImplicitParams;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@Api(value = "测试模块",tags = "测试模块")
//@RestController //将数据以json形式返回
//public class TestController {
//    @Value("${text}")
//    private String text;
//
//    @Autowired
//    private SysUserMapper userMapper;
//
//    @GetMapping("/test")
//    @ApiOperation(value = "测试",notes = "测试")
//    public String test(){
//        return "Hello World111111!";
//    }
//
//    @ApiOperation(value = "测试",notes = "测试")
//    @GetMapping("/text")
//    public String text(){
//        return text;
//    }
//
//
//    @ApiOperation(value = "用户接口返回")
//    @GetMapping("/user")
//    public List<SysUser> user(){
//        return userMapper.selectList(null);
//    }
//
//    @ApiOperation(value = "swagger参数测试")
//    @GetMapping("/getById")
//    @ApiImplicitParams(
//            {
//               @ApiImplicitParam(name="id",value = "用户id",dataType = "long",paramType = "query",required = true,defaultValue = "")
//            }
//    )
//    public List<SysUser> getById(@RequestParam("id") Long id){
//        return userMapper.selectList(null);
//    }
//
//
//
//    @ApiOperation(value = "测试统一返回类 成功")
//    @GetMapping("/success")
//    public Result success(){
//        return new Result<>().success(userMapper.selectList(null));
//    }
//
//
//
//    @ApiOperation(value = "测试统一返回类 失败")
//    @GetMapping("/error")
//    public Result error(){
//        return new Result<>().error("测试统一返回类 失败");
//    }
//
//}
