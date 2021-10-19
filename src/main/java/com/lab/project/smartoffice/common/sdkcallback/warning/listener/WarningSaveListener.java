package com.lab.project.smartoffice.common.sdkcallback.warning.listener;

import com.lab.common.utils.ParameterUtil;
import com.lab.common.utils.bean.BeanUtils;
import com.lab.framework.redis.RedisCache;
import com.lab.project.smartoffice.common.constant.RedisConstant;
import com.lab.project.smartoffice.common.sdkcallback.domain.DataCollectionEntity;
import com.lab.project.smartoffice.common.sdkcallback.warning.domain.DataWarning;
import com.lab.project.smartoffice.common.sdkcallback.warning.enums.WarningType;
import com.lab.project.smartoffice.common.sdkcallback.warning.event.WarningSaveEvent;
import com.lab.project.smartoffice.common.sdkcallback.warning.mapper.DataWarningMapper;
import com.lab.project.smartoffice.common.sdkcallback.warning.domain.DeviceSpaceBO;
import com.lab.project.smartoffice.common.space.mapper.SpaceMapper;
import com.neusiri.ai.api.yitu.milesight.constant.KaConstant;
import com.neusiri.ai.sdk.milesight.service.MilesightService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

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
    @EventListener(WarningSaveListener.class)
    public void warningRedisListener(WarningSaveEvent event){
        log.info("处理告警相关的Redis信息");
    }

    @Order(2)
    @Async
    @EventListener(WarningSaveListener.class)
    public void warningSendMessageToSDK(WarningSaveEvent event){
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
    @EventListener(WarningSaveListener.class)
    public void warningSaveListener(WarningSaveEvent event){
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





}
