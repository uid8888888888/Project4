package com.stylefeng.guns.rest.modular.user.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author YangShuo
 * @date 2019-07-19 11:35
 *
 * jedis连接池
 * 使用方法：
 * 1.获取jedis : Jedis jedis =  JedisUtil.getJedisFromPool();
 * 2.使用完关闭jedis： jedis.close();
 */
public class JedisUtil {

   private static JedisPool jedisPool = new JedisPool();

   public static Jedis getJedisFromPool(){
      Jedis resource = jedisPool.getResource();
      return resource;
   }
}
