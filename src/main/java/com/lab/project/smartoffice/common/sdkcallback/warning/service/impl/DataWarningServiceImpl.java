package com.lab.project.smartoffice.common.sdkcallback.warning.service.impl;

import com.lab.common.utils.ParameterUtil;
import com.lab.framework.aspectj.lang.annotation.Log;
import com.lab.framework.web.domain.AjaxResult;
import com.lab.project.smartoffice.common.sdkcallback.warning.domain.DataWarning;
import com.lab.project.smartoffice.common.sdkcallback.warning.domain.dto.DataWarningDTO;
import com.lab.project.smartoffice.common.sdkcallback.warning.domain.vo.DataWarningVO;
import com.lab.project.smartoffice.common.sdkcallback.warning.event.WarningClearEvent;
import com.lab.project.smartoffice.common.sdkcallback.warning.listener.WarningClearListener;
import com.lab.project.smartoffice.common.sdkcallback.warning.mapper.DataWarningMapper;
import com.lab.project.smartoffice.common.sdkcallback.warning.service.DataWarningService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.List;

/**
 * @author 陈宽
 * @create 2021-10-21 16:49
 * @description
 */
@Service
@Slf4j
@AllArgsConstructor
public class DataWarningServiceImpl implements DataWarningService {

    private DataWarningMapper dataWarningMapper;

    private ApplicationEventPublisher applicationEventPublisher;

    /**
     * 根据条件筛选、显示告警信息
     * @param dataWarningDTO
     * @return
     */
    @Override
    public List<DataWarning> list(DataWarningDTO dataWarningDTO) {
        List<DataWarning> dataWarningList = dataWarningMapper.selectDataWarning(dataWarningDTO);
        log.info("selectDataWarning=={}",dataWarningList);
        return dataWarningList;
    }

    @Override
    public AjaxResult editDataWarning(DataWarningDTO dataWarningDTO) {
        // 1.修改数据库相关内容
        ParameterUtil.setUpdateEntity(dataWarningDTO);
        // TODO 2.清除Redis缓存信息  3.发送指令给报警器(异步)
        applicationEventPublisher.publishEvent(new WarningClearEvent(dataWarningDTO.getIds()));
        int result = dataWarningMapper.editDataWarning(dataWarningDTO);
        if (result < 0){
            AjaxResult.error("乐观锁触发,修改失败");
        }
        return AjaxResult.success("操作成功");
    }

    @Override
    public DataWarningVO statistics(DataWarning dataWarning) {
        return dataWarningMapper.statistics(dataWarning);
    }

    @Override
    public List<DataWarningVO> analyze(DataWarning dataWarning) {
        return dataWarningMapper.analyze(dataWarning);
    }
}
