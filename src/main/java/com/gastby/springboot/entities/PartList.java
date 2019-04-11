package com.gastby.springboot.entities;

public class PartList {
    private String id;
    private String partListId;
    private String partId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPartListId() {
        return partListId;
    }

    public void setPartListId(String partListId) {
        this.partListId = partListId;
    }

    public String getPartId() {
        return partId;
    }

    public void setPartId(String partId) {
        this.partId = partId;
    }
}
