package com.neuedu.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAsPect {

    //aspectJ weaving syntax
    //execution(* com.neuedu.model.service.*.*(..))")

    //stands for the before method will be weaved into all methods under classes of com.neuedu.model
    //weaved == cut

    /**
     * AOP: many concepts,
     * advice(通知): before, after, after-throwing(works in case of exception), after-returning(works when there is no exception)(in spring, it is always a method in a aspect)
     * after-throwing and after-returning, there are mutually exclusive
     * pointcut(切入点): specifies which methods the advice should be weaved
     * weaving(织入): the behavior of cutting into other methods
     */
    @Before("execution(* com.neuedu.model.service.*.*(..))")
    public void before() {
        //before the method executes
        System.out.println("methods before");
    }

    @After("execution(* com.neuedu.model.service.*.*(..))")
    public void after() {
        //after the method executes;
        System.out.println("methods after");
    }

    @AfterThrowing("execution(* com.neuedu.model.service.*.*(..))")
    public void afterThrowing() {
        System.out.println("methods exception");
    }

    @AfterReturning("execution(* com.neuedu.model.service.*.*(..))")
    public void afterReturning() {
        System.out.println("methods returning");
    }
}
