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
@TableName("sys_role_menu")
@ApiModel(value = "SysRoleMenu对象", description = "角色菜单关系表")
public class SysRoleMenu extends BaseEntity {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty("角色id")
    @TableField("role_id")
    private Integer roleId;
    @ApiModelProperty("菜单id")
    @TableField("menu_id")
    private Integer menuId;


}
