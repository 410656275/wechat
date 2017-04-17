package com.example.service.impl;

import com.example.constants.WxAPI;
import com.example.constants.WxParams;
import com.example.entity.Result;
import com.example.entity.wechat.tag.TagDto;
import com.example.entity.wechat.tag.TagMenberDto;
import com.example.entity.wechat.tag.TagUserDto;
import com.example.service.WXTagService;
import com.example.utils.ResultUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 *
 * Created by cc on 2017/4/17 0017.
 */
@Service
public class WXTagServiceImpl implements WXTagService{

    @Override
    public Result getTags(String token) throws IOException {
        return getTags(WxAPI.WECHAT_TAG_GET,token);
    }

    @Override
    public Result delTags(String token, TagDto tag) throws IOException {
        return delTags(WxAPI.WECHAT_TAG_DEL,token,tag.toGson());
    }

    @Override
    public Result addTags(String token, TagDto tag) throws IOException {
        return addTags(WxAPI.WECHAT_TAG_ADD,token,tag.toGson());
    }

    @Override
    public Result updateTags(String token, TagDto tag) throws IOException {
        return updateTags(WxAPI.WECHAT_TAG_UPDATE,token,tag.toGson());
    }

    @Override
    public Result getUsersByTag(String token, TagUserDto tagUserDto) throws IOException {
        return getUsersByTag(WxAPI.WECHAT_TAG_USER_GET,token,tagUserDto.toGson());
    }

    @Override
    public Result addUsersByTag(String token, TagMenberDto tagMenberDto) throws IOException {
        return addUsersByTag(WxAPI.WECHAT_TAG_USER_ADD,token,tagMenberDto.toGson());
    }

    @Override
    public Result delUsersByTag(String token, TagMenberDto tagMenberDto) throws IOException {
        return delUsersByTag(WxAPI.WECHAT_TAG_USER_DEL,token,tagMenberDto.toGson());
    }

    /** 内部方法 */

    private Result getTags(String url, String token) throws IOException {
        return ResultUtil.doGet(url,token,WxParams.TAGS);
    }

    private Result delTags(String url, String token, String params) throws IOException {
        return ResultUtil.doPost(url,token,params,WxParams.OK,false);
    }

    private Result addTags(String url, String token, String params) throws IOException {
        return ResultUtil.doPost(url,token,params,WxParams.ID,true);
    }

    private Result updateTags(String url, String token, String params) throws IOException {
        return ResultUtil.doPost(url,token,params,WxParams.OK,false);
    }

    private Result getUsersByTag(String url, String token, String params) throws IOException {
        return ResultUtil.doPost(url,token,params,WxParams.COUNT,true);
    }
    private Result addUsersByTag(String url, String token, String params) throws IOException {
        return ResultUtil.doPost(url,token,params,WxParams.OK,false);
    }

    private Result delUsersByTag(String url, String token, String params) throws IOException {
        return ResultUtil.doPost(url,token,params,WxParams.OK,false);
    }
}
