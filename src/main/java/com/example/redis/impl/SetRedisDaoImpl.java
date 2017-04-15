package com.example.redis.impl;

import com.example.redis.SetRedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * Created by cc on 17-1-19.
 */
@Repository
public class SetRedisDaoImpl extends RedisDaoImpl implements SetRedisDao {

    @Autowired
    private StringRedisTemplate template;

    @Override
    public Long add(String key, List<String> values) {
        String[] arrString = values.toArray(new String[values.size()]);
        return template.opsForSet().add(key,arrString);
    }

    @Override
    public Long size(String key) {
        return template.opsForSet().size(key);
    }

    @Override
    public Set<String> difference(String key, String otherKey) {
        return template.opsForSet().difference(key,otherKey);
    }

    @Override
    public Set<String> difference(String key, List<String> otherKeys) {
        return template.opsForSet().difference(key,otherKeys);
    }

    @Override
    public Long differenceAndStore(String key, String otherKey, String destKey) {
        return template.opsForSet().differenceAndStore(key,otherKey,destKey);
    }

    @Override
    public Long differenceAndStore(String key, List<String> otherKeys, String destKey) {
        return template.opsForSet().differenceAndStore(key,otherKeys,destKey);
    }

    @Override
    public Long intersectAndStore(String key, String otherKey, String destKey) {
        return template.opsForSet().intersectAndStore(key,otherKey,destKey);
    }

    @Override
    public Long intersectAndStore(String key, List<String> otherKeys, String destKey) {
        return template.opsForSet().intersectAndStore(key,otherKeys,destKey);
    }

    @Override
    public Boolean isMember(String key, String value) {
        return template.opsForSet().isMember(key,value);
    }

    @Override
    public Set<String> members(String key) {
        return template.opsForSet().members(key);
    }

    @Override
    public Boolean move(String key, String value, String destKey) {
        return template.opsForSet().move(key,value,destKey);
    }

    @Override
    public String pop(String key) {
        return template.opsForSet().pop(key);
    }

    @Override
    public String randomMember(String key) {
        return template.opsForSet().randomMember(key);
    }

    @Override
    public List<String> randomMembers(String key, long count) {
        return template.opsForSet().randomMembers(key,count);
    }

    @Override
    public Long remove(String key, List<String> values) {
        String[] toBeStored = values.toArray(new String[values.size()]);
        return template.opsForSet().remove(key,toBeStored);
    }

    @Override
    public Set<String> union(String key, String otherKey) {
        return template.opsForSet().union(key,otherKey);
    }

    @Override
    public Set<String> union(String key, List<String> otherKeys) {
        return template.opsForSet().union(key,otherKeys);
    }

    @Override
    public Long unionAndStore(String key, String otherKey, String destKey) {
        return template.opsForSet().unionAndStore(key,otherKey,destKey);
    }

    @Override
    public Long unionAndStore(String key, List<String> otherKeys, String destKey) {
        return template.opsForSet().unionAndStore(key,otherKeys,destKey);
    }

    @Override
    public Set<String> scan(String key, String match) {
        Set<String> set = new HashSet<>();
        Cursor<String> values = template.opsForSet().scan(key, ScanOptions.scanOptions().match(match).build());
        while (values.hasNext()){
            set.add(values.next());
        }
        return set;
    }
}
