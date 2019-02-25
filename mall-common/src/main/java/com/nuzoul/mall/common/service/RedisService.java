package com.nuzoul.mall.common.service;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

public abstract class RedisService {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    protected abstract String getModle();

    protected void cacheSet(String key, String value, int expire) {
        key = this.getModle() + "_" + key;
        redisTemplate.opsForValue().set(key, value);
        redisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }

    protected  void refreshExpire(String key,int expire){
        key = this.getModle() + "_" + key;
        redisTemplate.expire(key,expire,TimeUnit.SECONDS);
    }

    protected void cacheSet(String key, String value) {
        key = this.getModle() + "_" + key;
        redisTemplate.opsForValue().set(key, value);
        redisTemplate.expire(key, 86400, TimeUnit.SECONDS);
    }

    protected void cacheSet(String key, Object value, int expire) {
        key = this.getModle() + "_" + key;
        redisTemplate.opsForValue().set(key, JSON.toJSONString(value));
        redisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }

    protected void cacheSet(String key, Object value) {
        key = this.getModle() + "_" + key;
        redisTemplate.opsForValue().set(key, JSON.toJSONString(value));
        redisTemplate.expire(key, 86400, TimeUnit.SECONDS);
    }

    protected String cacheGet(String key) {
        key = this.getModle() + "_" + key;
        return redisTemplate.opsForValue().get(key);
    }

    protected Object cacheGetObject(String key) {
        key = this.getModle() + "_" + key;
        return JSON.parse(redisTemplate.opsForValue().get(key));
    }

    protected void cacheLpush(String key, String value) {
        key = this.getModle() + "_" + key;
        redisTemplate.opsForList().leftPush(key, value);
        redisTemplate.expire(key, 86400, TimeUnit.SECONDS);
    }

    protected void cacheLpush(String key, String value, int expire) {
        key = this.getModle() + "_" + key;
        redisTemplate.opsForList().leftPush(key, value);
        redisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }

    protected String cacheRpop(String key) {
        key = this.getModle() + "_" + key;
        return redisTemplate.opsForList().rightPop(key);
    }

    protected boolean cacheDelete(String key) {
        return redisTemplate.delete(this.getModle() + "_" + key);
    }



    protected Boolean getLock(String key, String value, int expire) {
        key = this.getModle() + "_" + key;
        Boolean aBoolean = redisTemplate.opsForValue().setIfAbsent(key, value);
        if (aBoolean) {
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
            return true;
        } else {
            return false;
        }
    }
}
