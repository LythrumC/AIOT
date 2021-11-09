package com.lab.project.smartoffice.common.sdkcallback.warning.mapper;

import com.lab.project.smartoffice.common.sdkcallback.warning.domain.DataWarning;
import com.lab.project.smartoffice.common.sdkcallback.warning.domain.dto.DataWarningDTO;
import com.lab.project.smartoffice.common.sdkcallback.warning.domain.vo.DataWarningVO;

import java.util.List;

/**
 * @author 陈宽
 * @create 2021-10-18 15:42
 * @description
 */
public interface DataWarningMapper {
    /**
     * 保存告警信息
     * @param dataWarning
     */
    void saveDataWarning(DataWarning dataWarning);

    /**
     * 查询告警信息
     * @param dataWarningDTO
     * @return
     */
    List<DataWarning> selectDataWarning(DataWarningDTO dataWarningDTO);

    int editDataWarning(DataWarningDTO dataWarningDTO);

    DataWarningVO statistics(DataWarning dataWarning);

    List<DataWarningVO> analyze(DataWarning dataWarning);
}
