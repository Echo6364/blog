package com.echo.common.shiro.cache;


import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisCacheManager implements CacheManager {

    @Autowired
    private RedisTemplate redisTemplate; //

    @Override
    public <K, V> Cache<K, V> getCache(String name) throws CacheException {
        System.out.println("name:" + name);
        return new RedisCache<K, V>(120, redisTemplate);// 为了简化代码的编写，此处直接new一个Cache
    }

}