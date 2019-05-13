package com.neuedu.aspect;

import com.neuedu.utils.DBUtils;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TransactionAspect {
    @Before("execution(* com.neuedu.model.service.AccountService.transferMoneyAspect(..))")
    public void getConnection() {
        DBUtils.getConnection();
    }

    @AfterReturning("execution(* com.neuedu.model.service.AccountService.transferMoneyAspect(..))")
    public void closeConnection() {
        DBUtils.closeConnection();
    }

    @AfterThrowing("execution(* com.neuedu.model.service.AccountService.transferMoneyAspect(..))")
    public void rollBackConnection() {
        DBUtils.rollBackConnection();
    }

    @After("execution(* com.neuedu.model.service.AccountService.transferMoneyAspect(..))")
    public void commitConnection() {
        DBUtils.commitConnection();
    }
}
