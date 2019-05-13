package com.neuedu.aspect;

import org.aspectj.lang.annotation.Before;

public class TestAspect {
    @Before("execution(* com.neuedu.model.service.*.*(..))")
    public void test1(){
        System.out.println("test");
    }
}
