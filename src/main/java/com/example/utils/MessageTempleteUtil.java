package com.example.utils;

import com.example.constants.WechatConstants;
import com.example.entity.gateway.MsgPo;
import com.example.entity.gateway.Item;

/**
 * 生成被动消息回复的模板
 * Created by cc on 17-2-13.
 */
public class MessageTempleteUtil {

    public static String createMessage(String fromUserName, String toUserName, MsgPo msgPo){
        Long createTime = System.currentTimeMillis();
        String msgType = msgPo.getMsgType();

        StringBuilder str = new StringBuilder();
        str.append("<xml>");
        str.append("<ToUserName><![CDATA[").append(fromUserName).append("]]></ToUserName>");
        str.append("<FromUserName><![CDATA[").append(toUserName).append("]]></FromUserName>");
        str.append("<CreateTime>").append(createTime).append("</CreateTime>");
        str.append("<MsgType><![CDATA[").append(msgType).append("]]></MsgType>");

        switch (msgType){
            //文本回复
            case WechatConstants.MSG_TYPE_TEXT:
                str.append("<Content><![CDATA[").append(msgPo.getContent()).append("]]></Content>");
                break;
            //图片回复
            case WechatConstants.MSG_TYPE_IMAGE:
                str.append("<Image><MediaId><![CDATA[").append(msgPo.getMediaId()).append("]]></MediaId></Image>");
                break;
            //语音回复
            case WechatConstants.MSG_TYPE_VOICE:
                str.append("<Voice><MediaId><![CDATA[").append(msgPo.getMediaId()).append("]]></MediaId></Voice>");
                break;
            //视频消息
            case WechatConstants.MSG_TYPE_VIDEO:
                str.append("<Video>");
                str.append("<MediaId><![CDATA[").append(msgPo.getMediaId()).append("]]></MediaId>");
                str.append("<Title><![CDATA[").append(msgPo.getTitle()).append("]]></Title>");
                str.append("<Description><![CDATA[").append(msgPo.getDescription()).append("]]></Description>");
                str.append("</Video>");
                break;
            //音乐消息
            case WechatConstants.MSG_TYPE_MUSIC:
                str.append("<Music>");
                str.append("<Title><![CDATA[").append(msgPo.getTitle()).append("]]></Title>");
                str.append("<Description><![CDATA[").append(msgPo.getDescription()).append("]]></Description>");
                str.append("<MusicUrl><![CDATA[").append(msgPo.getMusicUrl()).append("]]></MusicUrl>");
                str.append("<HQMusicUrl><![CDATA[").append(msgPo.getHQMusicUrl()).append("]]></HQMusicUrl>");
                str.append("<ThumbMediaId><![CDATA[").append(msgPo.getThumbMediaId()).append("]]></ThumbMediaId>");
                str.append("</Music>");
                break;
            //图文消息
            case WechatConstants.MSG_TYPE_NEWS:
                int num = msgPo.getItems().size();
                str.append("<ArticleCount><![CDATA[").append(num).append("]]></ArticleCount>");
                str.append("<Articles>");
                for(int i=0; i< num; i++){
                    Item item = msgPo.getItems().get(i);
                    str.append("<item>");
                    str.append("<Title><![CDATA[").append(item.getTitle()).append("]]></Title>");
                    str.append("<Description><![CDATA[").append(item.getDescription()).append("]]></Description>");
                    str.append("<PicUrl><![CDATA[").append(item.getPicUrl()).append("]]></PicUrl>");
                    str.append("<Url><![CDATA[").append(item.getUrl()).append("]]></Url>");
                    str.append("</item>");
                }
                str.append("</Articles>");
                break;
        }
        str.append("</xml>");
        return str.toString();
    }



}
