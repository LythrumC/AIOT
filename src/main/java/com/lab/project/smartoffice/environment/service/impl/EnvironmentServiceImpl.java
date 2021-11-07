package com.lab.project.smartoffice.environment.service.impl;

import com.lab.framework.redis.RedisCache;
import com.lab.project.smartoffice.common.constant.RedisConstant;
import com.lab.project.smartoffice.common.datacollection.mapper.DataCollectionMapper;
import com.lab.project.smartoffice.common.sdkcallback.domain.DataCollectionEntity;
import com.lab.project.smartoffice.common.sdkcallback.domain.DeviceFunctionDTO;
import com.lab.project.smartoffice.common.sdkcallback.domain.RedisData;
import com.lab.project.smartoffice.common.space.domain.bo.SpaceDeviceBO;
import com.lab.project.smartoffice.environment.service.EnvironmentService;
import com.lab.project.smartoffice.machineRoomMonitor.domain.vo.MachineRoomVo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 陈宽
 * @create 2021-11-02 9:57
 * @description
 */
@Service
@AllArgsConstructor
@Slf4j
public class EnvironmentServiceImpl implements EnvironmentService {

    @Resource
    private RedisCache redisCache;

    @Resource
    private DataCollectionMapper dataCollectionMapper;

    @Override
    public List<SpaceDeviceBO> getSpaceIdAndDeviceId() {
        Map<String, SpaceDeviceBO> spaceDeviceRedis = redisCache.getCacheMap(RedisConstant.SPACE_DEVICE_CACHE_REDIS);
        log.info("spaceDeviceRedis===={}",spaceDeviceRedis);
        return spaceDeviceRedis
                .values()
                .stream()
                .filter(spaceDeviceBO -> spaceDeviceBO.getSpaceType() == 11)
                .filter(spaceDeviceBO -> spaceDeviceBO.getDeviceType() == 10)
                .collect(Collectors.toList());
    }

    @Override
    public RedisData getRedisSpaceInfo(DataCollectionEntity dataCollectionEntity) {
        // 从Redis中获取最新数据
        Map<String, RedisData> cacheMap = redisCache.getCacheMap(String.valueOf(dataCollectionEntity.getSpaceId()));
        log.info("从Redis中获取数据=========" + cacheMap );
        // 根据设备id获取最新数据
        return cacheMap.get(String.valueOf(dataCollectionEntity.getDeviceId()));
    }

    @Override
    public List<DataCollectionEntity> listDataCollectionGraph(DataCollectionEntity dataCollectionEntity) {
        return dataCollectionMapper.listDataCollectionGraph(dataCollectionEntity);
    }
}
