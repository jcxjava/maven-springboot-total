package com.jiangcx.entity;

/**
 * Created by jiangcx on 2019/3/7
 */
public abstract class Fruit {
    private Double size;
    private Double weight;

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public abstract void eating();
}
