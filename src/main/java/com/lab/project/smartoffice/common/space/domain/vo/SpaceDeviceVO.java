package com.lab.project.smartoffice.common.space.domain.vo;

import com.lab.project.smartoffice.common.space.domain.SpaceDeviceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author 陈宽
 * @create 2021-09-29 10:12
 * @description
 */
@Data
public class SpaceDeviceVO extends SpaceDeviceEntity {
    /**
     * 设备名称
     */
    private String deviceName;

    /**
     * 设备类型
     */
    private String deviceType;

    /**
     * 设备图片url
     */
    private String devicePicUrl;

}
