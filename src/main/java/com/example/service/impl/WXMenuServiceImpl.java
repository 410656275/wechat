package com.example.service.impl;

import com.example.constants.WxAPI;
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

    @Override
    public Result getMenu(String token) throws IOException {
        return getMenu(WxAPI.WECHAT_MENU_GET,token);
    }

    @Override
    public Result addMenu(String token, MenuDto menuDto) throws IOException {
        return addMenu(WxAPI.WECHAT_MENU_ADD,token,menuDto.toGson());
    }

    @Override
    public Result delMenu(String token) throws IOException {
        return delMenu(WxAPI.WECHAT_MENU_DELETE,token);
    }

    @Override
    public Result addConditionalMenu(String token, ConditionalMenuDto conditionalMenuDto) throws IOException {
        return addConditionalMenu(WxAPI.WECHAT_CONDITIONAL_MENU_ADD,token,conditionalMenuDto.toGson());
    }

    @Override
    public Result delConditionalMenu(String token, String menuid) throws IOException {
        return delConditionalMenu(WxAPI.WECHAT_CONDITIONAL_MENU_DEL,token,menuid);
    }

    @Override
    public Result trymatchMenu(String token, String user_id) throws IOException {
        return trymatchMenu(WxAPI.WECHAT_CONDITIONAL_MENU_TRYMATCH,token,user_id);
    }

    @Override
    public Result getSelfMenu(String token) throws IOException {
        return getSelfMenu(WxAPI.WECHAT_CONDITIONAL_MENU_SELF,token);
    }

    /** 内部方法 */
    private Result getMenu(String url, String token) throws IOException {
        return ResultUtil.doGet(url,token,WxParams.MENU);
    }

    private Result addMenu(String url, String token, String params) throws IOException {
        return ResultUtil.doPost(url,token,params,WxParams.OK,false);
    }

    private Result delMenu(String url, String token) throws IOException {
        return ResultUtil.doGet(url,token,WxParams.OK,false);
    }

    private Result addConditionalMenu(String url, String token, String params) throws IOException {
        return ResultUtil.doPost(url,token,params,WxParams.MENUID,true);
    }

    private Result delConditionalMenu(String url, String token, String params) throws IOException {
        return ResultUtil.doPost(url,token,params,WxParams.OK,false);
    }

    private Result trymatchMenu(String url, String token, String params) throws IOException {
        return ResultUtil.doPost(url,token,params,WxParams.BUTTON,true);
    }

    private Result getSelfMenu(String url, String token) throws IOException {
        return ResultUtil.doGet(url,token,WxParams.IS_MENU_OPEN);
    }
}
