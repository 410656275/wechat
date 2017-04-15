package com.example.controller;

import com.example.constants.WxParams;
import com.example.entity.Result;
import com.example.entity.wechat.menu.ConditionalMenuDto;
import com.example.entity.wechat.menu.MenuDto;
import com.example.service.WXMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 微信菜单接口封装
 * Created by cc on 17-4-14.
 */
@RestController
@RequestMapping("menu")
public class WXMenuController {

    @Autowired
    private WXMenuService wxMenuService;

    /** 查询所有菜单 */
    @GetMapping("{appid}")
    public Result getMenu(@PathVariable String appid, HttpServletRequest request) throws IOException {
        return wxMenuService.getMenu((String) request.getAttribute(WxParams.ACCESS_TOKEN));
    }

    /** 创建菜单 */
    @PostMapping("{appid}")
    public Result addMenu(@PathVariable String appid, @RequestBody MenuDto menuDto,HttpServletRequest request) throws IOException {
        return wxMenuService.addMenu((String) request.getAttribute(WxParams.ACCESS_TOKEN),menuDto);
    }

    /** 删除所有菜单 */
    @DeleteMapping("{appid}")
    public Result delMenu(@PathVariable String appid,HttpServletRequest request) throws IOException {
        return wxMenuService.delMenu((String) request.getAttribute(WxParams.ACCESS_TOKEN));
    }


    /** 创建个性化菜单 */
    @PostMapping("conditional/{appid}")
    public Result addConditionalMenu(@PathVariable String appid, @RequestBody ConditionalMenuDto conditionalMenuDto, HttpServletRequest request) throws IOException {
        return wxMenuService.addConditionalMenu((String) request.getAttribute(WxParams.ACCESS_TOKEN),conditionalMenuDto);
    }

    /** 删除个性化菜单 */
    @DeleteMapping("conditional/{appid}")
    public Result delConditionalMenu(@PathVariable String appid,@RequestBody String menuid, HttpServletRequest request) throws IOException {
        return wxMenuService.delConditionalMenu((String) request.getAttribute(WxParams.ACCESS_TOKEN),menuid);
    }

    /** 测试个性化菜单匹配结果 */
    @PostMapping("trymatch/{appid}")
    public Result trymatchMenu(@PathVariable String appid,@RequestBody String user_id,HttpServletRequest request) throws IOException {
        return wxMenuService.trymatchMenu((String) request.getAttribute(WxParams.ACCESS_TOKEN),user_id);
    }

    /** 获取自定义菜单配置 */
    @GetMapping("selfmenu/{appid}")
    public Result getSelfMenu(@PathVariable String appid,HttpServletRequest request) throws IOException {
        return wxMenuService.getSelfMenu((String) request.getAttribute(WxParams.ACCESS_TOKEN));
    }

}
