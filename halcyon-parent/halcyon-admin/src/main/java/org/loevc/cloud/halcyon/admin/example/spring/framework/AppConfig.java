package org.loevc.cloud.halcyon.admin.example.spring.framework;


import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@ComponentScan("org.loevc.cloud.halcyon.admin.example.spring.framework")
@EnableTransactionManagement
@Configuration
public class AppConfig {

/*    @Bean
    public UserService userService1(){
        return new UserService();
    }

    @Bean
    public UserService userService2(){
        return new UserService();
    }*/

//    @Bean(autowire = Autowire.BY_TYPE)
//    public GoodSpuService goodSpuService(){
//        return new GoodSpuService();
//    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource());
        return transactionManager;
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://192.168.1.9:3306/loevc?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT%2B8&allowMultiQueries=true&allowPublicKeyRetrieval=true");
        dataSource.setUsername("root");
        dataSource.setPassword("mysql57");
        return dataSource;
    }


}
