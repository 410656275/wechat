/**   
* @Title: MusicMessage.java 
* @Package tv.stardream.sendMessage.entity 
* @Description: TODO(用一句话描述该文件做什么) 
* @author lyt
* @date 2013-12-16 下午3:15:27  
*/
package com.example.entity.wechat.message;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: 音乐消息
 * @Description: TODO(这里用一句话描述这个类的作用)
 */
@Data
public class MusicMessage implements Serializable {
    private String title;
    private String description;
    private String musicurl;
    private String hqmusicurl;
    private String thumb_media_id;
    
}
