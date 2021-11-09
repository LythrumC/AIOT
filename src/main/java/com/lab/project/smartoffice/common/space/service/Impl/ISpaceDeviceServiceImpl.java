package com.lab.project.smartoffice.common.space.service.Impl;

import com.lab.common.utils.ParameterUtil;
import com.lab.framework.redis.RedisCache;
import com.lab.framework.web.domain.AjaxResult;
import com.lab.project.smartoffice.common.device.domain.DeviceEntity;
import com.lab.project.smartoffice.common.sdkcallback.runner.ClearRedis;
import com.lab.project.smartoffice.common.space.domain.SpaceDeviceEntity;
import com.lab.project.smartoffice.common.space.domain.dto.SpaceDeviceDto;
import com.lab.project.smartoffice.common.space.mapper.SpaceDeviceMapper;
import com.lab.project.smartoffice.common.space.service.ISpaceDeviceService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import javax.swing.*;
import java.util.List;

/**
 * @author 陈宽
 * @create 2021-09-26 11:02
 * @description  ISpaceService接口实现
 */
@Service
@AllArgsConstructor
@Slf4j
public class ISpaceDeviceServiceImpl implements ISpaceDeviceService {

    @Resource
    private SpaceDeviceMapper spaceDeviceMapper;

    @Resource
    private RedisCache redisCache;

    @Resource
    private ClearRedis clearRedis;
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
    public List<DeviceEntity> listNoUse(String deviceType, String deviceName) {
//        log.info("deviceType=={},deviceName=={}",deviceName,deviceType);
        List<DeviceEntity> deviceEntities = spaceDeviceMapper.listNoUse(deviceType,deviceName);
        return deviceEntities;
    }

    /**
     * 列表显示当前Space存在的高警器
     * @param id
     * @return
     */
    @Override
    public List<SpaceDeviceEntity> list(Long id) {
        List<SpaceDeviceEntity> list = spaceDeviceMapper.list(id);
        return list;
    }

    /**
     * 给当前空间Space添加设备
     * @param spaceDeviceDto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public AjaxResult addSpaceDevice(SpaceDeviceDto spaceDeviceDto) {
        // 1.释放使用的设备
        Long spaceId = spaceDeviceDto.getSpaceId();
        List<SpaceDeviceEntity> spaceDeviceList = spaceDeviceDto.getSpaceDeviceList();
        List<SpaceDeviceEntity> list = spaceDeviceMapper.list(spaceId);
        if (list.size() > 0){ spaceDeviceMapper.removeSpaceDevice(spaceId); }

        // 清除Redis缓存
        clearRedis.clearRedisCache();
        redisCache.deleteObject(String.valueOf(spaceDeviceDto.getSpaceId()));

        log.info("spaceDeviceList===={}",spaceDeviceList.size());

        if (spaceDeviceList.size() != 0 && spaceDeviceList != null){
            // 2.判断设备是否被使用
            Integer results = spaceDeviceMapper.noUseDeviceInSpace(spaceDeviceList);
            // 3.新增设备
            if (results == 0){
                if (spaceDeviceList != null && spaceDeviceList.size() > 0){
                    // 设置基础属性
                    for (SpaceDeviceEntity spaceDeviceEntity : spaceDeviceList) { ParameterUtil.setCreateEntity(spaceDeviceEntity); }
                    // 添加设备
                    spaceDeviceMapper.addSpaceDevice(spaceDeviceList);
                } else { AjaxResult.error("请选择要添加的设备"); }
            } else {
                // 设备被占用，手动回滚
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return AjaxResult.error("该设备被占用,无法添加");
            }
        } else {
            return AjaxResult.error("没有选择设备");
        }

        return AjaxResult.success("添加成功");
    }



}
