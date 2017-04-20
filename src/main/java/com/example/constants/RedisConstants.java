package com.example.constants;

/**
 * redis key 常量
 * Created by cc on 17-4-5.
 */
public class RedisConstants {


    public static final String WECHAT = "wechat:";
    /** token存放key  string **/
    public static final String STRING_TOKEN = ":token";

    /** 临时二维码存放 */
    public static final String STRING_QRCODE_EXPIRE = ":qrcode:expire";

    /** 永久二维码存放 */
    public static final String STRING_QRCODE = ":qrcode";
}
