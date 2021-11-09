package com.lab.project.smartoffice.common.space.service;

import com.lab.framework.web.domain.AjaxResult;
import com.lab.project.smartoffice.common.space.domain.SpaceEntity;

import java.util.List;

/**
 * @author 陈宽
 * @create 2021-09-24 10:07
 * @description
 */

public interface ISpaceService {
    /**
     * 新增教室
     * @param spaceEntity
     * @return
     */
    Integer addSpace(SpaceEntity spaceEntity);

    /**
     * 显示空间列表
     * @param spaceType
     * @return
     */
    List<SpaceEntity> getSpaceList(String spaceType, String spaceName, String spacePosition);

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
