package com.example.redis.impl;

import com.example.redis.RedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 通用redis操作
 * Created by cc on 17-1-18.
 */
@Repository
public class RedisDaoImpl implements RedisDao {

    @Autowired private StringRedisTemplate template;

    @Override
    public void del(String key) {
        template.delete(key);
    }

    @Override
    public void del(List<String> keys) {
        template.delete(keys);
    }

    @Override
    public byte[] dump(String key) {
        return template.dump(key);
    }

    @Override
    public Boolean exists(String key) {
        return template.hasKey(key);
    }

    @Override
    public Boolean expire(String key, long time, TimeUnit type) {
        return template.expire(key,time,type);
    }

    @Override
    public Boolean expireAt(String key, Date date) {
        return template.expireAt(key,date);
    }

    @Override
    public Set<String> keys(String pattern) {
        return template.keys(pattern);
    }

    @Override
    public Boolean move(String key, int db) {
        return template.move(key,db);
    }

    @Override
    public Boolean persist(String key) {
        return template.persist(key);
    }

    @Override
    public long getExpire(String key) {
        return template.getExpire(key);
    }

    @Override
    public long getExpire(String key, TimeUnit type) {
        return template.getExpire(key,type);
    }

    @Override
    public String randomKey() {
        return template.randomKey();
    }

    @Override
    public void rename(String oldKey, String newKey) {
        template.rename(oldKey,newKey);
    }

    @Override
    public Boolean renameIfAbsent(String oldKey, String newKey) {
        return template.renameIfAbsent(oldKey,newKey);
    }

    @Override
    public String type(String key) {
        return template.type(key).code();
    }


}
