package com.ald.ecanew.springbootdemosecond.biz.impl;

import com.ald.ecanew.springbootdemosecond.biz.PersonService;
import com.ald.ecanew.springbootdemosecond.biz.UserService;
import com.ald.ecanew.springbootdemosecond.dal.dao.BaseDao;
import com.ald.ecanew.springbootdemosecond.dal.dao.PersonDao;
import com.ald.ecanew.springbootdemosecond.dal.domain.PersonDo;
import com.ald.ecanew.springbootdemosecond.dal.domain.UserDo;
import com.alibaba.fastjson.JSON;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public UserDo getByUserName(String userName) {
        return null;
    }

    @Override
    public UserDo getById(Object id) {
        UserDo userDo = mongoTemplate.findById(id, UserDo.class,"users");
       /* Query query=new Query(Criteria.where("id").is(id));
        UserDo userDo2 = mongoTemplate.findOne(query, UserDo.class, "users");*/
        return userDo;
    }



    @Override
    public  List<UserDo> findUser() {
        Criteria regex = Criteria.where("mobile").regex("PP");
        Query query = new Query(regex).limit(1).skip(2);
        List<UserDo> users = mongoTemplate.find(query, UserDo.class, "users");
        return users;
    }

    @Override
    public UserDo save(UserDo userDo) {
        UserDo user = mongoTemplate.save(userDo, "users");
        return user ;
    }

    @Override
    public void update() {
        Criteria criteria = Criteria.where("_id").is("5cf263f66942ad6124c6d26b");
        //Criteria criteria = Criteria.where("mobile").is("PPP");
        Query query = new Query(criteria);
        UserDo users = mongoTemplate.findOne(query, UserDo.class, "users");
        System.out.println(JSON.toJSONString(users));
        Update update = Update.update("mobile", "TTTTT555");
        update.set("bird_location", "shanghai555");
        UpdateResult result = mongoTemplate.updateFirst(query, update, "users");
        //UpdateResult result = mongoTemplate.updateMulti(query, update, "users");
        System.out.println(JSON.toJSONString(result));
    }
}