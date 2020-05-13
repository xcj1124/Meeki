package xaau.xcj.Curriculum.resource.management;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * @auther: Meeki
 * @data: 2019/3/12 11:02
 * @message:配置数据源
 */
@Configuration
public class DataSoureceConfig {
    @Bean
    public DataSource dataSource(Environment environment) {
        System.out.println("------------->"+environment.getProperty("spring.datasource.url"));
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(environment.getProperty("spring.datasource.url"));
        hikariDataSource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
        hikariDataSource.setUsername(environment.getProperty("spring.datasource.username"));
        hikariDataSource.setPassword(environment.getProperty("spring.datasource.password"));
        return hikariDataSource;
    }
}
