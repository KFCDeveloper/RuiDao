package com.neuedu.testannotation;

import com.neuedu.model.service.EmpService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//
public class TestEmpService {
    public static void main(String[] args) {
        //1.initialize the spring container
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.get a instance of the service
        EmpService service = context.getBean(EmpService.class);
        //3.invoke its method to see if aspect is weaved or not
        service.
    }
}
