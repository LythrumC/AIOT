package com.lab.project.smartoffice.common.space.domain.dto;

import com.lab.project.smartoffice.common.device.domain.DeviceEntity;
import com.lab.project.smartoffice.common.space.domain.SpaceDeviceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author 陈宽
 * @create 2021-09-27 10:54
 * @description DTO，专门接受前端request里的数据
 */
@Data
@AllArgsConstructor
@ToString
public class SpaceDeviceDto{
    /**
     * 空间名称
     */
    private Long spaceId;

    /**
     * 传回的设备列表
     */
    private List<SpaceDeviceEntity> spaceDeviceList;
}
