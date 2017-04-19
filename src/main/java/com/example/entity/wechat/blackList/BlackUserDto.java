package com.example.entity.wechat.blackList;

import com.example.entity.CommonDto;

import java.io.Serializable;
import java.util.List;

/**
 *
 * Created by cc on 17-4-19.
 */
public class BlackUserDto extends CommonDto implements Serializable{
    private List<String> openid_list;
}
