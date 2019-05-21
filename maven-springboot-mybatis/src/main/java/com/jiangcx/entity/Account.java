package com.jiangcx.entity;

import java.io.Serializable;

/**
 * Created by jiangcx on 2019/5/21
 */
public class Account implements Serializable {
    private static final long serialVersionUID = 7594429366869506998L;

    private int id;
    private String userName;
    private int money;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
