package com.example.service;

import com.example.entity.Result;
import com.example.entity.wechat.menu.ConditionalMenuDto;
import com.example.entity.wechat.menu.MenuDto;

import java.io.IOException;

/**
 * 封装微信菜单接口
 * Created by cc on 17-4-14.
 */
public interface WXMenuService {

    /** 查询菜单 */
    Result getMenu(String token) throws IOException;

    /** 创建菜单 */
    Result addMenu(String token, MenuDto menuDto) throws IOException;

    /** 删除菜单 */
    Result delMenu(String token) throws IOException;

    /** 创建个性菜单 */
    Result addConditionalMenu(String token, ConditionalMenuDto conditionalMenuDto) throws IOException;

    /** 删除个性菜单 */
    Result delConditionalMenu(String token, String menuid) throws IOException;

    /** 测试个性化菜单匹配结果 */
    Result trymatchMenu(String token, String user_id) throws IOException;

    /** 获取自定义菜单配置 */
    Result getSelfMenu(String token) throws IOException;
}
