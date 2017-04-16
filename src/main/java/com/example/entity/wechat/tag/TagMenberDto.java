package com.example.entity.wechat.tag;

import com.example.entity.CommonDto;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 *
 * Created by cc on 2017/4/15 0015.
 */
@Data
public class TagMenberDto extends CommonDto implements Serializable {
    private List<String> openid_list;
    private Integer tagid;
}
