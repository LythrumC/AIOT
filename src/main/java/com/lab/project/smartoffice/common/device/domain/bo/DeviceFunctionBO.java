package com.lab.project.smartoffice.common.device.domain.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 陈宽
 * @create 2021-10-14 14:46
 * @description
 */
@Data
public class DeviceFunctionBO implements Serializable {
    /**
     * 序列化id
     */
    private static final long serialVersionUID = 1L;

    /**
     * 设备功能类型
     * （
     * 1001：AM107-温度；
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
     * 10001：UC1152-采集RS485传感器
     * ）
     */
    // 有问题
    @ApiModelProperty(value = "设备功能类型(1001：AM107-温度；1002：AM107-湿度；1003：AM107-红外_1/0；1004：AM107-光照；1005：AM107-二氧化碳；1006：AM107-TVOC；1007：AM107-大气压；1008：AM107-电量；2001：EM300-SLD-漏水检测_1/0；2002：EM300-SLD-温度；2003：EM300-SLD-湿度；EM300-SLD-电量；3001：VS121-人数统计；4001：WS50x-面板状态；4002：WS50x-按键控制；4101：WS52X-用电统计；4102：WS52X-开关控制；4201：WS301-开关状态_1/0；4202：WS301-拆卸状态_1/0；4203：WS301-电量；6001：UC1152-透传KA76B02报警器；10001：UC1152-采集RS485传感器)")
    private String deviceFunctionType;

    /**
     * 设备功能类型名称
     */
    @ApiModelProperty(value = "设备功能类型名称")
    private String deviceFunctionTypeName;
}
