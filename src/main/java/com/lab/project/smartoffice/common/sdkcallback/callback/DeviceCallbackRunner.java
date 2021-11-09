package com.lab.project.smartoffice.common.sdkcallback.callback;

import com.alibaba.fastjson.JSON;
import com.lab.project.smartoffice.common.sdkcallback.domain.CallBackDTO;
import com.lab.project.smartoffice.common.sdkcallback.service.DataHandlerService;
import com.neusiri.ai.api.yitu.milesight.callback.runner.MilesightCallbackRunner;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.activation.DataHandler;
import java.util.Map;

/**
 * @author 陈宽
 * @create 2021-10-09 11:38
 * @description   设备获取信息后，回调信息
 */
@Component
@Slf4j
@AllArgsConstructor
public class DeviceCallbackRunner implements MilesightCallbackRunner {

    private DataHandlerService dataHandlerService;

    @Override
    public void execute(Map params) {
        log.info("进入回调,接收到参数:" + params);
        CallBackDTO callBackDTO = JSON.parseObject(JSON.toJSONString(params),CallBackDTO.class);
        log.info(callBackDTO.toString());
        if (callBackDTO != null && callBackDTO.getDataList().size() > 0){
            log.info("处理业务");
            // TODO 处理业务
            dataHandlerService.handleDataParam(callBackDTO);
        } else {
            // 忽略消息，输入日志
            log.info("接收到没有数据的回调，忽略消息，设备id为:{}",callBackDTO.getDeviceEui());
        }
    }
}
