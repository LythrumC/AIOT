package com.lab.project.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lab.common.utils.ParameterUtil;
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
        ParameterUtil.setCreateEntity(classroomEntity);
        int i = classroomMapper.addClassroom(classroomEntity);
        return i;
    }

    /**
     * 显示教室列表
     * @param classroomName
     * @return 教室列表
     */
    @Override
    public List<ClassroomEntity> selectAllClassroom(String classroomName) {
        List<ClassroomEntity> classroomEntities = classroomMapper.selectAllClassroom(classroomName);
        return classroomEntities;
    }

    /**
     * 显示教室详细信息
     * @param id 主键id
     * @return
     */
    @Override
    public ClassroomEntity selectClassroomById(Long id) {
        ClassroomEntity classroomEntity = classroomMapper.selectClassroomById(id);
        return classroomEntity;
    }

    /**
     * 更新教室信息
     * @param classroomEntity
     * @return
     */
    @Override
    public int update(ClassroomEntity classroomEntity) {
        classroomEntity.setUpdateBy("student");
        int i = classroomMapper.updateClassroom(classroomEntity);
        return i;
    }

    /**
     * 删除教室
     * @param ids
     * @return
     */
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
