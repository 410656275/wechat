package com.example.entity.wechat.menu;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by vobile on 16-7-27.
 */
@Data
public class SubButton implements Serializable {
    private String type;
    private String name;
    private String key;
    private String url;
    private String appid;//miniprogram类型必须
    private String pagepath;//miniprogram类型必须


}
