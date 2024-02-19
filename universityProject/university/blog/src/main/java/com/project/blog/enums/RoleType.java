package com.project.blog.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum RoleType {

    ROLE_ADMIN("ROLE_ADMIN", "超级管理员"),
    ROLE_USER("ROLE_USER", "普通用户");

    /**
     * 存到数据库的值
     */
    @EnumValue
    private String key;

    /**
     * 前端显示的值
     */
    @JsonValue
    private String name;


    RoleType(String key, String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }


}
