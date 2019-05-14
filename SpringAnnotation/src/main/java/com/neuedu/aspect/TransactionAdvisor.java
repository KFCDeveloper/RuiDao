package com.neuedu.aspect;

import com.neuedu.utils.DBUtils;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Component
public class TransactionAdvisor implements MethodInterceptor {
    /*
        because a adviser only have one advice, to specify the type of the advice,
        you must implements different interface

        invasive design（侵入式设计）
        非侵入式设计是不强迫用户实现接口，让用户感觉框架在哪里？

        because we must implemet a interface, this is called invasive interface
     */
    @Override
    public Object invoke(MethodInvocation c) throws Throwable {
        DBUtils.getConnection();
        try {
            //call our business logic
            //dao.deductMoney();
            //dao.addMoney();
            c.proceed();
            DBUtils.commitConnection();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            DBUtils.rollBackConnection();
            throw throwable;
        } finally {
            DBUtils.closeConnection();
        }
        return null;
    }
}
