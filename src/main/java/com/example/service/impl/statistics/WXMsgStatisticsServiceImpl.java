package com.example.service.impl.statistics;

import com.example.constants.WxAPI;
import com.example.constants.WxParams;
import com.example.entity.Result;
import com.example.entity.wechat.statistics.StatisticsSearchDto;
import com.example.service.statistics.WXMsgStatisticsService;
import com.example.utils.ResultUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 *
 * Created by cc on 17-4-20.
 */
@Service
public class WXMsgStatisticsServiceImpl implements WXMsgStatisticsService{

    @Override
    public Result getMsg(String token, StatisticsSearchDto statisticsSearchDto) throws IOException {
        return getMsg(WxAPI.WECHAT_STATISTICS_MSG,token,statisticsSearchDto);
    }

    @Override
    public Result getMsgHour(String token, StatisticsSearchDto statisticsSearchDto) throws IOException {
        return getMsgHour(WxAPI.WECHAT_STATISTICS_MSG_HOUR,token,statisticsSearchDto);
    }

    @Override
    public Result getMsgWeek(String token, StatisticsSearchDto statisticsSearchDto) throws IOException {
        return getMsgWeek(WxAPI.WECHAT_STATISTICS_MSG_WEEK,token,statisticsSearchDto);
    }

    @Override
    public Result getMsgMonth(String token, StatisticsSearchDto statisticsSearchDto) throws IOException {
        return getMsgMonth(WxAPI.WECHAT_STATISTICS_MSG_MONTH,token,statisticsSearchDto);
    }

    @Override
    public Result getMsgDist(String token, StatisticsSearchDto statisticsSearchDto) throws IOException {
        return getMsgDist(WxAPI.WECHAT_STATISTICS_MSG_DIST,token,statisticsSearchDto);
    }

    @Override
    public Result getMsgDistWeek(String token, StatisticsSearchDto statisticsSearchDto) throws IOException {
        return getMsgDistWeek(WxAPI.WECHAT_STATISTICS_MSG_DIST_WEEK,token,statisticsSearchDto);
    }

    @Override
    public Result getMsgDistMonth(String token, StatisticsSearchDto statisticsSearchDto) throws IOException {
        return getMsgDistMonth(WxAPI.WECHAT_STATISTICS_MSG_DIST_MONTH,token,statisticsSearchDto);
    }

    /** 内部方法 */
    private Result getMsg(String url, String token, StatisticsSearchDto statisticsSearchDto) throws IOException {
        return ResultUtil.doPost(url,token,statisticsSearchDto.toGson(), WxParams.LIST,true);
    }

    private Result getMsgHour(String url, String token, StatisticsSearchDto statisticsSearchDto) throws IOException {
        return ResultUtil.doPost(url,token,statisticsSearchDto.toGson(), WxParams.LIST,true);
    }

    private Result getMsgWeek(String url, String token, StatisticsSearchDto statisticsSearchDto) throws IOException {
        return ResultUtil.doPost(url,token,statisticsSearchDto.toGson(), WxParams.LIST,true);
    }

    private Result getMsgMonth(String url, String token, StatisticsSearchDto statisticsSearchDto) throws IOException {
        return ResultUtil.doPost(url,token,statisticsSearchDto.toGson(), WxParams.LIST,true);
    }

    private Result getMsgDist(String url, String token, StatisticsSearchDto statisticsSearchDto) throws IOException {
        return ResultUtil.doPost(url,token,statisticsSearchDto.toGson(), WxParams.LIST,true);
    }

    private Result getMsgDistWeek(String url, String token, StatisticsSearchDto statisticsSearchDto) throws IOException {
        return ResultUtil.doPost(url,token,statisticsSearchDto.toGson(), WxParams.LIST,true);
    }

    private Result getMsgDistMonth(String url, String token, StatisticsSearchDto statisticsSearchDto) throws IOException {
        return ResultUtil.doPost(url,token,statisticsSearchDto.toGson(), WxParams.LIST,true);
    }

}
