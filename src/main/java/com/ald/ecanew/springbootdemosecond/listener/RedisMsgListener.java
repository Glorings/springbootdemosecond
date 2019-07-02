/*
package com.ald.ecanew.springbootdemosecond.listener;

import com.ald.ecanew.springbootdemosecond.config.domain.PersonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
public class RedisMsgListener implements MessageListener {


    @Override
    public void onMessage(Message message, byte[] bytes) {
        System.out.println(new String(message.getBody()));
        System.out.println(new String(bytes));
    }
}*/
