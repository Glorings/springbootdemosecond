package com.ald.ecanew.springbootdemosecond.dal.domain;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;

@Alias("personDo")
 public class PersonDo extends BaseDo implements Serializable {
    /**
     * 主键Id
     */
    private Long id;
    

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 最后修改时间
     */
    private Date gmtModified;

    /**
     * 第三方贷款id
     */
    private String userName;

    /**
     * 贷款编号
     */
    private String realName;

    /**
     * 原始Json结果
     */
    private Integer age;


     public Long getId() {
         return id;
     }

     public void setId(Long id) {
         this.id = id;
     }

     public Date getGmtCreate() {
         return gmtCreate;
     }

     public void setGmtCreate(Date gmtCreate) {
         this.gmtCreate = gmtCreate;
     }

     public Date getGmtModified() {
         return gmtModified;
     }

     public void setGmtModified(Date gmtModified) {
         this.gmtModified = gmtModified;
     }

     public String getUserName() {
         return userName;
     }

     public void setUserName(String userName) {
         this.userName = userName;
     }

     public String getRealName() {
         return realName;
     }

     public void setRealName(String realName) {
         this.realName = realName;
     }

     public Integer getAge() {
         return age;
     }

     public void setAge(Integer age) {
         this.age = age;
     }
 }