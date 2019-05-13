package com.neuedu.testannotation;

import com.neuedu.model.service.DeptService;
import com.neuedu.model.service.EmpService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//AOP 面向切面可插拔
public class TestEmpService {
    public static void main(String[] args) {
        //1.initialize the spring container
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.get a instance of the service
        EmpService service = context.getBean(EmpService.class);
        /*
         * How spring works? Spring will create a child class
         *
         * Dynamic Proxy can be supported by JDK, JDK the proxied class to implement a interface.
         * Here, Dynamic Proxy supported by Spring is called cglib(third party component)
         * Spring also support JDK proxy
         *
         * Spring implements dynamic proxy based on cglib(supported by third party component)
         *
         * Class xx$Proxy extends EmpService
         * {
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


        //3.invoke its method to see if aspect is weaved or not
        service.addEmp();
        service.deleteEmp();

        DeptService service2 = context.getBean(DeptService.class);
    }
}
