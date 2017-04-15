package com.example.redis;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * redis通用操作类
 * Created by cc on 17-1-18.
 */
public interface RedisDao {

    /** 该命令用于在 key 存在时删除 key */
    void del(String key);

    /** 批量删除 key */
    void del(List<String> keys);

    /** 序列化给定 key ，并返回被序列化的值。 */
    byte[] dump(String key);

    /** 检查给定 key 是否存在 */
    Boolean exists(String key);

    /** 为给定 key 设置过期时间。 */
    Boolean expire(String key, long time, TimeUnit type);

    /** 为给定 key 设置过期时间,时间参数是 UNIX 时间戳(unix timestamp) */
    Boolean expireAt(String key, Date date);

    /** 查找所有符合给定模式( pattern)的 key  */
    Set<String> keys(String pattern);

    /** 将当前数据库的 key 移动到给定的数据库 db 当中。  */
    Boolean move(String key,int db);

    /** 移除 key 的过期时间，key 将持久保持。 */
    Boolean persist(String key);

    /** 返回 key 的剩余的过期时间。 -1:没有过期时间  -2：key不存在*/
    long getExpire(String key);

    /** 返回 key 的剩余的过期时间。 */
    long getExpire(String key,TimeUnit type);

    /** 从当前数据库中随机返回一个 key 。 */
    String randomKey();

    /** 修改 key 的名称 */
    void rename(String oldKey,String newKey);

    /** 仅当 newkey 不存在时，将 key 改名为 newkey 。 */
    Boolean renameIfAbsent(String oldKey,String newKey);

    /** 返回 key 所储存的值的类型。 */
    String type(String key);













}
