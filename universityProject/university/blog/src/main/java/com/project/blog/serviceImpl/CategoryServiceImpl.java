package com.project.blog.serviceImpl;

import com.project.blog.entity.Category;
import com.project.blog.mapper.CategoryMapper;
import com.project.blog.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}
