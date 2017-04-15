package com.example.redis.impl;

import com.example.redis.HashRedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * Created by cc on 17-1-19.
 */
@Repository
public class HashRedisDaoImpl extends RedisDaoImpl implements HashRedisDao {

    @Autowired
    private StringRedisTemplate template;

    @Override
    public Long delete(String key, List<String> values) {
        String[] strings = values.toArray(new String[values.size()]);
        return template.opsForHash().delete(key, (Object[]) strings);
    }

    @Override
    public Boolean hasKey(String key, String hkey) {
        return template.opsForHash().hasKey(key,hkey);
    }

    @Override
    public String get(String key, String hkey) {
        return (String) template.opsForHash().get(key,hkey);
    }

    @Override
    public Map<Object, Object> entries(String key) {
        return template.opsForHash().entries(key);
    }

    @Override
    public Long increment(String key, String hkey, long value) {
        return template.opsForHash().increment(key,hkey,value);
    }

    @Override
    public Double increment(String key, String hkey, double vaule) {
        return template.opsForHash().increment(key,hkey,vaule);
    }

    @Override
    public Set<Object> hkeys(String key) {
        return template.opsForHash().keys(key);
    }

    @Override
    public Long size(String key) {
        return template.opsForHash().size(key);
    }

    @Override
    public List<Object> multiGet(String key, List<Object> hkeys) {
        return template.opsForHash().multiGet(key,hkeys);
    }

    @Override
    public void putAll(String key, Map<String, String> map) {
        template.opsForHash().putAll(key,map);
    }

    @Override
    public void put(String key, String hkey, String value) {
        template.opsForHash().put(key,hkey,value);
    }

    @Override
    public Boolean putIfAbsent(String key, String hkey, String value) {
        return template.opsForHash().putIfAbsent(key,hkey,value);
    }

    @Override
    public List<Object> values(String key) {
        return template.opsForHash().values(key);
    }

    @Override
    public Map<Object, Object> scan(String key, String match) {


        Map<Object, Object> map = new HashMap<>();
        Cursor<Map.Entry<Object, Object>> curosr = template.opsForHash().scan(key, ScanOptions.scanOptions().match(match).build());
        while(curosr.hasNext()) {
            Map.Entry<Object, Object> entry = curosr.next();
            map.put(entry.getKey(), entry.getValue());
        }
        return map;
    }


}
