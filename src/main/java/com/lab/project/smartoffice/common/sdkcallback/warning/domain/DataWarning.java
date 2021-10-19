package com.lab.project.smartoffice.common.sdkcallback.warning.domain;

import com.lab.framework.web.domain.BaseEntity;
import com.lab.project.smartoffice.common.sdkcallback.domain.DataCollectionEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author 陈宽
 * @create 2021-10-18 15:00
 * @description
 */
@Data
public class DataWarning extends DataCollectionEntity {
    /**
     * 序列化id
     */
    private static final long serialVersionUID = 1L;

    /**
     * 数据采集ID
     */
    private Long dataCollectionId;

    /**
     * 告警类型
     */
    private Integer dataWarningType;

    /**
     * 告警类型名称
     */
    private String dataWarningTypeName;

    /**
     * 处理状态
     */
    private Integer processingStatus;
}
