package com.lab.project.smartoffice.common.sdkcallback.warning.handle;

import com.lab.project.smartoffice.common.sdkcallback.annotation.DeviceFunctionAnnotation;
import com.lab.project.smartoffice.common.sdkcallback.domain.DataCollectionEntity;
import com.lab.project.smartoffice.common.sdkcallback.handle.AbstractDeviceTypeHandler;
import com.lab.project.smartoffice.common.sdkcallback.warning.enums.LeakWaterStatus;
import com.lab.project.smartoffice.common.sdkcallback.warning.enums.StrategyEnable;
import com.lab.project.smartoffice.common.sdkcallback.warning.event.WarningSaveEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * @author 陈宽
 * @create 2021-10-19 14:49
 * @description
 */
@Slf4j
@Service
@AllArgsConstructor
@DeviceFunctionAnnotation("2001")
public class LeakWaterHandler extends AbstractDeviceTypeHandler {
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void saveWarining(DataCollectionEntity dataCollectionEntity) {
        // 策略未开启
        if (StrategyEnable.STRATEGY_ENABLE_OFF.getCode().equals(dataCollectionEntity.getStrategyIsEnable())){
            return;
        }

        // 策略开启
        if (LeakWaterStatus.LEAK_WATER_ON.getCode().equals(dataCollectionEntity.getDeviceFunctionData())){
            // 发送警告信息
            applicationEventPublisher.publishEvent(new WarningSaveEvent(dataCollectionEntity,dataCollectionEntity.getDeviceFunctionType()));

        }


    }
}
