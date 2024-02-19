package com.project.blog.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CategoryDTO extends PageInfo {

    @ApiModelProperty("标题")
    private String title;

}
