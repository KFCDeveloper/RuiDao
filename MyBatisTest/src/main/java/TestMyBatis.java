import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import com.neuedu.model.mapper.DeptMapper;
import com.neuedu.model.po.Salgrade;
import com.neuedu.util.DBUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.neuedu.model.po.Dept;

public class TestMyBatis {
    private static SqlSession session = null;
//    public static void main(String[] args) {
//
//        //1. Create a sqlsessionFactory
//        String resource = "xml/mybatis-config.xml";
//        InputStream inputStream;
//        try {
//            inputStream = Resources.getResourceAsStream(resource);
//            SqlSessionFactory sqlSessionFactory =
//                    new SqlSessionFactoryBuilder().build(inputStream);
//
//            //org.apache.ibatis.session.defaults.DefaultSqlSessionFactory@35bbe5e8
//            //35bbe5e8 this is hashcode for this object
//            //(this hashcode is calculated according to object memory address)
//            System.out.println(sqlSessionFactory);
//
//            //2. Use SqlSessionFactory to get SqlSession(equal to connection)
////          SqlSession session = sqlSessionFactory.openSession();
//            session = sqlSessionFactory.openSession();
//
//            System.out.println(session);
//
//            //Run a SQL
//            //session.selectOne("com.neuedu.model.mapper.DeptMapper.selectDept", 10);
//            //Dept d = session.selectOne("com.neuedu.model.mapper.DeptMapper.selectDept", 20);
//
//            //new version
//            DeptMapper mapper = session.getMapper(DeptMapper.class);
//
//            //first example
//            Dept d = mapper.selectDept(20);
//            System.out.println(d.getDeptno()+"\t"+d.getDname()+"\t"+d.getLoc());
//
//            //second example
//            getAllDepts();
//
//            //third example
//            getDeptByName();
//
//            //forth example
//            getDeptByName();
//
//            //five example
//            addDept();
//            getSalagrade();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } finally {
//            if (session!=null){
//                session.close();
//            }
//
//        }
//    }
    public static void main(String[] args) {
//        getAllDepts();
        getSalgrade();
    }

    private static void getAllDepts(){
        SqlSession session = DBUtils.getInstance();
        DeptMapper mapper = session.getMapper(DeptMapper.class);
        List<Dept> d = mapper.selectAllDept();

        //to iterate this list
        Iterator<Dept> it = d.iterator();
        while (it.hasNext()){
            Dept item = it.next();
            //output it's content
            System.out.println(item.toString());
        }

    }

    private static void getDeptByName(){
        SqlSession session = DBUtils.getInstance();
        DeptMapper mapper = session.getMapper(DeptMapper.class);
        List<Dept> d = mapper.selectDeptByName("SEARCH");

        //to iterate this list
        Iterator<Dept> it = d.iterator();
        while (it.hasNext()){
            Dept item = it.next();
            //output it's content
            System.out.println(item.toString());
        }
    }

     private static void getDeptByNameAndLoc() {
        SqlSession session = DBUtils.getInstance();
        DeptMapper mapper = session.getMapper(DeptMapper.class);
        List<Dept> d = mapper.selectDeptByNameAndLoc("RESEARCH","DALLAS");

        //to iterate this list
        Iterator<Dept> it = d.iterator();
        while (it.hasNext()) {
            Dept item = it.next();
            //output it's content
            System.out.println(item.toString());
        }
    }

    public static void addDept() {
        SqlSession session = DBUtils.getInstance();
        DeptMapper mapper = session.getMapper(DeptMapper.class);
        mapper.addDept(50,"test","test");
        session.commit();
    }
    private static void getSalgrade() {
        SqlSession session = DBUtils.getInstance();
        DeptMapper mapper = session.getMapper(DeptMapper.class);

        List<Salgrade>list = mapper.getSalgrade(1);
        Iterator<Salgrade> it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
