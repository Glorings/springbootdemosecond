package com.ald.ecanew.springbootdemosecond.biz.impl;

import com.ald.ecanew.springbootdemosecond.biz.PersonService;
import com.ald.ecanew.springbootdemosecond.biz.UserService;
import com.ald.ecanew.springbootdemosecond.dal.dao.BaseDao;
import com.ald.ecanew.springbootdemosecond.dal.dao.PersonDao;
import com.ald.ecanew.springbootdemosecond.dal.dao.UserJpaDao;
import com.ald.ecanew.springbootdemosecond.dal.domain.PersonDo;
import com.ald.ecanew.springbootdemosecond.dal.domain.UserDo;
import com.ald.ecanew.springbootdemosecond.dal.domain.UserJpaDo;
import com.alibaba.fastjson.JSON;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    UserJpaDao userJpaDao;


    @Override
    public UserDo getByUserName(String userName) {
        return null;
    }

    @Override
    @Async
    public UserDo getById(Object id) {
        UserDo userDo = mongoTemplate.findById(id, UserDo.class,"users");
       /* Query query=new Query(Criteria.where("id").is(id));
        UserDo userDo2 = mongoTemplate.findOne(query, UserDo.class, "users");*/
        return userDo;
    }



    @Override
    public  List<UserDo> findUser() {
        Criteria regex = Criteria.where("username").regex("k");
        Query query = new Query(regex).limit(1);
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

    @Override
    public List<UserJpaDo> findAll() {
        return userJpaDao.findAll();
    }

    @Override
    public Page<UserJpaDo> queryAllByPage(int page, int pageSize) {
        PageRequest pageRequest = PageRequest.of(page-1,pageSize);
        return userJpaDao.findAll(pageRequest);
    }

    @Override
    public void unset() {
        Criteria criteria = Criteria.where("_id").is("5cf263226942ad6124c6d26a");
        Query query = new Query(criteria);
        Update update = new Update();
        update.unset("bird_location");
        UpdateResult result = mongoTemplate.updateFirst(query, update, "users");
    }


}