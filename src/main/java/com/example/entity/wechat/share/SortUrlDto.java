package com.example.entity.wechat.share;

import com.example.entity.CommonDto;
import lombok.Data;

import java.io.Serializable;

/**
 *
 * Created by cc on 17-4-20.
 */
@Data
public class SortUrlDto extends CommonDto implements Serializable {
    private String action;//long2short
    private String long_url;
}
