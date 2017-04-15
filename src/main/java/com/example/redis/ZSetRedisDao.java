package com.example.redis;


import java.util.Set;

/**
 * 封装zset类型的redis操作
 * Created by cc on 17-1-19.
 */
public interface ZSetRedisDao extends RedisDao{

    /** 向有序集合添加一个或者更新已存在成员的分数 */
    Boolean add(String key, String value, double score);

    /** 移除有序集合中的一个或多个成员 */
    Long remove(String key, String... values);

    /** 有序集合中对指定成员的分数加上增量 increment */
    Double incrementScore(String key, String value, double delta);

    /** 返回有序集合中指定成员的索引 */
    Long rank(String key, String value);

    /** 返回有序集合中指定成员的排名，有序集成员按分数值递减(从大到小)排序 */
    Long reverseRank(String key, Object value);

    /** 通过索引区间返回有序集合成指定区间内的成员 */
    Set<String> range(String key, long start, long end);

    /**  */
    /**  */


    /** 移除有序集合中的一个或多个成员 */


    /** 获取有序集合的成员数 */
    Long zCard(String key);

    /** 计算在有序集合中指定区间分数的成员数 */
    Long count(String key, double min, double max);




    /** 获取有序集合的成员数 */





    /**  */
    /**  */
    /**  */
    /**  */
    /**  */



}
