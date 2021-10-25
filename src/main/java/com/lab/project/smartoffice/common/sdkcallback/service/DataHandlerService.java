package com.lab.project.smartoffice.common.sdkcallback.service;

import com.lab.common.utils.ParameterUtil;
import com.lab.common.utils.bean.BeanUtils;
import com.lab.framework.redis.RedisCache;
import com.lab.project.smartoffice.common.constant.RedisConstant;
import com.lab.project.smartoffice.common.datacollection.mapper.DataCollectionMapper;
import com.lab.project.smartoffice.common.device.domain.bo.DeviceBO;
import com.lab.project.smartoffice.common.device.mapper.DeviceMapper;
import com.lab.project.smartoffice.common.sdkcallback.domain.CallBackDTO;
import com.lab.project.smartoffice.common.sdkcallback.domain.DataCollectionEntity;
import com.lab.project.smartoffice.common.sdkcallback.domain.DeviceFunctionDTO;
import com.lab.project.smartoffice.common.device.domain.bo.DeviceFunctionBO;
import com.lab.project.smartoffice.common.sdkcallback.domain.RedisData;
import com.lab.project.smartoffice.common.sdkcallback.domain.bo.GatewayBO;
import com.lab.project.smartoffice.common.sdkcallback.handle.DeviceFunctionHandlerContext;
import com.lab.project.smartoffice.common.space.domain.bo.SpaceDeviceBO;
import com.lab.project.smartoffice.common.space.domain.bo.SpaceStrategyBO;
import com.lab.project.smartoffice.common.space.mapper.SpaceMapper;
import com.lab.project.smartoffice.common.space.mapper.SpaceStrategyMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 陈宽
 * @create 2021-10-13 11:19
 * @description
 */
@Service
@Slf4j
@AllArgsConstructor
public class DataHandlerService {

    private SpaceMapper spaceMapper;

    private SpaceStrategyMapper spaceStrategyMapper;

    private DeviceMapper deviceMapper;

    private RedisCache redisCache;

    private DataCollectionMapper dataCollectionMapper;

    private DeviceFunctionHandlerContext deviceFunctionHandlerContext;


    /**
     * 将回传的数据保存进数据库
     * 将space和device分别查询分装进BO后再保存
     * @param callBackDTO
     */
    public void handleDataParam(CallBackDTO callBackDTO){
        // 获取设备id和网关id
        String deviceId = callBackDTO.getDeviceEui();
        String getewayId = callBackDTO.getGeteWayEui();
        // 1.获取Space相关信息
        Map<String, SpaceDeviceBO> spaceDeviceBOMap = initSpaceDeviceRedis();
        //   1.1 通过deviceID作为KEY值，拿到spaceDeviceBO
        SpaceDeviceBO spaceDeviceBO = spaceDeviceBOMap.get(deviceId);
        if (spaceDeviceBO == null){
            log.info("获取设备绑定空间信息失败，设备id为{}",deviceId);
            return ;
        }
        String spaceId = String.valueOf(spaceDeviceBO.getSpaceId());
        // 2.获取device相关信息
        Map<String, DeviceBO> deviceBOMap = initDeviceRedis();
        //   2.1 获取对应deviceId所在的设备信息
        DeviceBO deviceBO = deviceBOMap.get(deviceId);
        // 3.获取spaceStrategy相关信息
        Map<String, SpaceStrategyBO> spaceStrategyBOMap = initSpaceStrategyRedis();
        // 4.获取deviceFunction相关信息
        Map<String, DeviceFunctionBO> deviceFunctionBOMap = initDeviceFunctionRedis();
        // 5.获取gateway相关信息
        Map<String, GatewayBO> gatewayBOMap = initGateWayRedis();
        //    5.1 获取具体属性
        GatewayBO gatewayBO = gatewayBOMap.get(getewayId);


        // 准备一个DataCollectionList收集整合space和device后的数据
        List<DataCollectionEntity> dataCollectionEntityList = new ArrayList<>();
        // 传输回来的数据(deviceFunctionData 和 deviceFunctionType)
        List<DeviceFunctionDTO> deviceFunctionDTOList = callBackDTO.getDataList();
        // 遍历回传集合收集到dataCollection中
        //=============缓存Redis数据开始=============
        RedisData redisData = new RedisData();
        // 填充redisData属性
        redisData.setSpaceId(spaceId);
        redisData.setDeviceId(deviceId);
        redisData.setDeviceName(deviceBO.getDeviceName());
        redisData.setDevicePicUrl(deviceBO.getDevicePicUrl());
        for (DeviceFunctionDTO deviceFunctionDTO : deviceFunctionDTOList) {
            DeviceFunctionBO deviceFunctionBO = deviceFunctionBOMap.get(String.valueOf(deviceFunctionDTO.getDeviceFunctionType()));
            deviceFunctionDTO.setWarning(false);
            if (deviceFunctionBO == null){
                log.info("在缓存中来找到:" + deviceFunctionDTO.getDeviceFunctionType() + "对应相关信息");
                continue;
            }
            deviceFunctionDTO.setDeviceFunctionName(deviceFunctionBO.getDeviceFunctionTypeName() + "对应相关信息");
        }
        redisData.setDataList(deviceFunctionDTOList);
        HashMap<String,RedisData> redisDataHashMap = new HashMap<>(16);
        // 收集的值存入map
        redisDataHashMap.put(deviceId,redisData);
        // 将map存进redis
        redisCache.setCacheMap(spaceId,redisDataHashMap);
        //=============缓存Redis数据结束=============
        if (deviceFunctionDTOList != null && deviceFunctionDTOList.size() != 0){
            for (DeviceFunctionDTO deviceFunctionDTO : deviceFunctionDTOList) {
                // Datacollection收集数据
                DataCollectionEntity dataCollectionEntity = new DataCollectionEntity();
                // 1.属性拷贝，把SpaceDeviceBO中的属性拷贝到dataCollection中
                BeanUtils.copyProperties(spaceDeviceBO,dataCollectionEntity);
                // 2.属性拷贝，把deviceBO中的属性拷贝到dataCollection中
                BeanUtils.copyProperties(deviceBO,dataCollectionEntity);
                // 3.属性拷贝，把SpaceStrategyBO中的属性拷贝到dataCollection中
                //   3.1 拼接Key
                String spaceUnionStrategy = spaceDeviceBO.getSpaceId() + "@" + deviceFunctionDTO.getDeviceFunctionType();
                SpaceStrategyBO spaceStrategyBO = spaceStrategyBOMap.get(spaceUnionStrategy);
                if (spaceStrategyBO == null){
                    continue;
                }
                //   3.2 属性拷贝
                BeanUtils.copyProperties(spaceStrategyBOMap,dataCollectionEntity);
                // 4.属性拷贝，把deviceFunctionBO中的属性拷贝到dataCollection中
                //   4.1 获取deviceFunctionBO
                DeviceFunctionBO deviceFunctionBO = deviceFunctionBOMap.get(deviceFunctionDTO.getDeviceFunctionType());
                //   4.2 属性拷贝
                BeanUtils.copyProperties(deviceFunctionBO,dataCollectionEntity);
                // 5.属性拷贝，把GateWayBO中的属性拷贝到dataCollection中
                BeanUtils.copyProperties(gatewayBO,dataCollectionEntity);
                // 6.填充deviceFunctionData值
                dataCollectionEntity.setDeviceFunctionData(deviceFunctionDTO.getDeviceFunctionData());



                BeanUtils.copyProperties(deviceBOMap,dataCollectionEntity);
                // 7.填充dataCollection公共属性
                dataCollectionEntity.setCreateBy("系统创建");
                ParameterUtil.setCreateEntity(dataCollectionEntity);
                dataCollectionEntityList.add(dataCollectionEntity);
            }
        }
        dataCollectionEntityList.forEach(System.out::println);
        // 批量插入到数据库
        if(dataCollectionEntityList.size() > 0){
            dataCollectionMapper.insertBatch(dataCollectionEntityList);
        }
        log.info("入库完成插入数据数量：{}",dataCollectionEntityList.size());
        // 处理并判断是否需要警告
        for (DataCollectionEntity dataCollectionEntity : dataCollectionEntityList) {
            // 发异步送警告信息
            deviceFunctionHandlerContext.getHandlerInstance(String.valueOf(dataCollectionEntity
                    .getDeviceFunctionType()))
                    .saveWarining(dataCollectionEntity);

        }
    }

    private Map<String, GatewayBO> initGateWayRedis() {
        // 1.直接从redis中获取
        Map<String, GatewayBO> gatewayBOMap = redisCache.getCacheMap(RedisConstant.GATEWAY_CACHE_REDIS);
        // 2.判断从Redis取出的数据是否存在
        if (gatewayBOMap.size() == 0){
            // 2.1如果没有数据，则从数据库中获取
            gatewayBOMap = deviceMapper.getGatewayMap();
            // 2.2将存储的结果放进Redis
            redisCache.setCacheMap(RedisConstant.GATEWAY_CACHE_REDIS,gatewayBOMap);
        }
        // 3.返回查询结果
        return gatewayBOMap;
    }

    /**
     * 从Redis取出Space相关信息封装进DeviceFunctionBO
     * @return
     */
    private Map<String, DeviceFunctionBO> initDeviceFunctionRedis() {
        // 1.直接从redis中获取
        Map<String, DeviceFunctionBO> deviceFunctionBOMap = redisCache.getCacheMap(RedisConstant.DEVICE_FUNCTION_CACHE_REDIS);
        // 2.判断从Redis取出的数据是否存在
        if (deviceFunctionBOMap.size() == 0){
            // 2.1如果没有数据，则从数据库中获取
            deviceFunctionBOMap = deviceMapper.getDeviceFunctionMap();
            // 2.2将存储的结果放进Redis
            redisCache.setCacheMap(RedisConstant.DEVICE_FUNCTION_CACHE_REDIS,deviceFunctionBOMap);
        }
        // 3.返回查询结果
        return deviceFunctionBOMap;
    }

    /**
     * 从Redis取出Space相关信息封装进SpaceStrategty
     * @return
     */
    private Map<String, SpaceStrategyBO> initSpaceStrategyRedis() {
        // 1.直接从redis中获取
        Map<String, SpaceStrategyBO> spaceStrategyBOMap = redisCache.getCacheMap(RedisConstant.SPACE_STRATEGY_CACHE_REDIS);
        // 2.判断从Redis取出的数据是否存在
        if (spaceStrategyBOMap.size() == 0){
            // 2.1如果没有数据，则从数据库中获取
            spaceStrategyBOMap = spaceStrategyMapper.getSpaceStrategyMap();
            // 2.2将存储的结果放进Redis
            redisCache.setCacheMap(RedisConstant.SPACE_STRATEGY_CACHE_REDIS,spaceStrategyBOMap);
        }
        // 3.返回查询结果
        return spaceStrategyBOMap;
    }

    /**
     * 从Redis取出Space相关信息封装进SpaceDeviceBO
     * @return
     */
    public Map<String, SpaceDeviceBO> initSpaceDeviceRedis(){
        // 1.直接从redis中获取
        Map<String, SpaceDeviceBO> spaceDeviceRedis = redisCache.getCacheMap(RedisConstant.SPACE_DEVICE_CACHE_REDIS);
        // 2.判断从Redis取出的数据是否存在
        if (spaceDeviceRedis.size() == 0 ){
            // 2.1如果没有数据，则从数据库中获取
            spaceDeviceRedis = spaceMapper.getSpaceDeviceMap();
            // 2.2将存储的结果放进Redis
            redisCache.setCacheMap(RedisConstant.SPACE_DEVICE_CACHE_REDIS,spaceDeviceRedis);

        }
        // 3.返回查询结果
        return spaceDeviceRedis;
    }

    /**
     * 从Redis取出Device相关信息封装进DeviceBO
     * @return
     */
    public Map<String, DeviceBO> initDeviceRedis(){
        // 1.直接从Redis中获取
        Map<String, DeviceBO> deviceBOMap = redisCache.getCacheMap(RedisConstant.DEVICE_CACHE_REDIS);
        // 2.判断从Redis取出的数据是否存在
        if (deviceBOMap.size() == 0){
            // 2.1如果没有数据，则从数据库中获取
            deviceBOMap = deviceMapper.getDeviceMap();
            // 2.2将存储的结果放进Redis
            redisCache.setCacheMap(RedisConstant.DEVICE_CACHE_REDIS,deviceBOMap);
        }
        // 返回数据
        return deviceBOMap;

    }
}
