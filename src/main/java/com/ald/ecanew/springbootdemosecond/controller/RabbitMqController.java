package com.ald.ecanew.springbootdemosecond.controller;

import com.ald.ecanew.springbootdemosecond.biz.ActiveMqService;
import com.ald.ecanew.springbootdemosecond.biz.RabbitMqService;
import com.ald.ecanew.springbootdemosecond.dal.domain.PersonDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMqController {

    @Autowired
    RabbitMqService rabbitMqService;

    @GetMapping("/hello32")
    public String activeMqStr() {
        rabbitMqService.sendMsg("DDDDD");
        return "TTTTT";
    }

    @GetMapping("/hello33")
    public String activeMqObject() {
        PersonDo personDo = new PersonDo();
        personDo.setUserName("TTTTTT");
        rabbitMqService.sendUser(personDo);
        return "YYYYY";
    }

}