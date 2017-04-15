package com.example.redis;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * list类型redis操作
 * Created by cc on 17-1-19.
 */
public interface ListRedisDao extends RedisDao{

    /** 移出并获取列表的第一个元素， 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止 */
    String leftPop(String key,long time, TimeUnit type);

    /** 移出并获取列表的最后一个元素， 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止 */
    String rightPop(String key,long time, TimeUnit type);

    /** 从列表中弹出一个值，将弹出的元素插入到另外一个列表中并返回它； 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止 */
    String rightPopAndLeftPush(String key, String newKey, long time, TimeUnit type);

    /** 通过索引获取列表中的元素 */
    String index(String key, long index);

    /** 在列表的元素前插入元素 */
    Long leftPush(String key, String pivot, String value);

    /** 在列表的元素后插入元素 */
    Long rightPush(String key, String pivot, String value);

    /** 获取列表长度 */
    Long size(String key);

    /** 移出并获取列表的第一个元素 */
    String leftPop(String key);

    /** 将一个值插入到列表头部 */
    Long leftPush(String key, String value);

    /** 将多个值插入到列表头部 */
    Long leftPushAll(String key, List<String> values);

    /** 将一个值插入到已存在的列表头部 */
    Long leftPushIfPresent(String key, String value);

    /** 获取列表指定范围内的元素 */
    List<String> range(String key, long start, long end);

    /** 移除列表元素 */
    Long remove(String key, long count, String value);

    /** 通过索引设置列表元素的值 */
    void set(String key, long index, String value);

    /** 对一个列表进行修剪(trim)，就是说，让列表只保留指定区间内的元素，不在指定区间之内的元素都将被删除 */
    void trim(String key, long start, long end);

    /** 移除并获取列表最后一个元素 */
    String rightPop(String key);

    /** 移除列表的最后一个元素，并将该元素添加到另一个列表并返回 */
    String rightPopAndLeftPush(String sourceKey, String destinationKey);

    /** 在列表中添加一个值 */
    Long rightPush(String key, String value);

    /** 在列表中添加多个值 */
    Long rightPushAll(String key, List<String> values);

    /** 为已存在的列表添加值 */
    Long rightPushIfPresent(String key, String value);




}
