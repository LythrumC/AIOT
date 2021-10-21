package com.lab.project.smartoffice.common.sdkcallback.warning.domain;

import com.lab.framework.web.domain.BaseEntity;
import com.lab.project.smartoffice.common.sdkcallback.domain.DataCollectionEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author 陈宽
 * @create 2021-10-18 15:00
 * @description
 */
@Data
public class DataWarning extends BaseEntity {
    /**
     * 序列化id
     */
    private static final long serialVersionUID = 1L;

    /**
     * 数据告警id
     */
    private Long id;

    /**
     * 数据采集ID
     */
    private Long dataCollectionId;

    /**
     * 告警类型
     */
    private Integer dataWarningType;

    /**
     * 告警类型名称
     */
    private String dataWarningTypeName;

    /**
     * 处理状态
     */
    private Integer processingStatus;

    /**
     * 空间id
     */
    private Long spaceId;

    private Integer spaceType;

    private String spaceTypeName;

    private String spaceName;

    private String spacePosition;

    private String spaceCapacity;

    private String spacePicUrl;

    private String gateWayId;

    private String gateWayName;

    private String gateWayModel;

    private String deviceId;

    /**
     * 设备名字
     */
    private String deviceName;

    @ApiModelProperty(value = "设备类型（10：AM107；20：EM300-SLD；30：VS121；40：WS50X；41：WS52X；42：WS301；60：UC1152数据透传-KA76B02报警器；100：UC1152数据采集）")
    private String deviceModel;

    /**
     * 设备类型
     */
    private Integer deviceType;

    private String deviceTypeName;

    /**
     * 设备坐标
     */
    private String devicePosition;

    /**
     * X轴坐标
     */
    private String devicePositionX;

    /**
     * Y轴坐标
     */
    private String devicePositionY;

    /**
     * Z轴坐标
     */
    private String devicePositionZ;

    /**
     * 设备图片url
     */
    private String devicePicUrl;

    /**
     * 设备长度
     */
    private Integer deviceLength;

    /**
     * 设备宽度
     */
    private Integer deviceWidth;

    /**
     * 设备高度
     */
    private Integer deviceHeight;

    private Long strategyId;

    /**
     * 策略名称
     */
    private String strategyName;

    /**
     * 策略是否启用
     */
    private String strategyIsEnable;

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
     * 设备功能类型
     * （
     * 1001：AM107-温度；
     * 1002：AM107-湿度；
     * 1003：AM107-红外_1/0；
     * 1004：AM107-光照；
     * 1005：AM107-二氧化碳；
     * 1006：AM107-TVOC；
     * 1007：AM107-大气压；
     * 1008：AM107-电量；
     * 2001：EM300-SLD-漏水检测_1/0；
     * 2002：EM300-SLD-温度；
     * 2003：EM300-SLD-湿度；EM300-SLD-电量；
     * 3001：VS121-人数统计；
     * 4001：WS50x-面板状态；
     * 4002：WS50x-按键控制；
     * 4101：WS52X-用电统计；
     * 4102：WS52X-开关控制；
     * 4201：WS301-开关状态_1/0；
     * 4202：WS301-拆卸状态_1/0；
     * 4203：WS301-电量；6001：UC1152-透传KA76B02报警器；
     * 10001：UC1152-采集RS485传感器
     * ）
     */
    @ApiModelProperty(value = "设备功能类型(1001：AM107-温度；1002：AM107-湿度；1003：AM107-红外_1/0；1004：AM107-光照；1005：AM107-二氧化碳；1006：AM107-TVOC；1007：AM107-大气压；1008：AM107-电量；2001：EM300-SLD-漏水检测_1/0；2002：EM300-SLD-温度；2003：EM300-SLD-湿度；EM300-SLD-电量；3001：VS121-人数统计；4001：WS50x-面板状态；4002：WS50x-按键控制；4101：WS52X-用电统计；4102：WS52X-开关控制；4201：WS301-开关状态_1/0；4202：WS301-拆卸状态_1/0；4203：WS301-电量；6001：UC1152-透传KA76B02报警器；10001：UC1152-采集RS485传感器)")
    private Integer deviceFunctionType;

    /**
     * 设备功能类型名称
     */
    @ApiModelProperty(value = "设备功能类型名称")
    private String deviceFunctionTypeName;

    /**
     * 具体功能的采集值，平台返回；有符号，个位为小数点后1位，数值除以10为实际值
     */
    @ApiModelProperty(value = "具体功能的采集值，平台返回；有符号，个位为小数点后1位，数值除以10为实际值")
    private Integer deviceFunctionData;

    /**
     * 序号
     */
    @ApiModelProperty(value = "序号")
    private Long sortNo;

    /**
     * 设备创建时间
     */
    @ApiModelProperty(value = "设备创建时间")
    private Date createTime;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private String createBy;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    /**
     * 更新人
     */
    @ApiModelProperty(value = "更新人")
    private String updateBy;

    /**
     * 版本号
     */
    @ApiModelProperty(value = "版本号")
    private Long version;

    /**
     * 删除状态(删除标记（0：未删除；2：已删除）
     */
    @ApiModelProperty(value = "删除状态(删除标记（0：未删除；2：已删除）")
    private String delFlag;


}
