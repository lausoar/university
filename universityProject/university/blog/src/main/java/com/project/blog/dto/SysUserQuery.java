package com.project.blog.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SysUserQuery extends PageInfo {

    @ApiModelProperty("用户名")
    private String username;

}
