package com.project.blog.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project.blog.common.PageVO;
import com.project.blog.common.Result;
import com.project.blog.dto.SysRoleDTO;
import com.project.blog.dto.SysRoleMenuDTO;
import com.project.blog.entity.SysMenu;
import com.project.blog.entity.SysRole;
import com.project.blog.entity.SysRoleMenu;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Api(value = "角色模块", tags = "角色模块")
@RestController
@RequestMapping("/sysRole")
public class SysRoleController extends BaseController {
    @ApiOperation(value = "列表", notes = "测试xxxxxxx")
    @GetMapping("/list")
    public Result<List<SysRole>> list() {
        return new Result<>().success(sysRoleService.list());
    }

    @ApiOperation(value = "分页查询", notes = "分页查询")
    @PostMapping("/page")
    public Result<PageVO<SysRole>> findPage(@RequestBody SysRoleDTO sysRoleDTO) {
        //查出的数据降序排列
        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByDesc(SysRole::getId);

        //模糊查询
        if(sysRoleDTO.getTitle() !=null && !"".equals(sysRoleDTO.getTitle())){
            wrapper.like(SysRole::getTitle,sysRoleDTO.getTitle());
        }

        Page<SysRole> page = sysRoleService.page(
                new Page<>(
                        sysRoleDTO.getPageNum(),
                        sysRoleDTO.getPageSize()
                ),
                wrapper
        );
        return new Result<>().success(new PageVO<>(page));
    }

    //编辑 新增  id
    @ApiOperation(value = "数据保存或更新", notes = "数据保存或更新")
    @PostMapping("/save")
    public Result save(@Validated @RequestBody SysRole sysRole) {
        sysRoleService.saveOrUpdate(sysRole);
        return new Result<>().success();
    }

    // 根据用户的id来删除用户
    @ApiOperation(value = "数据根据id批量删除", notes = "数据根据id批量删除")
    @PostMapping("/delBatch")
    public Result delBatch(@RequestBody List<Integer> ids) {
        sysRoleService.removeByIds(ids);
        return new Result<>().success();
    }
    @GetMapping("/getByRoleId")
    public Result getById(@RequestParam("roleId") Integer roleId){
        LambdaQueryWrapper<SysRoleMenu> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysRoleMenu::getRoleId,roleId);

        List<SysMenu> objects = new ArrayList<>();
        List<SysRoleMenu> list = sysRoleMenuService.list(wrapper);
        list.forEach(item->{
            //拿到菜单id
            SysMenu byId = sysMenuService.getById(item.getMenuId());
            objects.add(byId);

        });
        return new Result<>().success(objects);
    }


    //将角色和菜单进行绑定

    @PostMapping("/saveRoleMenu")
    public Result saveRoleMenu(@Validated @RequestBody SysRoleMenuDTO sysRoleMenuDTO){

//        if(sysRoleMenuDTO!=null){
//
//        }
        LambdaQueryWrapper<SysRoleMenu> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysRoleMenu::getRoleId,sysRoleMenuDTO.getRoleId());
        List<SysRoleMenu> list = sysRoleMenuService.list(wrapper);
        list.forEach(item->{
          sysRoleMenuService.removeById(item.getId());
        });

        //插入数据之前先删除数据
        sysRoleMenuDTO.getMenuIdList().forEach(item->{
            SysRoleMenu sysRoleMenu = new SysRoleMenu();
            sysRoleMenu.setRoleId(sysRoleMenuDTO.getRoleId());
            sysRoleMenu.setMenuId(item);
            sysRoleMenuService.saveOrUpdate(sysRoleMenu);
        });
        return new Result<>().success();
    }

}
