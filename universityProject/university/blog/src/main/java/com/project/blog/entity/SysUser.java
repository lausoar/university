package com.project.blog.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.project.blog.enums.RoleType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@TableName("sys_user")
@ApiModel(value = "User对象", description = "用户信息表")
public class SysUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    //数据为""和" "和null的情况下会被拦截
    @NotBlank(message = "用户名不能为空")
//    @Length(min = 5,max = 50)
    @Length(min = 5,max = 50,message = "用户名长度需要在[5和50]之间")
    @ApiModelProperty("用户名")
    @TableField("username")
    private String username;

//    @NotBlank(message = "密码不能为空")
//    @Length(min = 8,max = 100,message = "密码需要在[8和100]之间")
    @ApiModelProperty("密码")
    @TableField("password")
    private String password;

    @ApiModelProperty("座右铭")
    @TableField("motto")
    private String motto;

    @ApiModelProperty("邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty("电话")
    @TableField("mobile")
    private String mobile;

    @ApiModelProperty("地址")
    @TableField("address")
    private String address;

    @ApiModelProperty("头像")
    @TableField("avatar_url")
    private String avatarUrl;

    @ApiModelProperty("角色类型")
    @TableField("role_type")
    private RoleType roleType;

    @ApiModelProperty("文章总浏览量")
    @TableField("views")
    private Integer views;

    @ApiModelProperty("加盐")
    @TableField("salt")
    private String salt;

}
