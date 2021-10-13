package com.lab.project.smartoffice.common.sdkcallback.domain;

import com.lab.framework.web.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author 陈宽
 * @create 2021-10-13 10:00
 * @description t_data_collection实体类
 */
@Data
@ApiModel(value = "数据采集实体")
public class DataCollectionEntity extends BaseEntity{
    /**
     * 序列化id
     */
    private static final long serialVersionUID = 1L;

    /**
     * 数据采集id
     */
    private Long id;

    /**
     * 空间id
     */
    @ApiModelProperty(value = "空间id")
    private Long spaceId;

    /**
     * 空间类型（10：机房；11：环境点；12：会议室）
     */
    @ApiModelProperty(value = "空间类型 1=0：机房；11：环境点；12：会议室")
    private Integer spaceType;

    /**
     * 空间类型名称
     */
    @ApiModelProperty(value = "空间类型名称")
    private String spaceTypeName;

    /**
     * 空间名称
     */
    @ApiModelProperty(value = "空间名称")
    private String spaceName;

    /**
     * 空间位置
     */
    @ApiModelProperty(value = "空间位置")
    private String spacePosition;

    /**
     * 空间容量（人）
     */
    @ApiModelProperty(value = "空间容量，人=")
    private Integer  spaceCapacity;

    /**
     * 空间图url
     */
    @ApiModelProperty(value = "空间图url")
    private String spacePicUrl;

    /**
     * 网关id（平台回传）
     */
    @ApiModelProperty(value = "网关id")
    private String gatewayId;

    /**
     * 网关名称
     */
    @ApiModelProperty(value = "网关名称")
    private String gatewayName;

    /**
     * 网关型号（UG65、UG67等）
     */
    @ApiModelProperty(value = "网关型号，U=G65、UG67等")
    private String gatewayModel;

    /**
     * 设备id（平台回传）
     */
    @ApiModelProperty(value = "设备id")
    private String deviceId;

    /**
     * 设备名称
     */
    @ApiModelProperty(value = "设备名称")
    private String deviceName;

    /**
     * 设备型号（如：AM107、EM300-SLD）
     */
    @ApiModelProperty(value = "设备型号，AM107、EM300-SLD")
    private String deviceModel;

    /**
     * 设备类型
     * （10：AM107；
     * 20：EM300-SLD；
     * 30：VS121；
     * 40：WS50x；
     * 41：WS52X；
     * 42：WS301；
     * 60：UC1152数据透传-KA76B02报警器；
     * 100：UC1152数据采集）
     */
    @ApiModelProperty(value = "设备型号，1=0：AM107；20：EM300-SLD；30：VS121；40：WS50x；41：WS52X；42：WS301；60：UC1152数据透传-KA76B02报警器；100：UC1152数据采集")
    private Integer deviceType;

    /**
     * 设备类型名称
     */
    @ApiModelProperty(value = "设备类型名称")
    private String deviceTypeName;

    /**
     * 设备在空间内位置（预留）
     */
    @ApiModelProperty(value = "设备在空间内位置（预留）")
    private String devicePosition;

    /**
     * 设备相对空间长度位置
     */
    @ApiModelProperty(value = "设备相对空间长度位置")
    private String devicePositionX;

    /**
     * 设备相对空间宽度位置
     */
    @ApiModelProperty(value = "设备相对空间宽度位置")
    private String devicePositionY;

    /**
     * 设备相对空间高度位置
     */
    @ApiModelProperty(value = "设备相对空间高度位置")
    private String devicePositionZ;

    /**
     * 设备图片url
     */
    @ApiModelProperty(value = "设备图片url")
    private String devicePicUrl;

    /**
     * 设备长度
     */
    @ApiModelProperty(value = "设备长度")
    private Integer deviceLength;

    /**
     * 设备宽度
     */
    @ApiModelProperty(value = "设备宽度")
    private Integer deviceWidth;

    /**
     * 设备高度
     */
    @ApiModelProperty(value = "设备高度")
    private Integer deviceHeight;

    /**
     * 空间策略id
     */
    @ApiModelProperty(value = "空间策略id")
    private Long strategyId;

    /**
     * 策略名称
     */
    @ApiModelProperty(value = "策略名称")
    private String strategyName;

    /**
     * 策略是否启用（0：未启用；1：启用）
     */
    @ApiModelProperty(value = "策略是否启用（0：未启用；1：启用）")
    private String strategyIsEnable;

    /**
     * 策略具体值，人数=0；漏水状态=1/0；有符号，个位为小数点后1位，数值除以10为实际值
     */
    @ApiModelProperty(value = "策略具体值，人数=0；漏水状态=1/0；有符号，个位为小数点后1位，数值除以10为实际值")
    private Integer strategyData;

    /**
     * 策略值小于，有符号，个位为小数点后1位，数值除以10为实际值
     */
    @ApiModelProperty(value = "策略值小于，有符号，个位为小数点后1位，数值除以10为实际值")
    private Integer strategyDataSmallerThan;

    /**
     * 策略值大于，有符号，个位为小数点后1位，数值除以10为实际值
     */
    @ApiModelProperty(value = "策略值大于，有符号，个位为小数点后1位，数值除以10为实际值")
    private Integer strategyDataBiggerThan;

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
