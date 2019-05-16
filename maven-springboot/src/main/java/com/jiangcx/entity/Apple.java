package com.jiangcx.entity;

/**
 * Created by jiangcx on 2019/3/7
 */
public class Apple extends Fruit{
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void eating() {
        System.out.println("I like eat Apple.");
    }

    public static void main(String[] args){
        Apple apple = new Apple();
        apple.setSize(5d);
        apple.setColor("red");
        System.out.println();
    }


}
