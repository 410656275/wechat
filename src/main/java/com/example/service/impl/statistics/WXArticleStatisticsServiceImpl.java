package com.example.service.impl.statistics;

import com.example.constants.WxAPI;
import com.example.constants.WxParams;
import com.example.entity.Result;
import com.example.entity.wechat.statistics.StatisticsSearchDto;
import com.example.service.statistics.WXArticleStatisticsService;
import com.example.utils.ResultUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 *
 * Created by cc on 17-4-20.
 */
@Service
public class WXArticleStatisticsServiceImpl implements WXArticleStatisticsService {


    @Override
    public Result getArticleSummary(String token, StatisticsSearchDto statisticsSearchDto) throws IOException {
        return getArticleSummary(WxAPI.WECHAT_STATISTICS_ARTICLES_SUMMARY,token,statisticsSearchDto);
    }

    @Override
    public Result getArticleTotal(String token, StatisticsSearchDto statisticsSearchDto) throws IOException {
        return getArticleTotal(WxAPI.WECHAT_STATISTICS_ARTICLES_TOTAL,token,statisticsSearchDto);
    }

    @Override
    public Result getArticleRead(String token, StatisticsSearchDto statisticsSearchDto) throws IOException {
        return getArticleRead(WxAPI.WECHAT_STATISTICS_ARTICLES_READ,token,statisticsSearchDto);
    }

    @Override
    public Result getArticleReadHour(String token, StatisticsSearchDto statisticsSearchDto) throws IOException {
        return getArticleReadHour(WxAPI.WECHAT_STATISTICS_ARTICLES_READ_HOUR,token,statisticsSearchDto);
    }

    @Override
    public Result getArticleShare(String token, StatisticsSearchDto statisticsSearchDto) throws IOException {
        return getArticleShare(WxAPI.WECHAT_STATISTICS_ARTICLES_SHARE,token,statisticsSearchDto);
    }

    @Override
    public Result getArticleShareHour(String token, StatisticsSearchDto statisticsSearchDto) throws IOException {
        return getArticleShareHour(WxAPI.WECHAT_STATISTICS_ARTICLES_SHARE_HOUR,token,statisticsSearchDto);
    }


    /** 内部方法 */
    private Result getArticleSummary(String url, String token, StatisticsSearchDto statisticsSearchDto) throws IOException {
        return ResultUtil.doPost(url,token,statisticsSearchDto.toGson(), WxParams.LIST,true);
    }

    private Result getArticleTotal(String url, String token, StatisticsSearchDto statisticsSearchDto) throws IOException {
        return ResultUtil.doPost(url,token,statisticsSearchDto.toGson(), WxParams.LIST,true);
    }

    private Result getArticleRead(String url, String token, StatisticsSearchDto statisticsSearchDto) throws IOException {
        return ResultUtil.doPost(url,token,statisticsSearchDto.toGson(), WxParams.LIST,true);
    }

    private Result getArticleReadHour(String url, String token, StatisticsSearchDto statisticsSearchDto) throws IOException {
        return ResultUtil.doPost(url,token,statisticsSearchDto.toGson(), WxParams.LIST,true);
    }

    private Result getArticleShare(String url, String token, StatisticsSearchDto statisticsSearchDto) throws IOException {
        return ResultUtil.doPost(url,token,statisticsSearchDto.toGson(), WxParams.LIST,true);
    }

    private Result getArticleShareHour(String url, String token, StatisticsSearchDto statisticsSearchDto) throws IOException {
        return ResultUtil.doPost(url,token,statisticsSearchDto.toGson(), WxParams.LIST,true);
    }

}
