package com.example.utils;

import com.example.constants.WxErrorCode;
import com.example.entity.Result;

/**
 * Created by cc on 17-4-12.
 *
 */
public class ResultUtil {


    /**
     * 成功带参数的返回
     * @param obj
     * @return
     */
    public static Result success(Object obj){
        Result result = new Result();
        result.setData(obj);
        return result;
    }

    /**
     * 成功带参数的返回
     * @return
     */
    public static Result success(WxErrorCode errorCode,Object obj){
        Result result = new Result();
        result.setCode(errorCode.getCode());
        result.setMsg(errorCode.getMsg());
        result.setData(obj);
        return result;
    }


    /**
     * 失败返回
     * @return
     */
    public static Result error(int code, String msg,String data){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    /**
     * 失败返回带详细信息
     * @return
     */
    public static Result error(WxErrorCode errorCode){
        Result result = new Result();
        result.setCode(errorCode.getCode());
        result.setMsg(errorCode.getMsg());
        return result;
    }


}
