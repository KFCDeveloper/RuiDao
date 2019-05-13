package com.neuedu.model.dao;

import com.neuedu.utils.DBUtils;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class AccountDAO {
    public void addMoney() throws SQLException{
        //get connection in here?
        Connection conn = DBUtils.getConnection();
        PreparedStatement statement = conn.prepareStatement("update account2 set money = money+100 where id = 2");
        statement.executeUpdate();

        if(statement!=null){
            statement.close();
        }
        //don't close the conn inside DAO method.
    }

    //要是里面写try catch 了的话，自己就catch住了，那么外层调用的时候就觉得没有exception了，就没有办法在catch住exception的时候回滚了
    public void deductMoney() throws SQLException{
        //get connection from threadLocal
        //get connection in here?
        Connection conn = DBUtils.getConnection();
        PreparedStatement statement = conn.prepareStatement("update account set money = money-100 where id = 1");
        statement.executeUpdate();
        if(statement!=null){
            statement.close();
        }
        //don't close the conn inside DAO method.
    }
}
