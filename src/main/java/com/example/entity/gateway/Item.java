package com.example.entity.gateway;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: Item 
 * @author lyt
 * @date 2013-12-19 下午3:15:57 
 *  
 */
@Data
public class Item implements Serializable {
    private String title;//    Title    否   图文消息标题
    private String description;//    Description  否   图文消息描述
    private String picUrl;//    PicUrl   否   图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
    private String url;//    Url  否   点击图文消息跳转链接

}
