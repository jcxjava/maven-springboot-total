package jdbcByAnnotation;

import pojo.ConfigProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jiangcx on 2019/3/6
 */
@Configuration
public class JDBCAnnotatio {
    @Bean
    public ConfigProperties mysqlConfig(){
        return new ConfigProperties();
    }
}
