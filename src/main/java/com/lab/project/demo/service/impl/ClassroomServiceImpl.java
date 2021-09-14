package com.lab.project.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lab.project.demo.domain.ClassroomEntity;
import com.lab.project.demo.mapper.ClassroomMapper;
import com.lab.project.demo.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
        int i = classroomMapper.addClassroom(classroomEntity);
        return i;
    }

    @Override
    public List<ClassroomEntity> selectAllClassroom(String classroomName) {
        List<ClassroomEntity> classroomEntities = classroomMapper.selectAllClassroom(classroomName);
        return classroomEntities;
    }


}
