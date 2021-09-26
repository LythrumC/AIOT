package com.lab.project.smartoffice.common.space.service;

import com.lab.framework.web.domain.AjaxResult;
import com.lab.project.smartoffice.common.device.domain.DeviceEntity;

import java.util.List;

/**
 * @author 陈宽
 * @create 2021-09-26 11:01
 * @description  SpaceDevice服务层接口
 */
public interface ISpaceDeviceService {
    /**
     * 查询没有使用的告警设备
     * @param deviceType
     * @return
     */
    List<DeviceEntity> listWarningDevice(String deviceType);

    /**
     * 查询指定告警设备
     * @param deviceType
     * @return
     */
    List<DeviceEntity> listNoUse(String deviceType);

    /**
     * 列表显示出当前Space存在的告警器
     * @param id
     * @return
     */
    List<DeviceEntity> list(Long id);

    Integer addSpaceDevice(DeviceEntity deviceEntity);
}
