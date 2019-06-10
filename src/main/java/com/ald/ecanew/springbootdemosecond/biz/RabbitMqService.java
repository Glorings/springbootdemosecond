package com.ald.ecanew.springbootdemosecond.biz;

import com.ald.ecanew.springbootdemosecond.dal.domain.PersonDo;

public interface RabbitMqService {

    public void sendMsg(String msg);

    public void sendUser(PersonDo personDo);

}
