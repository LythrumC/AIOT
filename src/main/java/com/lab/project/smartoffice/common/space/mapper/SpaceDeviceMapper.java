package com.lab.project.smartoffice.common.space.mapper;

import com.lab.project.smartoffice.common.device.domain.DeviceEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 陈宽
 * @create 2021-09-26 11:03
 * @description  SpaceDeviceMapper文件接口
 */
public interface SpaceDeviceMapper {
    /**
     * 查询所有报警器
     * @param deviceType
     * @return
     */
    List<DeviceEntity> listWarningDevices(@Param("deviceType") String deviceType);

    /**
     *
     * @param deviceType
     * @return
     */
    List<DeviceEntity> listNoUse(@Param("deviceType") String deviceType);

    /**
     * 列表显示当前Space存在的告警器
     * @param id
     * @return
     */
    List<DeviceEntity> list(@Param("id") Long id);
}
