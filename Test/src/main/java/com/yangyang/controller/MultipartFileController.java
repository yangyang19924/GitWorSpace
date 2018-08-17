package com.yangyang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by yangyang on 2018/8/17.
 */
@Controller
@RequestMapping("/upload")
public class MultipartFileController {

    @RequestMapping("toUpload")
    public String toUpload() {
        return "fileUpload";
    }

    @RequestMapping("fileUpload")
    @ResponseBody
    public String upload(MultipartFile multipartFile) {
        if(!multipartFile.isEmpty()) {
            String filePath = "E:\\MultipartFile\\" + multipartFile.getOriginalFilename();

            try {
                multipartFile.transferTo(new File(filePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "flag:success";
    }
}
