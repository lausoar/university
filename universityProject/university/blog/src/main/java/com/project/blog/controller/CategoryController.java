package com.project.blog.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project.blog.common.PageVO;
import com.project.blog.common.Result;
import com.project.blog.dto.CategoryDTO;
import com.project.blog.entity.Category;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(value = "栏目模块", tags = "栏目模块")
@RestController
@RequestMapping("/category")
public class CategoryController extends BaseController {

    @ApiOperation(value = "列表", notes = "测试xxxxxxx")
    @GetMapping("/list")
    public Result<List<Category>> list() {
        return new Result<>().success(categoryService.list());
    }

    @ApiOperation(value = "分页查询", notes = "分页查询")
    @PostMapping("/page")
    public Result<PageVO<Category>> findPage(@RequestBody CategoryDTO categoryDTO) {
        //查出的数据降序排列
        LambdaQueryWrapper<Category> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByDesc(Category::getId);

        //模糊查询
        if(categoryDTO.getTitle() !=null && !"".equals(categoryDTO.getTitle())){
            wrapper.like(Category::getTitle,categoryDTO.getTitle());
        }

        Page<Category> page = categoryService.page(
                new Page<>(
                        categoryDTO.getPageNum(),
                        categoryDTO.getPageSize()
                ),
                wrapper
        );
        return new Result<>().success(new PageVO<>(page));
    }

    //编辑 新增  id
    @ApiOperation(value = "数据保存或更新", notes = "数据保存或更新")
    @PostMapping("/save")
    public Result save(@Validated @RequestBody Category category) {
        categoryService.saveOrUpdate(category);
        return new Result<>().success();
    }

    // 根据用户的id来删除用户
    @ApiOperation(value = "数据根据id批量删除", notes = "数据根据id批量删除")
    @PostMapping("/delBatch")
    public Result delBatch(@RequestBody List<Integer> ids) {
        categoryService.removeByIds(ids);
        return new Result<>().success();
    }


}
