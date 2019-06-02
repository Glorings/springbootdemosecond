package com.ald.ecanew.springbootdemosecond.dal.dao;

import com.ald.ecanew.springbootdemosecond.dal.domain.PersonDo;
import com.ald.ecanew.springbootdemosecond.dal.domain.UserJpaDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface UserJpaDao extends MongoRepository<UserJpaDo, String> {

    List<UserJpaDo>  findByMobile(String mobile);

    List<UserJpaDo> findByUsernameLike(String userName);

    List<UserJpaDo>  findByMobileOrderByIdDesc(String mobile);

    List<UserJpaDo>  findByMobile(String mobile, Pageable pageable );

    UserJpaDo save(UserJpaDo userJpaDo);

}
