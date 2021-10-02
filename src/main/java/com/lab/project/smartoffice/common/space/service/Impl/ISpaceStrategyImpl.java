package com.lab.project.smartoffice.common.space.service.Impl;

import com.lab.common.utils.ParameterUtil;
import com.lab.framework.web.domain.AjaxResult;
import com.lab.project.smartoffice.common.space.domain.SpaceDeviceEntity;
import com.lab.project.smartoffice.common.space.domain.SpaceStrategyEntity;
import com.lab.project.smartoffice.common.space.domain.dto.SpaceStrategyDTO;
import com.lab.project.smartoffice.common.space.mapper.SpaceStrategyMapper;
import com.lab.project.smartoffice.common.space.service.ISpaceStrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 陈宽
 * @create 2021-10-02 14:07
 * @description
 */
@Service
public class ISpaceStrategyImpl implements ISpaceStrategyService {
    @Resource
    private SpaceStrategyMapper spaceStrategyMapper;

    /**
     * 添加策略
     * @param spaceStrategyDTO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public AjaxResult addSpaceStrategy(SpaceStrategyDTO spaceStrategyDTO) {
        try {
            // 1.清空之前的策略
            Long spaceId = spaceStrategyDTO.getSpaceId();
            List<SpaceStrategyEntity> spaceStrategyEntities = spaceStrategyDTO.getSpaceStrategyList();
            List<SpaceStrategyEntity> list = spaceStrategyMapper.listSpaceStrategy(spaceId);
            if (list.size() > 0){ spaceStrategyMapper.removeSpaceDevice(spaceId); }

            // 2.新增设备
            if (!CollectionUtils.isEmpty(spaceStrategyEntities)){
                for (SpaceStrategyEntity spaceStrategyEntity : spaceStrategyEntities) {
                    // 添加基础属性
                    ParameterUtil.setCreateEntity(spaceStrategyEntity);
                }
                spaceStrategyMapper.addSpaceStrategy(spaceStrategyEntities);
            }
        }catch(Exception e) {
            // 设备被占用，手动回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return AjaxResult.error("策略添加失败");
        }
        return AjaxResult.success("策略添加成功");
    }

    @Override
    public List<SpaceStrategyEntity> listSpaceStrategy(Long spaceId) {
        return spaceStrategyMapper.listSpaceStrategy(spaceId);
    }
}
