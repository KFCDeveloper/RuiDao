import com.neuedu.model.mapper.EmpMapper;
import com.neuedu.model.po.Emp;
import com.neuedu.util.DBUtils;
import org.apache.ibatis.session.SqlSession;

import java.sql.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class TestMyBatisEmp {
    public static void main(String[] args) {

        getInfos();

    }

    private static void addEmp() {
        //get SqlSession
        SqlSession session = DBUtils.getInstance();
        //get mapper
        EmpMapper mapper = session.getMapper(EmpMapper.class);
        //create a instance of Emp
        Emp emp = new Emp();
        emp.setEmpno(8888);
        emp.setEname("feiyy");
        emp.setMgr(7369);
        emp.setJob("teacher");
        //how to get a sql.Date
        //System.currentTimeMillis() returns milliseconds between now and 1970-1-1 0:0:0
        emp.setHiredate(new Date(System.currentTimeMillis()));
        emp.setSal(8888.88);
        emp.setComm(6666.66);
        emp.setDeptno(10);

        mapper.addEmp(emp);

        //to commit session
        session.commit();

    }

    private static void addEmp2() {
        //get SqlSession
        SqlSession session = DBUtils.getInstance();
        //get mapper
        EmpMapper mapper = session.getMapper(EmpMapper.class);

        HashMap<String, Object> map = new HashMap<String, Object>();

        map.put("ename", "feiyy");
        map.put("mgr", 7369);
        map.put("job", "teacher");
        map.put("hiredate", new Date(System.currentTimeMillis()));
        map.put("sal", "9999.99");
        map.put("deptno", 10);

        mapper.addEmp2(map);
        //<insert id="addDept2" useGeneratedKeys="false" keyProperty="empno">
        //output the empno
        System.out.println(map.get("empno"));

        //to commit session
        session.commit();

    }

    public static void updateEmp() {
        SqlSession session = DBUtils.getInstance();
        EmpMapper mapper = session.getMapper(EmpMapper.class);
        Emp emp = new Emp();
        emp.setEmpno(8888);
        emp.setSal(9998.66);
        emp.setComm(1888);

        mapper.updateEmp(emp);
        session.commit();
    }

    public static void deleteEmp() {
        SqlSession session = DBUtils.getInstance();
        EmpMapper mapper = session.getMapper(EmpMapper.class);

        mapper.deleteEmp(8891);
        session.commit();
    }

    public static void getJob() {
        SqlSession session = DBUtils.getInstance();
        EmpMapper mapper = session.getMapper(EmpMapper.class);

        System.out.println(mapper.getJobByEmpno(7369));
    }

    public static void getInfo() {
        SqlSession session = DBUtils.getInstance();
        EmpMapper mapper = session.getMapper(EmpMapper.class);

        HashMap hashMap = mapper.getInfoByEmpno(8888);
        System.out.println(hashMap.get("ename") + "\t" + hashMap.get("job"));
    }

    public static void findByColumn() {
        SqlSession session = DBUtils.getInstance();
        EmpMapper mapper = session.getMapper(EmpMapper.class);

        List list = mapper.FindByColumn("empno", 7369);
//        List list = mapper.FindByColumn("empno","BLAKE");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println(list.size());
    }

    public static void getInfos() {
        SqlSession session = DBUtils.getInstance();
        EmpMapper mapper = session.getMapper(EmpMapper.class);

        List<HashMap> list = mapper.getInfos();
        Iterator<HashMap> it = list.iterator();

        HashMap item;
        while (it.hasNext()) {
            item = it.next();
            System.out.println(item.get("empno") + "\t" + item.get("ename") + "\t" + item.get("job") + "\t" + item.get("mgr") + "\t" + item.get("hiredate") + "\t" + item.get("sal") + "\t" + item.get("comm") + "\t" + item.get("deptno") + "\t");
        }
    }

}
