package com.project.blog.serviceImpl;

import com.project.blog.entity.Article;
import com.project.blog.mapper.ArticleMapper;
import com.project.blog.service.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

}
