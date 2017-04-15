package com.example.entity.wechat.message;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Data;

import java.io.Serializable;

/**
 * 消息发送对象
 * Created by vobile on 16-6-7.
 */
@Data
public class MessageDto implements Serializable {
    private String touser;
    private String msgtype;
    private TextMessage text;
    private ImageMessage image;
    private VoiceMessage voice;
    private VideoMessage video;
    private MusicMessage music;
    private NewsMessage news;
    private MpnewsMessage mpnews;
    private WxcardMessage wxcard;

    public String toGson(){
        Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
        return gson.toJson(this);
    }

}
