package com.ald.ecanew.springbootdemosecond.biz.impl;

import com.ald.ecanew.springbootdemosecond.biz.PersonService;
import com.ald.ecanew.springbootdemosecond.dal.dao.BaseDao;
import com.ald.ecanew.springbootdemosecond.dal.dao.PersonDao;
import com.ald.ecanew.springbootdemosecond.dal.domain.PersonDo;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;



@Service("personServiceImpl")
public class PersonServiceImpl extends ParentServiceImpl<PersonDo, Long>  implements PersonService {

    @Resource
    private PersonDao personDao;

    @Override
    public BaseDao<PersonDo, Long> getDao() {
        return personDao;
    }

    @Override
    @Cacheable(value = "redisCache",key ="'redis_user_'+#userName")
    public PersonDo getByUserName(String userName) {
        PersonDo personDo = personDao.getByUserName(userName);
        return personDo;
    }
}