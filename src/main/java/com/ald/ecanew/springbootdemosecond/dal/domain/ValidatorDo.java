package com.ald.ecanew.springbootdemosecond.dal.domain;


import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;

public class ValidatorDo {

    @NotNull
    public String  id;

    @Future
    @DateTimeFormat(pattern="yyyy-MM-dd")
    public Date date;

    @NotNull
    @DecimalMin(value ="0.1")
    @DecimalMax(value ="0.3")
    public BigDecimal amount;

    @Min(10)
    @Max(20)
    public Integer  age;

    @Range(min=10,max = 20)
    public Long size;

    public String  birdLocation;

    @Size(min =1,max = 3)
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
