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
    public static final String WECHAT_SHARE_SORT_URL="https://api.weixin.qq.com/cgi-bin/shorturl?access_token=ACCESS_TOKEN";

    //微信数据统计
        //用户分析数据接口
    public static final String WECHAT_STATISTICS_USER_SUMMARY="https://api.weixin.qq.com/datacube/getusersummary?access_token=ACCESS_TOKEN";//获取用户增减数据  7
    public static final String WECHAT_STATISTICS_USER_CUMULATE="https://api.weixin.qq.com/datacube/getusercumulate?access_token=ACCESS_TOKEN";//获取累计用户数据  7

        //图文分析数据接口
    public static final String WECHAT_STATISTICS_ARTICLES_SUMMARY="https://api.weixin.qq.com/datacube/getarticlesummary?access_token=ACCESS_TOKEN";//获取图文群发每日数据  1
    public static final String WECHAT_STATISTICS_ARTICLES_TOTAL="https://api.weixin.qq.com/datacube/getarticletotal?access_token=ACCESS_TOKEN";//获取图文群发总数据  1
    public static final String WECHAT_STATISTICS_ARTICLES_READ="https://api.weixin.qq.com/datacube/getuserread?access_token=ACCESS_TOKEN";//获取图文统计数据  3
    public static final String WECHAT_STATISTICS_ARTICLES_READ_HOUR="https://api.weixin.qq.com/datacube/getuserreadhour?access_token=ACCESS_TOKEN";//获取图文统计分时数据  1
    public static final String WECHAT_STATISTICS_ARTICLES_SHARE="https://api.weixin.qq.com/datacube/getusershare?access_token=ACCESS_TOKEN";//获取图文分享转发数据  7
    public static final String WECHAT_STATISTICS_ARTICLES_SHARE_HOUR="https://api.weixin.qq.com/datacube/getusersharehour?access_token=ACCESS_TOKEN";//获取图文分享转发分时数据  1


        //消息分析数据接口
    public static final String WECHAT_STATISTICS_MSG="https://api.weixin.qq.com/datacube/getupstreammsg?access_token=ACCESS_TOKEN";//获取消息发送概况数据 7
    public static final String WECHAT_STATISTICS_MSG_HOUR="https://api.weixin.qq.com/datacube/getupstreammsghour?access_token=ACCESS_TOKEN";//获取消息分送分时数据 1
    public static final String WECHAT_STATISTICS_MSG_WEEK="https://api.weixin.qq.com/datacube/getupstreammsgweek?access_token=ACCESS_TOKEN";//获取消息发送周数据 30
    public static final String WECHAT_STATISTICS_MSG_MONTH="https://api.weixin.qq.com/datacube/getupstreammsgmonth?access_token=ACCESS_TOKEN";//获取消息发送月数据 30
    public static final String WECHAT_STATISTICS_MSG_DIST="https://api.weixin.qq.com/datacube/getupstreammsgdist?access_token=ACCESS_TOKEN";//获取消息发送分布数据 15
    public static final String WECHAT_STATISTICS_MSG_DIST_WEEK="https://api.weixin.qq.com/datacube/getupstreammsgdistweek?access_token=ACCESS_TOKEN";//获取消息发送分布周数据 30
    public static final String WECHAT_STATISTICS_MSG_DIST_MONTH="https://api.weixin.qq.com/datacube/getupstreammsgdistmonth?access_token=ACCESS_TOKEN";//获取消息发送分布月数据 30

        //接口分析数据接口
    public static final String WECHAT_STATISTICS_INTERFACE_SUMMARY="https://api.weixin.qq.com/datacube/getinterfacesummary?access_token=ACCESS_TOKEN";//获取接口分析数据 30
    public static final String WECHAT_STATISTICS_INTERFACE_SUMMARY_HOUR="https://api.weixin.qq.com/datacube/getinterfacesummaryhour?access_token=ACCESS_TOKEN";//获取接口分析分时数据 1





}
