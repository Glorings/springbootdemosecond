package com.ald.ecanew.springbootdemosecond.biz.impl;

import com.ald.ecanew.springbootdemosecond.biz.ActiveMqService;
import com.ald.ecanew.springbootdemosecond.dal.domain.PersonDo;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("activeMqServiceImpl")
public class ActiveMqServiceImpl implements ActiveMqService {

    @Autowired
    JmsTemplate  jmsTemplate;
    @Override
    public void sendMsg(String msg) {
        System.out.println("AAAAAAAAA");
        jmsTemplate.convertAndSend(msg);
    }

    @Override
    @JmsListener(destination = "${spring.jms.template.default-destination}")
    public void receiveMsg(String msg) {
        System.out.println("BBBBBBBBBBBBB");
    }

    @Override
    public void sendMsg(PersonDo personDo) {
        System.out.println("CCCCCCC");
        jmsTemplate.convertAndSend("myDestination3",personDo);
    }

    @Override
    @JmsListener(destination = "myDestination3")
    public void receiveMsg(PersonDo personDo) {
        System.out.println("DDDDDD");
        System.out.println(JSON.toJSONString(personDo));
    }
}
