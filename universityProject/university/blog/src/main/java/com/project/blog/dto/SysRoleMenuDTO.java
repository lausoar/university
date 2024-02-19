package com.project.blog.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;


@Data
public class SysRoleMenuDTO  {

//    @NotBlank(message = "角色id不能为空")
    @ApiModelProperty("角色id")
    private Integer roleId;
//    @NotBlank(message = "菜单id不能为空")
    @ApiModelProperty("菜单id列表")
    private List<Integer> menuIdList;


}
