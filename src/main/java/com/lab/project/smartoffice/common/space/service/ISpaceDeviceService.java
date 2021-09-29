package com.lab.project.smartoffice.common.space.service;

import com.lab.framework.web.domain.AjaxResult;
import com.lab.project.smartoffice.common.device.domain.DeviceEntity;
import com.lab.project.smartoffice.common.space.domain.SpaceDeviceEntity;
import com.lab.project.smartoffice.common.space.domain.dto.SpaceDeviceDto;

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
    List<DeviceEntity> listNoUse(String deviceType, String deviceName);

    /**
     * 列表显示出当前Space存在的告警器
     * @param id
     * @return
     */
    List<SpaceDeviceEntity> list(Long id);

    /**
     * 给当前是Space空间添加设备
     * @param spaceDeviceDto
     * @return
     */
    AjaxResult addSpaceDevice(SpaceDeviceDto spaceDeviceDto);



}
