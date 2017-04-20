package com.example.controller;

import com.example.constants.WxParams;
import com.example.entity.Result;
import com.example.entity.wechat.share.SortUrlDto;
import com.example.entity.wechat.share.TicketDto;
import com.example.service.WXShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 推广接口封装（二维码）
 * Created by cc on 17-4-19.
 */
@RestController
@RequestMapping("share")
public class WXShareController {

    @Autowired
    private WXShareService wxShareService;

    /** 创建二维码ticket */
    @PostMapping("ticket/{appid}")
    public Result getTicket(@PathVariable String appid, @RequestBody TicketDto ticketDto, HttpServletRequest request) throws IOException {
        return wxShareService.getTicket((String)request.getAttribute(WxParams.ACCESS_TOKEN),ticketDto);
    }

    /** 长链接转短链接 */
    @PostMapping("sorturl/{appid}")
    public Result getSorturl(@PathVariable String appid, @RequestBody SortUrlDto sortUrlDto,HttpServletRequest request) throws IOException {
        return wxShareService.getSorturl((String)request.getAttribute(WxParams.ACCESS_TOKEN),sortUrlDto);
    }
    
}
