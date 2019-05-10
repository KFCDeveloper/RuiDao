package com.neuedu.model.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neuedu.model.po.Emp;

public interface EmpMapper {
	
	public void addEmp(Emp emp);
	
	public void addEmp2(HashMap map);
	
	public void updateEmp(Emp emp);
	
	public void deleteEmp(int empno);
	
	public String getJobByEmpno(int empno);
	
	public HashMap getInfoByEmpno(int empno);
	
	public List<Emp> FindByColumn(@Param("column")String column, @Param("value")Object value);

    public List<HashMap> getInfos();
    
    public Emp getEmpInfoByEmpno(int empno);

}
