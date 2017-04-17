package com.example.service.impl;

import com.example.constants.WechatConstants;
import com.example.service.WXGatewayService;
import com.example.service.WXResponseService;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.stereotype.Service;


/**
 * Created by cc on 17-2-13.
 */
@Service
public class WXGatewayServiceImpl implements WXGatewayService{

    private static final Logger logger = LoggerFactory.getLogger(WXGatewayServiceImpl.class);

    @Autowired
    WXResponseService wxResponseService;

    @Override
    public String getResp(JSONObject req) {

        String msgType = req.getString(WechatConstants.MSG_TYPE);

        switch(msgType){
            //文本信息处理
            case WechatConstants.MSG_TYPE_TEXT:
                return wxResponseService.textResponse(req);
            //地理信息
            case WechatConstants.MSG_TYPE_LOCATION:
                return wxResponseService.locationResponse(req);
            //链接信息
            case WechatConstants.MSG_TYPE_LINK:
                return wxResponseService.linkResponse(req);
            //图片信息
            case WechatConstants.MSG_TYPE_IMAGE:
                return wxResponseService.imageResponse(req);
            //音频信息
            case WechatConstants.MSG_TYPE_VOICE:
                return wxResponseService.voiceResponse(req);
            //视频信息
            case WechatConstants.MSG_TYPE_VIDEO:
                return wxResponseService.videoResponse(req);
            //设备硬件
            case WechatConstants.MSG_TYPE_DEVICE_EVENT:
                return wxResponseService.deviceEventResponse(req);
            //事件处理
            case WechatConstants.MSG_TYPE_EVENT:
                String event =req.getString(WechatConstants.MSG_NODE_EVENT);
                switch (event){
                    //关注事件
                    case WechatConstants.MSG_TYPE_SUBSCRIBE:
                        return wxResponseService.subscribeResponse(req);
                    //取消关注事件
                    case WechatConstants.MSG_TYPE_UNSUBSCRIBE:
                        return wxResponseService.unsubscribeResponse(req);
                    //扫码事件
                    case WechatConstants.MSG_TYPE_SCAN:
                        return wxResponseService.scanResponse(req);
                    //点击菜单
                    case WechatConstants.MSG_TYPE_CLICK:
                        return wxResponseService.clickResponse(req);
                    //点击菜单跳转链接
                    case WechatConstants.MSG_TYPE_VIEW:
                        return wxResponseService.viewResponse(req);
                    //扫码推事件
                    case WechatConstants.MSG_TYPE_SCANCODE_PUSH:
                        return wxResponseService.scanCodePushResponse(req);
                    //扫码推事件且弹出“消息接收中”提示框
                    case WechatConstants.MSG_TYPE_SCANCODE_WAITMSG:
                        return wxResponseService.scanCodeWaitMsgResponse(req);
                    //弹出系统拍照发图
                    case WechatConstants.MSG_TYPE_PIC_SYSPHOTO:
                        return wxResponseService.picSysPhotoResponse(req);
                    //弹出拍照或者相册发图
                    case WechatConstants.MSG_TYPE_PIC_PHOTO_OR_ALBUM:
                        return wxResponseService.picPhotoOrAlbumResponse(req);
                    //弹出微信相册发图器
                    case WechatConstants.MSG_TYPE_PIC_WEIXIN:
                        return wxResponseService.picWeiXinResponse(req);
                    //弹出地理位置选择器
                    case WechatConstants.MSG_TYPE_LOCATION_SELECT:
                        return wxResponseService.locationSelectResponse(req);
                    default:
                        logger.error("[微信网关消息处理][未识别事件类型][事件类型："+event+"]");
                        return "success";
                }

            //其他
            default:
                logger.error("【微信网关消息处理】【未识别消息类型】【消息类型："+msgType+"】");
                return "success";
        }

    }
}
