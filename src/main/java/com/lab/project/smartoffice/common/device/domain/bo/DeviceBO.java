package com.lab.project.smartoffice.common.device.domain.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 陈宽
 * @create 2021-10-13 15:51
 * @description
 */
@Data
public class DeviceBO {
    /**
     * 设备id（平台回传）
     */
    @ApiModelProperty(value = "设备id")
    private String deviceId;

    /**
     * 设备名称
     */
    @ApiModelProperty(value = "设备名称")
    private String deviceName;

    /**
     * 设备型号（如：AM107、EM300-SLD）
     */
    @ApiModelProperty(value = "设备型号，AM107、EM300-SLD")
    private String deviceModel;

    /**
     * 设备类型
     * （10：AM107；
     * 20：EM300-SLD；
     * 30：VS121；
     * 40：WS50x；
     * 41：WS52X；
     * 42：WS301；
     * 60：UC1152数据透传-KA76B02报警器；
     * 100：UC1152数据采集）
     */
    @ApiModelProperty(value = "设备型号，1=0：AM107；20：EM300-SLD；30：VS121；40：WS50x；41：WS52X；42：WS301；60：UC1152数据透传-KA76B02报警器；100：UC1152数据采集")
    private Integer deviceType;

    /**
     * 设备类型名称
     */
    @ApiModelProperty(value = "设备类型名称")
    private String deviceTypeName;

    /**
     * 设备图片url
     */
    @ApiModelProperty(value = "设备图片url")
    private String devicePicUrl;

    /**
     * 设备长度
     */
    @ApiModelProperty(value = "设备长度")
    private Integer deviceLength;

    /**
     * 设备宽度
     */
    @ApiModelProperty(value = "设备宽度")
    private Integer deviceWidth;

    /**
     * 设备高度
     */
    @ApiModelProperty(value = "设备高度")
    private Integer deviceHeight;
}
