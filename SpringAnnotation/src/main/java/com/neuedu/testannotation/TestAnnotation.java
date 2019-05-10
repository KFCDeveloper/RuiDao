package com.neuedu.testannotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnotation {
    public static void main(String[] args) {
        //1.get Spring IOC container
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //2.get Bean
        //2. get Bean
        TestController bean = context.getBean(TestController.class);
//        TestController bean = (TestController) context.getBean("testController");
//        System.out.println(bean);
        bean.outPutCollaborators();
    }
}
