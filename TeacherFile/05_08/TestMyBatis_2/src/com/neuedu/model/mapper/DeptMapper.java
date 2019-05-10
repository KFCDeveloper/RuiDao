package com.neuedu.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neuedu.model.po.Dept;

public interface DeptMapper {
	
	public Dept selectDept(int deptno);
	
	public List<Dept> selectAllDept();
	
	public List<Dept> selectDeptByName(String dname);
	
	//have more than one argument
	public List<Dept> selectDeptByNameAndLoc(@Param("dname")String dname, @Param("loc")String loc);

}
