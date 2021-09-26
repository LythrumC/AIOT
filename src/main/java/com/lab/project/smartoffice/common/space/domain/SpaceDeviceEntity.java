package com.lab.project.smartoffice.common.space.domain;

import com.lab.framework.web.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author 陈宽
 * @create 2021-09-26 10:48
 * @description
 */
@Data
@AllArgsConstructor
@ToString
public class SpaceDeviceEntity extends BaseEntity {
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
     * 设备id
     */
    private String deviceId;

    /**
     * 设备坐标
     */
    private String deivcePosition;

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
    private String deivcePositionZ;

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

    public SpaceDeviceEntity() { }
}
