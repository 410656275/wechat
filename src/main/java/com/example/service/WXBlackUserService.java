package com.example.service;

import com.example.entity.Result;
import com.example.entity.wechat.blackList.BlackUserDto;

import java.io.IOException;

/**
 * 黑名单用户管理
 * Created by cc on 17-4-19.
 */
public interface WXBlackUserService {

    /** 获取公众号的黑名单列表 */
    Result getBlackUserList(String token, String begin_openid) throws IOException;

    /** 拉黑用户 */
    Result addUserToBlackList(String token, BlackUserDto blackUserDto) throws IOException;

    /** 取消拉黑用户 */
    Result delUserFromBlackList(String token, BlackUserDto blackUserDto) throws IOException;

}
