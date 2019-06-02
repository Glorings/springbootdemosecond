package com.ald.ecanew.springbootdemosecond.validator;


import com.ald.ecanew.springbootdemosecond.dal.domain.MyValidatorDo;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Date;

@Component
public class MyValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(MyValidatorDo.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        MyValidatorDo myValidatorDo = (MyValidatorDo) o;
        if (myValidatorDo.getAge()>10){
            errors.rejectValue("age", "年龄超大");
        }
    }
}
