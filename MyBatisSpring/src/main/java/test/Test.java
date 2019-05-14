package test;

import com.neuedu.model.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        //1.initialize the spring container
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //2.get Account Service
        AccountService service = context.getBean(AccountService.class);

        //3.invoke
        service.transferMoney();
    }
}
