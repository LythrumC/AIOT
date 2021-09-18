package com.lab.common.utils;

import com.lab.framework.web.domain.BaseEntity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 参数工具类
 *
 * @author wangdong
 * @date 2020.04.28
 */
public class ParameterUtil {

    /**
     * 通过传入id数组返回Map<String, Object>
     *
     * @param ids 传入id数组
     * @return Map
     */
    public static Map<String, Object> getBatchUpdateMapByIds(Long[] ids) {
        // 初始化map
        Map<String, Object> map = initMap();   //user,nowdate
        // 设置id数组
        map.put("ids" , ids);
        // 返回map
        return map;
    }

    /**
     * 设置创建基础字段
     *
     * @param t        泛型
     * @param operator 操作人（具体设备类型：box —— 盒子；gateway —— 人脸面板；verification —— 人证核验机）
     */
    public static <T extends BaseEntity> void setCreateEntity(T t, String operator) {
        // 获取当前时间
        Date date = DateUtils.getNowDate();
        // 设置创建时间
        t.setCreateTime(date);
        // 设置更新时间
        t.setUpdateTime(date);
        // 设置创建人
        t.setCreateBy(operator);
        // 设置更新人 
        t.setUpdateBy(operator);
        // 设置版本号
        t.setVersion(0L);
        // 设置序号
        t.setSortNo(0L);
        // 设置未删除
        t.setDelFlag("0");
    }

    /**
     * 设置创建基础字段
     *
     * @param t 泛型
     */
    public static <T extends BaseEntity> void setCreateEntity(T t) {
        // 获取当前时间
        Date date = DateUtils.getNowDate();
        // 获取当前登录人用户名
        String userName = t.getCreateBy() == null ? SecurityUtils.getUsername() : t.getCreateBy();
        // 设置创建时间
        t.setCreateTime(date);
        // 设置创建人
        t.setCreateBy(userName);    
        // 设置更新时间
        t.setUpdateTime(date);
        // 设置更新人
        t.setUpdateBy(userName);
        // 设置版本号
        t.setVersion(0L);
        // 设置序号
        t.setSortNo(0L);
        // 设置未删除
        t.setDelFlag("0" );
    }

    /**
     * 设置更新基础字段
     *
     * @param t 泛型
     */
    public static <T extends BaseEntity> void setUpdateEntity(T t) {
        // 获取当前时间
        Date date = DateUtils.getNowDate();
        // 获取当前登录人用户名
        String userName = t.getCreateBy() == null ? SecurityUtils.getUsername() : t.getCreateBy();
        // 设置更新时间
        t.setUpdateTime(date);
        // 设置更新人
        t.setUpdateBy(userName);
    }

    /**
     * 初始化返回参数Map<String, Object>
     *
     * @return 返回参数
     */
    private static Map<String, Object> initMap() {
        // 定义Map
        Map<String, Object> map = new HashMap<>(16);
        // 设置更新时间
        map.put("time" , DateUtils.getNowDate());
        // 设置更新人
        map.put("user" , SecurityUtils.getUsername());
        return map;
    }

    /**
     * 设置后台更新基础字段
     *
     * @param t 泛型
     */
    public static <T extends BaseEntity> void setUpdateEntityByMachine(T t) {
        // 获取当前时间
        Date date = DateUtils.getNowDate();
        // 设置更新时间
        t.setUpdateTime(date);
        // 设置更新人
        t.setUpdateBy("machine");
    }

    /**
     * 设置创建基础字段
     *
     * @param t 泛型
     */
    public static <T extends BaseEntity> void setMachineCreateEntity(T t) {
        // 获取当前时间
        Date date = DateUtils.getNowDate();
        // 获取当前登录人用户名
        String userName = "machine";
        // 设置创建时间
        t.setCreateTime(date);
        // 设置创建人
        t.setCreateBy(userName);
        // 设置未删除
        t.setDelFlag("0");
        // 设置更新时间
        t.setUpdateTime(date);
        // 设置更新人
        t.setUpdateBy(userName);
        // 设置版本号
        t.setVersion(0L);
        // 设置序号
        t.setSortNo(0L);
    }

}
