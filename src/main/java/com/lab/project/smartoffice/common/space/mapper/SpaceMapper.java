package com.lab.project.smartoffice.common.space.mapper;

import com.lab.project.smartoffice.common.space.domain.SpaceEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 陈宽
 * @create 2021-09-24 10:35
 * @description
 */
public interface SpaceMapper {

    /**
     * 插入空间信息
     * @param spaceEntity
     * @return
     */
    Integer insertSpace(SpaceEntity spaceEntity);

    List<SpaceEntity> getSpaceList(@Param("spaceType") String spaceType);

    /**
     * 删除空间信息
     * @param spaceEntity
     * @return
     */
    Integer removeSpace(SpaceEntity spaceEntity);

    /**
     * 更新空间信息
     * @param spaceEntity
     * @return
     */
    Integer updateSpace(SpaceEntity spaceEntity);
}
