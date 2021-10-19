package com.lab.project.smartoffice.common.sdkcallback.warning.enums;

/**
 * @author 陈宽
 * @create 2021-10-15 14:37
 * @description
 */
public enum StrategyEnable {

    STRATEGY_ENABLE_OFF("0", "策略已关闭"), STRATEGY_ENABLE_ON("1", "策略已开启闭");



    /**
     * 是否开启策略描述
     */
    private String message;
    /**
     * 策略开启状态码
     */
    private String code;

    StrategyEnable(String code, String message){
        this.code = code;
        this.message = message;
    };

    public String getCode(){
        return code;
    }


}
