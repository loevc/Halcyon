package org.loevc.cloud.halcyon.admin;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReflectTests {

    @Test
    void testReflect() throws ClassNotFoundException {
        ClassLoader.getSystemClassLoader().loadClass("org.loevc.cloud.halcyon.admin.ReflectTests");
    }
}
