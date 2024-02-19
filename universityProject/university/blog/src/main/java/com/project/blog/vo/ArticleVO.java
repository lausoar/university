package com.project.blog.vo;

import com.project.blog.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ArticleVO extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("文章内容")
    private String content;

    @ApiModelProperty("封面图")
    private String picture;

    @ApiModelProperty("所属栏目")
    private Integer categoryId;

    @ApiModelProperty("浏览量")
    private Integer views;

    @ApiModelProperty("所属栏目描述")
    private String categoryName;


    @ApiModelProperty("创建用户名称")
    private String createUsername;

    @ApiModelProperty("更新用户名称")
    private String updateUsername;

    @ApiModelProperty("发布用户")
    private Integer createUserId;

    @ApiModelProperty("更新用户")
    private Integer updateUserId;

}
