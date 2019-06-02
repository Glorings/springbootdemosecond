package com.ald.ecanew.springbootdemosecond.converter;

import com.ald.ecanew.springbootdemosecond.dal.domain.UserDo;
import jdk.internal.dynalink.linker.ConversionComparator;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class StringToUserConverter implements Converter<String,UserDo> {

    @Override
    public UserDo convert(String s) {
        UserDo userDo = new UserDo();
        String[] split = s.split("_");
        userDo.setUsername(split[0]);
        userDo.setMobile(split[1]);
        return userDo;
    }
}