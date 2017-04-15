/**   
* @Title: Article.java 
* @Package tv.stardream.sendMessage.entity 
* @Description: TODO(用一句话描述该文件做什么) 
* @author lyt
* @date 2013-12-16 下午3:18:39  
*/
package com.example.entity.wechat.message;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: 图片
 * @Description: TODO(这里用一句话描述这个类的作用)
 */
@Data
public class Article implements Serializable {
    private String title;
    private String description;
    private String url;
    private String picurl;
    
}
