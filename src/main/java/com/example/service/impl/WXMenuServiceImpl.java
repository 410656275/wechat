package com.example.service.impl;

import com.example.constants.WxErrorCode;
import com.example.constants.WxParams;
import com.example.entity.Result;
import com.example.entity.wechat.menu.ConditionalMenuDto;
import com.example.entity.wechat.menu.MenuDto;
import com.example.exception.MyException;
import com.example.service.WXMenuService;
import com.example.utils.HttpUtils;
import com.example.utils.ResultUtil;
import com.google.gson.Gson;
import net.sf.json.JSONObject;
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
        String result = HttpUtils.httpGet(WECHAT_MENU_GET.replace(WxParams.URL_ACCESS_TOKEN,token));
        if (result.contains(WxParams.MENU)){
            return ResultUtil.success(JSONObject.fromObject(result));
        }else {
            throw new MyException(WxErrorCode.WX_ERROR_MENU,result);
        }
    }

    @Override
    public Result addMenu(String token, MenuDto menuDto) throws IOException {
        String result = HttpUtils.httpPost(WECHAT_MENU_ADD.replace(WxParams.URL_ACCESS_TOKEN,token),menuDto.toGson());
        if (result.contains(WxParams.OK)){
            return new Result();
        }else {
            throw new MyException(WxErrorCode.WX_ERROR_MENU,result);
        }
    }

    @Override
    public Result delMenu(String token) throws IOException {
        String result = HttpUtils.httpGet(WECHAT_MENU_DELETE.replace(WxParams.URL_ACCESS_TOKEN,token));
        if (result.contains(WxParams.OK)){
            return new Result();
        }else {
            throw new MyException(WxErrorCode.WX_ERROR_MENU,result);
        }
    }

    @Override
    public Result addConditionalMenu(String token, ConditionalMenuDto conditionalMenuDto) throws IOException {
        String result = HttpUtils.httpPost(WECHAT_CONDITIONAL_MENU_ADD.replace(WxParams.URL_ACCESS_TOKEN,token),conditionalMenuDto.toGson());
        if (result.contains(WxParams.MENUID)){
            return ResultUtil.success(JSONObject.fromObject(result));
        }else {
            throw new MyException(WxErrorCode.WX_ERROR_MENU,result);
        }
    }

    @Override
    public Result delConditionalMenu(String token, String menuid) throws IOException {
        String result = HttpUtils.httpPost(WECHAT_CONDITIONAL_MENU_DEL.replace(WxParams.URL_ACCESS_TOKEN,token),menuid);
        if (result.contains(WxParams.OK)){
            return new Result();
        }else {
            throw new MyException(WxErrorCode.WX_ERROR_MENU,result);
        }
    }

    @Override
    public Result trymatchMenu(String token, String user_id) throws IOException {
        String result = HttpUtils.httpPost(WECHAT_CONDITIONAL_MENU_TRYMATCH.replace(WxParams.URL_ACCESS_TOKEN,token),user_id);
        if (result.contains(WxParams.BUTTON)){
            return ResultUtil.success(JSONObject.fromObject(result));
        }else {
            throw new MyException(WxErrorCode.WX_ERROR_MENU,result);
        }
    }

    @Override
    public Result getSelfMenu(String token) throws IOException {
        String result = HttpUtils.httpGet(WECHAT_CONDITIONAL_MENU_SELF.replace(WxParams.URL_ACCESS_TOKEN,token));
        if (result.contains(WxParams.IS_MENU_OPEN)){
            return ResultUtil.success(JSONObject.fromObject(result));
        }else {
            throw new MyException(WxErrorCode.WX_ERROR_MENU,result);
        }
    }
}
