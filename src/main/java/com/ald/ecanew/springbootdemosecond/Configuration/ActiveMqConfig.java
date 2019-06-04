package com.ald.ecanew.springbootdemosecond.Configuration;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.jms.Queue;
import javax.jms.Topic;
import java.util.concurrent.Executor;

@Configuration
@EnableJms
public class ActiveMqConfig {

    @Bean
    public Queue queue() {
        return new ActiveMQQueue("sample.queue2");
    }

    @Bean
    public Topic topic() {
        return new ActiveMQTopic("sample.topic2");
    }

}