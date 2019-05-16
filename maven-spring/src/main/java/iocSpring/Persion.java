package iocSpring;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by jiangcx on 2019/3/1
 */
public class Persion {
    @Value("James")
    private String name;
    private Integer age;
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void sayHello(){
        System.out.println("hello:"+name);
    }
}
