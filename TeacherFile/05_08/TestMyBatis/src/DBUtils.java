import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class DBUtils {
	
	public static SqlSession getInstance()
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		SqlSession session = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory =
					  new SqlSessionFactoryBuilder().build(inputStream);
			
			//2. Use SqlSessionFactory to get SqlSession(equal to connection)
			session = sqlSessionFactory.openSession();	
			//close session
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return session;
	}

}
