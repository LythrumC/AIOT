package com.lab.project.smartoffice.common.space.domain.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 陈宽
 * @create 2021-10-13 11:18
 * @description
 */
@Data
public class SpaceDeviceBO implements Serializable {

    /**
     * 序列化id
     */
    private static final long serialVersionUID = 1L;

    /**
     * 空间名称
     */
    @ApiModelProperty(value = "空间名称")
    private String spaceName;

    /**
     * 空间类型（10：机房；11：环境点；12：会议室）
     */
    @ApiModelProperty(value = "空间类型 1=0：机房；11：环境点；12：会议室")
    private Integer spaceType;


    /**
     * 空间位置
     */
    @ApiModelProperty(value = "空间位置")
    private String spacePosition;

    /**
     * 空间容量（人）
     */
    @ApiModelProperty(value = "空间容量，人=")
    private Integer  spaceCapacity;

    /**
     * 空间图url
     */
    @ApiModelProperty(value = "空间图url")
    private String spacePicUrl;

    /**
     * 设备id（平台回传）
     */
    @ApiModelProperty(value = "设备id，平台回传")
    private String deviceId;

    /**
     * 空间id
     */
    @ApiModelProperty(value = "空间id")
    private Long spaceId;

    /**
     * 设备相对空间长度位置
     */
    @ApiModelProperty(value = "设备相对空间长度位置")
    private String devicePositionX;

    /**
     * 设备相对空间宽度位置
     */
    @ApiModelProperty(value = "设备相对空间宽度位置")
    private String devicePositionY;

    /**
     * 设备相对空间高度位置
     */
    @ApiModelProperty(value = "设备相对空间高度位置")
    private String devicePositionZ;

    /**
     * 设备在空间内位置（预留）
     */
    @ApiModelProperty(value = "设备在空间内位置（预留）")
    private String devicePosition;

}
