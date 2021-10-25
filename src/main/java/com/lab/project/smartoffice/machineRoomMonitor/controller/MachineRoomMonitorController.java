package com.lab.project.smartoffice.machineRoomMonitor.controller;

import com.lab.framework.web.controller.BaseController;
import com.lab.framework.web.domain.AjaxResult;
import com.lab.project.smartoffice.common.sdkcallback.domain.DataCollectionEntity;
import com.lab.project.smartoffice.machineRoomMonitor.service.impl.MachineRoomMonitorServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 陈宽
 * @create 2021-10-25 17:44
 * @description
 */
@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/smartOffice/machineRoomMonitor")
public class MachineRoomMonitorController extends BaseController {
    private MachineRoomMonitorServiceImpl machineRoomMonitorService;


    @GetMapping("/getRedisSpaceInfo")
    public AjaxResult getRedisSpaceInfo(DataCollectionEntity dataCollectionEntity){
        return AjaxResult.success(machineRoomMonitorService.getRedisSpaceInfo(dataCollectionEntity));
    }

    @GetMapping("/getRedisDeviceInfo")
    public AjaxResult getRedisDeviceInfo(DataCollectionEntity dataCollectionEntity){
        return AjaxResult.success(machineRoomMonitorService.getRedisDeviceInfo(dataCollectionEntity));
    }

}
