package com.lab.project.smartoffice.common.space.domain;

import com.lab.framework.web.domain.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author 陈宽
 * @create 2021-09-24 10:08
 * @description
 */
@Data
@AllArgsConstructor
@ToString
public class SpaceEntity extends BaseEntity {

    /**
     * 序列化id
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 空间类型
     */
    @ApiModelProperty(value = "空间类型（10：机房；11：环境点；12：会议室）")
    private Integer spaceType;

    /**
     * 空间名称
     */
    private String spaceName;

    /**
     * 空间位置
     */
    private String spacePosition;

    /**
     * 空间可容纳人数
     */
    private Integer spaceCapacity;

    /**
     * 空间是否可用
     */
    private String spaceIsEnable;

    /**
     * 空间URL地址
     */
    private String spacePicUrl;

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

    /**
     * 无参构造器
     */
    public SpaceEntity() { }
}
