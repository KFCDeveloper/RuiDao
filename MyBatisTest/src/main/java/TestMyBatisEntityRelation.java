import com.neuedu.model.mapper.DeptMapper;
import com.neuedu.model.mapper.EmpMapper;
import com.neuedu.model.mapper.ScoresMapper;
import com.neuedu.model.po.Dept;
import com.neuedu.model.po.Emp;
import com.neuedu.model.po.Scores;
import com.neuedu.model.po.Student;
import com.neuedu.util.DBUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TestMyBatisEntityRelation {
    public static void main(String[] args) {
        selectStudentById();
    }

    private static void getEmpInfo() {
        SqlSession session = DBUtils.getInstance();
        EmpMapper mapper = session.getMapper(EmpMapper.class);
        Emp emp =  mapper.getEmpInfoByEmpno(7369);
        System.out.println(emp);
        System.out.println(emp.getD());
    }

    private static void getDeptInfo() {
        SqlSession session = DBUtils.getInstance();
        DeptMapper mapper = session.getMapper(DeptMapper.class);
        Dept dept = mapper.getDept(10);
        System.out.println(dept);
        dept.getEmps().forEach(System.out::println);

    }

    private static void getDepts() {
        SqlSession session = DBUtils.getInstance();
        DeptMapper mapper = session.getMapper(DeptMapper.class);
        List<Dept> ds = mapper.getDepts();
        for(Dept d:ds)
        {
            System.out.println(d.getDeptno()+"\t"+d.getDname()+"\t"+d.getLoc());

            //get all employees of this department
            List<Emp> list = d.getEmps();
            for(Emp e:list)
            {
                System.out.println(e.getEmpno()+"\t"+e.getEname());
            }
        }
    }

    private static void getDeptLazy() {
        SqlSession session = DBUtils.getInstance();
        DeptMapper mapper = session.getMapper(DeptMapper.class);
        Dept d = mapper.getDeptLazy(10);

        System.out.println(d.getDname());

        for (Emp it: d.getEmps()) {
            System.out.println(it);
        }

    }

    private static void getDeptLazyAll() {
        SqlSession session = DBUtils.getInstance();
        DeptMapper mapper = session.getMapper(DeptMapper.class);
        List<Dept> list= mapper.getDeptLazyAll();

        for (Dept d:list) {
            System.out.println("---------------------");
            System.out.println(d.getDname());
            for (Emp e:d.getEmps()){
                System.out.println(e.getEname());
            }
        }

    }

    private static void getEmpLazy() {
        SqlSession session = DBUtils.getInstance();
        EmpMapper mapper = session.getMapper(EmpMapper.class);
        List<Emp> d = mapper.getEmpInfoByEmpnoLazy(7698);

        for (Emp e:d) {
            System.out.println(e);
        }

//        for (Emp item:d) {
//            System.out.println(item.getD());
//        }

    }

    private static void selectStudentById(){
        SqlSession session = DBUtils.getInstance();
        ScoresMapper mapper = session.getMapper(ScoresMapper.class);

        Student s = mapper.getStudentById(2);
        System.out.println(s);
        for (Scores item:s.getScores()) {
            System.out.println(item);
        }
    }


}
