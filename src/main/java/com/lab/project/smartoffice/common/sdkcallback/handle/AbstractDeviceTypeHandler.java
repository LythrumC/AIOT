package com.lab.project.smartoffice.common.sdkcallback.handle;

import com.lab.project.smartoffice.common.sdkcallback.domain.DataCollectionEntity;

/**
 * @author 陈宽
 * @create 2021-10-15 14:34
 * @description
 */
public abstract class AbstractDeviceTypeHandler {
    /**
     * 保存警告信息的抽象方法统一参数格式
     * @param dataCollectionEntity
     */
    abstract public void saveWarining(DataCollectionEntity dataCollectionEntity);
}
