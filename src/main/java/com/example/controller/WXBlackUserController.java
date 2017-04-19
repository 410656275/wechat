package com.example.controller;

import com.example.constants.WxParams;
import com.example.entity.Result;
import com.example.entity.wechat.blackList.BlackUserDto;
import com.example.service.WXBlackUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 微信黑名单用户管理
 * Created by cc on 17-4-19.
 */
@RestController
@RequestMapping("black")
public class WXBlackUserController {


    @Autowired
    private WXBlackUserService wxBlackUserService;

    /** 获取公众号的黑名单列表 */
    @PostMapping("{appid}")
    public Result getBlackUserList(@PathVariable String appid, @RequestBody String begin_openid, HttpServletRequest request) throws IOException {
        return wxBlackUserService.getBlackUserList((String)request.getAttribute(WxParams.ACCESS_TOKEN),begin_openid);
    }

    /** 拉黑用户 */
    @PutMapping("{appid}")
    public Result addUserToBlackList(@PathVariable String appid, @RequestBody BlackUserDto blackUserDto, HttpServletRequest request) throws IOException {
        return wxBlackUserService.addUserToBlackList((String)request.getAttribute(WxParams.ACCESS_TOKEN),blackUserDto);
    }

    /** 取消拉黑用户 */
    @DeleteMapping("{appid}")
    public Result delUserFromBlackList(@PathVariable String appid, @RequestBody BlackUserDto blackUserDto, HttpServletRequest request) throws IOException {
        return wxBlackUserService.delUserFromBlackList((String)request.getAttribute(WxParams.ACCESS_TOKEN),blackUserDto);
    }

}
