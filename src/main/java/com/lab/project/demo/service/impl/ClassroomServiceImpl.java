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
    public PageInfo<ClassroomEntity> getPageInfo(String keyword) {
        // 1.调用PageHelper的静态方法开启分页功能
        // 这里充分体现了PageHelper的"非侵入"式设计：原本要做的的查询不必有任何修改

        // 2.执行查询
        List<ClassroomEntity> classroomEntities = classroomMapper.selectClassroomByKeyword(keyword);
//        System.out.println(admins);

        // 3.封装到PageInfo
        return new PageInfo<>(classroomEntities);
    }


}
