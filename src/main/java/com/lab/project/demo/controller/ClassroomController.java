package com.lab.project.demo.controller;

import com.github.pagehelper.PageInfo;
import com.lab.common.exception.job.TaskException;
import com.lab.framework.aspectj.lang.annotation.Log;
import com.lab.framework.web.controller.BaseController;
import com.lab.framework.web.domain.AjaxResult;
import com.lab.framework.web.page.TableDataInfo;
import com.lab.project.demo.domain.ClassroomEntity;
import com.lab.project.demo.service.ClassroomService;
import com.lab.project.monitor.domain.SysJob;
import lombok.extern.slf4j.Slf4j;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.ObjectStreamClass;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 陈宽
 * @create 2021-09-13 10:04
 * @description
 */

@RestController
@RequestMapping("/demo/classroom" )
@Slf4j
public class ClassroomController extends BaseController {
    @Autowired
    private ClassroomService classroomService;

    @PostMapping("/add")
    public AjaxResult addClassroom(@RequestBody ClassroomEntity classroomEntity){
        classroomService.addClassroom(classroomEntity);
        return AjaxResult.success("新增成功");
    }


    @GetMapping("/list")
    public TableDataInfo selectAllClassroom(String classroomName){
        List<ClassroomEntity> classroomEntities = null;
        // 调用service方法获取PageInfo对象
        if (classroomName != null){
            classroomEntities = classroomService.selectAllClassroom(classroomName);
        } else {
            classroomEntities = classroomService.selectAllClassroom("");
        }
//        System.out.println(classroomEntities);
        return getDataTable(classroomEntities);
    }

    @GetMapping("/getInfo/{id}")
    public AjaxResult getInfoClassroom(@PathVariable("id")Long id){
        ClassroomEntity classroomEntity = classroomService.selectClassroomById(id);
        return AjaxResult.success(classroomEntity);
    }

    @PutMapping("/edit")
    public AjaxResult editClassroom(@RequestBody ClassroomEntity classroomEntity){
        return classroomService.update(classroomEntity);
    }

    @DeleteMapping("/delete/{ids}" )
    public AjaxResult removeClassroom(@PathVariable Long[] ids){
        return  classroomService.removeClassroom(ids);
    }




}
