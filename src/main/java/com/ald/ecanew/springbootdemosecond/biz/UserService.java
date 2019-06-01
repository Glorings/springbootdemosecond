package com.ald.ecanew.springbootdemosecond.biz;

import com.ald.ecanew.springbootdemosecond.dal.domain.PersonDo;
import com.ald.ecanew.springbootdemosecond.dal.domain.UserDo;

import java.util.List;

public interface UserService {

    UserDo getByUserName(String userName);

    UserDo getById(Object id);

    List<UserDo> findUser();

    UserDo save(UserDo userDo);

    void update();
}
