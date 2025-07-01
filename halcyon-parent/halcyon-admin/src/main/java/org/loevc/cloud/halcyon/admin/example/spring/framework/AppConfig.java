package org.loevc.cloud.halcyon.admin.example.spring.framework;


import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("org.loevc.cloud.halcyon.admin.example.spring.framework")
public class AppConfig {

/*    @Bean
    public UserService userService1(){
        return new UserService();
    }

    @Bean
    public UserService userService2(){
        return new UserService();
    }*/

    @Bean(autowire = Autowire.BY_TYPE)
    public GoodSpuService goodSpuService(){
        return new GoodSpuService();
    }



}
