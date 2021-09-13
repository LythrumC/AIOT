package com.lab.project.demo.domain;

import com.lab.framework.web.domain.BaseEntity;
import com.sun.tracing.dtrace.ArgsAttributes;
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author 陈宽
 * @create 2021-09-13 10:06
 * @description
 */
@Data
@AllArgsConstructor
@ToString
public class ClassroomEntity extends BaseEntity {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 教室名字
     */
    private String classroomName;

    /**
     * 教室描述
     */
    private String content;

    /**
     * 教室容纳学生数量
     */
    private Integer classroomNum;

    /**
     * 序号
     */
    private Long sortNo;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 版本号
     */
    private Long version;

    /**
     * 删除标记(0:未删除; 2:已删除)
     */
    private String delFlag;

    public ClassroomEntity() {
    }
}
