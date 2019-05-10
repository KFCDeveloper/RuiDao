package com.neuedu.springtestcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//Dependency Injection
public class TestService {

    //IOC inversion of control, also called DI(dependency injection)
    //collaborator
    private TestDAO testDAO;
    private UserDAO userDAO;

    public TestService(TestDAO testDAO, UserDAO userDAO) {
        this.testDAO = testDAO;
        this.userDAO = userDAO;
    }

    /*private TestService(){
            System.out.println("spring create a bean");
        }

        //如果改成 setTestdao Spring就会识别不了
        //naming rule of the setter method, setTestDAO
        public void setTestDAO(TestDAO testDAO) {
            this.testDAO = testDAO;
        }

        public void setUserDAO(UserDAO userDAO) {
            this.userDAO = userDAO;d
        }
        */
    public void outputDependency(){
        System.out.println("testDAO");
    }

    public static void main(String[] args) {
        //get instance from Spring container

        //by default, spring uses singleton mode
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //get instance from Spring container
        Test3(context);

    }

    public static void Test1(ApplicationContext context){
        //by default, spring uses singleton mode
        TestService service = (TestService)context.getBean("testService");
        TestService service2 = (TestService)context.getBean("testService");
        TestService service3 = (TestService)context.getBean("testService");

        System.out.println(service);
        System.out.println(service2);
        System.out.println(service3);
    }

    public static void Test2(ApplicationContext context){
        TestBean bean1 = (TestBean)context.getBean("testBean");
        TestBean bean2 = (TestBean)context.getBean("testBean");
        TestBean bean3 = (TestBean)context.getBean("testBean");
        TestBean bean4 = (TestBean)context.getBean("testBean");
        TestBean bean5 = (TestBean)context.getBean("testBean");
        TestBean bean6 = (TestBean)context.getBean("testBean");
        TestBean bean7 = (TestBean)context.getBean("testBean");
        TestBean bean8 = (TestBean)context.getBean("testBean");
        TestBean bean9 = (TestBean)context.getBean("testBean");
        TestBean bean10 = (TestBean)context.getBean("testBean");

        System.out.println(bean1);
        System.out.println(bean2);
        System.out.println(bean3);
        System.out.println(bean4);
        System.out.println(bean5);
        System.out.println(bean6);
        System.out.println(bean7);
        System.out.println(bean8);
        System.out.println(bean9);
        System.out.println(bean10);
    }

    public static void Test3(ApplicationContext context){
        System.out.println("===================================");

        TestBean2 t = context.getBean(TestBean2.class);
        TestBean2 t2 = context.getBean(TestBean2.class);
        TestBean2 t3 = context.getBean(TestBean2.class);
        System.out.println(t);
        System.out.println(t2);
        System.out.println(t3);
    }
}
