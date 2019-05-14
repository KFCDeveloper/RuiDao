package com.neuedu.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.neuedu.utils.DBUtils;

@Repository
public class AccountDAO {
	
	public void addMoney()
	{
		//get connection from threadlocal
		Connection conn= DBUtils.getConnection();
		try {
			PreparedStatement statement = conn.prepareStatement("update account2 set money = money+100 where id = 2");
		    //execute the sql
			statement.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//don't close the conn inside DAO method.
		
	}
	
	public void deductMoney()
	{
		//get connection from threadlocal
		Connection conn= DBUtils.getConnection();
		try {
			PreparedStatement statement = conn.prepareStatement("update account set money = money-100 where id = 1");
		    //execute the sql
			statement.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//don't close the conn inside DAO method.
	}

}
