package com.lab.project.smartoffice.common.sdkcallback.warning.controller;

import com.lab.framework.web.controller.BaseController;
import com.lab.framework.web.domain.AjaxResult;
import com.lab.framework.web.page.TableDataInfo;
import com.lab.project.smartoffice.common.sdkcallback.warning.domain.DataWarning;
import com.lab.project.smartoffice.common.sdkcallback.warning.domain.dto.DataWarningDTO;
import com.lab.project.smartoffice.common.sdkcallback.warning.service.DataWarningService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.PUT;

/**
 * @author 陈宽
 * @create 2021-10-21 16:48
 * @description
 */
@RestController
@RequestMapping("/smartOffice/dataWarning")
@AllArgsConstructor
@Slf4j
public class DataWarningController extends BaseController {
    private DataWarningService dataWarningService;

    @GetMapping("/list")
    public TableDataInfo list(DataWarningDTO dataWarningDTO){
        startPage();
//        log.info("dataWarningDTO=={}",dataWarningDTO.toString());
//        log.info("deviceName=={}",dataWarningDTO.getDeviceName());
//        log.info("dataWarningType=={}",dataWarningDTO.getDataWarningType());
//        log.info("processingStatus=={}",dataWarningDTO.getProcessingStatus());
//        log.info("beginTime=={}",dataWarningDTO.getBeginTime());
//        log.info("endTime=={}",dataWarningDTO.getEndTime());
//        log.info("spaceType=={}",dataWarningDTO.getSpaceType());

        return getDataTable(dataWarningService.list(dataWarningDTO));
    }

    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody DataWarningDTO dataWarningDTO){
        return dataWarningService.editDataWarning(dataWarningDTO);
    }

    @GetMapping("/statistics")
    public AjaxResult statistics(DataWarning dataWarning){
        return AjaxResult.success(dataWarningService.statistics(dataWarning));
    }

    @GetMapping("/analyze")
    public AjaxResult analyze(DataWarning dataWarning){
        return AjaxResult.success(dataWarningService.analyze(dataWarning));
    }
}
