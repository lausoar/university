package com.project.blog.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PageInfo {

    /**
     * 页码
     */
    @ApiModelProperty("页码")
    private Integer pageNum;

    /**
     * 每页显示条数
     */
    @ApiModelProperty("每页显示条数")
    private Integer pageSize;

}
