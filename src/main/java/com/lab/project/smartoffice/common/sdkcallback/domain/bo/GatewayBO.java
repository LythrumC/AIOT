package com.lab.project.smartoffice.common.sdkcallback.domain.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 陈宽
 * @create 2021-10-14 15:30
 * @description
 */
@Data
public class GatewayBO implements Serializable {
    /**
     * 网关id（平台回传）
     */
    @ApiModelProperty(value = "网关id")
    private String gatewayId;

    /**
     * 网关名称
     */
    @ApiModelProperty(value = "网关名称")
    private String gatewayName;

    /**
     * 网关型号（UG65、UG67等）
     */
    @ApiModelProperty(value = "网关型号，U=G65、UG67等")
    private String gatewayModel;
}
