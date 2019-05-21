package com.neuedu.model.mapper;

import com.neuedu.model.po.Emp;

import java.util.List;

public interface EmpMapper {
    public List<Emp>getEmps(Emp condition);
}
