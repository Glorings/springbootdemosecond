package com.ald.ecanew.springbootdemosecond.dal.domain;


import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;

public class MyValidatorDo {

    public String  id;

    public Date date;

    public BigDecimal amount;

    public Integer  age;

    public Long size;

    public String  birdLocation;

    public String  favoties;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getBirdLocation() {
        return birdLocation;
    }

    public void setBirdLocation(String birdLocation) {
        this.birdLocation = birdLocation;
    }

    public String getFavoties() {
        return favoties;
    }

    public void setFavoties(String favoties) {
        this.favoties = favoties;
    }
}
