package com.example.service.impl;

import com.example.constants.WxErrorCode;
import com.example.constants.WxParams;
import com.example.entity.Result;
import com.example.entity.wechat.tag.TagDto;
import com.example.entity.wechat.tag.TagMenberDto;
import com.example.entity.wechat.tag.TagUserDto;
import com.example.service.WXUserService;
import com.example.utils.ResultUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 *
 * Created by cc on 2017/4/15 0015.
 */
@Service
public class WXUserServiceImpl implements WXUserService{

    //微信标签接口组
    private static final String WECHAT_TAG_GET="https://api.weixin.qq.com/cgi-bin/tags/get?access_token=ACCESS_TOKEN";
    private static final String WECHAT_TAG_DEL="https://api.weixin.qq.com/cgi-bin/tags/delete?access_token=ACCESS_TOKEN";
    private static final String WECHAT_TAG_ADD="https://api.weixin.qq.com/cgi-bin/tags/create?access_token=ACCESS_TOKEN";
    private static final String WECHAT_TAG_UPDATE="https://api.weixin.qq.com/cgi-bin/tags/update?access_token=ACCESS_TOKEN";

    //微信标签用户接口组
    private static final String WECHAT_TAG_USER_GET="https://api.weixin.qq.com/cgi-bin/user/tag/get?access_token=ACCESS_TOKEN";

    @Override
    public Result getTags(String token) throws IOException {
        return getTags(WECHAT_TAG_GET,token,WxParams.TAGS);
    }

    @Override
    public Result delTags(String token, TagDto tag) throws IOException {
        return delTags(WECHAT_TAG_DEL,token,tag.toGson(),WxParams.OK);
    }

    @Override
    public Result addTags(String token, TagDto tag) throws IOException {
        return addTags(WECHAT_TAG_ADD,token,tag.toGson(),WxParams.ID);
    }

    @Override
    public Result updateTags(String token, TagDto tag) throws IOException {
        return updateTags(WECHAT_TAG_UPDATE,token,tag.toGson(),WxParams.OK);
    }

    @Override
    public Result getUsersByTag(String token, TagUserDto tagUserDto) throws IOException {
        return getUsersByTag(WECHAT_TAG_USER_GET,token,tagUserDto.toGson(),WxParams.COUNT);
    }

    @Override
    public Result addUsersByTag(String token, TagMenberDto tagMenberDto) {
        return null;
    }

    /** 内部方法 */

    private Result getTags(String url, String token, String tags) throws IOException {
        return ResultUtil.doGet(url,token,tags,WxErrorCode.WX_ERROR_TAG);
    }

    private Result delTags(String url, String token, String params, String tags) throws IOException {
        return ResultUtil.doPost(url,token,params,tags,WxErrorCode.WX_ERROR_TAG,false);
    }

    private Result addTags(String url, String token, String params, String tags) throws IOException {
        return ResultUtil.doPost(url,token,params,tags,WxErrorCode.WX_ERROR_TAG,true);
    }

    private Result updateTags(String url, String token, String params, String tags) throws IOException {
        return ResultUtil.doPost(url,token,params,tags,WxErrorCode.WX_ERROR_TAG,false);
    }

    private Result getUsersByTag(String url, String token, String params, String tags) throws IOException {
        return ResultUtil.doPost(url,token,params,tags,WxErrorCode.WX_ERROR_TAG,true);
    }


}
