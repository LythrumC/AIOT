package com.lab.project.smartoffice.common.sdkcallback.warning.domain.dto;

import com.lab.project.smartoffice.common.sdkcallback.warning.domain.DataWarning;
import lombok.Data;

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


}
