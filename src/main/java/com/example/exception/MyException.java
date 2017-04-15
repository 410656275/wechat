package com.example.exception;


import com.example.constants.WxErrorCode;
import lombok.Data;

/**
 * Created by cc on 17-4-12.
 */
@Data
public class MyException extends RuntimeException{

    private int code;
    private String data;

    public MyException(WxErrorCode wxErrorCode) {
        super(wxErrorCode.getMsg());
        this.code = wxErrorCode.getCode();
        this.data = null;
    }

    public MyException(WxErrorCode wxErrorCode,String data){
        super(wxErrorCode.getMsg());
        this.code = wxErrorCode.getCode();
        this.data = data;
    }
}
