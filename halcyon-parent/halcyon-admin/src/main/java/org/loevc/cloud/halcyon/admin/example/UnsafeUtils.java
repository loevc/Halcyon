package org.loevc.cloud.halcyon.admin.example;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2025/4/25 9:29
 * @Description TODO
 * @Version 1.0
 */
public class UnsafeUtils {

    public static Unsafe getUnsafe(){
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            return (Unsafe)theUnsafe.get(null);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
