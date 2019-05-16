import pojo.ConfigProperties;
import iocSpring.SpringConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;
import java.util.Map;

/**
 * spirng jdbc：
 * Created by jiangcx on 2019/3/5
 */

public class SpringJDBCTest {
    /**
     * 通过applicationContext.xml配置的方式连接数据库
     */
    @Test
    public void testByXml(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate",JdbcTemplate.class);
        System.out.println(jdbcTemplate);
        String sql = "select cname from course where cno = '3-105' ";
        String str = jdbcTemplate.queryForObject(sql, String.class);
        System.out.println(str);
    }

    /**
     * 通过注解的方式连接数据库
     */
    @Test
    public void testByAnnotation(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
        ConfigProperties cp = (ConfigProperties)ac.getBean("mysqlConfig");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        System.out.println(cp.getDriver());
        System.out.println(cp.getUrl());
        dataSource.setDriverClassName(cp.getDriver());
        dataSource.setUrl(cp.getUrl());
        dataSource.setUsername(cp.getUsername());
        dataSource.setPassword(cp.getPassword());
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<Map<String, Object>> students = jdbcTemplate.queryForList("SELECT * from student");
        System.out.println("students:"+students);
    }

}
