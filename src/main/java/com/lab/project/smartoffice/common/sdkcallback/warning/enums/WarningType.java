package com.lab.project.smartoffice.common.sdkcallback.warning.enums;

/**
 * @author 陈宽
 * @create 2021-10-18 15:26
 * @description
 */
public enum WarningType {
    /**
     * 温度异常
     */
    TEMPERATURE_WARNING(1001,"温度异常"),

    /**
     * 二氧化碳异常
     */
    CARBON_WARNING(1005,"二氧化碳超标"),

    /**
     * TVOC超标
     */
    TVOC_WARNING(1006,"TVOC超标"),

    /**
     * 漏水
     */
    LEAK_WATER_WARNING(2001,"漏水");


    Integer code;

    String warningTypeName;

    WarningType(Integer code, String warningTypeName){
        this.code = code;
        this.warningTypeName = warningTypeName;
    }

    public Integer getCode(){
        return code;
    }

    public String getWarningTypeName(){
        return warningTypeName;
    }

    public static String getWarningTypeNameByCode(Integer code){
        for(WarningType warningType : WarningType.values()){
            if (code.equals(warningType.getCode())){
                return warningType.getWarningTypeName();
            }
        }
        return null;
    }
}
