package com.example.service.impl.statistics;

import com.example.constants.WxAPI;
import com.example.constants.WxParams;
import com.example.entity.Result;
import com.example.entity.wechat.statistics.StatisticsSearchDto;
import com.example.service.statistics.WXInterfaceStatisticsService;
import com.example.utils.ResultUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 *
 * Created by cc on 17-4-20.
 */
@Service
public class WXInterfaceStatisticsServiceImpl implements WXInterfaceStatisticsService {
    @Override
    public Result getInterfaceSummary(String token, StatisticsSearchDto statisticsSearchDto) throws IOException {
        return getInterfaceSummary(WxAPI.WECHAT_STATISTICS_INTERFACE_SUMMARY,token,statisticsSearchDto);
    }

    @Override
    public Result getInterfaceSummaryHour(String token, StatisticsSearchDto statisticsSearchDto) throws IOException {
        return getInterfaceSummaryHour(WxAPI.WECHAT_STATISTICS_INTERFACE_SUMMARY_HOUR,token,statisticsSearchDto);
    }

    /** 内部方法 */
    private Result getInterfaceSummary(String url, String token, StatisticsSearchDto statisticsSearchDto) throws IOException {
        return ResultUtil.doPost(url,token,statisticsSearchDto.toGson(), WxParams.LIST,true);
    }

    private Result getInterfaceSummaryHour(String url, String token, StatisticsSearchDto statisticsSearchDto) throws IOException {
        return ResultUtil.doPost(url,token,statisticsSearchDto.toGson(), WxParams.LIST,true);
    }
}
