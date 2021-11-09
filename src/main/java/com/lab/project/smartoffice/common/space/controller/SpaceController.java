package com.lab.project.smartoffice.common.space.controller;

import com.lab.framework.web.controller.BaseController;
import com.lab.framework.web.domain.AjaxResult;
import com.lab.framework.web.page.TableDataInfo;
import com.lab.project.smartoffice.common.space.domain.SpaceEntity;
import com.lab.project.smartoffice.common.space.service.ISpaceService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author 陈宽
 * @create 2021-09-24 10:04
 * @description
 */
@RestController
@RequestMapping("/smartOffice/space" )
@AllArgsConstructor
@Slf4j
public class SpaceController extends BaseController {

    private ISpaceService spaceService;

    @PostMapping("/add")
    public AjaxResult addSpace(@RequestBody SpaceEntity spaceEntity){
        return toAjax(spaceService.addSpace(spaceEntity));
    }

    @GetMapping("/list")
    public TableDataInfo getSpaceList(String spaceType, String spaceName, String spacePosition){
        startPage();
        log.info("spaceName=={},spacePosition=={}",spaceName,spacePosition);
        return getDataTable( spaceService.getSpaceList(spaceType, spaceName, spacePosition));
    }

    @PutMapping("/remove" )
    public AjaxResult removeClassroom(@RequestBody SpaceEntity spaceEntity){
         return toAjax(spaceService.removeSpace(spaceEntity));
    }

    @PutMapping("/edit")
    public AjaxResult editClassroom(@RequestBody SpaceEntity spaceEntity){
        return toAjax(spaceService.updateSpace(spaceEntity));
    }



}
