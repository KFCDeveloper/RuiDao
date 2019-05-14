package com.neuedu.aspect;

import com.neuedu.utils.DBUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
//method1: 前三个注解
//method2: 最后一个@Around注解
public class TransactionAspect {
    @Before("execution(* com.neuedu.model.service.AccountService.transferMoneyAspect(..))")
    public void getConnection() {
        DBUtils.getConnection();
    }

    @AfterReturning("execution(* com.neuedu.model.service.AccountService.transferMoneyAspect(..))")
    public void commitConnection() {
        DBUtils.commitConnection();
        DBUtils.closeConnection();

    }

    @AfterThrowing("execution(* com.neuedu.model.service.AccountService.transferMoneyAspect(..))")
    public void rollBackConnection() {
        DBUtils.rollBackConnection();
        DBUtils.closeConnection();
    }


    /*@After("execution(* com.neuedu.model.service.AccountService.transferMoneyAspect(..))")
    public void closeConnection() {
        DBUtils.closeConnection();
    }
    */

    //当只需要写简单的东西的时候，就只写@After或者@Before之类的
    //当我用Around的时候，就要让我return Object
    /*
        around is very powerfully, it allows you control your proxy object all by your self.
     */
//    @Around("execution(* com.neuedu.model.service.AccountService.transferMoneyAspect(..))")
//    public Object process(ProceedingJoinPoint pjp) throws Throwable {
//        DBUtils.getConnection();
//
//        try {
//            //call our business logic
//            //dao.deductMoney();
//            //dao.addMoney();
//            pjp.proceed();
//            DBUtils.commitConnection();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//            DBUtils.rollBackConnection();
//            throw throwable;
//        } finally {
//            DBUtils.closeConnection();
//        }
//        return null;
//    }

}
