package com.neuedu.model.mapper;

import com.neuedu.model.po.Dept;
import com.neuedu.model.po.Salgrade;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//
public interface DeptMapper {
    Dept selectDept(int para);

    List<Dept> selectAllDept();

    List<Dept> selectDeptByName(String dname);

    // @Para对应的DeptMapper中的参数名
    List<Dept> selectDeptByNameAndLoc(@Param("dname") String dname, @Param("loc") String loc);

    void addDept(@Param("deptno") int deptno, @Param("dname") String dname, @Param("loc") String loc);

    List<Salgrade> getSalgrade(int grade);

    Dept getDept(int deptno);

    List<Dept> getDepts();

    Dept getDeptLazy(int deptno);

    List<Dept> getDeptLazyAll();

}