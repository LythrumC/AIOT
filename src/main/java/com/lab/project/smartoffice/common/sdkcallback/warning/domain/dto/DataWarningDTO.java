package com.lab.project.smartoffice.common.sdkcallback.warning.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lab.project.smartoffice.common.sdkcallback.warning.domain.DataWarning;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author 陈宽
 * @create 2021-10-21 17:00
 * @description
 */
@Data
public class DataWarningDTO extends DataWarning {
    private static final long serialVersionUID = 1L;
    /**
     * 告警数据id
     */
    private Long[] ids;

    /**
     * 处理开始时间
     */
    @ApiModelProperty(value = "处理开始时间" )
    @JsonIgnore
    private String processingBeginTime;

    /**
     * 处理结束时间
     */
    @ApiModelProperty(value = "处理结束时间" )
    @JsonIgnore
    private String processingEndTime;



}
