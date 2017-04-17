package com.example.entity.wechat.user;

import com.example.entity.CommonDto;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 *
 * Created by cc on 2017/4/17 0017.
 */
@Data
public class UserInfoDto extends CommonDto implements Serializable{
    private List<UserList> user_list;
}
