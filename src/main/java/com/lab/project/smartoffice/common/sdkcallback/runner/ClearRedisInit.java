package com.lab.project.smartoffice.common.sdkcallback.runner;

import com.lab.framework.redis.RedisCache;
import com.lab.project.smartoffice.common.constant.RedisConstant;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author 陈宽
 * @create 2021-10-15 14:25
 * @description
 */
@Component
public class ClearRedisInit implements ApplicationRunner {
    @Resource
    private RedisCache redisCache;

    /**
     * 重启项目启动清理
     * @param args
     * @throws Exception
     */
    @Override
    @Async // 异步注解
    public void run(ApplicationArguments args) throws Exception {
        redisCache.deleteObject(RedisConstant.SPACE_DEVICE_CACHE_REDIS);
        redisCache.deleteObject(RedisConstant.DEVICE_CACHE_REDIS);
        redisCache.deleteObject(RedisConstant.SPACE_STRATEGY_CACHE_REDIS);
        redisCache.deleteObject(RedisConstant.DEVICE_FUNCTION_CACHE_REDIS);
        redisCache.deleteObject(RedisConstant.GATEWAY_CACHE_REDIS);
        redisCache.deleteObject(RedisConstant.SPACE_STRATEGY_CACHE_REDIS);
        redisCache.deleteObject(RedisConstant.WARNING_FLAG);




    }

}
