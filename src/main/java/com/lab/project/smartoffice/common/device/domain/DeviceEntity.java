package com.lab.project.smartoffice.common.device.domain;

import com.lab.framework.web.domain.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author 陈宽
 * @create 2021-09-24 15:25
 * @description  设备实体类
 */
@Data
@AllArgsConstructor
@ToString
public class DeviceEntity extends BaseEntity {
    /**
     * 主键id
     */
    private String id;

    /**
     * 网关id
     */
    private String gatewayId;

    /**
     * 设备名字
     */
    private String deviceName;

    /**
     * 设备类型
     *   10：AM107；
     *   20：EM300-SLD；
     *   30：VS121；
     *   40：WS50x；
     *   41：WS52X；
     *   42：WS301；
     *   60：UC1152数据透传-KA76B02报警器；
     *   100：UC1152数据采集）
     */
    @ApiModelProperty(value = "设备类型（10：AM107；20：EM300-SLD；30：VS121；40：WS50X；41：WS52X；42：WS301；60：UC1152数据透传-KA76B02报警器；100：UC1152数据采集）")
    private String deviceModel;

    /**
     * 设备类型
     */
    private Integer deviceType;

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

    /**
     * 设备是否启用（0：未启用；1：启用）
     */
    private String deviceIsEnable;

    /**
     * 序号
     */
    private Long sortNo;

    /**
     * 设备创建时间
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

    public DeviceEntity() {
    }
}
