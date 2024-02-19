package com.project.blog.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project.blog.common.PageVO;
import com.project.blog.common.Result;
import com.project.blog.dto.SysMenuDTO;
import com.project.blog.entity.SysMenu;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "菜单模块", tags = "菜单模块")
@RestController
@RequestMapping("/sysMenu")
public class SysMenuController extends BaseController {
    @ApiOperation(value = "列表", notes = "测试xxxxxxx")
    @GetMapping("/list")
    public Result<List<SysMenu>> list() {
        return new Result<>().success(sysMenuService.list());
    }

    @ApiOperation(value = "分页查询", notes = "分页查询")
    @PostMapping("/page")
    public Result<PageVO<SysMenu>> findPage(@RequestBody SysMenuDTO sysMenuDTO) {
        //查出的数据降序排列
        LambdaQueryWrapper<SysMenu> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByDesc(SysMenu::getStatus);
        wrapper.orderByDesc(SysMenu::getId);

        //模糊查询
        if(sysMenuDTO.getTitle() !=null && !"".equals(sysMenuDTO.getTitle())){
            wrapper.like(SysMenu::getTitle,sysMenuDTO.getTitle());
        }

        Page<SysMenu> page = sysMenuService.page(
                new Page<>(
                        sysMenuDTO.getPageNum(),
                        sysMenuDTO.getPageSize()
                ),
                wrapper
        );
        return new Result<>().success(new PageVO<>(page));
    }

    //编辑 新增  id
    @ApiOperation(value = "数据保存或更新", notes = "数据保存或更新")
    @PostMapping("/save")
    public Result save(@Validated @RequestBody SysMenu sysMenu) {
        sysMenuService.saveOrUpdate(sysMenu);
        return new Result<>().success();
    }

    // 根据用户的id来删除用户
    @ApiOperation(value = "数据根据id批量删除", notes = "数据根据id批量删除")
    @PostMapping("/delBatch")
    public Result delBatch(@RequestBody List<Integer> ids) {
        sysMenuService.removeByIds(ids);
        return new Result<>().success();
    }

}
