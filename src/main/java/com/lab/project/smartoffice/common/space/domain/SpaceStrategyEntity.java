package com.lab.project.smartoffice.common.space.domain;

import com.lab.framework.web.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author 陈宽
 * @create 2021-09-30 11:15
 * @description
 */
@Data
@AllArgsConstructor
@ToString
public class SpaceStrategyEntity extends BaseEntity {
    /**
     * 序列化id
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 空间id
     */
    private Long spaceId;

    /**
     * 策略名称
     */
    private String strategyName;

    /**
     * 策略是否启用
     */
    private String strategyIsEnable;

    /**
     * 设备功能类型
     * （1001：AM107-温度；
     * 1002：AM107-湿度；
     * 1003：AM107-红外_1/0；
     * 1004：AM107-光照；
     * 1005：AM107-二氧化碳；
     * 1006：AM107-TVOC；
     * 1007：AM107-大气压；
     * 1008：AM107-电量；
     * 2001：EM300-SLD-漏水检测_1/0；
     * 2002：EM300-SLD-温度；
     * 2003：EM300-SLD-湿度；
     * EM300-SLD-电量；
     * 3001：VS121-人数统计；
     * 4001：WS50x-面板状态；
     * 4002：WS50x-按键控制；
     * 4101：WS52X-用电统计；
     * 4102：WS52X-开关控制；
     * 4201：WS301-开关状态_1/0；
     * 4202：WS301-拆卸状态_1/0；
     * 4203：WS301-电量；
     * 6001：UC1152-透传KA76B02报警器；
     * 10001：UC1152-采集RS485传感器）
     */
    private int deviceFunctionType;

    /**
     * 策略具体指
     */
    private int strategyData;

    /**
     * 策略值小于，有符号，个位为小数点后1位，数值除以10为实际值
     */
    private int strategyDataSmallerThan;

    /**
     * 策略值大于，有符号，个位为小数点后1位，数值除以10为实际值
     */
    private int strategyDataBiggerThan;

    /**
     * 序号
     */
    private Long sortNo;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 版本号
     */
    private Long version;

    /**
     * 删除状态(删除标记（0：未删除；2：已删除）)
     */
    private String delFlag;

    public SpaceStrategyEntity() { }
}
