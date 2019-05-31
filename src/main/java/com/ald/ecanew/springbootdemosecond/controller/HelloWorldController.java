package com.ald.ecanew.springbootdemosecond.controller;

import com.ald.ecanew.springbootdemosecond.config.domain.AnimalBatchConfig;
import com.ald.ecanew.springbootdemosecond.config.domain.PersonBatchConfig;
import com.ald.ecanew.springbootdemosecond.config.domain.PersonConfig;
import com.ald.ecanew.springbootdemosecond.dal.dao.PersonDao;
import com.ald.ecanew.springbootdemosecond.dal.domain.PersonDo;
import com.alibaba.fastjson.JSON;
import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@RestController
public class HelloWorldController{

    private Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @Value("${name}")
    private String name;
    @Autowired
    private PersonConfig personConfig;
    @Autowired
    PersonBatchConfig personBatchConfig;
    @Autowired
    AnimalBatchConfig animalBatchConfig;

    @Autowired
    BasicDataSource dataSource;

    @Resource
    PersonDao personDao;

    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping("/hello")
    public String sayHello() {
        System.out.println("111");
        return "helloWorld222";
    }

    @GetMapping("/hello2")
    public String sayHello2() {
        System.out.printf(name);
        return name;
    }

    @GetMapping("/hello3")
    public String sayHello3() {
        System.out.println(animalBatchConfig.getName());
        return JSON.toJSONString(animalBatchConfig);
    }

    @GetMapping("/hello4")
    public String testJsp(ModelMap model) {
        System.out.println(personConfig.getName());
        System.out.println(personConfig.getGender());
        model.put("msg", "TTTTT");
        return "index";
    }

    @GetMapping("/hello5")
    private String testMysql() {
        int result = 0;
        Connection conn = null;
        if(dataSource==null) {
            logger.error("testMysql dataSource is null");
        }
        try {
            conn = dataSource.getConnection();
            ResultSet resultSet = conn.prepareStatement("select count(1) from test2").executeQuery();
            if(resultSet.next()) {
                result = resultSet.getInt(1);
            }
            if(result>0) {
                return result+"";
            }
        } catch (SQLException e) {
            logger.error("validMysqlInfo conn exec error",e);
        }finally {
            if(conn!=null) {
                try {
                    if(!conn.isClosed()) {
                        conn.close();
                    }
                } catch (Exception e) {
                    logger.error("validMysqlInfo conn close error",e);
                }
            }
        }
        return null;
    }

    @GetMapping("/hello6")
    public String testMybatis() {
        PersonDo personDo = personDao.getById(1L);
        return JSON.toJSONString(personDo);
    }

    @GetMapping("/hello7")
    public String testRedis() {
        redisTemplate.opsForValue().set("Name","Glorings");
        Object name = redisTemplate.opsForValue().get("Name");
        return JSON.toJSONString(name);
    }
}