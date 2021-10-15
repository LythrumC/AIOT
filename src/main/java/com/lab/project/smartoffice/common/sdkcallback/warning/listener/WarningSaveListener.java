package com.lab.project.smartoffice.common.sdkcallback.warning.listener;

import com.lab.project.smartoffice.common.sdkcallback.warning.event.WarningSaveEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author 陈宽
 * @create 2021-10-15 15:11
 * @description
 */
@Component
@Slf4j
public class WarningSaveListener {

    @Order(1)
    @Async
    @EventListener(WarningSaveListener.class)
    public void warningSaveListener(WarningSaveEvent event){
        log.info("WarningSaveListener-----1");


    }

    @Order(2)
    @Async
    @EventListener(WarningSaveListener.class)
    public void warningSendMessageToSDK(WarningSaveEvent event){
        log.info("WarningSaveListener-----2");
    }
}
