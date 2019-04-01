package com.gastby.springboot.entities;

public class InsertRecord {
    private String id;
    private String name;
    private String date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "[" +date+'\''+"]："+
                "插入了编号为：" + id + '\'' +
                ", 名称为：" + name + '\'' +
                " 的零件;\n";
    }
}
