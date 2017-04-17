package com.example.service.impl;

import com.example.constants.WxParams;
import com.example.entity.Result;
import com.example.entity.wechat.menu.ConditionalMenuDto;
import com.example.entity.wechat.menu.MenuDto;
import com.example.service.WXMenuService;
import com.example.utils.ResultUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 *
 * Created by cc on 17-4-14.
 */
@Service
public class WXMenuServiceImpl implements WXMenuService{

    //普通菜单
    private static final String WECHAT_MENU_GET="https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
    private static final String WECHAT_MENU_ADD="https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
    private static final String WECHAT_MENU_DELETE="https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";

    //个性化菜单
    private static final String WECHAT_CONDITIONAL_MENU_ADD="https://api.weixin.qq.com/cgi-bin/menu/addconditional?access_token=ACCESS_TOKEN";
    private static final String WECHAT_CONDITIONAL_MENU_DEL="https://api.weixin.qq.com/cgi-bin/menu/delconditional?access_token=ACCESS_TOKEN";
    private static final String WECHAT_CONDITIONAL_MENU_TRYMATCH="https://api.weixin.qq.com/cgi-bin/menu/trymatch?access_token=ACCESS_TOKEN";

    private static final String WECHAT_CONDITIONAL_MENU_SELF="https://api.weixin.qq.com/cgi-bin/get_current_selfmenu_info?access_token=ACCESS_TOKEN";

    @Override
    public Result getMenu(String token) throws IOException {
        return getMenu(WECHAT_MENU_GET,token,WxParams.MENU);
    }

    @Override
    public Result addMenu(String token, MenuDto menuDto) throws IOException {
        return addMenu(WECHAT_MENU_ADD,token,menuDto.toGson(),WxParams.OK,false);
    }

    @Override
    public Result delMenu(String token) throws IOException {
        return delMenu(WECHAT_MENU_DELETE,token,WxParams.OK,false);
    }

    @Override
    public Result addConditionalMenu(String token, ConditionalMenuDto conditionalMenuDto) throws IOException {
        return addConditionalMenu(WECHAT_CONDITIONAL_MENU_ADD,token,conditionalMenuDto.toGson(),WxParams.MENUID,true);
    }

    @Override
    public Result delConditionalMenu(String token, String menuid) throws IOException {
        return delConditionalMenu(WECHAT_CONDITIONAL_MENU_DEL,token,menuid,WxParams.OK,false);
    }

    @Override
    public Result trymatchMenu(String token, String user_id) throws IOException {
        return trymatchMenu(WECHAT_CONDITIONAL_MENU_TRYMATCH,token,user_id,WxParams.BUTTON,true);
    }

    @Override
    public Result getSelfMenu(String token) throws IOException {
        return getSelfMenu(WECHAT_CONDITIONAL_MENU_SELF,token,WxParams.IS_MENU_OPEN);
    }

    /** 内部方法 */
    private Result getMenu(String url, String token, String tags) throws IOException {
        return ResultUtil.doGet(url,token,tags);
    }

    private Result addMenu(String url, String token, String params, String tags,boolean returnParams) throws IOException {
        return ResultUtil.doPost(url,token,params,tags,returnParams);
    }

    private Result delMenu(String url, String token, String tags,boolean returnParams) throws IOException {
        return ResultUtil.doGet(url,token,tags,returnParams);
    }

    private Result addConditionalMenu(String url, String token, String params, String tags,boolean returnParams) throws IOException {
        return ResultUtil.doPost(url,token,params,tags,returnParams);
    }

    private Result delConditionalMenu(String url, String token, String params, String tags,boolean returnParams) throws IOException {
        return ResultUtil.doPost(url,token,params,tags,returnParams);
    }

    private Result trymatchMenu(String url, String token, String params, String tags,boolean returnParams) throws IOException {
        return ResultUtil.doPost(url,token,params,tags,returnParams);
    }

    private Result getSelfMenu(String url, String token, String tags) throws IOException {
        return ResultUtil.doGet(url,token,tags);
    }
}
