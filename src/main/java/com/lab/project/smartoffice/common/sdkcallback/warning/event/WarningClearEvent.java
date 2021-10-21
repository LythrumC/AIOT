package com.lab.project.smartoffice.common.sdkcallback.warning.event;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 陈宽
 * @create 2021-10-21 17:10
 * @description
 */
@Data
@AllArgsConstructor
public class WarningClearEvent {
    private Long[] ids;
}
