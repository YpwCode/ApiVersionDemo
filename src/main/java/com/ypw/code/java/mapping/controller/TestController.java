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
public class TestController {

    @GetMapping("/test")
    public String hello() {
        return "test";
    }

    @GetMapping("/test")
    @ApiVersion("1.0.1")
    public String helloV1_0_1() {
        return "test: 1.0.1";
    }

    @GetMapping("/test")
    @ApiVersion("1.0.2")
    public String helloV1_0_2() {
        return "test: 1.0.2";
    }

    @GetMapping("/test")
    @ApiVersion("1.0.3")
    public String helloV1_0_3() {
        return "test: 1.0.3";
    }

}
