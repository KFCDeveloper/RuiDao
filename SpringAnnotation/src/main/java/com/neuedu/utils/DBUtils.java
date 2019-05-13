package com.neuedu.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * this class is used to manage database connection
 */
public class DBUtils {
    //当前线程
    //只能放一个东西 Connection，同一个线程里的从里面取的都一样
    private static ThreadLocal<Connection> tl = new ThreadLocal<>();

    //this static block automaticallly runs when DBUtils is loaded into memory
    static {
        //load the database connector
        try {
            //将其加载到内存里，为了执行里面的静态代码块，所以new一下也行
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        //1. if there is connection inside threadLocal
        //thread.get(), threadlocal.set()
        if(tl.get()==null){
            //create a connection, and put it in threadlocal
            try {

                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/scott","root","");
                conn.setAutoCommit(false);
                tl.set(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return tl.get();
    }

    public static void commitConnection(){
        try {
            tl.get().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void rollBackConnection(){
        try {
            tl.get().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection(){
        //first close the connection
        try {
            tl.get().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //remove it from threadlocal
        tl.remove();
    }
}
