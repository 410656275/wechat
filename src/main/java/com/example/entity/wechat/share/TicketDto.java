package com.example.entity.wechat.share;

import com.example.entity.CommonDto;
import lombok.Data;

import java.io.Serializable;

/**
 *
 * Created by cc on 2017/4/19 0019.
 */
@Data
public class TicketDto extends CommonDto implements Serializable{

    private String action_name;
    private Long expire_seconds;//临时二维码用
    private ActionInfo action_info;

}
