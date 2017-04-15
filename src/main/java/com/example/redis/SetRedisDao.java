package com.example.redis;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * 封装set类型的redis操作
 * Created by cc on 17-1-19.
 */
public interface SetRedisDao extends RedisDao{

    /** 向集合添加一个或多个成员 */
    Long add(String key, List<String> values);

    /** 获取集合的成员数 */
    Long size(String key);

    /** 返回给定集合的差集 */
    Set<String> difference(String key, String otherKey);

    /** 返回给定所有集合的差集 */
    Set<String> difference(String key, List<String> otherKeys);

    /** 返回给定集合的差集并存储在 destKey 中 */
    Long differenceAndStore(String key, String otherKey, String destKey);

    /** 返回给定所有集合的差集并存储在 destKey 中 */
    Long differenceAndStore(String key, List<String> otherKeys, String destKey);

    /** 返回给定集合的交集并存储在 destKey 中 */
    Long intersectAndStore(String key, String otherKey, String destKey);

    /** 返回给定所有集合的交集并存储在 destKey 中 */
    Long intersectAndStore(String key, List<String> otherKeys, String destKey);

    /** 判断 member 元素是否是集合 key 的成员 */
    Boolean isMember(String key, String value);

    /** 返回集合中的所有成员 */
    Set<String> members(String key);

    /** 将 member 元素从 source 集合移动到 destKey 集合 */
    Boolean move(String key, String value, String destKey);

    /** 移除并返回集合中的一个随机元素 */
    String pop(String key);

    /** 返回集合中一个随机数 */
    String randomMember(String key);

    /** 返回集合中多个随机数 */
    List<String> randomMembers(String key, long count);

    /** 移除集合中一个或多个成员 */
    Long remove(String key, List<String> values);

    /** 返回给定集合的并集 */
    Set<String> union(String key, String otherKey);

    /** 返回所有给定集合的并集 */
    Set<String> union(String key, List<String> otherKeys);

    /** 给定集合的并集存储在 destination 集合中 */
    Long unionAndStore(String key, String otherKey, String destKey);

    /** 所有给定集合的并集存储在 destination 集合中 */
    Long unionAndStore(String key, List<String> otherKeys, String destKey);

    /** 迭代集合中的元素 */
    Set<String> scan(String key, String match);



}
