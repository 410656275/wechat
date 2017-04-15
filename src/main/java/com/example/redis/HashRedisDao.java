package com.example.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 封装hash类型redis操作
 * Created by cc on 17-1-19.
 */
public interface HashRedisDao extends RedisDao{

    /** 删除多个哈希表字段 */
    Long delete(String key, List<String> values);

    /** 查看哈希表 key 中，指定的字段是否存在 */
    Boolean hasKey(String key, String hkey);

    /** 获取存储在哈希表中指定字段的值 */
    String get(String key, String hkey);

    /** 获取在哈希表中指定 key 的所有字段和值 */
    Map<Object, Object> entries(String key);

    /** 为哈希表 key 中的指定字段的整数值加上增量 increment  */
    Long increment(String key, String hkey, long value);

    /** 为哈希表 key 中的指定字段的浮点数值加上增量 increment */
    Double increment(String key, String hkey, double vaule);

    /** 获取所有哈希表中的字段 */
    Set<Object> hkeys(String key);

    /** 获取哈希表中字段的数量 */
    Long size(String key);

    /** 获取所有给定字段的值 */
    List<Object> multiGet(String key, List<Object> hkeys);

    /** 同时将多个 field-value (域-值)对设置到哈希表 key 中 */
    void putAll(String key,Map<String,String> map);

    /** 将哈希表 key 中的字段 field 的值设为 value  */
    void put(String key, String hkey, String value);

    /** 只有在字段 field 不存在时，设置哈希表字段的值 */
    Boolean putIfAbsent(String key, String hkey, String value);

    /** 获取哈希表中所有值 */
    List<Object> values(String key);

    /** 迭代哈希表中的键值对 */
    Map<Object, Object> scan(String key, String match);

}
