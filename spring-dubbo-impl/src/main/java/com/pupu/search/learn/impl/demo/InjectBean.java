package com.pupu.search.learn.impl.demo;

public class InjectBean {
    private String id;

    @Override
    public String toString() {
        return "com.pupu.search.learn.impl.demo.InjectBean{" +
                "id='" + id + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
