package com.example.entity.wechat.statistics;

import com.example.entity.CommonDto;
import lombok.Data;

import java.io.Serializable;

/**
 * 数据统计搜索参数
 * Created by cc on 17-4-20.
 */
@Data
public class StatisticsSearchDto extends CommonDto implements Serializable{
    private String begin_date;
    private String end_date;
}
