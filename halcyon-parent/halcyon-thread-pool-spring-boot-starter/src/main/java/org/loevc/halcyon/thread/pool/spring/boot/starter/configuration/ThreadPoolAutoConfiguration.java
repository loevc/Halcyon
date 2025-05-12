package org.loevc.halcyon.thread.pool.spring.boot.starter.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Configuration
public class ThreadPoolAutoConfiguration {

    private static final AtomicInteger count = new AtomicInteger(0);

    @Bean
    @ConditionalOnClass(ThreadPoolExecutor.class)
    public ThreadPoolExecutor halcyonThreadPool(){
        return new ThreadPoolExecutor(4, 16, 10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100),
                r ->  new Thread(r, "halcyon-" + count.incrementAndGet()),
                new ThreadPoolExecutor.AbortPolicy());
    }
}

