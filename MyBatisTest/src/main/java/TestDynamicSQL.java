import com.neuedu.model.mapper.DeptMapper;
import com.neuedu.model.mapper.EmpMapper;
import com.neuedu.model.po.Dept;
import com.neuedu.model.po.Emp;
import com.neuedu.util.DBUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class TestDynamicSQL {
    public static void main(String[] args) {
        queryByPage();
    }


    /**
     * //In our java programs:
     * String sql = "select * from emp where 1=1"
     * if(empno!=null){
     * sql = sql + "and empno = ?";
     * }
     * if(ename!=null){
     * sql = sql + "and ename = ?";
     * }
     * <p>
     * PreparedStatement stat = conn.PreparedStatement(sql);
     * //replace? with the value
     * Int index = 1;
     * if(empno!=null){
     * Stat.setInt(index++,empno);
     * }if(ename!=null){
     * Stat.setString(index++,ename);
     * }
     */
//    Dynamic SQL, for conditional query
    private static void searchByCondition() {
        SqlSession session = DBUtils.getInstance();
        EmpMapper mapper = session.getMapper(EmpMapper.class);

        Emp e = new Emp();
//        e.setEname("SMITH");
        e.setEmpno(7369);
//        e.setEname("SMITH");
        List<Emp> list = mapper.getEmpByConditions(e);
        for (Emp item : list) {
            System.out.println(item);
        }
    }

    private static void searchEmpByOneCondition() {
        SqlSession session = DBUtils.getInstance();
        EmpMapper mapper = session.getMapper(EmpMapper.class);

        Emp e = new Emp();
//        e.setEname("SMITH");
        e.setEmpno(7369);
//        e.setEname("SMITH");
        List<Emp> list = mapper.getEmpByOneCondition(e);
        for (Emp item : list) {
            System.out.println(item);
        }
    }

    private static void updateByCondition() {
        SqlSession session = DBUtils.getInstance();
        EmpMapper mapper = session.getMapper(EmpMapper.class);

        Emp e = new Emp();
        e.setEmpno(8888);
        e.setEname("feiyuanyuan");
        e.setJob("manager");

        mapper.updatEmpByCondition(e);

        session.commit();
    }

    private static void getEmps() {
        SqlSession session = DBUtils.getInstance();
        EmpMapper mapper = session.getMapper(EmpMapper.class);

        List<Integer> list = new ArrayList<>();
        list.add(7566); //new Integer(7566) 自动装箱 传一个基本类型，包装成包装类
        list.add(7369);
        list.add(8889);

        List<Emp> emps = mapper.getEmps(list);
        for (Emp e : emps) {
            System.out.println(e);
        }
    }

    private static void getEmps2() {
        SqlSession session = DBUtils.getInstance();
        EmpMapper mapper = session.getMapper(EmpMapper.class);

        int[]array = new int[3];
        array[0] = 7566;
        array[1] = 7369;
        array[2] = 8889;

        List<Emp> emps = mapper.getEmps2(array);
        for (Emp e : emps) {
            System.out.println(e);
        }
    }

    private static void queryByPage() {
        SqlSession session = DBUtils.getInstance();
        EmpMapper mapper = session.getMapper(EmpMapper.class);

//        从index开始，打出recordCount个
        List<Emp> emps = mapper.getEmpByPage(0,10);
        for (Emp e : emps) {
            System.out.println(e);
        }

        /*
          this time, get data from cache
          用同一个session 使用同一句sql就从cache中拿数据
          by default, data will be cached and shared in one session
          if you create two different sessions, data can not be cached
         */
        List<Emp> emps2 = mapper.getEmpByPage(0,10);
        for (Emp e : emps2) {
            System.out.println(e);
        }

        // 因为这里是 java project 所以当java程序自己结束时，所有的都没有了，所以关不关session都可以
        //如果是web project, session 不会消失，会一直跑
        session.close();
    }
}
