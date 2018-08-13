package com.yangyang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by yangyang on 2018/8/13.
 */
@Controller
@RequestMapping(value = "/upload")
public class TestMultipartResolver {

    @RequestMapping("fileUpload")
    @ResponseBody
    public String upload(MultipartFile multipartFile) {

    }
}
