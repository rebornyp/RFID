package com.gastby.springboot.entities;

public class MonitorRecord implements Record{
    private String id;
    private String readerId;
    private String tagId;
    private String info;
    private String startTime;
    private String endTime;
    private String worker;
    private String partId;
    private String partName;

    public String getPartId() {
        return partId;
    }

    public void setPartId(String partId) {
        this.partId = partId;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReaderId() {
        return readerId;
    }

    public void setReaderId(String readerId) {
        this.readerId = readerId;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
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

    public String getWorker() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }

    @Override
    public String startTime() {
        return startTime;
    }

    @Override
    public String endTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return "出入库监控：{" +
                "记录编号='" + id + '\'' +
                ", 阅读器编号='" + readerId + '\'' +
                ", 出入库信息='" + info + '\'' +
                ", 开始时间='" + startTime + '\'' +
                ", 结束时间='" + endTime;
    }
}
