package com.neuedu.springbootdemo.model.mapper;

import com.neuedu.springbootdemo.model.po.Emp;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface EmpMapper {
    public List<Emp> getEmps(Emp condition);

    public void addEmp(Emp e);
}
