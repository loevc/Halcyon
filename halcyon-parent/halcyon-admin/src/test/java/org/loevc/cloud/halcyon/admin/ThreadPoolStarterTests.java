package org.loevc.cloud.halcyon.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ThreadPoolExecutor;

@SpringBootTest
public class ThreadPoolStarterTests {

    @Autowired
    private ThreadPoolExecutor halcyonThreadPool;

    @Test
    void testThreadPoolStart(){
        System.out.println("coreThreadSize : " + halcyonThreadPool.getCorePoolSize());
    }
}
