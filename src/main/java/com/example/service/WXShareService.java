package com.example.service;

import com.example.entity.Result;
import com.example.entity.wechat.share.SortUrlDto;
import com.example.entity.wechat.share.TicketDto;

import java.io.IOException;

/**
 * 微信推广相关接口
 * Created by cc on 2017/4/19 0019.
 */
public interface WXShareService {

    /** 创建二维码ticket */
    Result getTicket(String token, TicketDto ticketDto) throws IOException;

    /** 长链接转短链接 */
    Result getSorturl(String token, SortUrlDto sortUrlDto) throws IOException;
}
