package com.lab.project.smartoffice.common.space.service.Impl;

import com.lab.framework.web.domain.AjaxResult;
import com.lab.project.smartoffice.common.device.domain.DeviceEntity;
import com.lab.project.smartoffice.common.space.mapper.SpaceDeviceMapper;
import com.lab.project.smartoffice.common.space.service.ISpaceDeviceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 陈宽
 * @create 2021-09-26 11:02
 * @description  ISpaceService接口实现
 */
@Service
@AllArgsConstructor
public class ISpaceDeviceServiceImpl implements ISpaceDeviceService {

    private SpaceDeviceMapper spaceDeviceMapper;
    /**
     * 查询所有声光报警器
     * @param deviceType
     * @return
     */
    @Override
    public List<DeviceEntity> listWarningDevice(String deviceType) {
        List<DeviceEntity> deviceEntities = spaceDeviceMapper.listWarningDevices(deviceType);
        return deviceEntities;
    }

    /**
     * 查询指定型号的告警设备
     * @param deviceType
     * @return
     */
    @Override
    public List<DeviceEntity> listNoUse(String deviceType) {
        List<DeviceEntity> deviceEntities = spaceDeviceMapper.listNoUse(deviceType);
        return deviceEntities;
    }

    /**
     * 列表显示当前Space存在的高警器
     * @param id
     * @return
     */
    @Override
    public List<DeviceEntity> list(Long id) {
        List<DeviceEntity> list = spaceDeviceMapper.list(id);
        return list;
    }

    /**
     * 给当前spcae空间添加告警器
     * @param spaceId
     * @return
     */
    @Override
    public Integer addSpaceDevice(DeviceEntity deviceEntity) {
        return null;
    }
}
