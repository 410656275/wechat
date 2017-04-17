package com.example.service.impl;

import com.example.constants.WxAPI;
import com.example.constants.WxParams;
import com.example.entity.Result;
import com.example.entity.wechat.user.RemarkDto;
import com.example.entity.wechat.user.UserInfoDto;
import com.example.service.WXUserService;
import com.example.utils.HttpUtils;
import com.example.utils.ResultUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 *
 * Created by cc on 2017/4/15 0015.
 */
@Service
public class WXUserServiceImpl implements WXUserService{

    @Override
    public Result getTagsByUser(String token, String openid) throws IOException {
        return getTagsByUser(WxAPI.WECHAT_USER_TAG_GET,token,openid,WxParams.TAGID_LIST,true);
    }

    @Override
    public Result setUserRemark(String token, RemarkDto remarkDto) throws IOException {
        return setUserRemark(WxAPI.WECHAT_USER_REMARK,token,remarkDto.toGson(),WxParams.OK,false);
    }

    @Override
    public Result getUserInfo(String token, String openid) throws IOException {
        return getUserInfo(token,openid,true);
    }

    @Override
    public Result getUserInfoList(String token, UserInfoDto userInfoDto) throws IOException {
        return getUserInfoList(WxAPI.WECHAT_USER_INFO_LIST,token,userInfoDto.toGson(),WxParams.USER_INFO_LIST,true);
    }

    /** 内部方法 */


    private Result getTagsByUser(String url, String token, String params, String tags, boolean returnParams) throws IOException {
        return ResultUtil.doPost(url,token,params,tags,returnParams);
    }

    private Result setUserRemark(String url, String token, String params, String tags, boolean returnParams) throws IOException {
        return ResultUtil.doPost(url,token,params,tags,returnParams);
    }

    private Result getUserInfo(String token, String openid, boolean returnParams) throws IOException {
        String result = HttpUtils.httpGet(WxAPI.WECHAT_USER_INFO.replace(WxParams.URL_ACCESS_TOKEN, token).replace(WxParams.URL_OPENID,openid));
        return ResultUtil.checkResult(WxParams.SUBSCRIBE,returnParams,result);
    }

    private Result getUserInfoList(String url, String token, String params, String tags, boolean returnParams) throws IOException {
        return ResultUtil.doPost(url,token,params,tags,returnParams);
    }

}
