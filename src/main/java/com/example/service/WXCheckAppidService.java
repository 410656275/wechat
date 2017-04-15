package com.example.service;

import com.example.entity.table.Account;

/**
 * 校验微信appid是否有效
 * Created by cc on 17-4-13.
 */
public interface WXCheckAppidService {

    /**
     * 校验appid是否有效
     * @param appid
     * @return
     */
    Account check(String appid);

}
