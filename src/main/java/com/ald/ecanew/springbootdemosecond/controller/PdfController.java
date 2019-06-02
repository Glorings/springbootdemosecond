package com.ald.ecanew.springbootdemosecond.controller;

import com.ald.ecanew.springbootdemosecond.config.domain.PersonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PdfController {

    @GetMapping("/hello17")
    public String exportPdf(String userName,String note) {
        System.out.println("111");
        return "helloWorld222";
    }

}