package com.example.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by cc on 17-4-12.
 */
@Data
public class Result implements Serializable{
    private int code;
    private String msg;
    private Object data;

    public Result() {
        code=0;
        msg ="success";
    }
}
