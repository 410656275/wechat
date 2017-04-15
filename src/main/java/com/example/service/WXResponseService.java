package com.example.service;

import net.sf.json.JSONObject;

/**
 * 微信消息类型处理
 * Created by cc on 17-2-13.
 */
public interface WXResponseService {

    /** 文本消息处理 */
    String textResponse(JSONObject json);

    /** 地理信息消息处理 */
    String locationResponse(JSONObject json);

    /** 链接信息消息处理 */
    String linkResponse(JSONObject req);

    /** 图片信息消息处理 */
    String imageResponse(JSONObject req);

    /** 音频信息消息处理 */
    String voiceResponse(JSONObject req);

    /** 视频信息消息处理 */
    String videoResponse(JSONObject req);

    /** 设备硬件消息处理 */
    String deviceEventResponse(JSONObject req);

    /** 关注事件处理 */
    String subscribeResponse(JSONObject req);

    /** 取消关注事件处理 */
    String unsubscribeResponse(JSONObject req);

    /** 扫码事件处理 */
    String scanResponse(JSONObject req);

    /** 点击菜单事件 */
    String clickResponse(JSONObject req);

    /** 点击菜单跳转链接 */
    String viewResponse(JSONObject req);

    /** 扫码推事件 */
    String scanCodePushResponse(JSONObject req);

    /** 扫码推事件且弹出“消息接收中”提示框 */
    String scanCodeWaitMsgResponse(JSONObject req);

    /** 弹出系统拍照发图 */
    String picSysPhotoResponse(JSONObject req);

    /** 弹出拍照或者相册发图 */
    String picPhotoOrAlbumResponse(JSONObject req);

    /** 弹出微信相册发图器 */
    String picWeiXinResponse(JSONObject req);

    /** 弹出地理位置选择器 */
    String locationSelectResponse(JSONObject req);
}
