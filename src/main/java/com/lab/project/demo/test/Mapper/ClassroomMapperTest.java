package com.lab.project.demo.test.Mapper;

import com.lab.LabApplication;
import com.lab.common.utils.ParameterUtil;
import com.lab.framework.aspectj.lang.annotation.Log;
import com.lab.framework.web.domain.AjaxResult;
import com.lab.project.demo.domain.ClassroomEntity;
import com.lab.project.demo.mapper.ClassroomMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 陈宽
 * @create 2021-09-13 11:25
 * @description
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LabApplication.class)//这里的Application是springboot的启动类名
@WebAppConfiguration
public class ClassroomMapperTest {
    @Autowired
    private ClassroomMapper classroomMapper;

    @Test
    public void addClassroomTest(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        ClassroomEntity classroomEntity = new ClassroomEntity(
                null,
                "AIOT",
                "AIOT实验室",
                45,
                null,
                date,
                "陈宽",
                null,
                null,
                new Long(1),
                "0");
        ParameterUtil.setCreateEntity(classroomEntity);
        int i = classroomMapper.addClassroom(classroomEntity);
        System.out.println(i);
    }

    @Test
    public void selectAllClassroom(){
        List<ClassroomEntity> classroomEntities = classroomMapper.selectAllClassroom("AIOT");
        System.out.println(classroomEntities);

    }

}
