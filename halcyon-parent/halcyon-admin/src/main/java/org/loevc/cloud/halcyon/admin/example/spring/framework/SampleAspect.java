package org.loevc.cloud.halcyon.admin.example.spring.framework;

//import org.aopalliance.intercept.Joinpoint; // 这个类不对哦
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SampleAspect {

    @Before("execution(public void org.loevc.cloud.halcyon.admin.example.spring.framework.OrderService.print())")
    public void sampleBefore(JoinPoint joinPoint){
        System.out.println("before");
    }

}
