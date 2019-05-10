import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.neuedu.model.mapper.DeptMapper;
import com.neuedu.model.po.Dept;

public class TestMyBatis {

	public static void main(String[] args) {
		
		//invoke method;
		//getAllDepts();
		
		//getDeptByName();
		
		//addDept();
		getDeptByName();
		
	/*	SqlSession session = null;
		
		//1. Create a sqlsessionFactory
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory =
					  new SqlSessionFactoryBuilder().build(inputStream);
			
			//org.apache.ibatis.session.defaults.DefaultSqlSessionFactory@35bbe5e8
			//35bbe5e8 this is hashcode for this object
			//(this hashcode is calculated according to object memory address)
			System.out.println(sqlSessionFactory);
			
			//2. Use SqlSessionFactory to get SqlSession(equal to connection)
			session = sqlSessionFactory.openSession();
			
			System.out.println(session);
			
			//Run a SQL
			//session.selectOne("com.neuedu.model.mapper.DeptMapper.selectDept", 10);
			Dept d = session.selectOne("a.selectDept", 20);
			
			System.out.println(d.getDeptno()+"\t"+d.getDname()+"\t"+d.getLoc());
			
			
			//new version,
			//MyBatis create a class that implements DeptMapper, overwrite all of its methods
			*//**
			 * 
			 * ¶¯Ì¬´úÀí
			 * 
			 * class $Proxy0 implements DeptMapper
			 * {
			 *     public Dept selectDept(int deptno)
			 *     {
			 *     
			 *       all of the JDBC sourcecode in here 
			 *     
			 *     }   
			 * }
			 * 
			 * 
			 *//*
			
			//deptMapper is object of the dynamicly created class
			DeptMapper deptMapper = session.getMapper(DeptMapper.class);
					
			Dept d = deptMapper.selectDept(10);
			
			System.out.println(d.getDeptno()+"\t"+d.getDname()+"\t"+d.getLoc());
			
			//close session
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}*/
	}
	
	public static void addDept()
	{
         SqlSession session = null;
		
		//1. Create a sqlsessionFactory
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory =
					  new SqlSessionFactoryBuilder().build(inputStream);
			
			//2. Use SqlSessionFactory to get SqlSession(equal to connection)
			session = sqlSessionFactory.openSession();
			
			//deptMapper is object of the dynamicly created class
			DeptMapper deptMapper = session.getMapper(DeptMapper.class);
					
			deptMapper.addDept("test3", "test3");
			
		    //when we do insert, update, delete, we must manually commit session
			session.commit();
			
			//close session
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
	}
	
	public static void getAllDepts()
	{
         SqlSession session = null;
		
		//1. Create a sqlsessionFactory
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory =
					  new SqlSessionFactoryBuilder().build(inputStream);
			
			//2. Use SqlSessionFactory to get SqlSession(equal to connection)
			session = sqlSessionFactory.openSession();
			
			//deptMapper is object of the dynamicly created class
			DeptMapper deptMapper = session.getMapper(DeptMapper.class);
					
			List<Dept> d = deptMapper.selectAllDept();
			
			//to iterate this list
			Iterator<Dept> it = d.iterator();
			while(it.hasNext())
			{
				Dept item = it.next();
				//output its content
				System.out.println(item.getDeptno()+"\t"+item.getDname()+"\t"+item.getLoc());
			}
			
			//close session
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
	}
	
	public static void getDeptByName()
	{
         SqlSession session = null;
		
		//1. Create a sqlsessionFactory
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory =
					  new SqlSessionFactoryBuilder().build(inputStream);
			
			//2. Use SqlSessionFactory to get SqlSession(equal to connection)
			session = sqlSessionFactory.openSession();
			
			//deptMapper is object of the dynamicly created class
			DeptMapper deptMapper = session.getMapper(DeptMapper.class);
				
			Dept condition = new Dept();
			condition.setDname("SEARCH");
			List<Dept> d = deptMapper.selectDeptByName("SEARCH");
			
			//to iterate this list
			Iterator<Dept> it = d.iterator();
			while(it.hasNext())
			{
				Dept item = it.next();
				//output its content
				System.out.println(item.getDeptno()+"\t"+item.getDname()+"\t"+item.getLoc());
			}
			
			//close session
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
	}
	
	public static void getDeptByNameAndLoc()
	{
         SqlSession session = null;
		
		//1. Create a sqlsessionFactory
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory =
					  new SqlSessionFactoryBuilder().build(inputStream);
			
			//2. Use SqlSessionFactory to get SqlSession(equal to connection)
			session = sqlSessionFactory.openSession();
			
			//deptMapper is object of the dynamicly created class
			DeptMapper deptMapper = session.getMapper(DeptMapper.class);
					
			List<Dept> d = deptMapper.selectDeptByNameAndLoc("RESEARCH", "DALLAS");
			
			//to iterate this list
			Iterator<Dept> it = d.iterator();
			while(it.hasNext())
			{
				Dept item = it.next();
				//output its content
				System.out.println(item.getDeptno()+"\t"+item.getDname()+"\t"+item.getLoc());
			}
			
			//close session
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
	}
	
	
	
}
