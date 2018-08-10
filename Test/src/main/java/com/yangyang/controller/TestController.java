package com.yangyang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yangyang on 2018/8/7.
 */
@RestController
@RequestMapping()
public class TestController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello";

    }
}
