/**   
* @Title: VoiceMessage.java 
* @Package tv.stardream.sendMessage.entity 
* @Description: TODO(用一句话描述该文件做什么) 
* @author lyt
* @date 2013-12-16 下午3:11:10  
*/
package com.example.entity.wechat.message;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: 音频消息
 * @Description: TODO(这里用一句话描述这个类的作用)
 */
@Data
public class VoiceMessage implements Serializable {
    private String media_id;

}
