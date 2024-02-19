package com.project.blog.exception;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException{

    private Integer code;
    public CustomException(Integer code,String msg){
        super(msg);
        this.code = code;
    }

    public CustomException(String msg){
        super(msg);
        this.code=500;
    }

}
