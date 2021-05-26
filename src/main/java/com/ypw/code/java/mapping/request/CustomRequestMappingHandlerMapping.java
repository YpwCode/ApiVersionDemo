package com.ypw.code.java.mapping.request;

import com.ypw.code.java.mapping.annotation.ApiVersion;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

/**
 * @author: yangpengwei
 * @time: 2021/5/26 2:10 下午
 * @description 自定义 RequestMapping 匹配
 */
public class CustomRequestMappingHandlerMapping extends RequestMappingHandlerMapping {

    /**
     * @author: yangpengwei
     * @time: 2021/5/26 2:12 下午
     * @description 方法注解查找
     */
    @Override
    protected RequestCondition<?> getCustomMethodCondition(Method method) {
        ApiVersion apiVersion = AnnotationUtils.findAnnotation(method, ApiVersion.class);
        return apiVersion == null ? null : new ApiVersionCondition(apiVersion.value());
    }
}