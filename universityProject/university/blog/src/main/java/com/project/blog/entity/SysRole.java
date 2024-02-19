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
@TableName("sys_role")
@ApiModel(value = "SysRole对象", description = "角色表")
public class SysRole extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "角色名称不能为空")
    @ApiModelProperty("角色名称")
    @TableField("title")
    private String title;

    @NotBlank(message = "角色描述不能为空")
    @ApiModelProperty("角色描述")
    @TableField("description")
    private String description;

    @NotBlank(message = "角色标识不能为空")
    @ApiModelProperty("角色标识")
    @TableField("role")
    private String role;


}
