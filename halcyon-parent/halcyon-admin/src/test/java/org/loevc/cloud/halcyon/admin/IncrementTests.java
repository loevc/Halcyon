package org.loevc.cloud.halcyon.admin;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IncrementTests {

    @Test
    void test1(){
        int a = 9;
        int b = a++;
        int c = ++a;
        int d = c--;
        int e = --d;

        System.err.println(a);
        System.err.println(b);
        System.err.println(c);
        System.err.println(d);
        System.err.println(e);
    }

    @Test
    void testBinaryDisplay(){
        Integer a = -1;
        Integer b = -129;
        System.err.println(Integer.toBinaryString(a));
        System.err.println(Integer.toBinaryString(b));
    }

    @Test
    void testCache(){
        Short s ;
        Integer i;
        Byte b;
        Long l;
        Character c;
        Boolean bool;

    }


    @Test
    void testBoxed(){
        Integer i = 10;
        int a = i;
    }

    @Test
    void testEquals(){
        System.out.println(42==42.0);
    }
}
