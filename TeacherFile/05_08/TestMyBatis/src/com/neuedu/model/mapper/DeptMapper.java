package com.neuedu.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neuedu.model.po.Dept;
import com.neuedu.model.po.Salgrade;

public interface DeptMapper {
	
	public Dept selectDept(int deptno);
	
	public List<Dept> selectAllDept();
	
	public List<Dept> selectDeptByName(@Param("dname") String dname);
	
	//have more than one argument
	public List<Dept> selectDeptByNameAndLoc(@Param("dname")String dname, @Param("loc")String loc);

    public void addDept(@Param("dname")String dname,@Param("loc")String loc);

    public Salgrade getSalgrade(int grade);
    
    public Dept getDept(int deptno);
    
    public List<Dept> getDepts();

}
