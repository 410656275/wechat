package com.example.service.impl;

import com.example.constants.WechatConstants;
import com.example.entity.gateway.MsgPo;
import com.example.service.WXResponseService;
import com.example.utils.MessageTempleteUtil;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

/**
 * Created by cc on 17-2-13.
 */
@Service
public class WXResponseServiceImpl implements WXResponseService {


    @Override
    public String textResponse(JSONObject json) {

        String fromUserName = json.getString(WechatConstants.FROM_USER_NAME);
        String toUserName = json.getString(WechatConstants.TO_USER_NAME);


        MsgPo msgPo = new MsgPo();

        //文字
        msgPo.setMsgType("text");
        msgPo.setContent("hello world");

//        //图片
//        msgPo.setMsgType("image");
//        msgPo.setMediaId("GXE6fWuKrAphr9BYzQI740yyGAG27GKAV16cOgOt4ZpAlOC7Awtn0FffOuXT0E3f");
//
//        //语音
//        msgPo.setMsgType("voice");

        String str = MessageTempleteUtil.createMessage(fromUserName,toUserName,msgPo);

        return str;
    }

    @Override
    public String locationResponse(JSONObject json) {
        return "error";
    }

    @Override
    public String linkResponse(JSONObject req) {
        return "error";
    }

    @Override
    public String imageResponse(JSONObject req) {
        return "error";
    }

    @Override
    public String voiceResponse(JSONObject req) {
        return "error";
    }

    @Override
    public String videoResponse(JSONObject req) {
        return "error";
    }

    @Override
    public String deviceEventResponse(JSONObject req) {
        return "error";
    }

    @Override
    public String subscribeResponse(JSONObject req) {
        return "error";
    }

    @Override
    public String unsubscribeResponse(JSONObject req) {
        return "error";
    }

    @Override
    public String scanResponse(JSONObject req) {
        return "error";
    }

    @Override
    public String clickResponse(JSONObject req) {
        return "error";
    }

    @Override
    public String viewResponse(JSONObject req) {
        return "error";
    }

    @Override
    public String scanCodePushResponse(JSONObject req) {
        return "error";
    }

    @Override
    public String scanCodeWaitMsgResponse(JSONObject req) {
        return "error";
    }

    @Override
    public String picSysPhotoResponse(JSONObject req) {
        return "error";
    }

    @Override
    public String picPhotoOrAlbumResponse(JSONObject req) {
        return "error";
    }

    @Override
    public String picWeiXinResponse(JSONObject req) {
        return "error";
    }

    @Override
    public String locationSelectResponse(JSONObject req) {
        return "error";
    }
}
