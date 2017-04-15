package com.example.redis.impl;

import com.example.redis.ZSetRedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 *
 * Created by cc on 17-1-19.
 */
@Repository
public class ZSetRedisDaoImpl extends RedisDaoImpl implements ZSetRedisDao {

    @Autowired
    private StringRedisTemplate template;

    @Override
    public Boolean add(String key, String value, double score) {
        return template.opsForZSet().add(key,value,score);
    }

    @Override
    public Long remove(String key, String... values) {
        return template.opsForZSet().remove(key,values);
    }

    @Override
    public Double incrementScore(String key, String value, double delta) {
        return template.opsForZSet().incrementScore(key,value,delta);
    }

    @Override
    public Long rank(String key, String value) {
        return template.opsForZSet().rank(key,value);
    }

    @Override
    public Long reverseRank(String key, Object value) {
        return template.opsForZSet().reverseRank(key,value);
    }

    @Override
    public Set<String> range(String key, long start, long end) {
        return template.opsForZSet().range(key,start,end);
    }

    @Override
    public Long zCard(String key) {
        return template.opsForZSet().zCard(key);
    }

    @Override
    public Long count(String key, double min, double max) {
        return template.opsForZSet().count(key,min,max);
    }


}
