package com.example.entity.gateway;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 微信被动回复对象
 * Created by cc on 17-3-29.
 */
@Data
public class MsgPo implements Serializable {
    private String msgType;
    private String content;
    private String mediaId;
    private String title;
    private String description;
    private String musicUrl;
    private String hQMusicUrl;
    private String thumbMediaId;
    private List<Item> items;

}
