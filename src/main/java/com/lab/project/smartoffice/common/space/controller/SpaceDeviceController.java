package com.lab.project.smartoffice.common.space.controller;

import com.lab.framework.web.controller.BaseController;
import com.lab.framework.web.domain.AjaxResult;
import com.lab.framework.web.page.TableDataInfo;
import com.lab.project.smartoffice.common.device.domain.DeviceEntity;
import com.lab.project.smartoffice.common.space.service.ISpaceDeviceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 陈宽
 * @create 2021-09-24 15:35
 * @description
 */
@RestController
@RequestMapping("/smartOffice/spaceDevice")
@AllArgsConstructor
public class SpaceDeviceController extends BaseController {

    private ISpaceDeviceService spaceDeviceService;

    /**
     * 列表显示报警器信息
     * @param deviceType
     * @return
     */
    @GetMapping("/listWarningDevice")
    public AjaxResult listWarningDevice(String deviceType){
        return AjaxResult.success(spaceDeviceService.listWarningDevice(deviceType));
    }


    /**
     * 查询执行型号告警器·
     * @param deviceType
     * @return
     */
    @GetMapping("/listNoUse")
    public AjaxResult listNoUse(String deviceType){
        return AjaxResult.success(spaceDeviceService.listNoUse(deviceType));
    }

    /**
     * 显示当前Space使用的传感器
     * @param spaceId
     * @return
     */
    @GetMapping("/list")
    public AjaxResult list(Long spaceId){
        return AjaxResult.success(spaceDeviceService.list(spaceId));
    }
}
