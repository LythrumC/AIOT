package com.lab.project.smartoffice.common.sdkcallback.warning.domain.vo;

import lombok.Data;

/**
 * @author 陈宽
 * @create 2021-10-22 14:22
 * @description
 */
@Data
public class DataWarningVO {
    /**
     * 告警总数
     */
    private Integer alarmsValue;

    /**
     * 等待处理的告警
     */
    private Integer pendingValue;

    /**
     * 已处理的告警
     */
    private Integer processedValue;

    /**
     *
     */
    private Integer dataWarningType;

    /**
     * 告警类型数量
     */
    private Integer dataWarningValue;

}
