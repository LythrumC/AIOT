package com.lab.project.smartoffice.common.sdkcallback.domain;

import lombok.Data;

import java.util.List;

/**
 * @author 陈宽
 * @create 2021-10-11 11:19
 * @description
 */
@Data
public class CallBackDTO {
    /**
     *  网关id
     */
    private String geteWayEui;

    /**
     *  设备id
     */
    private String deviceEui;

    /**
     *  回调数据
     */
    private List<DeviceFunctionDTO> dataList;


}
