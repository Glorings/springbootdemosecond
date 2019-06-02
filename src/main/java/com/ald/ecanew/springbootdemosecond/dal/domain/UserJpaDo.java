package com.ald.ecanew.springbootdemosecond.dal.domain;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Document(collection = "users")
public class UserJpaDo implements Serializable {

    @Id
    public String id;

    public String  mobile;

    public String  username;

    public String  age;

    @Field("bird_location")
    public String  birdLocation;

    public String  favoties;

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
}
