package com.lab.project.smartoffice.common.space.service.Impl;

import com.lab.common.utils.ParameterUtil;
import com.lab.project.smartoffice.common.sdkcallback.runner.ClearRedis;
import com.lab.project.smartoffice.common.space.domain.SpaceEntity;
import com.lab.project.smartoffice.common.space.mapper.SpaceMapper;
import com.lab.project.smartoffice.common.space.service.ISpaceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 陈宽
 * @create 2021-09-24 10:06
 * @description
 */
@Service
public class ISpaceServiceImpl implements ISpaceService {

    @Resource
    private SpaceMapper spaceMapper;

    @Resource
    private ClearRedis clearRedis;

    /**
     * 新增教室
     * @param spaceEntity
     * @return 影响行数
     */
    @Override
    public Integer addSpace(SpaceEntity spaceEntity) {
        ParameterUtil.setCreateEntity(spaceEntity);
        Integer result = spaceMapper.insertSpace(spaceEntity);
        return result;
    }

    /**
     * 返回space列表
     * @param spaceType
     * @return
     */
    @Override
    public List<SpaceEntity> getSpaceList(String spaceType) {
        return spaceMapper.getSpaceList(spaceType);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer removeSpace(SpaceEntity spaceEntity) {
        ParameterUtil.setUpdateEntity(spaceEntity);
        // 清除Redis缓存
        clearRedis.clearRedisCache();
        return spaceMapper.removeSpace(spaceEntity);

    }

    /**
     * 更新空间信息
     * @param spaceEntity
     * @return
     */
    @Override
    public Integer updateSpace(SpaceEntity spaceEntity) {
        ParameterUtil.setUpdateEntity(spaceEntity);
        Integer result = spaceMapper.updateSpace(spaceEntity);
        return result;
    }
}
