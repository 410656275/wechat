package com.example.service.impl;

import com.example.constants.WxAPI;
import com.example.constants.WxParams;
import com.example.entity.Result;
import com.example.entity.wechat.blackList.BlackUserDto;
import com.example.service.WXBlackUserService;
import com.example.utils.ResultUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 *
 * Created by cc on 17-4-19.
 */
@Service
public class WXBlackUserServiceImpl implements WXBlackUserService {

    @Override
    public Result getBlackUserList(String token, String begin_openid) throws IOException {
        return getBlackUserList(WxAPI.WECHAT_BLACK_USER_LIST,token,begin_openid);
    }

    @Override
    public Result addUserToBlackList(String token, BlackUserDto blackUserDto) throws IOException {
        return addUserToBlackList(WxAPI.WECHAT_BLACK_USER_ADD,token,blackUserDto.toGson());
    }

    @Override
    public Result delUserFromBlackList(String token, BlackUserDto blackUserDto) throws IOException {
        return delUserFromBlackList(WxAPI.WECHAT_BLACK_USER_DEL,token,blackUserDto.toGson());
    }


    /** 内部方法 */

    private Result getBlackUserList(String url, String token, String params) throws IOException {
        return ResultUtil.doPost(url,token,params, WxParams.TOTAL,true);
    }

    private Result addUserToBlackList(String url, String token, String params) throws IOException {
        return ResultUtil.doPost(url,token,params, WxParams.OK,false);
    }

    private Result delUserFromBlackList(String url, String token, String params) throws IOException {
        return ResultUtil.doPost(url,token,params, WxParams.OK,false);
    }
}
