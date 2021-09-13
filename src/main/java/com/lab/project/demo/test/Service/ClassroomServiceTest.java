package com.lab.project.demo.test.Service;

import com.lab.LabApplication;
import com.lab.common.utils.ParameterUtil;
import com.lab.project.demo.domain.ClassroomEntity;
import com.lab.project.demo.mapper.ClassroomMapper;
import com.lab.project.demo.service.ClassroomService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 陈宽
 * @create 2021-09-13 11:53
 * @description
 */
public class ClassroomServiceTest {

    @Autowired
    private ClassroomService classroomService;

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
        int i = classroomService.addClassroom(classroomEntity);
        System.out.println(i);
    }
}
