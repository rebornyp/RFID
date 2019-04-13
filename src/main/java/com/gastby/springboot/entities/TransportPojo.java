package com.gastby.springboot.entities;


public class TransportPojo implements Record{
    private String id; //自增序号
    private String tid; //货运任务编号
    private String listId; //货运清单编号
    private String readerId; //运输任务中阅读器编号
    private String startTime; // 开始时间
    private String endTime; // 结束时间
    private String startHouse; // 开始厂房
    private String endHouse; // 结束厂房
    private String worker; // 工人编号


    public String getWorker() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }

    private String info; // 备注

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getListId() {
        return listId;
    }

    public void setListId(String listId) {
        this.listId = listId;
    }

    public String getReaderId() {
        return readerId;
    }

    public void setReaderId(String readerId) {
        this.readerId = readerId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStartHouse() {
        return startHouse;
    }

    public void setStartHouse(String startHouse) {
        this.startHouse = startHouse;
    }

    public String getEndHouse() {
        return endHouse;
    }

    public void setEndHouse(String endHouse) {
        this.endHouse = endHouse;
    }



    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String startTime() {
        return startTime;
    }

    @Override
    public String endTime() {
        return startTime;
    }

    @Override
    public String toString() {
        return "TransportPojo{" +
                "id='" + id + '\'' +
                ", tid='" + tid + '\'' +
                ", listId='" + listId + '\'' +
                ", readerId='" + readerId + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", startHouse='" + startHouse + '\'' +
                ", endHouse='" + endHouse + '\'' +
                ", worker='" + worker + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
