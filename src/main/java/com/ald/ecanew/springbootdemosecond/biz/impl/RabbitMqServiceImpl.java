/*
package com.ald.ecanew.springbootdemosecond.biz.impl;

import com.ald.ecanew.springbootdemosecond.biz.ActiveMqService;
import com.ald.ecanew.springbootdemosecond.biz.RabbitMqService;
import com.ald.ecanew.springbootdemosecond.dal.domain.PersonDo;
import com.alibaba.fastjson.JSON;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service("rabbitMqServiceImpl")
public class RabbitMqServiceImpl implements RabbitMqService,RabbitTemplate.ConfirmCallback {

    @Value("${rabbitmq.queue.msg}")
    private String msgQueue;

    @Value("${rabbitmq.queue.user}")
    private String userQueue;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Override
    public void sendMsg(String msg) {
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.convertAndSend(msgQueue,msg);
    }

    @Override
    public void sendUser(PersonDo personDo) {
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.convertAndSend(msgQueue,personDo);
    }


    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {
            System.out.println("消费成功");
        }else{
            System.out.println("消费失败");
        }
    }
}
*/
