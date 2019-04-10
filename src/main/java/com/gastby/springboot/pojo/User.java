package com.gastby.springboot.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "user")
public class User {
    private int id;
    private String userId;
    private String name;
    private String mailBox;
    private String gender;
    private String info;
    private String level;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getMailBox() {
        return mailBox;
    }

    public void setMailBox(String mailBox) {
        this.mailBox = mailBox;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "用户User{" +
                "序号：" + id +
                ", 用户编号：'" + userId + '\'' +
                ", 用户姓名：'" + name + '\'' +
                ", 用户级别：'" + level + '\'' +
                '}';
    }
}
