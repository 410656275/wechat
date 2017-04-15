package com.example.entity;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * Created by cc on 17-3-29.
 */
@Data
public class ResponseDto implements Serializable {
    private int code;
    private String msg;
    private int subCode;
    private String subMsg;
    private Object object;

    public ResponseDto() {
        code=0;
        msg ="success";
    }

}
