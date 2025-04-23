package org.loevc.cloud.halcyon.admin;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SynchronizedTests {

    @Test
    void test1(){
        Integer a = 1;
        synchronized (a){

        }
    }
}
