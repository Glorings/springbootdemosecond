package com.ald.ecanew.springbootdemosecond.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Map;

@Controller
public class UploadController {

    //HttpServletRequest作为参数
    @PostMapping("/hello18")
    @ResponseBody
    public void uploadRequest(HttpServletRequest request) {
        MultipartHttpServletRequest mr = (MultipartHttpServletRequest) request;
        MultipartFile mf = mr.getFile("file");
        String filename = mf.getOriginalFilename();
        File file = new File(filename);
        try {
            mf.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //使用spring mvc的MultipartFile作为参数
    @PostMapping("/hello19")
    @ResponseBody
    public void uploadMultipartFile(MultipartFile file) {
        String filename = file.getOriginalFilename();
        File fileNew = new File(filename);
        try {
            file.transferTo(fileNew);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //使用servlet的Part作为参数(推荐，因为不依赖于mvc)
    @PostMapping("/hello20")
    @ResponseBody
    public void uploadPart(Part file) {
        String fileName = file.getSubmittedFileName();
        try {
            file.write(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}