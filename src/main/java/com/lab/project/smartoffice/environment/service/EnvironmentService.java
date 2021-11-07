package com.lab.project.smartoffice.environment.service;

import com.lab.project.smartoffice.common.sdkcallback.domain.DataCollectionEntity;
import com.lab.project.smartoffice.common.sdkcallback.domain.RedisData;
import com.lab.project.smartoffice.common.space.domain.bo.SpaceDeviceBO;
import com.lab.project.smartoffice.machineRoomMonitor.domain.vo.MachineRoomVo;

import java.util.List;

/**
 * @author 陈宽
 * @create 2021-11-02 9:57
 * @description
 */
public interface EnvironmentService {

    List<SpaceDeviceBO> getSpaceIdAndDeviceId();

    RedisData getRedisSpaceInfo(DataCollectionEntity dataCollectionEntity);

    List<DataCollectionEntity> listDataCollectionGraph(DataCollectionEntity dataCollectionEntity);
}
