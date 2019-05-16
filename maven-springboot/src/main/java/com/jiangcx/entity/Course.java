package com.jiangcx.entity;

/**
 * Created by jiangcx on 2019/2/27
 */
public class Course {

    private String cno;//课程编号
    private String cname;//课程名称
    private String tno;//教师编号

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }
}
