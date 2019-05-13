package com.neuedu.testannotation;

import com.neuedu.model.service.ITestService;
import com.neuedu.model.service.TestService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTestService {

    /**
     *  How many types of implementation of dynamic proxy
     *
     *  1. JDK support & cglib support, both of them are done at run time.(Spring AOP works on this)
     *
     *  2. AspectJ(this is third party utility), this framework create proxy class during compile path
     *  when compile JAVA file => class file, modify the class
     *  EmpService service = context.getBean(EmpService.class);// the instance is really Emp  没有产生额外的类，class文件是被篡改过的
     *  AspectJ need to take a control of JAVA compilation process.
     *  AspectJ have better performance.
     *  Spring does not have much to do with AspectJ, it just uses some of the AspectJ annotation
     *  Spring supports the integration of AspectJ(check the document)
     *  引用了org.aspectJ 是为了复用注解而已，没有使用编译功能，spring认为aspectJ功能太全，没有必要，但是在spring里面集成aspectJ也是可以的
     *  Spring 的AOP依赖于IOC 都交给IOC来管理
     *
     *  普通代理是自己写一个代理类，一个代理类是对应一个Service，就是代理模式
     *  动态代理是生成代理类
     */



    public static void main(String[] args) {
        //1.initialize the spring container
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //
        ITestService service = context.getBean(TestService.class);

        service.test();

        /*
         *  how spring works? spring create a class that implements this interface
         *
         *  in this case, spring implement dynamic proxy based on JDK support
         *
         *  Class xx$Proxy implements ITestService
         * {
         *      TestService service;
         *      public void addEmp()
         *      {
         *          //logAspect.before();
         *          //testAspect.test();
         *          //business logic
         *          try
         *          {
         *              super.addEmp();
         *              //logAspect.afterReturning();
         *          }
         *          catch(Exception)
         *          {
         *              //logAspect.afterThrowing();
         *          }
         *          finally
         *          {
         *              //logAspect.after();
         *          }
         *
         *          //logAspect.afterReturning();
         *      }
         * }
         * EmpService service = new xx$Proxy();
         * service.addEmp();
         * 这就是动态代理 Dynamic proxy
         */
    }

}
