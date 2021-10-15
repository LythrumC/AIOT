package com.lab.project.smartoffice.common.sdkcallback.warning.handle;

import com.lab.project.smartoffice.common.sdkcallback.annotation.DeviceFunctionAnnotation;
import com.lab.project.smartoffice.common.sdkcallback.domain.DataCollectionEntity;
import com.lab.project.smartoffice.common.sdkcallback.handle.AbstractDeviceTypeHandler;
import com.lab.project.smartoffice.common.sdkcallback.warning.enums.StrategyEnable;
import com.lab.project.smartoffice.common.sdkcallback.warning.event.WarningSaveEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * @author 陈宽
 * @create 2021-10-15 15:31
 * @description
 */
@Slf4j
@Service
@AllArgsConstructor
@DeviceFunctionAnnotation("1001")
public class TemperatureHandler extends AbstractDeviceTypeHandler {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void saveWarining(DataCollectionEntity dataCollectionEntity) {
        log.info("进入到对应的处理方式");
        // 策略是否开启
        if (StrategyEnable.STRATEGY_ENABLE_OFF.equals(dataCollectionEntity.getStrategyIsEnable())){
            // 策略没有开启
            return ;
        }

        int result = dataCollectionEntity.getStrategyDataBiggerThan().compareTo(dataCollectionEntity.getDeviceFunctionData());
        if (result < 0){
            // 发送警告信息
            applicationEventPublisher.publishEvent(new WarningSaveEvent(dataCollectionEntity, dataCollectionEntity.getDeviceFunctionType()));
        }
    }
}
