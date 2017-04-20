package com.example.service.impl.statistics;

import com.example.constants.WxAPI;
import com.example.constants.WxParams;
import com.example.entity.Result;
import com.example.entity.wechat.statistics.StatisticsSearchDto;
import com.example.service.statistics.WXUserStatisticsService;
import com.example.utils.ResultUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 *
 * Created by cc on 17-4-20.
 */
@Service
public class WXUserStatisticsServiceImpl implements WXUserStatisticsService{
    @Override
    public Result getUserSummary(String token, StatisticsSearchDto statisticsSearchDto) throws IOException {
        return getUserUummary(WxAPI.WECHAT_STATISTICS_USER_SUMMARY,token,statisticsSearchDto);
    }

    @Override
    public Result getUserCumulate(String token, StatisticsSearchDto statisticsSearchDto) throws IOException {
        return getUserCumulate(WxAPI.WECHAT_STATISTICS_USER_CUMULATE,token,statisticsSearchDto);
    }


    /** 内部方法 */

    private Result getUserUummary(String url, String token, StatisticsSearchDto statisticsSearchDto) throws IOException {
        return ResultUtil.doPost(url,token,statisticsSearchDto.toGson(), WxParams.LIST,true);
    }

    private Result getUserCumulate(String url, String token, StatisticsSearchDto statisticsSearchDto) throws IOException {
        return ResultUtil.doPost(url,token,statisticsSearchDto.toGson(), WxParams.LIST,true);
    }
}
