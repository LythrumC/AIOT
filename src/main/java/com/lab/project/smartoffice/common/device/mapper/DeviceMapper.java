package com.lab.project.smartoffice.common.device.mapper;

import com.lab.project.smartoffice.common.device.domain.bo.DeviceBO;
import com.lab.project.smartoffice.common.device.domain.bo.DeviceFunctionBO;
import com.lab.project.smartoffice.common.sdkcallback.domain.bo.GatewayBO;
import org.apache.ibatis.annotations.MapKey;

import java.util.Map;

/**
 * @author 陈宽
 * @create 2021-10-13 16:04
 * @description
 */
public interface DeviceMapper {
    /**
     * 从t_Device表中取出device信息，封装到Map中
     * @return
     */
    @MapKey("deviceId")
    Map<String, DeviceBO> getDeviceMap();

    @MapKey("deviceFunctionType")
    Map<String, DeviceFunctionBO> getDeviceFunctionMap();

    @MapKey("gatewayId")
    Map<String, GatewayBO> getGatewayMap();
}
