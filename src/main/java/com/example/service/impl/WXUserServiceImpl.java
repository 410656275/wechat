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
        return getTagsByUser(WxAPI.WECHAT_USER_TAG_GET,token,openid);
    }

    @Override
    public Result setUserRemark(String token, RemarkDto remarkDto) throws IOException {
        return setUserRemark(WxAPI.WECHAT_USER_REMARK,token,remarkDto.toGson());
    }

    @Override
    public Result getUserInfo(String token, String openid) throws IOException {
        String url = WxAPI.WECHAT_USER_INFO.replace(WxParams.URL_OPENID,openid);
        return getUserInfo(url,token,WxParams.SUBSCRIBE);
    }

    @Override
    public Result getUserInfoList(String token, UserInfoDto userInfoDto) throws IOException {
        return getUserInfoList(WxAPI.WECHAT_USER_INFO_LIST,token,userInfoDto.toGson());
    }

    @Override
    public Result getUserList(String token, String next_openid) throws IOException {
        String url = WxAPI.WECHAT_USER_LIST.replace(WxParams.NEXT_OPENID,next_openid);
        return getUserList(url,token,WxParams.TOTAL);
    }

    /** 内部方法 */


    private Result getTagsByUser(String url, String token, String params) throws IOException {
        return ResultUtil.doPost(url,token,params,WxParams.TAGID_LIST,true);
    }

    private Result setUserRemark(String url, String token, String params) throws IOException {
        return ResultUtil.doPost(url,token,params,WxParams.OK,false);
    }

    private Result getUserInfo(String url,String token,String tags) throws IOException {
        return ResultUtil.doGet(url,token,tags);
    }

    private Result getUserInfoList(String url, String token, String params) throws IOException {
        return ResultUtil.doPost(url,token,params,WxParams.USER_INFO_LIST,true);
    }

    private Result getUserList(String url,String token,String tags) throws IOException {
        return ResultUtil.doGet(url,token,tags);
    }



}
