package com.project.blog.controller;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project.blog.common.PageVO;
import com.project.blog.common.Result;
import com.project.blog.dto.SysUserDTO;
import com.project.blog.dto.SysUserQuery;
import com.project.blog.dto.UserLoginDTO;
import com.project.blog.dto.UserRegisterDTO;
import com.project.blog.entity.SysMenu;
import com.project.blog.entity.SysRole;
import com.project.blog.entity.SysRoleMenu;
import com.project.blog.entity.SysUser;
import com.project.blog.enums.RoleType;
import com.project.blog.enums.StatusType;
import com.project.blog.exception.CustomException;
import com.project.blog.utils.JwtUtils;
import com.project.blog.utils.UserThreadLocal;
import com.project.blog.utils.Utils;
import com.project.blog.vo.SysUserListVO;
import com.project.blog.vo.SysUserLoginVO;
import com.project.blog.vo.SysUserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Api(value = "用户模块", tags = "用户模块")

@RestController
@RequestMapping("/sysUser")
public class SysUserController extends BaseController {


    @ApiOperation(value = "用户列表", notes = "测试xxxxxxx")
    @GetMapping("/list")
    public Result<List<SysUser>> list() {
        return new Result<>().success(sysUserService.list());
    }


    //分页查询 页码 每页显示多少条
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @PostMapping("/page")
    public Result<PageVO<SysUser>> findPage(@RequestBody SysUserQuery userQuery) {
        //查出的数据降序排列 且支持用户名称模糊查询


        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByDesc(SysUser::getId);

        if (!"".equals(userQuery.getUsername()) && userQuery.getUsername() != null) {
            wrapper.like(SysUser::getUsername, userQuery.getUsername());
        }
        //TODO 用户分页功能未完成
        Page<SysUser> page = sysUserService.page(
                new Page<>(
                        userQuery.getPageNum(),
                        userQuery.getPageSize()
                ),
                wrapper
        );

        //TODO 新增
        Page<SysUserListVO> voPage = new Page<>();
        BeanUtil.copyProperties(page,voPage);

        List<SysUser> records = page.getRecords();
        List<SysUserListVO> listVOList = new ArrayList<>();

        records.forEach(item->{
            SysUserListVO sysUserListVO = new SysUserListVO();
            BeanUtil.copyProperties(item,sysUserListVO);
            LambdaQueryWrapper<SysRole> queryWrapper = new LambdaQueryWrapper<>();
            //查询用户角色
            queryWrapper.eq(SysRole::getRole,item.getRoleType())
                            //只查询一条数据
                            .last("limit 1");

            SysRole sysRole = sysRoleService.getOne(queryWrapper);
            if(sysRole!=null){
                sysUserListVO.setRoleTypeText(sysRole.getTitle());
            }

            listVOList.add(sysUserListVO);
        });
        voPage.setRecords(listVOList);
        return new Result<>().success(new PageVO<>(voPage));
    }

    //编辑 新增  id
    @ApiOperation(value = "数据保存或更新", notes = "数据保存或更新")
    @PostMapping("/save")
    public Result save(@Validated @RequestBody SysUser user) {
        //判断用户权限
        SysUserDTO currentUser = UserThreadLocal.getCurrentUser();
        //管理员权限
        if (!RoleType.ROLE_ADMIN.equals(currentUser.getRoleType())) {
                //普通用户权限 只能对自己进行修改         //判断用户id是否一致
            if (Objects.equals(currentUser.getId(), user.getId())) {
                SysUser sysUser = sysUserService.getById(currentUser.getId());
                user.setRoleType(sysUser.getRoleType());

//                //权限不符
//                if (sysUser.getRoleType().equals(user.getRoleType())) {
//
//                }else{
//                    //不相等情况处理
//                }

            }else{
                throw new CustomException("用户ID不符，请重新登录");
            }
        }


        //TODO 用户保存功能未完成
//        throw new CustomException("这个是自定义异常");

        sysUserService.saveOrUpdate(user);
        return new Result<>().success();
    }

    // 根据用户的id来删除用户
    @ApiOperation(value = "数据根据id批量删除", notes = "数据根据id批量删除")
    @PostMapping("/delBatch")
    public Result delBatch(@RequestBody List<Integer> ids) {
        sysUserService.removeByIds(ids);
        return new Result<>().success();
    }

    //    @GetMapping("/login")
//    public Result login(@RequestParam("username") String username,@RequestParam("password") String password){
    @PostMapping("/login")
    public Result login(@Validated @RequestBody UserLoginDTO userLoginDTO) {
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUser::getUsername, userLoginDTO.getUsername())
//                .eq(SysUser::getPassword, userLoginDTO.getPassword())
                .last("limit 1");
        //user.setPassword(SecureUtil.md5(user.getPassword()+ salt ));
        SysUser userInfo = sysUserService.getOne(wrapper);
        if (userInfo != null) {
            String salt = userInfo.getSalt();

            if (!SecureUtil.md5(userLoginDTO.getPassword()+salt).equals(userInfo.getPassword())) {
                return new Result<>().error("请检查用户名密码是否正确");
            }

            LambdaQueryWrapper<SysRole> queryWrapper = new LambdaQueryWrapper<>();
            //查询用户角色
            queryWrapper.eq(SysRole::getRole,userInfo.getRoleType())
                    //只查询一条数据
                    .last("limit 1");

            SysRole sysRole = sysRoleService.getOne(queryWrapper);
            List<SysMenu> menuList = new ArrayList<>();
            if(sysRole!=null){
                LambdaQueryWrapper<SysRoleMenu> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                lambdaQueryWrapper.eq(SysRoleMenu::getRoleId,sysRole.getId());
                List<SysRoleMenu> roleMenuList = sysRoleMenuService.list(lambdaQueryWrapper);
                roleMenuList.forEach(item->{

                    LambdaQueryWrapper<SysMenu> sysRoleLambdaQueryWrapper = new LambdaQueryWrapper<>();
                    //查询用户角色
                    sysRoleLambdaQueryWrapper.eq(SysMenu::getId,item.getMenuId())
                            //只查询一条数据
                            .eq(SysMenu::getStatus, StatusType.Yes)
                            .last("limit 1");
                    if(sysMenuService.getOne(sysRoleLambdaQueryWrapper)!=null){
                        menuList.add(sysMenuService.getOne(sysRoleLambdaQueryWrapper));
                    }
                });
            }
            //生成jwt
            String token = JwtUtils.generateToken(userInfo);
            SysUserLoginVO sysUserLoginVO = new SysUserLoginVO();
            BeanUtil.copyProperties(userInfo,sysUserLoginVO);
            sysUserLoginVO.setToken(token);
            sysUserLoginVO.setMenuList(menuList);
            return new Result<>().success(sysUserLoginVO);
        } else {
            //new Result<>().error
            return new Result<>().error("请检查用户名密码是否正确");
//            throw new CustomException("请检查用户名密码是否正确");
        }


    }


    //需求：通过用户id查询出用户相关信息用于前端展示
    @GetMapping("/getById")
    public Result<SysUserVO> getById(@RequestParam("id") Integer id) {
        SysUser byId = sysUserService.getById(id);
        SysUserVO userVO = new SysUserVO();
        BeanUtils.copyProperties(byId, userVO);
        return new Result<>().success(userVO);
    }


    @PostMapping("/register")
    public Result register(@Validated @RequestBody UserRegisterDTO userRegisterDTO) {
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUser::getUsername, userRegisterDTO.getUsername())
                .last("limit 1");
        //有值 提示用户名已重复
        SysUser userInfo = sysUserService.getOne(wrapper);

        if (userInfo != null) {
            return new Result<>().error("用户名称重复");
        }
        SysUser user = new SysUser();
        BeanUtil.copyProperties(userRegisterDTO, user);
        String salt = Utils.salt();
        user.setSalt(salt);
        //密码加密
        user.setPassword(SecureUtil.md5(user.getPassword()+ salt ));

        //TODO 用户注册需将权限设置为普通用户
        user.setRoleType(RoleType.ROLE_USER);

        sysUserService.saveOrUpdate(user);
        return new Result<>().success();


    }
}
