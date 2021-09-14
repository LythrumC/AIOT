package com.lab.project.demo.service;

import com.github.pagehelper.PageInfo;
import com.lab.project.demo.domain.ClassroomEntity;

import java.util.List;

/**
 * @author 陈宽
 * @create 2021-09-13 10:59
 * @description
 */
public interface ClassroomService {

    /**
     * 
     * @param classroomEntity
     * @return
     */
    public int addClassroom(ClassroomEntity classroomEntity);

    /**
     * 列表显示所有教室信息
     * @return
     */
    public List<ClassroomEntity> selectAllClassroom(String classroomName);

}
