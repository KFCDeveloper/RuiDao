import com.neuedu.springtestcore.ExampleBean;
import com.neuedu.springtestcore.TestService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDI {
    public static void main(String[] args) {
        //1. get Spring IOC container
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2. get TestService instance from container
        TestService instance = context.getBean(TestService.class);
        //if we can get a xx@xx, we can make sure dependencies is injected by Spring
        instance.outputDependency();

    }

    public static void testExampleBean(){
        //1. get Spring IOC container
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2. get TestService instance from container
        ExampleBean exampleBean = context.getBean(ExampleBean.class);
        exampleBean.outPutInfo();
    }
}
