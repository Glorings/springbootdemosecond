package com.ald.ecanew.springbootdemosecond.biz;

import com.ald.ecanew.springbootdemosecond.dal.domain.PersonDo;

import java.util.List;

public interface PersonService extends ParentService<PersonDo, Long> {

    PersonDo getByUserName(String userName);
}
