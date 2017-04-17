package com.example.entity.wechat.user;

import com.example.entity.CommonDto;
import lombok.Data;

import java.io.Serializable;

/**
 * 设置用户备注名对象
 * Created by cc on 2017/4/17 0017.
 */
@Data
public class RemarkDto extends CommonDto implements Serializable{

    private String openid;
    private String remark;


}
