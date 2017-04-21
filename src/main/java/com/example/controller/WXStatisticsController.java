package com.example.controller;

import com.example.constants.WxParams;
import com.example.entity.Result;
import com.example.entity.wechat.statistics.StatisticsSearchDto;
import com.example.service.statistics.WXArticleStatisticsService;
import com.example.service.statistics.WXInterfaceStatisticsService;
import com.example.service.statistics.WXMsgStatisticsService;
import com.example.service.statistics.WXUserStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 微信数据统计接口封装
 * Created by cc on 17-4-20.
 */
@RestController
@RequestMapping("statistics")
public class WXStatisticsController {

    @Autowired private WXUserStatisticsService wxUserStatisticsService;
    @Autowired private WXArticleStatisticsService wxArticleStatisticsService;
    @Autowired private WXMsgStatisticsService wxMsgStatisticsService;
    @Autowired private WXInterfaceStatisticsService wxInterfaceStatisticsService;

    /** 获取用户增减数据 */
    @PostMapping("user/summary/{appid}")
    public Result getUserSummary(@PathVariable String appid, @RequestBody StatisticsSearchDto statisticsSearchDto, HttpServletRequest request) throws IOException {
        return wxUserStatisticsService.getUserSummary((String)request.getAttribute(WxParams.ACCESS_TOKEN),statisticsSearchDto);
    }

    /** 获取累计用户数据 */
    @PostMapping("user/cumulate/{appid}")
    public Result getUserCumulate(@PathVariable String appid, @RequestBody StatisticsSearchDto statisticsSearchDto, HttpServletRequest request) throws IOException {
        return wxUserStatisticsService.getUserCumulate((String)request.getAttribute(WxParams.ACCESS_TOKEN),statisticsSearchDto);
    }

    /** 获取图文群发每日数据 */
    @PostMapping("article/summary/{appid}")
    public Result getArticleSummary(@PathVariable String appid, @RequestBody StatisticsSearchDto statisticsSearchDto, HttpServletRequest request) throws IOException {
        return wxArticleStatisticsService.getArticleSummary((String)request.getAttribute(WxParams.ACCESS_TOKEN),statisticsSearchDto);
    }

    /** 获取图文群发总数据 */
    @PostMapping("article/total/{appid}")
    public Result getArticleTotal(@PathVariable String appid, @RequestBody StatisticsSearchDto statisticsSearchDto, HttpServletRequest request) throws IOException {
        return wxArticleStatisticsService.getArticleTotal((String)request.getAttribute(WxParams.ACCESS_TOKEN),statisticsSearchDto);
    }

    /** 获取图文群发总数据 */
    @PostMapping("article/read/{appid}")
    public Result getArticleRead(@PathVariable String appid, @RequestBody StatisticsSearchDto statisticsSearchDto, HttpServletRequest request) throws IOException {
        return wxArticleStatisticsService.getArticleRead((String)request.getAttribute(WxParams.ACCESS_TOKEN),statisticsSearchDto);
    }

    /** 获取图文统计分时数据 */
    @PostMapping("article/read/hour/{appid}")
    public Result getArticleReadHour(@PathVariable String appid, @RequestBody StatisticsSearchDto statisticsSearchDto, HttpServletRequest request) throws IOException {
        return wxArticleStatisticsService.getArticleReadHour((String)request.getAttribute(WxParams.ACCESS_TOKEN),statisticsSearchDto);
    }

    /** 获取图文分享转发数据 */
    @PostMapping("article/share/{appid}")
    public Result getArticleShare(@PathVariable String appid, @RequestBody StatisticsSearchDto statisticsSearchDto, HttpServletRequest request) throws IOException {
        return wxArticleStatisticsService.getArticleShare((String)request.getAttribute(WxParams.ACCESS_TOKEN),statisticsSearchDto);
    }

    /** 获取图文分享转发分时数据 */
    @PostMapping("article/share/hour/{appid}")
    public Result getArticleShareHour(@PathVariable String appid, @RequestBody StatisticsSearchDto statisticsSearchDto, HttpServletRequest request) throws IOException {
        return wxArticleStatisticsService.getArticleShareHour((String)request.getAttribute(WxParams.ACCESS_TOKEN),statisticsSearchDto);
    }

    /** 获取消息发送概况数据 */
    @PostMapping("msg/{appid}")
    public Result getMsg(@PathVariable String appid, @RequestBody StatisticsSearchDto statisticsSearchDto, HttpServletRequest request) throws IOException {
        return wxMsgStatisticsService.getMsg((String)request.getAttribute(WxParams.ACCESS_TOKEN),statisticsSearchDto);
    }

    /** 获取消息分送分时数据 */
    @PostMapping("msg/hour/{appid}")
    public Result getMsgHour(@PathVariable String appid, @RequestBody StatisticsSearchDto statisticsSearchDto, HttpServletRequest request) throws IOException {
        return wxMsgStatisticsService.getMsgHour((String)request.getAttribute(WxParams.ACCESS_TOKEN),statisticsSearchDto);
    }

    /** 获取消息发送周数据 */
    @PostMapping("msg/week/{appid}")
    public Result getMsgWeek(@PathVariable String appid, @RequestBody StatisticsSearchDto statisticsSearchDto, HttpServletRequest request) throws IOException {
        return wxMsgStatisticsService.getMsgWeek((String)request.getAttribute(WxParams.ACCESS_TOKEN),statisticsSearchDto);
    }
    /** 获取消息发送月数据 */
    @PostMapping("msg/month/{appid}")
    public Result getMsgMonth(@PathVariable String appid, @RequestBody StatisticsSearchDto statisticsSearchDto, HttpServletRequest request) throws IOException {
        return wxMsgStatisticsService.getMsgMonth((String)request.getAttribute(WxParams.ACCESS_TOKEN),statisticsSearchDto);
    }
    /** 获取消息发送分布数据 */
    @PostMapping("msg/dist/{appid}")
    public Result getMsgDist(@PathVariable String appid, @RequestBody StatisticsSearchDto statisticsSearchDto, HttpServletRequest request) throws IOException {
        return wxMsgStatisticsService.getMsgDist((String)request.getAttribute(WxParams.ACCESS_TOKEN),statisticsSearchDto);
    }
    /** 获取消息发送分布周数据 */
    @PostMapping("msg/dist/week/{appid}")
    public Result getMsgDistWeek(@PathVariable String appid, @RequestBody StatisticsSearchDto statisticsSearchDto, HttpServletRequest request) throws IOException {
        return wxMsgStatisticsService.getMsgDistWeek((String)request.getAttribute(WxParams.ACCESS_TOKEN),statisticsSearchDto);
    }
    /** 获取消息发送分布月数据 */
    @PostMapping("msg/dist/momth/{appid}")
    public Result getMsgDistMonth(@PathVariable String appid, @RequestBody StatisticsSearchDto statisticsSearchDto, HttpServletRequest request) throws IOException {
        return wxMsgStatisticsService.getMsgDistMonth((String)request.getAttribute(WxParams.ACCESS_TOKEN),statisticsSearchDto);
    }
    /** 获取接口分析数据 */
    @PostMapping("interface/summary/{appid}")
    public Result getInterfaceSummary(@PathVariable String appid, @RequestBody StatisticsSearchDto statisticsSearchDto, HttpServletRequest request) throws IOException {
        return wxInterfaceStatisticsService.getInterfaceSummary((String)request.getAttribute(WxParams.ACCESS_TOKEN),statisticsSearchDto);
    }

    /** 获取接口分析分时数据 */
    @PostMapping("interface/summary/hour/{appid}")
    public Result getInterfaceSummaryHour(@PathVariable String appid, @RequestBody StatisticsSearchDto statisticsSearchDto, HttpServletRequest request) throws IOException {
        return wxInterfaceStatisticsService.getInterfaceSummaryHour((String)request.getAttribute(WxParams.ACCESS_TOKEN),statisticsSearchDto);
    }
}
