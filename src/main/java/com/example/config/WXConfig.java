package com.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 微信相关配置参数
 * Created by cc on 17-2-13.
 */
@ConfigurationProperties(prefix = "wechat")
@Component
public class WXConfig {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
