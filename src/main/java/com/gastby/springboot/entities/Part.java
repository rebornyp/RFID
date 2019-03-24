package com.gastby.springboot.entities;

import java.util.Date;

public class Part {
    private Integer id;
    private String pid;
    private String tid;
    private String name;
    private Date birthDate;
    private String producer;
    private String position;

    @Override
    public String toString() {
        return "Part{" +
                "id=" + id +
                ", pid='" + pid + '\'' +
                ", tid='" + tid + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", producer='" + producer + '\'' +
                ", position='" + position + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }



}
