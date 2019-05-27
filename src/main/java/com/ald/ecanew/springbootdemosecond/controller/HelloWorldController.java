package com.ald.ecanew.springbootdemosecond.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController{

    @GetMapping("/hello")
    public String sayHello() {
        System.out.printf("111");
        return "helloWorld222";
    }

}