package com.example.redis;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 封装string类型的redis操作
 * Created by cc on 17-1-19.
 */
public interface StringRedisDao extends RedisDao{


    /** 设置指定 key 的值 */
    void set(String key, String value);


    /** 获取指定 key 的值 */
    String get(String key);

    /** 返回 key 中字符串值的子字符 */
    String get(String key,long start,long end);

    /** 将给定 key 的值设为 value ，并返回 key 的旧值(old value) */
    String getAndSet(String key,String value);

    /** 对 key 所储存的字符串值，获取指定偏移量上的位(bit) */
    Boolean getBit(String key,long offset);

    /** 获取所有(一个或多个)给定 key 的值。 */
    List<String> multiGet(List<String> values);

    /** 对 key 所储存的字符串值，设置或清除指定偏移量上的位(bit) */
    Boolean setBit(String key,long offset,boolean value);

    /** 将值 value 关联到 key ，并将 key 的过期时间设为 seconds (以秒为单位) */
    void set(String key,String value,long time,TimeUnit type);

    /** 只有在 key 不存在时设置 key 的值 */
    Boolean setIfAbsent(String key,String value);

    /** 用 value 参数覆写给定 key 所储存的字符串值，从偏移量 offset 开始 */
    void set(String key,String value,long offset);

    /** 返回 key 所储存的字符串值的长度 */
    long size(String key);

    /** 同时设置一个或多个 key-value 对 */
    void multiSet(Map<String,String> values);

    /** 同时设置一个或多个 key-value 对，当且仅当所有给定 key 都不存在 */
    Boolean multiSetIfAbsent(Map<String,String> values);

    /** 将 key 所储存的值加上给定的增量值（increment） */
    Long increment(String key,long increment);


    /** 将 key 所储存的值加上给定的浮点增量值（increment） */
    Double increment(String key,double increment);

    /** 如果 key 已经存在并且是一个字符串， APPEND 命令将 value 追加到 key 原来的值的末尾 */
    Integer append(String key, String value);

}
