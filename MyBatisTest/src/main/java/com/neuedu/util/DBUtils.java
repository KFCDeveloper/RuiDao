package com.neuedu.util;

import com.neuedu.model.mapper.DeptMapper;
import com.neuedu.model.po.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class DBUtils {
    public static SqlSession getInstance(){
        //1. Create a sqlsessionFactory
        String resource = "xml/mybatis-config.xml";
        InputStream inputStream;
        SqlSession session = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(inputStream);

            //org.apache.ibatis.session.defaults.DefaultSqlSessionFactory@35bbe5e8
            //35bbe5e8 this is hashcode for this object
            //(this hashcode is calculated according to object memory address)
            System.out.println(sqlSessionFactory);

            //2. Use SqlSessionFactory to get SqlSession(equal to connection)
//          SqlSession session = sqlSessionFactory.openSession();
            session = sqlSessionFactory.openSession();


            //Run a SQL
            //session.selectOne("com.neuedu.model.mapper.DeptMapper.selectDept", 10);
            //Dept d = session.selectOne("com.neuedu.model.mapper.DeptMapper.selectDept", 20);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return session;
    }
}
