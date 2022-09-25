package com.cx.test.entity;

import lombok.Data;

@Data

public class ResultVO {

    private Integer code ;

    private String message;

    private Object data;

    public ResultVO(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResultVO(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ResultVO success(Object data){
        return new ResultVO(1,"success",data);
    }

    public static ResultVO fail(String message){
        return new ResultVO(0,"success");
    }
}
