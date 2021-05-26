package com.ypw.code.java.mapping.annotation;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

/**
 * @author: yangpengwei
 * @time: 2021/5/26 2:17 下午
 * @description 版本号注解
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
public @interface ApiVersion {

    String value() default "";
}