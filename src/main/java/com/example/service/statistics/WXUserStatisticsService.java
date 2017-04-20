package com.example.service.statistics;

import com.example.entity.Result;
import com.example.entity.wechat.statistics.StatisticsSearchDto;

import java.io.IOException;

/**
 * 用户数据统计
 * Created by cc on 17-4-20.
 */
public interface WXUserStatisticsService {

    /** 获取用户增减数据 */
    Result getUserSummary(String token, StatisticsSearchDto statisticsSearchDto) throws IOException;

    /** 获取累计用户数据 */
    Result getUserCumulate(String token, StatisticsSearchDto statisticsSearchDto) throws IOException;

}
