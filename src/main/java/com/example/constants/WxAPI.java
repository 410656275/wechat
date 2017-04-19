package com.example.constants;

/**
 * 微信api接口地址常量
 * Created by cc on 2017/4/17 0017.
 */
public class WxAPI {

    //token
    public final static String WECHAT_TOKEN="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    //普通菜单
    public static final String WECHAT_MENU_GET="https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
    public static final String WECHAT_MENU_ADD="https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
    public static final String WECHAT_MENU_DELETE="https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
    public static final String WECHAT_CONDITIONAL_MENU_SELF="https://api.weixin.qq.com/cgi-bin/get_current_selfmenu_info?access_token=ACCESS_TOKEN";

    //个性化菜单
    public static final String WECHAT_CONDITIONAL_MENU_ADD="https://api.weixin.qq.com/cgi-bin/menu/addconditional?access_token=ACCESS_TOKEN";
    public static final String WECHAT_CONDITIONAL_MENU_DEL="https://api.weixin.qq.com/cgi-bin/menu/delconditional?access_token=ACCESS_TOKEN";
    public static final String WECHAT_CONDITIONAL_MENU_TRYMATCH="https://api.weixin.qq.com/cgi-bin/menu/trymatch?access_token=ACCESS_TOKEN";


    //微信标签接口组
    public static final String WECHAT_TAG_GET="https://api.weixin.qq.com/cgi-bin/tags/get?access_token=ACCESS_TOKEN";
    public static final String WECHAT_TAG_DEL="https://api.weixin.qq.com/cgi-bin/tags/delete?access_token=ACCESS_TOKEN";
    public static final String WECHAT_TAG_ADD="https://api.weixin.qq.com/cgi-bin/tags/create?access_token=ACCESS_TOKEN";
    public static final String WECHAT_TAG_UPDATE="https://api.weixin.qq.com/cgi-bin/tags/update?access_token=ACCESS_TOKEN";

    //微信标签用户接口组
    public static final String WECHAT_TAG_USER_GET="https://api.weixin.qq.com/cgi-bin/user/tag/get?access_token=ACCESS_TOKEN";
    public static final String WECHAT_TAG_USER_ADD="https://api.weixin.qq.com/cgi-bin/tags/members/batchtagging?access_token=ACCESS_TOKEN";
    public static final String WECHAT_TAG_USER_DEL="https://api.weixin.qq.com/cgi-bin/tags/members/batchuntagging?access_token=ACCESS_TOKEN";
    public static final String WECHAT_USER_TAG_GET="https://api.weixin.qq.com/cgi-bin/tags/getidlist?access_token=ACCESS_TOKEN";

    //微信用户相关接口
    public static final String WECHAT_USER_REMARK="https://api.weixin.qq.com/cgi-bin/user/info/updateremark?access_token=ACCESS_TOKEN";
    public static final String WECHAT_USER_INFO="https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
    public static final String WECHAT_USER_INFO_LIST="https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=ACCESS_TOKEN";
    public static final String WECHAT_USER_LIST="https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID";

    //微信黑名单相关接口
    public static final String WECHAT_BLACK_USER_LIST="https://api.weixin.qq.com/cgi-bin/tags/members/getblacklist?access_token=ACCESS_TOKEN";
    public static final String WECHAT_BLACK_USER_ADD="https://api.weixin.qq.com/cgi-bin/tags/members/batchblacklist?access_token=ACCESS_TOKEN";
    public static final String WECHAT_BLACK_USER_DEL="https://api.weixin.qq.com/cgi-bin/tags/members/batchunblacklist?access_token=ACCESS_TOKEN";

    //微信推广相关接口
    public static final String WECHAT_SHARE_QRCODE="https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=ACCESS_TOKEN";
    public static final String WECHAT_SHARE_SHOW_QRCODE="https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";




}
