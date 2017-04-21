package com.example.service.statistics;

import com.example.entity.Result;
import com.example.entity.wechat.statistics.StatisticsSearchDto;

import java.io.IOException;

/**
 * 接口分析数据
 * Created by cc on 17-4-20.
 */
public interface WXInterfaceStatisticsService {

    /** 获取接口分析数据 */
    Result getInterfaceSummary(String token, StatisticsSearchDto statisticsSearchDto) throws IOException;

    /** 获取接口分析分时数据 */
    Result getInterfaceSummaryHour(String token, StatisticsSearchDto statisticsSearchDto) throws IOException;

}
