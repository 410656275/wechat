package com.example.service;

import com.example.entity.Result;
import com.example.entity.wechat.user.RemarkDto;
import com.example.entity.wechat.user.UserInfoDto;

import java.io.IOException;

/**
 * 微信用户相关接口服务层
 * Created by cc on 2017/4/15 0015.
 */
public interface WXUserService {



    /** 获取用户身上的标签列表 */
    Result getTagsByUser(String token, String openid) throws IOException;

    /** 设置用户备注名 */
    Result setUserRemark(String token, RemarkDto remarkDto) throws IOException;

    /** 获取用户基本信息 */
    Result getUserInfo(String token, String openid) throws IOException;

    /** 批量获取用户基本信息 */
    Result getUserInfoList(String token, UserInfoDto userInfoDto) throws IOException;
}
