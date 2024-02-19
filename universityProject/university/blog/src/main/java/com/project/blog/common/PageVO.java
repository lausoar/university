package com.project.blog.common;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.util.List;

@Data
public class PageVO<T> {
    List<T> list;
    long total;

    public PageVO(Page<T> page){
        this.setList(page.getRecords());
        this.setTotal(page.getTotal());
    }

}
