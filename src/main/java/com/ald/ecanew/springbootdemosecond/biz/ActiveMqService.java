package com.ald.ecanew.springbootdemosecond.biz;

import com.ald.ecanew.springbootdemosecond.dal.domain.PersonDo;

public interface ActiveMqService {

    public void sendMsg(String msg);

    public void receiveMsg(String msg);

    public void sendMsg(PersonDo personDo);

    public void receiveMsg(PersonDo personDo);

}
