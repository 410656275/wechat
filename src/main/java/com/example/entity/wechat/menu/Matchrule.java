package com.example.entity.wechat.menu;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * Created by cc on 17-4-14.
 */
@Data
public class Matchrule implements Serializable {
    private String tag_id;
    private String sex;
    private String country;
    private String province;
    private String city;
    private String client_platform_type;
    private String language;
}
