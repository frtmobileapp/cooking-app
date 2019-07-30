package com.example.mytestapp;

/**
 * 物品实体类
 */
public class GoodsBean {
    public int picId;
    public String goodsName;
    public String goodsUnit;
    public double money;
    public int nun;

    public GoodsBean(int picId, String goodsName, String goodsUnit, double money, int nun) {
        this.picId = picId;
        this.goodsName = goodsName;
        this.goodsUnit = goodsUnit;
        this.money = money;
        this.nun = nun;
    }
}
