package com.example.service.impl;

import com.example.constants.WxAPI;
import com.example.constants.WxErrorCode;
import com.example.constants.WxParams;
import com.example.entity.Result;
import com.example.entity.wechat.share.TicketDto;
import com.example.redis.StringRedisDao;
import com.example.service.WXShareService;
import com.example.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 *
 * Created by cc on 2017/4/19 0019.
 */
@Service
public class WXShareServiceImpl implements WXShareService {

    @Autowired
    private StringRedisDao stringRedisDao;

    @Override
    public Result getTicket(String token, TicketDto ticketDto) throws IOException {
        return getTicket(WxAPI.WECHAT_SHARE_QRCODE,token,ticketDto);
    }

    private Result getTicket(String url, String token, TicketDto ticketDto) throws IOException {
        //1.换取ticket
        Result result =  ResultUtil.doPost(url,token,ticketDto.toGson(), WxParams.TICKET,true);

        if (result.getCode() == WxErrorCode.SUCCESS.getCode()){
            String type = ticketDto.getAction_name();
            String key;
            switch (type){
                case "QR_SCENE":
                    key = String.valueOf(ticketDto.getAction_info().getScene().getScene_id());
                    stringRedisDao.set(key, result.getData().toString(),ticketDto.getExpire_seconds(), TimeUnit.SECONDS);
                    break;
                case "QR_LIMIT_SCENE":
                    key = String.valueOf(ticketDto.getAction_info().getScene().getScene_id());
                    stringRedisDao.set(key, (String) result.getData());
                    break;
                case "QR_LIMIT_STR_SCENE":
                    key = ticketDto.getAction_info().getScene().getScene_str();
                    stringRedisDao.set(key, (String) result.getData());
                    break;
            }
        }
        return result;


    }
}
