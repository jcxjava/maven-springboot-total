package iocSpring;

import pojo.ConfigProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by jiangcx on 2019/3/1
 *
 * 通过注解的方式替换xml配置
 *  @Configuration 标注在类上，相当于把该类作为spring的xml配置文件中的<beans>，作用为：配置spring容器(应用上下文)
 *  @Bean 标注在方法上(返回某个实例的方法)，等价于spring的xml配置文件中的<bean>，作用为：注册bean对象
 *
 */
@Configuration
@ImportResource("classpath:/jdbc_driver.xml") //
public class SpringConfig {
    @Bean
    public Persion aPersion(){
        return new Persion();
    }

    @Bean
    public ConfigProperties mysqlConfig(){
        return new ConfigProperties();
    }
}
