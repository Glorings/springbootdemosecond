package com.ald.ecanew.springbootdemosecond.controller;

import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HelloWorldController{

    @Value("${name}")
    private String name;
    @Autowired
    private  PersonConfig personConfig;

    @GetMapping("/hello")
    public String sayHello() {
        System.out.printf("111");
        return "helloWorld222";
    }

    @GetMapping("/hello2")
    public String sayHello2() {
        System.out.printf(name);
        return name;
    }

    @GetMapping("/hello3")
    public String sayHello3() {
        System.out.println(personConfig.getName());
        System.out.println(personConfig.getGender());
        return personConfig.getName();
    }

    @GetMapping("/hello4")
    public String testJsp(ModelMap model) {
        System.out.println(personConfig.getName());
        System.out.println(personConfig.getGender());
        model.put("msg", "TTTTT");
        return "index";
    }
}