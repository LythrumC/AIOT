package com.lab.project.smartoffice.common.sdkcallback.warning.event;

import com.lab.project.smartoffice.common.sdkcallback.domain.DataCollectionEntity;
import lombok.Data;
import lombok.ToString;

/**
 * @author 陈宽
 * @create 2021-10-15 15:08
 * @description
 */
@Data
@ToString
public class WarningSaveEvent {
    private DataCollectionEntity dataCollectionEntity;

    private Integer dataWarningType;

    private Boolean IsHavingWarning;

    public WarningSaveEvent(DataCollectionEntity dataCollectionEntity, Integer dataWarningType) {
        this.dataCollectionEntity = dataCollectionEntity;
        this.dataWarningType = dataWarningType;
    }

    public WarningSaveEvent(DataCollectionEntity dataCollectionEntity, Integer dataWarningType, boolean IsHavingWarning) {
        this.dataCollectionEntity = dataCollectionEntity;
        this.dataWarningType = dataWarningType;
        this.IsHavingWarning = IsHavingWarning;
    }


}
