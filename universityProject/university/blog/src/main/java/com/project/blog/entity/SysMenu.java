package com.project.blog.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
@TableName("sys_menu")
@ApiModel(value = "SysMenu对象", description = "菜单表")
public class SysMenu extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "名称不能为空")
    @ApiModelProperty("名称")
    @TableField("title")
    private String title;

    @NotBlank(message = "路径不能为空")
    @ApiModelProperty("路径")
    @TableField("path")
    private String path;

    @NotBlank(message = "描述不能为空")
    @ApiModelProperty("描述")
    @TableField("description")
    private String description;

    @NotBlank(message = "页面路径不能为空")
    @ApiModelProperty("页面路径")
    @TableField("page_path")
    private String pagePath;


}
