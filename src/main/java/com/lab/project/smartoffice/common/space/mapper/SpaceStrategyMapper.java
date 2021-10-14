package com.lab.project.smartoffice.common.space.mapper;

import com.lab.project.smartoffice.common.space.domain.SpaceDeviceEntity;
import com.lab.project.smartoffice.common.space.domain.SpaceStrategyEntity;
import com.lab.project.smartoffice.common.space.domain.bo.SpaceStrategyBO;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 陈宽
 * @create 2021-10-02 14:08
 * @description
 */
public interface SpaceStrategyMapper {
    /**
     * 添加策略
     * @param strategyEntityList
     */
    void addSpaceStrategy(@Param("strategyEntityList") List<SpaceStrategyEntity> strategyEntityList);


    void removeSpaceDevice(@Param("spaceId") Long spaceId);

    /**
     * 查询这个空间正在使用的策略
     * @param spaceId
     * @return
     */
    List<SpaceStrategyEntity> listSpaceStrategy(@Param("spaceId") Long spaceId);

    @MapKey("spaceUnionStrategy")
    Map<String, SpaceStrategyBO> getSpaceStrategyMap();
}
