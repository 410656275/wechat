package com.example.service;

import com.example.entity.Result;

import java.io.IOException;

/**
 * 微信token操作相关服务封装
 * Created by cc on 17-4-13.
 */
public interface WXTokenService {


    /**
     * 直接获取token
     * @param appid
     * @param secret
     * @return
     */
    String getTokenSecret(String appid, String secret) throws IOException;

    /**
     * 检查缓存获取token
     * @param appid
     * @return
     */
    String getToken(String appid);

    /**
     * 查询token有效时间
     * @param appid
     * @return
     */
    Result getExpires(String appid);
}
