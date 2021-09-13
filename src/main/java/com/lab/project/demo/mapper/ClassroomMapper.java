package com.lab.project.demo.mapper;

import com.lab.project.demo.domain.ClassroomEntity;

import java.util.List;

/**
 * @author 陈宽
 * @create 2021-09-12 17:31
 * @description
 */
public interface ClassroomMapper {

    /**
     * 新增教室信息
     * @param classroomEntity
     * @return
     */
    public int addClassroom(ClassroomEntity classroomEntity);

    /**
     * Dao接口，分页查询
     * @param keyword
     * @return
     */
    List<ClassroomEntity> selectClassroomByKeyword(String keyword);


}
