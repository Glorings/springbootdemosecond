package com.ald.ecanew.springbootdemosecond.controller;

import com.ald.ecanew.springbootdemosecond.biz.ActiveMqService;
import com.ald.ecanew.springbootdemosecond.dal.domain.PersonDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActiveMqController {

    @Autowired
    ActiveMqService activeMqService;

    @GetMapping("/hello30")
    public String activeMqStr() {
        activeMqService.sendMsg("DDDDD");
        return "helloWorld222";
    }

    @GetMapping("/hello31")
    public String activeMqObject() {
        PersonDo personDo = new PersonDo();
        personDo.setUserName("TTTTTT");
        activeMqService.sendMsg(personDo);
        return "helloWorld222";
    }

}