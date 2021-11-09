package com.lab.project.smartoffice.common.sdkcallback.warning.service;

import com.lab.framework.web.domain.AjaxResult;
import com.lab.project.smartoffice.common.sdkcallback.warning.domain.DataWarning;
import com.lab.project.smartoffice.common.sdkcallback.warning.domain.dto.DataWarningDTO;
import com.lab.project.smartoffice.common.sdkcallback.warning.domain.vo.DataWarningVO;

import javax.xml.crypto.Data;
import java.util.List;

/**
 * @author 陈宽
 * @create 2021-10-21 16:49
 * @description
 */

public interface DataWarningService {
    /**
     * 根据条件筛选告警信息
     * @param DataWarningDTO
     * @return
     */
    List<DataWarning> list(DataWarningDTO DataWarningDTO);

    AjaxResult editDataWarning(DataWarningDTO dataWarningDTO);

    DataWarningVO statistics(DataWarning dataWarning);

    List<DataWarningVO> analyze(DataWarning dataWarning);
}
