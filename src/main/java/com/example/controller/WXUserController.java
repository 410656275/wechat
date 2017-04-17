package com.example.controller;

import com.example.constants.WxParams;
import com.example.entity.Result;
import com.example.entity.wechat.user.RemarkDto;
import com.example.entity.wechat.user.UserInfoDto;
import com.example.service.WXUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 微信用户相关接口封装
 * Created by Administrator on 2017/4/15 0015.
 */
@RestController
public class WXUserController {

    @Autowired
    private WXUserService wxUserService;



    /** 获取用户身上的标签列表 */
    @PostMapping("users/tags/{appid}")
    public Result getTagsByUser(@PathVariable String appid, @RequestBody String openid, HttpServletRequest request) throws IOException {
        return wxUserService.getTagsByUser((String)request.getAttribute(WxParams.ACCESS_TOKEN),openid);
    }

    /** 设置用户备注名 */
    @PostMapping("users/remark/{appid}")
    public Result setUserRemark(@PathVariable String appid, @RequestBody RemarkDto remarkDto, HttpServletRequest request) throws IOException {
        return wxUserService.setUserRemark((String)request.getAttribute(WxParams.ACCESS_TOKEN),remarkDto);
    }

    /** 获取用户基本信息 */
    @GetMapping("users/{appid}/{openid}")
    public Result getUserInfo(@PathVariable String appid, @PathVariable String openid, HttpServletRequest request) throws IOException {
        return wxUserService.getUserInfo((String)request.getAttribute(WxParams.ACCESS_TOKEN),openid);
    }

    /** 批量获取用户基本信息 */
    @PostMapping("users/{appid}")
    public Result getUserInfoList(@PathVariable String appid, @PathVariable UserInfoDto userInfoDto, HttpServletRequest request) throws IOException {
        return wxUserService.getUserInfoList((String)request.getAttribute(WxParams.ACCESS_TOKEN),userInfoDto);
    }










}
