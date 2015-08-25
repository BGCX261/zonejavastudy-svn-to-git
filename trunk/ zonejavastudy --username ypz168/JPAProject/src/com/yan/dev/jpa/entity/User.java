/**
 *  Copyright(c) 2010-2011 Yan.Dev. All Rights Reserved.
 */
package com.yan.dev.jpa.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Comment for User.java
 *
 * @author <a href="mailto:yan.dev@hotmail.com">yan.dev</a>
 * 
 * @blog:<a href="http://yan-dev.javaeye.com"><b>yan.dev's Blog</b></a>
 * @version 1.0
 * @time 2011-3-24 ÏÂÎç07:01:33
 */
@Entity
@Table(name="yan_user")
public class User {
    public User(){
    	
    }
    @Id
    @GeneratedValue(strategy=IDENTITY) 
	private int ID;
    
    @Column(name = "NAME")
    private String name;
    
    @Column(name = "LOGINID")
    private String loginId;
    
    @Column(name = "PASSWORD")
    private String password;
    
    @Column(name = "AGE")
    private int age;

    public int getId() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getLoginId() {
        return loginId;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.ID = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }    
}
