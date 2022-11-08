package fr.gdai.mybatis.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("fr.gdai.mybatis")
@Import({JdbcConfig.class, MybatisConfig.class})
public class SpringConfig {

}
