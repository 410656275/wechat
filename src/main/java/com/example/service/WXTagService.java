package com.example.service;

import com.example.entity.Result;
import com.example.entity.wechat.tag.TagDto;
import com.example.entity.wechat.tag.TagMenberDto;
import com.example.entity.wechat.tag.TagUserDto;

import java.io.IOException;

/**
 *
 * Created by cc on 2017/4/17 0017.
 */
public interface WXTagService {

    /** 查询标签列表 */
    Result getTags(String token) throws IOException;

    /** 删除标签 */
    Result delTags(String token, TagDto tag) throws IOException;

    /** 新建标签 */
    Result addTags(String token, TagDto tag) throws IOException;

    /** 修改标签 */
    Result updateTags(String token, TagDto tag) throws IOException;

    /** 获取标签下粉丝列表 */
    Result getUsersByTag(String token, TagUserDto tagUserDto) throws IOException;

    /** 批量为用户打标签 */
    Result addUsersByTag(String token, TagMenberDto tagMenberDto) throws IOException;

    /** 批量为用户取消标签 */
    Result delUsersByTag(String token, TagMenberDto tagMenberDto) throws IOException;
}
