package com.example.constants;

/**
 * 封装微信返回码
 * Created by cc on 17-4-5.
 */
public enum WxErrorCode {

    SUCCESS(0,"success"),
    SYS_ERROR(-1,"系统错误"),
    SYS_ERROR_PARAMS(2000,"输入参数不合法"),
    SYS_ERROR_PARAMS_APPID(20101,"appid不合法"),
    WX_ERROR_TOKEN(10001,"获取微信token错误"),
    WX_ERROR_GATEWAY(10002,"网关验证失败"),
    WX_ERROR_MENU(10003,"菜单接口调用失败"),


//    CACHE_TOKEN(1,"非缓存中获取token"),
//    WX_CATCH(10100,"微信接口异常"),
//    WX_ERROR_CODE(10200,"微信接口返回errcode"),
//    WX_ERROR_RESULT(10300,"微信接口返回参数异常"),
//    WX_ERROR_RESULT_NULL(10301,"微信接口返回参数为空"),
//
//    SYS_ERROR_PARAMS(20100,"参数不合法"),
//    SYS_ERROR_PARAMS_APPID(20101,"appid不合法"),
//    SYS_ERROR_PARAMS_LOSE(20102,"参数缺少"),
    ;


    WxErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
