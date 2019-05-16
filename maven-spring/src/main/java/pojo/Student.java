package pojo;

import org.springframework.stereotype.Component;

/**
 * Created by jiangcx on 2019/2/27
 */
@Component
public class Student {

    private String sno;
    private String sname;
    private String ssex;
    private String sbirthday;
    private String classes;

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public String getSbirthday() {
        return sbirthday;
    }

    public void setSbirthday(String sbirthday) {
        this.sbirthday = sbirthday;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public void learn(){
        System.out.println("good good study,day day up!");
    }

}


