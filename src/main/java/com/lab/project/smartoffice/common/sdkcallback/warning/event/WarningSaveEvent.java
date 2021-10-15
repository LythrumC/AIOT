package com.lab.project.smartoffice.common.sdkcallback.warning.event;

import com.lab.project.smartoffice.common.sdkcallback.domain.DataCollectionEntity;
import lombok.Data;

/**
 * @author 陈宽
 * @create 2021-10-15 15:08
 * @description
 */
@Data
public class WarningSaveEvent {
    private DataCollectionEntity dataCollectionEntity;

    private Integer dataWarningType;

    public WarningSaveEvent(DataCollectionEntity dataCollectionEntity, Integer dataWarningType){
        this.dataCollectionEntity = dataCollectionEntity;
        this.dataWarningType = dataWarningType;
    }

}
