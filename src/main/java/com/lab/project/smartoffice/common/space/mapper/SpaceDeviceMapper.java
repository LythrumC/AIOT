package com.lab.project.smartoffice.common.space.mapper;

import com.lab.project.smartoffice.common.device.domain.DeviceEntity;
import com.lab.project.smartoffice.common.space.domain.SpaceDeviceEntity;
import com.lab.project.smartoffice.common.space.domain.dto.SpaceDeviceDto;
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
    List<DeviceEntity> listNoUse(@Param("deviceType") String deviceType, @Param("deviceName")String deviceName);

    /**
     * 列表显示当前Space存在的告警器
     * @param id
     * @return
     */
    List<SpaceDeviceEntity> list(@Param("id") Long id);

    /**
     * 给当前Space空间添加设备
     * @param spaceDeviceEntityList
     * @return
     */
    void addSpaceDevice(@Param("spaceDeviceEntityList") List<SpaceDeviceEntity> spaceDeviceEntityList);

    /**
     * 释放当前空间设备
     * @param spaceId
     * @return
     */
    Integer removeSpaceDevice(@Param("spaceId") Long spaceId);

    /**
     * ]在当前Space空间查找是否有设备在使用
     * @param spaceDeviceEntityList
     * @return
     */
    Integer noUseDeviceInSpace(@Param("spaceDeviceEntityList") List<SpaceDeviceEntity> spaceDeviceEntityList);

}
