package com.project.blog.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class SysUserVO {

    @ApiModelProperty("id")

    private Integer id;
    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("座右铭")
    private String motto;

    @ApiModelProperty("头像")
    private String avatarUrl;

    @ApiModelProperty("文章总浏览量")
    private Integer views;

}
