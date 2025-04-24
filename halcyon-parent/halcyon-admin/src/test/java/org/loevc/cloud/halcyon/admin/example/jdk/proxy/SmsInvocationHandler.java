package org.loevc.cloud.halcyon.admin.example.jdk.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SmsInvocationHandler implements InvocationHandler {

    private final Object target;

    public SmsInvocationHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy pre");
//        System.out.println(proxy.toString());
        Object invoke = method.invoke(target, args);
        System.out.println("proxy after");
        return invoke;
    }
}
