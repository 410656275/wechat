/**   
* @Title: VideoMessage.java 
* @Package tv.stardream.sendMessage.entity 
* @Description: TODO(用一句话描述该文件做什么) 
* @author lyt
* @date 2013-12-16 下午3:14:05  
*/
package com.example.entity.wechat.message;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: 视频消息
 * @Description: TODO(这里用一句话描述这个类的作用)
 */
@Data
public class VideoMessage implements Serializable {
    private String media_id;
    private String title;
    private String description;
    
}
