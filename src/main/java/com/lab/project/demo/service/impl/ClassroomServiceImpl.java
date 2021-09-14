package com.lab.project.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lab.project.demo.domain.ClassroomEntity;
import com.lab.project.demo.mapper.ClassroomMapper;
import com.lab.project.demo.service.ClassroomService;
import com.lab.project.monitor.domain.SysJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 陈宽
 * @create 2021-09-13 11:01
 * @description
 */
@Service
public class ClassroomServiceImpl implements ClassroomService {
    @Resource
    private ClassroomMapper classroomMapper;

    /**
     * 新增教室信息
     * @param classroomEntity
     * @return
     */
    @Override
    public int addClassroom(ClassroomEntity classroomEntity) {
        Date date = new Date();
        String format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date);
        classroomEntity.setCreateTime(date);
        classroomEntity.setCreateBy("student");
        classroomEntity.setVersion(new Long(0));
        classroomEntity.setDelFlag("0");
        int i = classroomMapper.addClassroom(classroomEntity);
        return i;
    }

    @Override
    public List<ClassroomEntity> selectAllClassroom(String classroomName) {
        List<ClassroomEntity> classroomEntities = classroomMapper.selectAllClassroom(classroomName);
        return classroomEntities;
    }

    @Override
    public ClassroomEntity selectClassroomById(Long id) {
        ClassroomEntity classroomEntity = classroomMapper.selectClassroomById(id);
        return classroomEntity;
    }

    @Override
    public int update(ClassroomEntity classroomEntity) {
        classroomEntity.setUpdateBy("student");
        int i = classroomMapper.updateClassroom(classroomEntity);
        return i;
    }

    @Override
    public int removeClassroom(Long[] ids) {
        int i = 0;
        for (Long id : ids) {
            ClassroomEntity classroomEntity = classroomMapper.selectClassroomById(id);
             i = classroomMapper.deleteClassroom(id) + i;
        }
        return i;
    }


}
