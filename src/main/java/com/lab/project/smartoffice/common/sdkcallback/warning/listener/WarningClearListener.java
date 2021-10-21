package com.lab.project.smartoffice.common.sdkcallback.warning.listener;

import com.lab.framework.redis.RedisCache;
import com.lab.project.smartoffice.common.constant.RedisConstant;
import com.lab.project.smartoffice.common.sdkcallback.warning.domain.DataWarning;
import com.lab.project.smartoffice.common.sdkcallback.warning.domain.DeviceSpaceBO;
import com.lab.project.smartoffice.common.sdkcallback.warning.domain.dto.DataWarningDTO;
import com.lab.project.smartoffice.common.sdkcallback.warning.event.WarningClearEvent;
import com.lab.project.smartoffice.common.sdkcallback.warning.mapper.DataWarningMapper;
import com.neusiri.ai.api.yitu.milesight.constant.KaConstant;
import com.neusiri.ai.sdk.milesight.service.MilesightService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author 陈宽
 * @create 2021-10-21 17:10
 * @description
 */
@Component
@AllArgsConstructor
@Slf4j
public class WarningClearListener {

    private DataWarningMapper dataWarningMapper;

    private RedisCache redisCache;

    private MilesightService milesightService;

    @Async
    @Order(1)
    @EventListener(WarningClearEvent.class)
    public void warningClear(WarningClearEvent event){
        // 需要清除的警告id
        Long[] ids = event.getIds();
        DataWarningDTO dataWarningDTO = new DataWarningDTO();
        dataWarningDTO.setIds(ids);
        // 获取需要处理的告警数据集合
        List<DataWarning> dataWarningList = dataWarningMapper.selectDataWarning(dataWarningDTO);
        // 获取空间对应告警设备
        Map<String, DeviceSpaceBO> deviceSpaceBOMap = redisCache.getCacheMap(RedisConstant.SPACE_INCLUDE_DEVICE_CACHE);
        if (deviceSpaceBOMap == null){
            log.info("系统位置错误,清除告警信息获取相关设备失败");
            return ;
        }

        // 获取之前存储的已经告警的map
        Map<String, Boolean> cacheMap = redisCache.getCacheMap(RedisConstant.WARNING_FLAG);
        for (DataWarning dataWarning : dataWarningList) {
            String key = dataWarning.getSpaceId()
                    + dataWarning.getDeviceId()
                    + dataWarning.getDeviceFunctionType();
            // 覆盖掉之前的值
            cacheMap.put(key,false);
            DeviceSpaceBO deviceSpaceBO = deviceSpaceBOMap.get(dataWarning.getSpaceId().toString());
            if (deviceSpaceBO == null || deviceSpaceBO.getDeviceId() == null){
                log.error("获取空间对应的警告信息设备失败，空间id为{}",dataWarning.getSpaceId());
                continue;
            }
            // 清除警告信息
            milesightService.getKaAlertorService().manipulate(dataWarning.getGateWayId(),
                    deviceSpaceBO.getDeviceId(),
                    KaConstant.CONTROL_ALERTOR_STATE_OFF,
                    KaConstant.PORT);
        }
        // 更新缓存信息
        redisCache.setCacheMap(RedisConstant.WARNING_FLAG,cacheMap);
    }
}
