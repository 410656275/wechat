package com.example.service.statistics;

import com.example.entity.Result;
import com.example.entity.wechat.statistics.StatisticsSearchDto;

import java.io.IOException;

/**
 * 图文数据统计
 * Created by cc on 17-4-20.
 */
public interface WXArticleStatisticsService {

    /** 获取图文群发每日数据 */
    Result getArticleSummary(String token, StatisticsSearchDto statisticsSearchDto) throws IOException;

    /** 获取图文群发总数据 */
    Result getArticleTotal(String token, StatisticsSearchDto statisticsSearchDto) throws IOException;

    /** 获取图文群发总数据 */
    Result getArticleRead(String token, StatisticsSearchDto statisticsSearchDto) throws IOException;

    /** 获取图文统计分时数据 */
    Result getArticleReadHour(String token, StatisticsSearchDto statisticsSearchDto) throws IOException;
    /** 获取图文分享转发数据 */
    Result getArticleShare(String token, StatisticsSearchDto statisticsSearchDto) throws IOException;
    /** 获取图文分享转发分时数据 */
    Result getArticleShareHour(String token, StatisticsSearchDto statisticsSearchDto) throws IOException;
}
