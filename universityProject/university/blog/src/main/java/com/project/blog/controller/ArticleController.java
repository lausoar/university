package com.project.blog.controller;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project.blog.common.PageVO;
import com.project.blog.common.Result;
import com.project.blog.dto.ArticleDTO;
import com.project.blog.dto.SysUserDTO;
import com.project.blog.entity.Article;
import com.project.blog.entity.Category;
import com.project.blog.entity.SysUser;
import com.project.blog.enums.RoleType;
import com.project.blog.enums.StatusType;
import com.project.blog.utils.UserThreadLocal;
import com.project.blog.vo.ArticleDetailVO;
import com.project.blog.vo.ArticleVO;
import com.project.blog.vo.SysUserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(value = "文章模块", tags = "文章模块")
@RestController
@RequestMapping("/article")
public class ArticleController extends BaseController {

    @ApiOperation(value = "列表", notes = "测试xxxxxxx")
    @GetMapping("/list")
    public List<Article> list() {
        return articleService.list();
    }


    @ApiOperation(value = "前端分页查询", notes = "前端分页查询")
    @PostMapping("/uPage")
    public Result<PageVO<Article>> uPage(@RequestBody ArticleDTO articleDTO) {
        //查出的数据降序排列
        LambdaQueryWrapper<Article> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByDesc(Article::getId);
        wrapper.eq(Article::getStatus, StatusType.Yes);
        //模糊查询
        if (articleDTO.getTitle() != null && !"".equals(articleDTO.getTitle())) {
            wrapper.like(Article::getTitle, articleDTO.getTitle());
        }
        Page<Article> page = articleService.page(
                new Page<>(
                        articleDTO.getPageNum(),
                        articleDTO.getPageSize()
                ),
                wrapper
        );
        return new Result<>().success(new PageVO<>(page));
    }

    @ApiOperation(value = "文章详情", notes = "文章详情")
    @GetMapping("/uDetail")
    public Result<Article> findPage(@RequestParam("id") Integer id) {

        Article article = articleService.getById(id);

        if (article == null) {
            return new Result<>().error("该条数据没有找到");
        }
        if (StatusType.No.equals(article.getStatus())) {
            return new Result<>().error("该条数据已被禁用");
        }
        //浏览量+1
        article.setViews(article.getViews() + 1);
        articleService.saveOrUpdate(article);

        ArticleDetailVO articleDetailVO = new ArticleDetailVO();
        BeanUtil.copyProperties(article, articleDetailVO);

        //获取栏目
        if (articleDetailVO.getCategoryId() != null) {
            //查询的第一种方法
//            //查询到了
//            LambdaQueryWrapper<Category> wrapper = new LambdaQueryWrapper<>();
//            wrapper.eq(Category::getId,articleDetailVO.getCategoryId())
//                    .last("limit 1");
//            Category serviceOne = categoryService.getOne(wrapper);

            Category category = categoryService.getById(articleDetailVO.getCategoryId());
            if (category != null) {
                articleDetailVO.setCategoryText(category.getTitle());
            } else {
                //没有查询到
                articleDetailVO.setCategoryText("未知栏目");
            }

        } else {
            //没有查询到
            articleDetailVO.setCategoryText("未知栏目");
        }

        //获取用户信息
        SysUser sysUser = sysUserService.getById(articleDetailVO.getCreateUserId());
        if (sysUser != null) {
            SysUserVO sysUserVO = new SysUserVO();
            BeanUtil.copyProperties(sysUser, sysUserVO);

            articleDetailVO.setSysUserVO(sysUserVO);
        } else {
            //没有查询到
            SysUserVO sysUserVO = new SysUserVO();
            sysUserVO.setUsername("未知用户");

            articleDetailVO.setSysUserVO(sysUserVO);
        }
        return new Result<>().success(articleDetailVO);
    }


    @ApiOperation(value = "分页查询", notes = "分页查询")
    @PostMapping("/page")
    public Result<PageVO<Article>> findPage(@RequestBody ArticleDTO articleDTO) {
        //查出的数据降序排列
        LambdaQueryWrapper<Article> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByDesc(Article::getStatus);
        wrapper.orderByDesc(Article::getId);

        //模糊查询
        if (articleDTO.getTitle() != null && !"".equals(articleDTO.getTitle())) {
            wrapper.like(Article::getTitle, articleDTO.getTitle());
        }
        SysUserDTO currentUser = UserThreadLocal.getCurrentUser();

        if (currentUser != null) {
            //普通用户只能看到自己
            if (!RoleType.ROLE_ADMIN.equals(currentUser.getRoleType())) {
                wrapper.eq(Article::getCreateUserId, currentUser.getId());
            }
        }

        Page<Article> page = articleService.page(
                new Page<>(
                        articleDTO.getPageNum(),
                        articleDTO.getPageSize()
                ),
                wrapper
        );

        Page<ArticleVO> voPage = new Page<>();

        List<Article> records = page.getRecords();
        List<ArticleVO> voList = new ArrayList<>();
        BeanUtil.copyProperties(page, voPage);
        records.forEach(item -> {
            ArticleVO articleVO = new ArticleVO();
            BeanUtil.copyProperties(item, articleVO);

            Category category = categoryService.getById(articleVO.getCategoryId());
            if (category != null) {
                articleVO.setCategoryName(category.getTitle());
            } else {
                articleVO.setCategoryName("未知栏目");
            }

            SysUser createUser = sysUserService.getById(articleVO.getCreateUserId());
            SysUser updateUser = sysUserService.getById(articleVO.getUpdateUserId());
            if (createUser != null) {
                articleVO.setCreateUsername(createUser.getUsername());
            } else {
                articleVO.setCreateUsername("未知用户");
            }
            if (updateUser != null) {
                articleVO.setUpdateUsername(updateUser.getUsername());
            } else {
                articleVO.setUpdateUsername("未知用户");
            }
            voList.add(articleVO);

        });
        voPage.setRecords(voList);


        if (currentUser != null) {
            return new Result<>().success(new PageVO<>(voPage));
        } else {
            return new Result<>().success();

        }

    }

    //编辑 新增  id
    @ApiOperation(value = "数据保存或更新", notes = "数据保存或更新")
    @PostMapping("/save")
    public Result save(@Validated @RequestBody Article article) {

        SysUserDTO currentUser = UserThreadLocal.getCurrentUser();




        if (article.getId() != null) {

            if (!RoleType.ROLE_ADMIN.equals(currentUser.getRoleType())) {
                Article byId = articleService.getById(article.getId());
                //解决非超级管理员自己修改浏览量的bug
                article.setViews(byId.getViews());
            }
            article.setUpdateUserId(currentUser.getId());
        } else {

            if (!RoleType.ROLE_ADMIN.equals(currentUser.getRoleType())) {
                //解决非超级管理员自己修改浏览量的bug
                article.setViews(0);
            }

            //新增
            article.setCreateUserId(currentUser.getId());
        }



        articleService.saveOrUpdate(article);
        return new Result<>().success();
    }

    // 根据用户的id来删除用户
    @ApiOperation(value = "数据根据id批量删除", notes = "数据根据id批量删除")
    @PostMapping("/delBatch")
    public Result delBatch(@RequestBody List<Integer> ids) {

        //获取当前用户信息
        SysUserDTO currentUser = UserThreadLocal.getCurrentUser();

        //判断当前用户是否是超级管理员
        if (RoleType.ROLE_ADMIN.equals(currentUser.getRoleType())) {
            articleService.removeByIds(ids);
        } else {
            //非超级管理员
            for (Integer id : ids) {
                LambdaQueryWrapper<Article> wrapper = new LambdaQueryWrapper<>();
                //通过文章id查询该数据是否存在
                wrapper.eq(Article::getId, id)
                        //是否是本人删除这条数据
                        .eq(Article::getCreateUserId, currentUser.getId())
                        //只查询出一条数据
                        .last("limit 1");
                Article article = articleService.getOne(wrapper);
                if (article != null) {
                    articleService.removeById(id);
                }
            }
        }

        return new Result<>().success();
    }
}
