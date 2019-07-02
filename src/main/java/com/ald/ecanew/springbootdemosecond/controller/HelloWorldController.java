package com.ald.ecanew.springbootdemosecond.controller;

import com.ald.ecanew.springbootdemosecond.biz.PersonService;
import com.ald.ecanew.springbootdemosecond.biz.UserService;
import com.ald.ecanew.springbootdemosecond.config.domain.AnimalBatchConfig;
import com.ald.ecanew.springbootdemosecond.config.domain.PersonBatchConfig;
import com.ald.ecanew.springbootdemosecond.config.domain.PersonConfig;
import com.ald.ecanew.springbootdemosecond.dal.dao.PersonDao;
import com.ald.ecanew.springbootdemosecond.dal.dao.UserJpaDao;
import com.ald.ecanew.springbootdemosecond.dal.domain.*;
import com.ald.ecanew.springbootdemosecond.validator.MyValidator;
import com.alibaba.fastjson.JSON;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
/*import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.*;*/
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Autowired
    PersonService personService;

    @Resource
    PersonDao personDao;

 /*   @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisConnectionFactory redisConnectionFactory;*/

    @Autowired
    UserService userService;

    @Autowired
    UserJpaDao userJpaDao;

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
      /*  //String
        redisTemplate.opsForValue().set("Name","Glorings");
        Object name = redisTemplate.opsForValue().get("Name");
        stringRedisTemplate.opsForValue().set("gender","male");
        Object gender = stringRedisTemplate.opsForValue().get("gender");
        Long increment = redisTemplate.opsForValue().increment("increment", 2);
        //redisTemplate.opsForValue().set("decrement","50");
        Long decrement = redisTemplate.opsForValue().decrement("decrement", 1);

        //Hash
        HashMap<String, String> map = new HashMap<String,String>();
        map.put("filed1", "value1");
        map.put("filed2", "value2");
        stringRedisTemplate.opsForHash().putAll("hash",map);
        stringRedisTemplate.opsForHash().put("hash","filed3","value3");
        BoundHashOperations<String, Object, Object> boundHashOps = stringRedisTemplate.boundHashOps("hash");
        boundHashOps.delete("filed1");
        boundHashOps.put("filed4", "value4");
        boundHashOps.put("filed5", "value5");

        //List
        stringRedisTemplate.opsForList().leftPushAll("list1","v1","v2","v3","v4","v5");
        stringRedisTemplate.opsForList().rightPushAll("list2","v6","v7","v8","v9","v10");
        BoundListOperations<String, String> listOperations = stringRedisTemplate.boundListOps("list2");
        listOperations.rightPop();
        System.out.println(listOperations.index(1));
        listOperations.leftPush("v30");
        System.out.println( listOperations.size());
        List<String> range = listOperations.range(0, listOperations.size() - 2);

        //set
        //stringRedisTemplate.opsForSet().add("set1", "v1", "v2", "v3", "v1", "v4", "v5");
        //stringRedisTemplate.opsForSet().add("set2", "v2", "v4", "v5");
        BoundSetOperations<String, String> boundSetOps = stringRedisTemplate.boundSetOps("set1");
        boundSetOps.remove("v2");
        System.out.println(boundSetOps.members());
        System.out.println(boundSetOps.intersect("set2"));

        //zset
        Set<ZSetOperations.TypedTuple<String>> set = new HashSet<>();
        set.add(new DefaultTypedTuple<String>("v1", 1d));
        set.add(new DefaultTypedTuple<String>("v2", 3d));
        set.add(new DefaultTypedTuple<String>("v1", 2d));
        set.add(new DefaultTypedTuple<String>("v3", 5d));
        set.add(new DefaultTypedTuple<String>("v4", 4d));
        //stringRedisTemplate.opsForZSet().add("zset2", set);
        BoundZSetOperations<String, String> zSetOperations = stringRedisTemplate.boundZSetOps("zset2");
        zSetOperations.add("v5",20);
        System.out.println(zSetOperations.range(2, 3));
        System.out.println(zSetOperations.rangeByScore(3, 50));
        System.out.println(zSetOperations.score("v5"));
        return JSON.toJSONString(increment);
    }

    @GetMapping("/hello8")
    public void testRedisTransation() {
       *//* redisTemplate.opsForValue().set("key1", "value1");
        List result = (List)redisTemplate.execute((RedisOperations redisOperations) -> {
            redisOperations.watch("key1");
            redisOperations.multi();
            redisOperations.opsForValue().set("key2", "value2");
            //int a = 1 / 0;
            //redisOperations.opsForValue().increment("key1", 22);
            redisOperations.opsForValue().set("key3", "value3");
            return redisOperations.exec();
        });*//*
        System.out.println("1111");*/
        return null;
    }

    @GetMapping("/hello9")
    public void testRedisTopic() {
        //redisTemplate.convertAndSend("topic","MSGKKKTTT");
        System.out.println("'aaa'+'bb'");
    }

    @GetMapping("/hello10")
    public String testRedisCache() {
        return JSON.toJSONString(personService.getByUserName("18668465735"));
    }

    @GetMapping("/hello11")
    public String testMongo() {
        return JSON.toJSONString(userService.findUser());
     /*   UserDo userDo = new UserDo();
        userDo.setMobile("TTTT");
        userDo.setBirdLocation("shanghai");*/
        //return JSON.toJSONString(userService.save(userDo));
        //return JSON.toJSONString(userService.getById("5cc29b2b45c7a68b8b89c3aa"));
        //userService.update();
        //return null;

    }
    @GetMapping("/hello12")
    public String testMongoJpa() {
        //return  JSON.toJSONString(userJpaDao.findByMobile("PPP"));
        //return JSON.toJSONString(userJpaDao.findById("5cc556dff0a45d6724728474"));
        //return JSON.toJSONString(userJpaDao.findAll());
        //return JSON.toJSONString(userJpaDao.findByMobileOrderByIdDesc("PPP"));

       /* UserJpaDo userJpaDo = new UserJpaDo();
        userJpaDo.setAge("20");
        userJpaDo.setUsername("EEEE");
        userJpaDo.setMobile("18668465736s");
        return JSON.toJSONString(userJpaDao.save(userJpaDo));*/


        //return JSON.toJSONString(userService.queryAllByPage(2,3));
       //return JSON.toJSONString(userJpaDao.count());
       // return JSON.toJSONString(userJpaDao.count());
        userService.unset();
        return null;
    }

    @GetMapping("/hello13")
    public String testConverter(UserDo user) {
        return JSON.toJSONString(user);
    }

    @GetMapping("/hello14")
    public String testConverterGeneric(List<String> userName) {
        return JSON.toJSONString(userName);
    }

    @GetMapping("/hello15")
    public String testValidator(@Valid  ValidatorDo validatorDo) {

        ValidatorDo validatorDo1 = new ValidatorDo();
        validatorDo1.setAge(30);
        return JSON.toJSONString(validatorDo1);
    }

    @GetMapping("/hello16")
    public String testMyValidator(@Valid MyValidatorDo validatorDo, Errors error) {
        System.out.println(error);
        return JSON.toJSONString(validatorDo);
    }

    @InitBinder
    public void intBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(new MyValidator());
    }
}