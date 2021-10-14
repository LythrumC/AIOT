package com.lab.project.smartoffice.common.datacollection.mapper;

import com.lab.project.smartoffice.common.sdkcallback.domain.DataCollectionEntity;

import java.util.List;

/**
 * @author 陈宽
 * @create 2021-10-14 15:42
 * @description
 */
public interface DataCollectionMapper {

    /**
     * 批量插入dataCollection到数据表中
     * @param dataCollectionEntityList
     */
    void insertBatch(List<DataCollectionEntity> dataCollectionEntityList);
}
