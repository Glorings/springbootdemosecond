/*
package com.ald.ecanew.springbootdemosecond.Configuration;

import com.rabbitmq.client.AMQP;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;


@Configuration
public class RabbitMqConfig {

    @Value("${rabbitmq.queue.msg}")
    private String msgQueue;

    @Value("${rabbitmq.queue.user}")
    private String userQueue;


    @Bean
    public Queue creatQueueMsg() {
        return new Queue(msgQueue,true) ;//消息持久化
    }

    @Bean
    public Queue creatQueueUser() {
        return new Queue(userQueue,true) ;//消息持久化
    }

}*/
