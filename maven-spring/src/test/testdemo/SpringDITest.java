import pojo.Student;
import pojo.Teacher;
import iocSpring.Persion;
import iocSpring.SpringConfig;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by jiangcx on 2019/2/27
 * spring 依赖注入
 */
public class SpringDITest {
    private ApplicationContext ac = null;
    @Before
    public void init(){
        //ioc容器加载。  容器可理解为spring上下文，即ApplicationContext。
        ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
    @Test
    public void test(){
        Student student = ac.getBean("student",Student.class);
        System.out.println("name="+student.getSname());


        Teacher teacher = ac.getBean("teacher",Teacher.class);
        teacher.test();

        System.out.println(teacher.getConfig().getDriver());
        System.out.println(teacher.getConfig().getUrl());
        System.out.println(teacher.getConfig().getUsername());
        System.out.println(teacher.getConfig().getPassword());
        Teacher teacher1 = ac.getBean("teacher",Teacher.class);
        System.out.println(teacher.equals(teacher1));
    }

    /**
     * 通过注解的方式替换xml配置
     *  @Configuration 标注在类上，相当于把该类作为spring的xml配置文件中的<beans>，作用为：配置spring容器(应用上下文)
     *
     *  @Bean 标注在方法上(返回某个实例的方法)，等价于spring的xml配置文件中的<bean>，作用为：注册bean对象
     */
    @Test
    public void test2(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        System.out.println(context);
        Persion persion = (Persion) context.getBean("aPersion");
        persion.sayHello();
    }

}
