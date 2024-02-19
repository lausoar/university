package com.project.blog.vo;

import com.project.blog.entity.SysMenu;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class SysUserLoginVO {

    @ApiModelProperty("id")

    private Integer id;
    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("座右铭")
    private String motto;

    @ApiModelProperty("头像")
    private String avatarUrl;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("电话")
    private String mobile;

    @ApiModelProperty("token认证")
    private String token;

    @ApiModelProperty("角色类型")
    private String roleType;

    @ApiModelProperty("菜单列表")
    private List<SysMenu> menuList;

}
