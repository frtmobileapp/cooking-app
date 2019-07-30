package com.nd.frt.cookingapp;


public class Product {
    private String title;
    private int pic;
    private String des;
    private String time;

    public Product(String title, int pic, String des, String time) {
        this.title = title;
        this.pic = pic;
        this.des = des;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
