package com.neuedu.model.mapper;

import com.neuedu.model.po.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface EmpMapper {
    void addEmp(Emp emp);

    void addEmp2(HashMap map);

    void updateEmp(Emp emp);

    void deleteEmp(int empno);

    String getJobByEmpno(int empno);

    HashMap getInfoByEmpno(int empno);

    List<Emp> FindByColumn(@Param("column") String column, @Param("value") Object value);

    List<HashMap> getInfos();

    Emp getEmpInfoByEmpno(int empno);

    List<Emp> getEmpInfoByEmpnoLazy(int empno);

    //dynamic condition
    List<Emp> getEmpByConditions(Emp e);

    List<Emp> getEmpByOneCondition(Emp e);

    void updatEmpByCondition(Emp emp);

    List<Emp> getEmps(List<Integer> empnos);

    List<Emp> getEmps2(int[] empnos);

    List<Emp> getEmpByPage(@Param("index") int index,@Param("count") int recordCount);
}
