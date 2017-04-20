package com.example.service.statistics;

import com.example.entity.Result;
import com.example.entity.wechat.statistics.StatisticsSearchDto;

import java.io.IOException;

/**
 * 消息数据分析
 * Created by cc on 17-4-20.
 */
public interface WXMsgStatisticsService {

    /** 获取消息发送概况数据 */
    Result getMsg(String token, StatisticsSearchDto statisticsSearchDto) throws IOException;
    /** 获取消息分送分时数据 */
    Result getMsgHour(String token, StatisticsSearchDto statisticsSearchDto) throws IOException;
    /** 获取消息发送周数据 */
    Result getMsgWeek(String token, StatisticsSearchDto statisticsSearchDto) throws IOException;
    /** 获取消息发送月数据 */
    Result getMsgMonth(String token, StatisticsSearchDto statisticsSearchDto) throws IOException;

    /** 获取消息发送分布数据 */
    Result getMsgDist(String token, StatisticsSearchDto statisticsSearchDto) throws IOException;

    /** 获取消息发送分布周数据 */
    Result getMsgDistWeek(String token, StatisticsSearchDto statisticsSearchDto) throws IOException;

    /** 获取消息发送分布月数据 */
    Result getMsgDistMonth(String token, StatisticsSearchDto statisticsSearchDto) throws IOException;
}
