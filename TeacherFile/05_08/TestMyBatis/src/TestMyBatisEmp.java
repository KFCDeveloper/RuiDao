import java.sql.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.model.mapper.DeptMapper;
import com.neuedu.model.mapper.EmpMapper;
import com.neuedu.model.po.Dept;
import com.neuedu.model.po.Emp;
import com.neuedu.model.po.Salgrade;

public class TestMyBatisEmp {

	public static void main(String[] args) {
		
		getSalgrade();

	}
	
	public static void addEmp()
	{
		//get SqlSession
		SqlSession session = DBUtils.getInstance();
		
		//get mapper
		EmpMapper mapper = session.getMapper(EmpMapper.class);
		
		//create a instance of Emp
		Emp emp = new Emp();
		//emp.setEmpno(8888);
		emp.setEname("feiyy");
		emp.setMgr(7369);
		emp.setJob("teacher");
		//how to get a sql.Date
		//System.currentTimeMillis() returns milliseconds between now and 1970-1-1 0:0:0
		emp.setHiredate(new Date(System.currentTimeMillis()));
		emp.setSal(8888.88);
		emp.setComm(6666.66);
		
		//emp.setDeptno(10);
		
		mapper.addEmp(emp);
		
		//<insert id="addEmp" useGeneratedKeys="true" keyProperty="empno">
		//output the empno
		System.out.println(emp.getEmpno());
		
		
		//to commit session
		session.commit();
	}
	
	public static void addEmp2()
	{
		//get SqlSession
		SqlSession session = DBUtils.getInstance();
		
		//get mapper
		EmpMapper mapper = session.getMapper(EmpMapper.class);
		
	
		HashMap<String,Object> map = new HashMap<>();
		
		map.put("ename", "feiyy");
		map.put("mgr", 7369);
		map.put("job", "teacher");
		map.put("hiredate", new Date(System.currentTimeMillis()));
		map.put("sal", "9999.99");
		map.put("comm", "7777.77");
		map.put("deptno", 10);
		
		
		mapper.addEmp2(map);
		
		//<insert id="addEmp" useGeneratedKeys="true" keyProperty="empno">
		//output the empno
		System.out.println(map.get("empno"));
		
		
		//to commit session
		session.commit();
	}
	
	public static void updateEmp()
	{
		SqlSession session = DBUtils.getInstance();
		EmpMapper mapper = session.getMapper(EmpMapper.class);
		
		Emp e = new Emp();
		e.setEmpno(8888);
		e.setSal(9998.66);
		e.setComm(1888);
		
		mapper.updateEmp(e);
		
		session.commit();
	}
	
	public static void deleteEmp()
	{
		SqlSession session = DBUtils.getInstance();
		EmpMapper mapper = session.getMapper(EmpMapper.class);
		mapper.deleteEmp(8889);
		session.commit();
	}
	
	public static void getJob()
	{
		SqlSession session = DBUtils.getInstance();
		EmpMapper mapper = session.getMapper(EmpMapper.class);
		
		String job = mapper.getJobByEmpno(7369);
		
		System.out.println(job);
	}
	
	public static void getInfo()
	{
		SqlSession session = DBUtils.getInstance();
		EmpMapper mapper = session.getMapper(EmpMapper.class);
		
		HashMap map = mapper.getInfoByEmpno(8888);
		
		System.out.println(map.get("ename")+"\t"+map.get("job"));
	}
	
	public static void findByColumn()
	{
		SqlSession session = DBUtils.getInstance();
		EmpMapper mapper = session.getMapper(EmpMapper.class);
		
		List<Emp> list = mapper.FindByColumn("empno", 7369);
		Iterator<Emp> it = list.iterator();
		while(it.hasNext())
		{
			Emp e = it.next();
			System.out.println(e.getEmpno()+"\t"+e.getEname()+"\t"+e.getJob()+"\t"+e.getHiredate());
		}		
	}
	
	public static void getInfos()
	{
		SqlSession session = DBUtils.getInstance();
		EmpMapper mapper = session.getMapper(EmpMapper.class);
		
		List<HashMap> list = mapper.getInfos();
		
		Iterator<HashMap> it = list.iterator();
		HashMap map = null;
		while(it.hasNext())
		{
			map = it.next();
			System.out.println(map.get("empno")+"\t"+map.get("ename")+"\t"+map.get("dname")+"\t"+map.get("loc"));
		}
	}
	
	public static void getSalgrade()
	{
		SqlSession session = DBUtils.getInstance();
		DeptMapper mapper = session.getMapper(DeptMapper.class);
		
		Salgrade s = mapper.getSalgrade(1);
		System.out.println(s.getGrade()+"\t"+s.getHighsal()+"\t"+s.getLowsal());
		
	}
}
