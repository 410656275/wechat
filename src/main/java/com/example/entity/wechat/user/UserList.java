package com.example.entity.wechat.user;

import lombok.Data;

/**
 *
 * Created by cc on 2017/4/17 0017.
 */
@Data
public class UserList {
    private String openid;
    private String lang;

    public UserList() {
        this.lang = "zh_CN";
    }
}
