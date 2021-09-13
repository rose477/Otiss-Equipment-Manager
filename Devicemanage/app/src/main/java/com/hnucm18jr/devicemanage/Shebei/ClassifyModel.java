package com.hnucm18jr.devicemanage.Shebei;

import java.util.List;

public class ClassifyModel {
    private int id;
    private String name;
    private List<SubclassModel> list;

    public ClassifyModel() {
        super();
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

    public List<SubclassModel> getList() {
        return list;
    }

    public void setList(List<SubclassModel> list) {
        this.list = list;
    }
}
