package com.ypw.code.java.mapping.controller;

import com.ypw.code.java.mapping.annotation.ApiVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: yangpengwei
 * @time: 2021/5/26 2:21 下午
 * @description 测试
 */
@RestController
public class TestControllerV2 {

    @GetMapping("/test")
    @ApiVersion("2.0.0")
    public String hello() {
        return "test: 2.0.0";
    }

}
