package com.ald.ecanew.springbootdemosecond.Configuration;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import javax.jms.Queue;
import javax.jms.Topic;

@Configuration
public class Producer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Queue queue;
    @Autowired
    private Topic topic;

    @Scheduled(cron = "0/5 * * * * ?")
    public void send() {
        //发送队列消息
        this.jmsMessagingTemplate.convertAndSend(this.queue, "生产者辛苦生产的点对点消息成果");
        System.out.println("生产者：辛苦生产的点对点消息成果");
        //发送订阅消息
        this.jmsMessagingTemplate.convertAndSend(this.topic, "生产者辛苦生产的订阅/发布消息成果");
        System.out.println("生产者：辛苦生产的订阅/发布消息成果");
    }

}