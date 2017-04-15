package com.example.redis.impl;

import com.example.redis.ListRedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 * Created by cc on 17-1-19.
 */
@Repository
public class ListRedisDaoImpl extends RedisDaoImpl implements ListRedisDao {

    @Autowired
    private StringRedisTemplate template;

    @Override
    public String leftPop(String key, long time, TimeUnit type) {
        return template.opsForList().leftPop(key,time,type);
    }

    @Override
    public String rightPop(String key, long time, TimeUnit type) {
        return template.opsForList().rightPop(key,time,type);
    }

    @Override
    public String rightPopAndLeftPush(String key, String newKey, long time, TimeUnit type) {
        return template.opsForList().rightPopAndLeftPush(key,newKey,time,type);
    }

    @Override
    public String index(String key, long index) {
        return template.opsForList().index(key,index);
    }

    @Override
    public Long leftPush(String key, String pivot, String value) {
        return template.opsForList().leftPush(key,pivot,value);
    }

    @Override
    public Long rightPush(String key, String pivot, String value) {
        return template.opsForList().rightPush(key,pivot,value);
    }

    @Override
    public Long size(String key) {
        return template.opsForList().size(key);
    }

    @Override
    public String leftPop(String key) {
        return template.opsForList().leftPop(key);
    }

    @Override
    public Long leftPush(String key, String value) {
        return template.opsForList().leftPush(key,value);
    }

    @Override
    public Long leftPushAll(String key, List<String> values) {
        return template.opsForList().leftPushAll(key,values);
    }

    @Override
    public Long leftPushIfPresent(String key, String value) {
        return template.opsForList().leftPushIfPresent(key,value);
    }

    @Override
    public List<String> range(String key, long start, long end) {
        return template.opsForList().range(key,start,end);
    }

    @Override
    public Long remove(String key, long count, String value) {
        return template.opsForList().remove(key,count,value);
    }

    @Override
    public void set(String key, long index, String value) {
        template.opsForList().set(key,index,value);
    }

    @Override
    public void trim(String key, long start, long end) {
        template.opsForList().trim(key,start,end);
    }

    @Override
    public String rightPop(String key) {
        return template.opsForList().rightPop(key);
    }

    @Override
    public String rightPopAndLeftPush(String sourceKey, String destinationKey) {
        return template.opsForList().rightPopAndLeftPush(sourceKey,destinationKey);
    }

    @Override
    public Long rightPush(String key, String value) {
        return template.opsForList().rightPush(key,value);
    }

    @Override
    public Long rightPushAll(String key, List<String> values) {
        return template.opsForList().rightPushAll(key,values);
    }

    @Override
    public Long rightPushIfPresent(String key, String value) {
        return template.opsForList().rightPushIfPresent(key,value);
    }
}
