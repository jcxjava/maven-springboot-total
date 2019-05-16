package com.jiangcx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * springboot 默认扫描启动类同包及子包下的注解。
 */
@SpringBootApplication //标识该类为springboot的启动类 包含@Configuration、@EnableAutoConfiguration、@ComponentScan
@ServletComponentScan //在springboot启动时会扫描 @WebServlet注解的类，并进行实例化
//@ComponentScan(basePackages="com.jiangcx.controller")
@MapperScan("com.jiangcx.mapper")
public class MavenSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MavenSpringbootApplication.class, args);
	}

}
