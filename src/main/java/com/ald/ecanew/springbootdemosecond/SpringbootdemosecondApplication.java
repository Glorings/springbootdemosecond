package com.ald.ecanew.springbootdemosecond;

import com.ald.ecanew.springbootdemosecond.listener.RedisMsgListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import javax.annotation.PostConstruct;
import javax.persistence.NamedEntityGraph;

@SpringBootApplication
@PropertySource(value = "classpath:jdbc.properties")
@EnableCaching
@EnableMongoRepositories(basePackages = "com.ald.ecanew.springbootdemosecond.dal.dao")
//@EnableWebSecurity
@EnableJms
@EnableScheduling
public class SpringbootdemosecondApplication {

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    RedisConnectionFactory redisConnectionFactory;
    @Autowired
    RedisMsgListener redisMsgListener;
    public static void main(String[] args) {

        SpringApplication.run(SpringbootdemosecondApplication.class, args);
        System.out.println("TTTTTTTTT");
        System.out.println("YYYY");
    }

    @PostConstruct
    public void initRedisTemplate(){
        RedisSerializer stringSerializer = redisTemplate.getStringSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);



    }

    @Bean
    public ThreadPoolTaskScheduler initRedisTaskScheduler(){
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(20);
        return taskScheduler;
    }

    @Bean
    public RedisMessageListenerContainer initRedisContainer(){
        RedisMessageListenerContainer redisContainer = new RedisMessageListenerContainer();
        redisContainer.setConnectionFactory(redisConnectionFactory);
        redisContainer.setTaskExecutor(initRedisTaskScheduler());
        Topic topic = new ChannelTopic("topic");
        redisContainer.addMessageListener(redisMsgListener,topic);
        return redisContainer;
    }
}
