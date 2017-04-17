package com.example.service.impl;

import com.example.constants.RedisConstants;
import com.example.constants.WxAPI;
import com.example.constants.WxErrorCode;
import com.example.constants.WxParams;
import com.example.entity.Result;
import com.example.exception.MyException;
import com.example.redis.StringRedisDao;
import com.example.service.WXTokenService;
import com.example.utils.HttpUtils;
import com.example.utils.ResultUtil;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 *
 * Created by cc on 17-4-13.
 */
@Service
public class WXTokenServiceImpl implements WXTokenService{

    Logger logger = LoggerFactory.getLogger(WXTokenServiceImpl.class);

    @Autowired private StringRedisDao stringRedisDao;

    @Override
    public String getTokenSecret(String appid, String secret) throws IOException {
        String url = WxAPI.WECHAT_TOKEN.replace(WxParams.URL_APPID,appid).replace(WxParams.URL_APPSECRET,secret);
        String result = HttpUtils.httpGet(url);
        if (result.contains(WxParams.ACCESS_TOKEN)){
            JSONObject json = JSONObject.fromObject(result);
            String key = RedisConstants.WECHAT+appid+RedisConstants.STRING_TOKEN;
            String value = json.getString(WxParams.ACCESS_TOKEN);
            long time = json.getLong(WxParams.EXPIRES_IN)-600;
            stringRedisDao.set(key,value,time, TimeUnit.SECONDS);
            return json.getString(WxParams.ACCESS_TOKEN);
        }else {
            logger.warn("[微信获取token][返回失败][appid:"+appid+",secret:"+secret+"]");
            throw new MyException(WxErrorCode.WX_ERROR_TOKEN,result);
        }

    }

    @Override
    public String getToken(String appid){
        return stringRedisDao.get(RedisConstants.WECHAT+appid+RedisConstants.STRING_TOKEN);
    }

    @Override
    public Result getExpires(String appid) {
        long expires = stringRedisDao.getExpire(RedisConstants.WECHAT+appid+RedisConstants.STRING_TOKEN);
        return ResultUtil.success(expires);
    }
}
