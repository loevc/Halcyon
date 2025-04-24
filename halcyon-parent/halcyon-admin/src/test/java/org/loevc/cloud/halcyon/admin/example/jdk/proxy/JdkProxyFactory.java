package org.loevc.cloud.halcyon.admin.example.jdk.proxy;

import java.lang.reflect.Proxy;

public class JdkProxyFactory {
    public static Object getProxy(Object target){
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new SmsInvocationHandler(target)
        );
    }
}
