package com.lab.project.smartoffice.machineRoomMonitor.service;

import com.lab.project.smartoffice.common.sdkcallback.domain.DataCollectionEntity;
import com.lab.project.smartoffice.common.sdkcallback.domain.RedisData;
import com.lab.project.smartoffice.machineRoomMonitor.domain.vo.MachineRoomVo;

/**
 * @author 陈宽
 * @create 2021-10-25 17:46
 * @description
 */
public interface MachineRoomMonitorService {
    MachineRoomVo getRedisSpaceInfo(DataCollectionEntity dataCollectionEntity);

    RedisData getRedisDeviceInfo(DataCollectionEntity dataCollectionEntity);
}
