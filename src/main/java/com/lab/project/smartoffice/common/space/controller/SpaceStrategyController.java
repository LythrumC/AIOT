package com.lab.project.smartoffice.common.space.controller;

import com.lab.framework.web.controller.BaseController;
import com.lab.framework.web.domain.AjaxResult;
import com.lab.project.smartoffice.common.space.domain.dto.SpaceStrategyDTO;
import com.lab.project.smartoffice.common.space.service.ISpaceStrategyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * @author 陈宽
 * @create 2021-09-30 11:22
 * @description
 */
@RestController
@RequestMapping("/smartOffice/strategy")
public class SpaceStrategyController extends BaseController {
    @Resource
    private ISpaceStrategyService iSpaceStrategyService;

    @GetMapping("/list")
    public AjaxResult listSpaceStrategy(Long spaceId){
        return AjaxResult.success(iSpaceStrategyService.listSpaceStrategy(spaceId));
//        return AjaxResult.success(new ArrayList<>());
    }

    @PostMapping("/add")
    public AjaxResult addSpaceStrategy(@RequestBody SpaceStrategyDTO spaceStrategyDTO){
        return iSpaceStrategyService.addSpaceStrategy(spaceStrategyDTO);
    }

}
