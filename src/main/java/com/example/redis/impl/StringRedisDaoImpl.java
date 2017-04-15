package com.example.redis.impl;

import com.example.redis.StringRedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 *
 * Created by cc on 17-1-19.
 */
@Repository
public class StringRedisDaoImpl extends RedisDaoImpl implements StringRedisDao {

    @Autowired
    private StringRedisTemplate template;

    @Override
    public void set(String key, String value) {
        template.opsForValue().set(key,value);
    }

    @Override
    public String get(String key) {
        return template.opsForValue().get(key);
    }

    @Override
    public String get(String key,long start,long end) {
        return template.opsForValue().get(key,start,end);
    }

    @Override
    public String getAndSet(String key, String value) {
        return template.opsForValue().getAndSet(key,value);
    }

    @Override
    public Boolean getBit(String key, long offset) {
        return template.opsForValue().getBit(key,offset);
    }

    @Override
    public List<String> multiGet(List<String> values) {
        return template.opsForValue().multiGet(values);
    }

    @Override
    public Boolean setBit(String key, long offset, boolean value) {
        return template.opsForValue().setBit(key,offset,value);
    }

    @Override
    public void set(String key, String value, long time, TimeUnit type) {
        template.opsForValue().set(key,value,time,type);
    }

    @Override
    public Boolean setIfAbsent(String key, String value) {
        return template.opsForValue().setIfAbsent(key,value);
    }

    @Override
    public void set(String key, String value, long offset) {
        template.opsForValue().set(key,value,offset);
    }

    @Override
    public long size(String key) {
        return template.opsForValue().size(key);
    }

    @Override
    public void multiSet(Map<String, String> values) {
        template.opsForValue().multiSet(values);
    }

    @Override
    public Boolean multiSetIfAbsent(Map<String, String> values) {
        return template.opsForValue().multiSetIfAbsent(values);
    }

    @Override
    public Long increment(String key, long increment) {
        return template.opsForValue().increment(key,increment);
    }

    @Override
    public Double increment(String key, double increment) {
        return template.opsForValue().increment(key,increment);
    }

    @Override
    public Integer append(String key, String value) {
        return template.opsForValue().append(key,value);
    }


}
