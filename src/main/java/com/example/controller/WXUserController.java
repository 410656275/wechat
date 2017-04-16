package com.example.controller;

import com.example.constants.WxParams;
import com.example.entity.Result;
import com.example.entity.wechat.tag.TagDto;
import com.example.entity.wechat.tag.TagMenberDto;
import com.example.entity.wechat.tag.TagUserDto;
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

    /** 查询标签列表 */
    @GetMapping("tags/{appid}")
    public Result getTags(@PathVariable String appid, HttpServletRequest request) throws IOException {
        return wxUserService.getTags((String)request.getAttribute(WxParams.ACCESS_TOKEN));
    }
    /** 删除标签 */
    @DeleteMapping("tags/{appid}")
    public Result delTags(@PathVariable String appid, @RequestBody TagDto tag, HttpServletRequest request) throws IOException {
        return wxUserService.delTags((String)request.getAttribute(WxParams.ACCESS_TOKEN),tag);
    }
    /** 新建标签 */
    @PostMapping("tags/{appid}")
    public Result addTags(@PathVariable String appid, @RequestBody TagDto tag, HttpServletRequest request) throws IOException {
        return wxUserService.addTags((String)request.getAttribute(WxParams.ACCESS_TOKEN),tag);
    }
    /** 修改标签 */
    @PutMapping("tags/{appid}")
    public Result updateTags(@PathVariable String appid, @RequestBody TagDto tag, HttpServletRequest request) throws IOException {
        return wxUserService.updateTags((String)request.getAttribute(WxParams.ACCESS_TOKEN),tag);
    }

    /** 获取标签下粉丝列表 */
    @PostMapping("tags/users/{appid}")
    public Result getUsersByTag(@PathVariable String appid, @RequestBody TagUserDto tagUserDto, HttpServletRequest request) throws IOException {
        return wxUserService.getUsersByTag((String)request.getAttribute(WxParams.ACCESS_TOKEN),tagUserDto);
    }

    /** 批量为用户打标签 */
    @PostMapping("tags/members/{appid}")
    public Result addUsersByTag(@PathVariable String appid, @RequestBody TagMenberDto tagMenberDto, HttpServletRequest request) throws IOException {
        return wxUserService.addUsersByTag((String)request.getAttribute(WxParams.ACCESS_TOKEN),tagMenberDto);
    }








}
