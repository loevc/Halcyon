package org.loevc.cloud.halcyon.admin;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.concurrent.ThreadPoolExecutor;

@Slf4j
@SpringBootTest
public class ThreadPoolStarterTests {

    @Autowired
    private ThreadPoolExecutor halcyonThreadPool;

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void testThreadPoolStart(){
        System.out.println("coreThreadSize : " + halcyonThreadPool.getCorePoolSize());
        log.info("coreThreadSize : {}", halcyonThreadPool.getCorePoolSize());
        log.info("log print");
        halcyonThreadPool.execute( () -> System.out.println("print info test"));
        halcyonThreadPool.execute( () -> log.info("print info test"));
        int a = 1/0;
    }

    @Test
    void testContext(){
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            log.info("{} of Type: {}", beanDefinitionName, applicationContext.getBean(beanDefinitionName).getClass());
        }
    }

}
