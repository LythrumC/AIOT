package com.lab.project.smartoffice.common.sdkcallback.warning.enums;

import javax.print.attribute.standard.MediaSize;

/**
 * @author 陈宽
 * @create 2021-10-19 14:51
 * @description
 */
public enum LeakWaterStatus {
    LEAK_WATER_ON(1,"已漏水"),
    LEAK_WATER_OFF(0,"未漏水");


    Integer code;

    String message;

    LeakWaterStatus(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
