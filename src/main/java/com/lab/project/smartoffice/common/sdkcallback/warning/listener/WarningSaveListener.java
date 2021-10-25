package com.lab.project.smartoffice.common.sdkcallback.warning.listener;

import com.lab.common.utils.ParameterUtil;
import com.lab.common.utils.bean.BeanUtils;
import com.lab.framework.redis.RedisCache;
import com.lab.project.smartoffice.common.constant.RedisConstant;
import com.lab.project.smartoffice.common.sdkcallback.domain.DataCollectionEntity;
import com.lab.project.smartoffice.common.sdkcallback.domain.DeviceFunctionDTO;
import com.lab.project.smartoffice.common.sdkcallback.domain.RedisData;
import com.lab.project.smartoffice.common.sdkcallback.warning.domain.DataWarning;
import com.lab.project.smartoffice.common.sdkcallback.warning.enums.WarningType;
import com.lab.project.smartoffice.common.sdkcallback.warning.event.WarningSaveEvent;
import com.lab.project.smartoffice.common.sdkcallback.warning.mapper.DataWarningMapper;
import com.lab.project.smartoffice.common.sdkcallback.warning.domain.DeviceSpaceBO;
import com.lab.project.smartoffice.common.space.mapper.SpaceMapper;
import com.neusiri.ai.api.yitu.milesight.constant.KaConstant;
import com.neusiri.ai.sdk.milesight.service.MilesightService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 陈宽
 * @create 2021-10-15 15:11
 * @description
 */
@Component
@Slf4j
public class WarningSaveListener {

    private DataWarningMapper dataWarningMapper;

    private RedisCache redisCache;

    private MilesightService milesightService;

    private SpaceMapper spaceMapper;

    @Order(1)
    @Async
    @EventListener(WarningSaveEvent.class)
    public void warningRedisListener(WarningSaveEvent event){
        DataCollectionEntity dataCollectionEntity = event.getDataCollectionEntity();
        String key = dataCollectionEntity.getSpaceId()
                     + dataCollectionEntity.getDeviceId()
                     + dataCollectionEntity.getDeviceFunctionType();
        Map<String, Boolean> cacheMap = redisCache.getCacheMap(RedisConstant.WARNING_FLAG);
        if (cacheMap == null || cacheMap.get(key) == null || cacheMap.get(key) == false){
            cacheMap = new HashMap<>(16);
            cacheMap.put(key,true);
            redisCache.setCacheMap(RedisConstant.WARNING_FLAG,cacheMap);
        }
        Map<String, RedisData> redisCacheCacheMap = redisCache.getCacheMap(String.valueOf(dataCollectionEntity.getSpaceId()));
        RedisData redisData = redisCacheCacheMap.get(String.valueOf(dataCollectionEntity.getDeviceId()));
        List<DeviceFunctionDTO> dataList = redisData.getDataList();

        for (DeviceFunctionDTO deviceFunctionDTO : dataList) {
            // 判断是否为告警数据
            if (deviceFunctionDTO.getDeviceFunctionType().equals(dataCollectionEntity.getDeviceFunctionType())){
                // 设置报警状态
                deviceFunctionDTO.setWarning(true);
            }
        }
        redisCacheCacheMap.put(String.valueOf(dataCollectionEntity.getDeviceId()),redisData);
        redisCache.setCacheMap(String.valueOf(dataCollectionEntity.getSpaceId()),redisCacheCacheMap);

    }

    @Order(2)
    @Async
    @EventListener(WarningSaveEvent.class)
    public void warningSendMessageToSDK(WarningSaveEvent event){
        if (getIsWarning(event.getDataCollectionEntity())){
            log.info("已经发送的数据直接忽略");
            return ;
        }
        DataCollectionEntity dataCollectionEntity = event.getDataCollectionEntity();
        log.info("将报警信息推送到网关服务");
        Map<String, DeviceSpaceBO> stringDeviceSpaceBOMap = initSpaceAlarmRedis();
        DeviceSpaceBO deviceSpaceBO = stringDeviceSpaceBOMap.get(dataCollectionEntity.getSpaceId().toString());
        if (deviceSpaceBO == null || deviceSpaceBO == null){
            log.info("获取空间对应的警告信息失败，空间id{}",dataCollectionEntity.getSpaceId());
        }
        milesightService.getKaAlertorService().manipulate(dataCollectionEntity.getGatewayId(),
                deviceSpaceBO.getDeviceId(),
                KaConstant.CONTROL_ALERTOR_STATE_ON,
                KaConstant.PORT);

    }


    @Order(3)
    @Async
    @EventListener(WarningSaveEvent.class)
    public void warningSaveListener(WarningSaveEvent event){
        if (getIsWarning(event.getDataCollectionEntity())){
            return ;
        }
        log.info("告警信息入库");
        // 设置基础状态
        DataCollectionEntity dataCollectionEntity = event.getDataCollectionEntity();
        DataWarning dataWarning = new DataWarning();
        BeanUtils.copyProperties(dataCollectionEntity,dataWarning);
        dataWarning.setDataWarningType(event.getDataWarningType());
        dataWarning.setDataWarningTypeName(WarningType.getWarningTypeNameByCode(event.getDataWarningType()));
        dataWarning.setProcessingStatus(0);
        dataWarning.setDataCollectionId(dataCollectionEntity.getId());
        dataWarning.setId(null);
        dataWarning.setCreateBy("系统上报");
        ParameterUtil.setCreateEntity(dataWarning);
        dataWarning.setUpdateBy("");
        dataWarning.setUpdateTime(null);
        dataWarningMapper.saveDataWarning(dataWarning);
        log.info("告警信息入库完成");

    }

    private Map<String, DeviceSpaceBO> initSpaceAlarmRedis() {
        Map<String, DeviceSpaceBO> deviceSpaceBOMap = redisCache.getCacheMap(RedisConstant.SPACE_INCLUDE_DEVICE_CACHE);
        if (deviceSpaceBOMap.size() == 0){
            deviceSpaceBOMap = spaceMapper.getSpaceIncludeDevice();
            redisCache.setCacheMap(RedisConstant.SPACE_INCLUDE_DEVICE_CACHE,deviceSpaceBOMap);

        }
        return deviceSpaceBOMap;
    }

    private boolean getIsWarning(DataCollectionEntity dataCollectionEntity){
        String key = dataCollectionEntity.getSpaceId()
                + dataCollectionEntity.getDeviceId()
                + dataCollectionEntity.getDeviceFunctionType();
        Map<String, Boolean> cacheMap = redisCache.getCacheMap(RedisConstant.WARNING_FLAG);
        if (cacheMap == null || cacheMap.get(key) == null || cacheMap.get(key) == false){
            return false;
        }
        return cacheMap.get(key);
    }





}
