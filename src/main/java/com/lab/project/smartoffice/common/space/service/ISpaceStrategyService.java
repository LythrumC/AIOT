package com.lab.project.smartoffice.common.space.service;

import com.lab.framework.web.domain.AjaxResult;
import com.lab.project.smartoffice.common.space.domain.SpaceStrategyEntity;
import com.lab.project.smartoffice.common.space.domain.dto.SpaceStrategyDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 陈宽
 * @create 2021-10-02 14:06
 * @description
 */
@Service
public interface ISpaceStrategyService {
    /**
     * 添加策略
     * @param spaceStrategyDTO
     */
    AjaxResult addSpaceStrategy(SpaceStrategyDTO spaceStrategyDTO);

    List<SpaceStrategyEntity> listSpaceStrategy(Long spaceId);

}
