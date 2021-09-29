package com.lab.project.smartoffice.common.space.test;

import com.lab.LabApplication;
import com.lab.project.demo.mapper.ClassroomMapper;
import com.lab.project.smartoffice.common.device.domain.DeviceEntity;
import com.lab.project.smartoffice.common.space.domain.SpaceDeviceEntity;
import com.lab.project.smartoffice.common.space.domain.dto.SpaceDeviceDto;
import com.lab.project.smartoffice.common.space.mapper.SpaceDeviceMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 陈宽
 * @create 2021-09-27 11:54
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LabApplication.class)//这里的Application是springboot的启动类名
@WebAppConfiguration
public class SpaceDeviceMapperTest {

    @Autowired
    private SpaceDeviceMapper spaceDeviceMapper;

    @Test
    public void TestSpaceDeviceMapper_removeSpaceDevice(){
//        List<SpaceDeviceEntity> list = spaceDeviceMapper.list(new Long(1));
//        for (SpaceDeviceEntity spaceDeviceEntity : list) {
//            System.out.println(spaceDeviceEntity.toString());
//        }


    }
}
