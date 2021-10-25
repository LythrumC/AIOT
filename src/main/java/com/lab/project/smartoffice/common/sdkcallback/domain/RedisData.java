package com.lab.project.smartoffice.common.sdkcallback.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author 陈宽
 * @create 2021-10-25 17:55
 * @description 将前端传回的数据进行缓存
 */
@Data
public class RedisData implements Serializable {
    /**
     * 序列化id
     */
    private static final long serialVersionUID = 1L;

    private List<DeviceFunctionDTO> dataList;

    private String deviceId;

    private String deviceName;

    private String devicePicUrl;

    private String spaceId;
}
