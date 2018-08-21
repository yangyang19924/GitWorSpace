package com.yangyang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by yangyang on 2018/8/17.
 */
@Controller
@RequestMapping("/fileUpload")
public class MultipartFileController {

    @RequestMapping("/toUpload")
    public String toUpload() {
        return "fileUpload";
    }


    @RequestMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam(value = "multipartFile") MultipartFile multipartFile) {
        if(!multipartFile.isEmpty()) {
            String filePath = "E:\\MultipartFile\\" + multipartFile.getOriginalFilename();

            try {
                multipartFile.transferTo(new File(filePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "success";
    }


    @RequestMapping("/toUploadFiles")
    public String toUploadFiles() {
        return "filesUpload";
    }


    @RequestMapping("/uploadFiles")
    @ResponseBody
    public String uploadFiles(@RequestParam(value = "multipartFile") MultipartFile[] multipartFiles) {

        String filePath = "E:\\MultipartFile\\";

        if(multipartFiles!=null && multipartFiles.length>0) {
            try {
                for(MultipartFile file:multipartFiles) {
                    file.transferTo(new File(filePath + file.getOriginalFilename()));
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "success";
    }

}
