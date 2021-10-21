package com.lab.project.smartoffice.common.constant;

/**
 * @author 陈宽
 * @create 2021-10-13 14:39
 * @description
 */
public class RedisConstant {
    /**
     * 设备空间关联的Redis key值
     */
    public static final String SPACE_DEVICE_CACHE_REDIS = "spaceDeviceRedis";

    /**
     * 设备关联的Redis key值
     */
    public static final String DEVICE_CACHE_REDIS = "DeviceRedis";

    /**
     * 空间策略关联的Redis key值
     */
    public static final String SPACE_STRATEGY_CACHE_REDIS = "SpaceStrategyRedis";

    /**
     * 设备中存储的信息关联的Redis Key值
     */
    public static final String DEVICE_FUNCTION_CACHE_REDIS = "DeviceFunctionRedis";

    /**
     * 设备方法和设备名称的关联关系redis key值
     */
    public static final String GATEWAY_CACHE_REDIS = "GatewayRedis";

    /**
     * 空间报警设备关联关系
     */
    public static final String SPACE_INCLUDE_DEVICE_CACHE = "spaceIncludeDeviceCache";

    /**
     * 告警标识
     */
    public static final String WARNING_FLAG = "warningFlag";

}
