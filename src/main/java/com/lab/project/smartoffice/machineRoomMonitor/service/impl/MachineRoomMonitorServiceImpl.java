package com.lab.project.smartoffice.machineRoomMonitor.service.impl;

import com.lab.framework.aspectj.lang.annotation.Log;
import com.lab.framework.redis.RedisCache;
import com.lab.project.smartoffice.common.sdkcallback.domain.DataCollectionEntity;
import com.lab.project.smartoffice.common.sdkcallback.domain.DeviceFunctionDTO;
import com.lab.project.smartoffice.common.sdkcallback.domain.RedisData;
import com.lab.project.smartoffice.machineRoomMonitor.domain.vo.MachineRoomVo;
import com.lab.project.smartoffice.machineRoomMonitor.service.MachineRoomMonitorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author 陈宽
 * @create 2021-10-25 17:46
 * @description
 */
@Service
@AllArgsConstructor
@Slf4j
public class MachineRoomMonitorServiceImpl implements MachineRoomMonitorService {
    private RedisCache redisCache;
    @Override
    public MachineRoomVo getRedisSpaceInfo(DataCollectionEntity dataCollectionEntity) {
        log.info("MachineRoomMonitorServiceImpl=======" + dataCollectionEntity);

        Map<String, RedisData> cacheMap = redisCache.getCacheMap(String.valueOf(dataCollectionEntity.getSpaceId()));
        log.info("MachineRoomMonitorServiceImpl=====cacheMap============" + cacheMap);
        Iterator<Map.Entry<String, RedisData>> iterator = cacheMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, RedisData> next = iterator.next();
            RedisData value = next.getValue();
            // 遍历设备采集到的数据,过滤非报警数据
            Iterator<DeviceFunctionDTO> it = value.getDataList().iterator();
            while (it.hasNext()){
                DeviceFunctionDTO nx = it.next();
                if (!nx.getWarning()){
                    it.remove();
                }
            }
        }
        // 获取机房设备总数
        int deviceValue = cacheMap.size();
        // 正常设备数量
        int deviceNormalValue = 0;
        // 异常设备数量
        int deviceAbnormalValue = 0;
        HashMap<String, RedisData> newCacheMap = new HashMap<>();
        newCacheMap.putAll(cacheMap);
        Iterator<Map.Entry<String, RedisData>> iteratorNewCache = newCacheMap.entrySet().iterator();
        // 遍历获取
        while(iteratorNewCache.hasNext()){
            Map.Entry<String, RedisData> entry = iteratorNewCache.next();
            RedisData re = entry.getValue();
            if (CollectionUtils.isEmpty(re.getDataList())){
                deviceNormalValue++;
            }else {
                deviceAbnormalValue++;
            }
        }
        MachineRoomVo machineRoomVo = new MachineRoomVo();
        machineRoomVo.setRedisDataMap(cacheMap);
        machineRoomVo.setDeviceAbnormalValue(deviceAbnormalValue);
        machineRoomVo.setDeviceNormalValue(deviceNormalValue);
        machineRoomVo.setDeviceValue(deviceValue);
        log.info("MachineRoomMonitorServiceImpl=======MachineRoomVo" + machineRoomVo.toString());
        return machineRoomVo;
    }

    /**
     * 从redis中取出最新数据
     * @param dataCollectionEntity
     * @return
     */
    @Override
    public RedisData getRedisDeviceInfo(DataCollectionEntity dataCollectionEntity) {
        // 从Redis中获取最新数据
        Map<String, RedisData> cacheMap = redisCache.getCacheMap(String.valueOf(dataCollectionEntity.getSpaceId()));
        log.info("cacheMap.get(String.valueOf(dataCollectionEntity.getDeviceId()=={}" , cacheMap.get(String.valueOf(dataCollectionEntity.getDeviceId())));
        // 根据设备id获取最新数据
        return cacheMap.get(String.valueOf(dataCollectionEntity.getDeviceId()));
    }
}
