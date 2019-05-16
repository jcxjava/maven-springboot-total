package com.jiangcx.entity;

import java.io.Serializable;

/**
 * Created by jiangcx on 2019/5/15
 */
public class Teacher implements Serializable {
    //教师编号
    private String tno;
    //教师姓名
    private String tname;
    //性别
    private String tsex;
    //生日
    private String tbirthday;
    //职称
    private String prof;
    //系别、部门
    private String depart;

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTsex() {
        return tsex;
    }

    public void setTsex(String tsex) {
        this.tsex = tsex;
    }

    public String getTbirthday() {
        return tbirthday;
    }

    public void setTbirthday(String tbirthday) {
        this.tbirthday = tbirthday;
    }

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tno='" + tno + '\'' +
                ", tname='" + tname + '\'' +
                ", tsex='" + tsex + '\'' +
                ", tbirthday='" + tbirthday + '\'' +
                ", prof='" + prof + '\'' +
                ", depart='" + depart + '\'' +
                '}';
    }
}

