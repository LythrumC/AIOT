package com.lab.project.smartoffice.machineRoomMonitor.domain.vo;

import com.lab.project.smartoffice.common.sdkcallback.domain.RedisData;
import lombok.Data;

import java.util.Map;

/**
 * @author 陈宽
 * @create 2021-10-25 17:49
 * @description
 */
@Data
public class MachineRoomVo {
    private Integer deviceAbnormalValue;
    private Integer deviceNormalValue;
    private Integer deviceValue;
    private Map<String, RedisData> redisDataMap;
}
