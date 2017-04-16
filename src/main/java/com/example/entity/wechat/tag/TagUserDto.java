package com.example.entity.wechat.tag;

import com.example.entity.CommonDto;
import lombok.Data;

import java.io.Serializable;

/**
 *
 * Created by cc on 2017/4/15 0015.
 */
@Data
public class TagUserDto extends CommonDto implements Serializable{
    private String tagid;
    private String next_openid;

}
