package com.lab.project.demo.controller;

import com.github.pagehelper.PageInfo;
import com.lab.framework.web.domain.AjaxResult;
import com.lab.project.demo.domain.ClassroomEntity;
import com.lab.project.demo.service.ClassroomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ClassroomController {
    @Autowired
    private ClassroomService classroomService;

    @PostMapping("/add")
    public AjaxResult addClassroom(@RequestBody ClassroomEntity classroomEntity){
        Date date = new Date();
        String format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date);
        classroomEntity.setCreateTime(date);
        classroomEntity.setCreateBy("student");
        classroomEntity.setVersion(new Long(0));
        classroomEntity.setDelFlag("0");
        classroomService.addClassroom(classroomEntity);
        return AjaxResult.success("新增成功");
    }


    @GetMapping("/list")
    public AjaxResult selectAllClassroom(String classroomName){
        List<ClassroomEntity> classroomEntities = null;
        // 调用service方法获取PageInfo对象
        if (classroomName != null){
            classroomEntities = classroomService.selectAllClassroom(classroomName);
        } else {
            classroomEntities = classroomService.selectAllClassroom("");
        }
        System.out.println(classroomEntities);
        return AjaxResult.success("查询成功",classroomEntities);
    }


}
