package com.neuedu.model.service;

import com.neuedu.model.dao.AccountDAO;
import com.neuedu.utils.DBUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@Service
public class AccountService {

    @Autowired
    private AccountDAO dao;

    public void transferMoney(){
        /**
         * 1.   get connection
         *      and put the conn in threadlocal()
         * 2.   try
         * {
         *      //these method must use the same conn, 否则滚动的时候就会出错
         *      dao.addMoney();
         *
         *      ado.deductMoney();
         *
         *      conn.commit;
         * }
         * catch(Exception e)
         * {
         *      conn.rollback;
         * }
         * finally
         * {
         *      conn.close();
         * }
         */
        Connection conn = DBUtils.getConnection();


        try
        {
            //@Before
            //set autocommit = false; control autocommit by ourselves
            conn.setAutoCommit(false);

            dao.deductMoney();
            dao.addMoney();

            //@After
            DBUtils.commitConnection();
        }catch (Exception e)
        {
            //@After-throwing
            //这里要打印了才能看见红色的报错
            e.printStackTrace();
            //rollback
            DBUtils.rollBackConnection();
        }finally {
            //@After-returning
            //close connection
            DBUtils.closeConnection();
        }
    }

    //这里一定要向上抛出异常，抛给框架，不能自己把异常catch了，这样框架看起来你就没有异常
    public void transferMoneyAspect() throws SQLException {
        dao.deductMoney();
        dao.addMoney();
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService service = context.getBean(AccountService.class);

//        service.transferMoney();

        try {
            service.transferMoneyAspect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
