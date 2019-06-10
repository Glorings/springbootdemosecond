package com.ald.ecanew.springbootdemosecond.rabbitmq;

import com.ald.ecanew.springbootdemosecond.dal.domain.PersonDo;
import com.alibaba.fastjson.JSON;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitmqReceiver {

    @RabbitListener(queues = {"${rabbitmq.queue.msg}"})
    public void receiveQueueMsg(String msg) {
        System.out.println("收到消息："+msg);
    }

    @RabbitListener(queues = {"${rabbitmq.queue.user}"})
    public void receiveQueueUser(PersonDo personDo) {
        System.out.println("收到消息："+ JSON.toJSONString(personDo));
    }


}