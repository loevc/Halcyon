package org.loevc.cloud.halcyon.admin.example.spring.framework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Field;

public class BeanSample {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService orderService = (OrderService) applicationContext.getBean("orderService");
        // 怎么保证单例呢？ 通过 Map 实现
//        OrderService orderService2 = (OrderService) applicationContext.getBean("orderService");
//        OrderService orderService3 = (OrderService) applicationContext.getBean("orderService");
        orderService.print();


        /*OrderService bean = new OrderService();
        for (Field declaredField : bean.getClass().getDeclaredFields()) {
            if (declaredField.isAnnotationPresent(Autowired.class)){
                declaredField.set(bean, autowired object);
            }
        }*/

//        Object o = new Object();
//        applicationContext.getBeanFactory().registerSingleton("o", o);
//        System.out.println("end");
//
///*        System.out.println(applicationContext.getBean("userService"));
//        System.out.println(applicationContext.getBean("userService"));
//        System.out.println(applicationContext.getBean("userService"));
//        System.out.println(applicationContext.getBean("userService1"));
//        System.out.println(applicationContext.getBean("userService2"));*/
//
//        GoodSpuService spuService = (GoodSpuService) applicationContext.getBean("goodSpuService");
//        spuService.print();

    }

}
