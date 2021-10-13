package com.lab.project.smartoffice.common.sdkcallback.service;

import com.lab.common.utils.ParameterUtil;
import com.lab.common.utils.bean.BeanUtils;
import com.lab.framework.redis.RedisCache;
import com.lab.project.smartoffice.common.constant.RedisConstant;
import com.lab.project.smartoffice.common.device.domain.bo.DeviceBO;
import com.lab.project.smartoffice.common.device.mapper.DeviceMapper;
import com.lab.project.smartoffice.common.sdkcallback.domain.CallBackDTO;
import com.lab.project.smartoffice.common.sdkcallback.domain.DataCollectionEntity;
import com.lab.project.smartoffice.common.sdkcallback.domain.DeviceFunctionDTO;
import com.lab.project.smartoffice.common.space.domain.bo.SpaceDeviceBO;
import com.lab.project.smartoffice.common.space.mapper.SpaceDeviceMapper;
import com.lab.project.smartoffice.common.space.mapper.SpaceMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 陈宽
 * @create 2021-10-13 11:19
 * @description
 */
@Service
@Slf4j
@AllArgsConstructor
public class DataHandlerService {

    private SpaceMapper spaceMapper;

    private DeviceMapper deviceMapper;

    private RedisCache redisCache;


    /**
     * 将回传的数据保存进数据库
     * 将space和device分别查询分装进BO后再保存
     * @param callBackDTO
     */
    public void handleDataParam(CallBackDTO callBackDTO){
        // 获取设备id
        String deviceId = callBackDTO.getDeviceEui();
        // 1.获取Space相关信息
        Map<String, SpaceDeviceBO> spaceDeviceBOMap = initSpaceDeviceRedis();
        // 2.获取device相关信息
        Map<String, DeviceBO> deviceBOMap = initDeviceRedis();
        // 通过deviceID作为KEY值，拿到spaceBO和deviceBO数据
        SpaceDeviceBO spaceDeviceBO = spaceDeviceBOMap.get(deviceId);
        if (spaceDeviceBO == null){
            log.info("获取设备绑定空间信息失败，设备id为{}",deviceId);
            return ;
        }
        DeviceBO deviceBO = deviceBOMap.get(deviceId);
        // 准备一个DataCollectionList收集整合space和device后的数据
        List<DataCollectionEntity> dataCollectionEntityList = new ArrayList<>();
        // 传输回来的数据(deviceFunctionData 和 deviceFunctionType)
        List<DeviceFunctionDTO> deviceFunctionDTOList = callBackDTO.getDataList();
        // 遍历回传集合收集到dataCollection中
        if (deviceFunctionDTOList != null && deviceFunctionDTOList.size() != 0){
            for (DeviceFunctionDTO deviceFunctionDTO : deviceFunctionDTOList) {
                // Datacollection收集数据
                DataCollectionEntity dataCollectionEntity = new DataCollectionEntity();
                // 属性拷贝，把SpaceDeviceBO中的属性拷贝到dataCollection中
                BeanUtils.copyProperties(spaceDeviceBO,dataCollectionEntity);
                // 属性拷贝，把deviceBO中的属性拷贝的dataCollection中
                BeanUtils.copyProperties(deviceBO,dataCollectionEntity);
                // 填充dataCollection基本属性
                dataCollectionEntity.setCreateBy("系统创建");
                ParameterUtil.setCreateEntity(dataCollectionEntity);
                dataCollectionEntityList.add(dataCollectionEntity);
            }
        }
        // 批量插入到数据库



    }

    /**
     * 从Redis取出Space相关信息封装进SpaceDeviceBO
     * @return
     */
    public Map<String, SpaceDeviceBO> initSpaceDeviceRedis(){
        // 1.直接从redis中获取
        Map<String, SpaceDeviceBO> spaceDeviceRedis = redisCache.getCacheMap(RedisConstant.SPACE_DEVICE_REDIS);
        // 2.判断从Redis取出的数据是否存在
        if (spaceDeviceRedis.size() == 0 ){
            // 2.1如果没有数据，则从数据库中获取
            spaceDeviceRedis = spaceMapper.getSpaceDeviceMap();
            // 2.1将存储的结果放进Redis
            redisCache.setCacheMap(RedisConstant.SPACE_DEVICE_REDIS,spaceDeviceRedis);

        }
        // 3.返回查询结果
        return spaceDeviceRedis;
    }

    /**
     * 从Redis取出Device相关信息封装进DeviceBO
     * @return
     */
    public Map<String, DeviceBO> initDeviceRedis(){
        // 1.直接从Redis中获取
        Map<String, DeviceBO> deviceBOMap = redisCache.getCacheMap(RedisConstant.DEVICE_REDIS);
        // 2.判断从Redis取出的数据是否存在
        if (deviceBOMap.size() == 0){
            // 2.1如果没有数据，则从数据库中获取
            deviceBOMap = deviceMapper.getDeviceMap();
            // 2.1将存储的结果放进Redis
            redisCache.setCacheMap(RedisConstant.SPACE_DEVICE_REDIS,deviceBOMap);
        }
        // 返回数据
        return deviceBOMap;

    }
}
