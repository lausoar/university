package com.project.blog.dto;

import com.project.blog.enums.RoleType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SysUserDTO {


    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("角色类型")
    private RoleType roleType;

}
