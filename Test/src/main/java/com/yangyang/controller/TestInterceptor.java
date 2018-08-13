package com.yangyang.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangyang on 2018/8/13.
 */
@Controller
@RequestMapping(value = "role")
public class TestInterceptor {


    @RequestMapping("testInterceptor1")
    @ResponseBody
    public String testInterceptor1(){
        System.out.println("执行controller!");
        Map<String,Object> result = new HashMap<>();
        result.put("success",true);
        return JSON.toJSONString(result);
    }
}
