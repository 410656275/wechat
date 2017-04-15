package com.example.controller;

import com.example.constants.WxErrorCode;
import com.example.constants.WxParams;
import com.example.entity.Result;
import com.example.service.WXTokenService;
import com.example.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 微信token相关接口
 * Created by cc on 17-4-13.
 */
@RestController
@RequestMapping("tokens")
public class WXTokenController {

    @Autowired
    private WXTokenService wxTokenService;

    /** 通过appid获取token */
    @GetMapping("{appid}")
    public Result getAppid(@PathVariable String appid, HttpServletRequest request) throws IOException {
        return (Result) request.getAttribute(WxParams.ACCESS_TOKEN);
    }

    /** 刷新token */
    @GetMapping("{appid}/{secret}")
    public Result getAppidBySecret(@PathVariable String appid,@PathVariable String secret) throws IOException {
        return ResultUtil.success(wxTokenService.getTokenSecret(appid,secret));
    }

    /** 查询token有效时间 */
    @GetMapping("expires/{appid}")
    public Result getExpires(@PathVariable String appid){
        return wxTokenService.getExpires(appid);
    }



}
