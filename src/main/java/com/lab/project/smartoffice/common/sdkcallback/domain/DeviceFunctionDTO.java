package com.lab.project.smartoffice.common.sdkcallback.domain;

import lombok.Data;
import lombok.ToString;

/**
 * @author 陈宽
 * @create 2021-10-11 11:32
 * @description
 */
@Data
@ToString
public class DeviceFunctionDTO {
    /**
     * 对应功能回传数值，就是设备实际监测到的值
     */
    private Integer deviceFunctionData;

    /**
     * 设备功能类型
     * （1001：AM107-温度；
     * 1002：AM107-湿度；
     * 1003：AM107-红外_1/0；
     * 1004：AM107-光照；
     * 1005：AM107-二氧化碳；
     * 1006：AM107-TVOC；
     * 1007：AM107-大气压；
     * 1008：AM107-电量；
     * 2001：EM300-SLD-漏水检测_1/0；
     * 2002：EM300-SLD-温度；
     * 2003：EM300-SLD-湿度；EM300-SLD-电量；
     * 3001：VS121-人数统计；
     * 4001：WS50x-面板状态；
     * 4002：WS50x-按键控制；
     * 4101：WS52X-用电统计；
     * 4102：WS52X-开关控制；
     * 4201：WS301-开关状态_1/0；
     * 4202：WS301-拆卸状态_1/0；
     * 4203：WS301-电量；6001：UC1152-透传KA76B02报警器；
     * 10001：UC1152-采集RS485传感器）
     */
    private Integer deviceFunctionType;

    /**
     * 方法名称
     */
    private String deviceFunctionName;

    /**
     * 是否报警
     */
    private Boolean warning;
}
