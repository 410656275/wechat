package com.example.utils;

import com.example.constants.WxErrorCode;
import com.example.constants.WxParams;
import com.example.entity.Result;
import com.example.exception.MyException;
import net.sf.json.JSONObject;

import java.io.IOException;

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

    /** 微信get请求封装 */
    public static Result doGet(String url, String token, String tags,WxErrorCode wxErrorCode) throws IOException {
        String result = HttpUtils.httpGet(url.replace(WxParams.URL_ACCESS_TOKEN, token));
        return checkResult(tags,true,result,wxErrorCode);

    }

//    /** 微信get请求封装 */
//    public static Result doGet(String url, String token, String tags,WxErrorCode wxErrorCode,boolean returnParams) throws IOException {
//        String result = HttpUtils.httpGet(url.replace(WxParams.URL_ACCESS_TOKEN, token));
//        return checkResult(tags,returnParams,result,wxErrorCode);
//    }

    /**
     *  微信get请求封装
     * @param url
     * @param token
     * @param params
     * @param tags
     * @param wxErrorCode
     * @param returnParams 是否返回微信接口数据  true：是 fales：否
     * @return
     * @throws IOException
     */
    public static Result doPost(String url, String token,String params, String tags,WxErrorCode wxErrorCode,boolean returnParams) throws IOException {
        String result = HttpUtils.httpPost(url.replace(WxParams.URL_ACCESS_TOKEN, token),params);
        return checkResult(tags,returnParams,result,wxErrorCode);
    }


    private static Result checkResult(String tags, boolean returnParams, String result, WxErrorCode wxErrorCode) {
        if (result.contains(tags)){
            if (returnParams){
                return ResultUtil.success(JSONObject.fromObject(result));
            }else{
                return new Result();
            }
        }else {
            throw new MyException(wxErrorCode, result);
        }
    }



}
