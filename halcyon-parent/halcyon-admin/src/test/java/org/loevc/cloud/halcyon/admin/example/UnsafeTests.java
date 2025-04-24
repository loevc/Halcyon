package org.loevc.cloud.halcyon.admin.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

@SpringBootTest
public class UnsafeTests {

    @Test
    void testUnsafe(){
        Unsafe unsafe = Unsafe.getUnsafe();
    }

    @Test
    void test2(){
        Unsafe unsafe;
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe) theUnsafe.get(null);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        unsafe.allocateMemory(10);

    }
}
