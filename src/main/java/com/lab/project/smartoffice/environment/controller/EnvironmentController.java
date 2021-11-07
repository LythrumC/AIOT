package com.lab.project.smartoffice.environment.controller;

import com.lab.framework.web.domain.AjaxResult;
import com.lab.project.smartoffice.common.sdkcallback.domain.DataCollectionEntity;
import com.lab.project.smartoffice.environment.service.EnvironmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.annotation.Resources;

/**
 * @author 陈宽
 * @create 2021-11-02 9:51
 * @description
 */
@RestController
@RequestMapping("/smartOffice/environmentMonitor")
@AllArgsConstructor
public class EnvironmentController {

    @Resource
    private EnvironmentService environmentService;

    @GetMapping("/getSpaceIdAndDeviceId")
    public AjaxResult getSpaceIdAndDeviceId(){
        return AjaxResult.success(environmentService.getSpaceIdAndDeviceId());
    }

    @GetMapping("/getRedisSpaceInfo")
    public AjaxResult getRedisSpaceInfo(DataCollectionEntity dataCollectionEntity){
        return AjaxResult.success(environmentService.getRedisSpaceInfo(dataCollectionEntity));
    }

    @GetMapping("/listDataCollectionGraph")
    public AjaxResult listDataCollectionGraph(DataCollectionEntity dataCollectionEntity){
        return AjaxResult.success(environmentService.listDataCollectionGraph(dataCollectionEntity));

    }
}
