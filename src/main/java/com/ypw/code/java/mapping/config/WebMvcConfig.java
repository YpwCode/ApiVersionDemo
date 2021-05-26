package com.ypw.code.java.mapping.config;

import com.ypw.code.java.mapping.request.CustomRequestMappingHandlerMapping;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @author: yangpengwei
 * @time: 2021/5/26 2:15 下午
 * @description WebMvc 配置
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

   /**
    * @author: yangpengwei
    * @time: 2021/5/26 2:16 下午
    * @description 创建版本配置 RequestMappingHandlerMapping
    */
    @Override
    protected RequestMappingHandlerMapping createRequestMappingHandlerMapping() {
        RequestMappingHandlerMapping mapping = new CustomRequestMappingHandlerMapping();
        // 设置 order 减少非相关 RequestMapping 识别
        mapping.setOrder(0);
        return mapping;
    }
}