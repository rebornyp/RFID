package com.gastby.springboot.entities;


public class Part2 {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getProduceDate() {
        return produceDate;
    }

    public void setProduceDate(String produceDate) {
        this.produceDate = produceDate;
    }

    private Integer id;
    private String pid;
    private String name;
    private String type;
    private String info;
    private String producer;
    private String produceDate;
    private String tid;
    private String position;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "Part2{" +
                "id(自增序号):" + id +
                ", pid(零件编号):'" + pid + '\'' +
                ", name(零件名称):'" + name + '\'' +
                ", type(零件材质):'" + type + '\'' +
                ", info(零件信息):'" + info + '\'' +
                ", producer(零件制造者信息):'" + producer + '\'' +
                ", produceDate(零件制造时间):'" + produceDate + '\'' +
                '}';
    }
}
