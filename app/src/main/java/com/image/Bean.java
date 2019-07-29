package com.image;

import java.io.Serializable;

public class Bean implements Serializable {
    private String name;
    private String time;
    private int id;

    public Bean(String name, String time, int id) {
        this.name = name;
        this.time = time;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
