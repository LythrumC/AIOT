package com.lab.project.smartoffice.common.sdkcallback.runner;

import com.lab.framework.redis.RedisCache;
import com.lab.project.smartoffice.common.constant.RedisConstant;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author 陈宽
 * @create 2021-10-15 14:24
 * @description
 */
@Component
public class ClearRedis {
    @Resource
    private RedisCache redisCache;

    public void clearRedisCache(){
        redisCache.deleteObject(RedisConstant.SPACE_DEVICE_CACHE_REDIS);
        redisCache.deleteObject(RedisConstant.DEVICE_CACHE_REDIS);
        redisCache.deleteObject(RedisConstant.SPACE_STRATEGY_CACHE_REDIS);
        redisCache.deleteObject(RedisConstant.DEVICE_FUNCTION_CACHE_REDIS);
        redisCache.deleteObject(RedisConstant.GATEWAY_CACHE_REDIS);


    }
}
