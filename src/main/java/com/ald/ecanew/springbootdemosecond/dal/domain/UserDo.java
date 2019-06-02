package com.ald.ecanew.springbootdemosecond.dal.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class UserDo {

    @Id
    public String  id;

    public String  mobile;


    public String  username;

    public String  age;

    @Field("bird_location")
    public String  birdLocation;

    public String  favoties;

    public String  msg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
