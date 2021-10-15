package com.lab.project.smartoffice.common.sdkcallback.annotation;

import java.lang.annotation.*;

/**
 * @author 陈宽
 * @create 2021-10-15 15:16
 * @description
 */
@Target(ElementType.TYPE)
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface DeviceFunctionAnnotation {
    String value();
}
