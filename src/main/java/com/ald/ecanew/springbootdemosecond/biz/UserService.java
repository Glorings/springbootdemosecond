package com.ald.ecanew.springbootdemosecond.biz;

import com.ald.ecanew.springbootdemosecond.dal.domain.PersonDo;
import com.ald.ecanew.springbootdemosecond.dal.domain.UserDo;
import com.ald.ecanew.springbootdemosecond.dal.domain.UserJpaDo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface UserService {

    UserDo getByUserName(String userName);

    UserDo getById(Object id);

    List<UserDo> findUser();

    UserDo save(UserDo userDo);

    void update();

    List<UserJpaDo> findAll();

    Page<UserJpaDo> queryAllByPage(int page, int pageSize);

    void unset();

}
