package com.neuedu.model.service;

import java.sql.Connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.neuedu.model.dao.AccountDAO;
import com.neuedu.utils.DBUtils;

@Service
public class AccountService {
	
	@Autowired
	private AccountDAO dao;
	
	public void transferMoney()
	{
		/*
		 * 1. get a connection conn
		 *    and put the conn in threadlocal(all methods in the same thread can share the connection)
		 * 2. try
		 * {
		 *     
		 *     dao.addMoney();
		 *     
		 *     dao.deductMoney();
		 *     
		 *     conn.commit;
		 * }
		 * catch(Exception e)
		 * {
		 *     conn.rollback; 
		 * }
		 * finally
		 * {
		 *    conn.close();
		 * }
		 * 
		 */
		Connection conn = DBUtils.getConnection();
		
		try
		{
			dao.deductMoney();
			dao.addMoney();
			
			//commit
			DBUtils.commitConnection();
		}
		catch(Exception e)
		{
			//rollback
			DBUtils.rollbackConnection();
		}
		finally
		{
			//close connection
			DBUtils.closeConnection();
		}	
	}
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		AccountService service = context.getBean(AccountService.class);
		
		service.transferMoney();
	
	}

}
