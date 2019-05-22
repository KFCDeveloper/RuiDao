package com.neuedu.springbootdemo.model.service;

import com.neuedu.springbootdemo.model.mapper.EmpMapper;
import com.neuedu.springbootdemo.model.po.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TestService {
    @Autowired
    private EmpMapper empMapper;

    public void test(){
        System.out.println("皓皓");
    }

    public List<Emp>getEmps(Emp condition){
        return empMapper.getEmps(condition);
    }

    @Transactional
    public void addEmp(Emp e)throws Exception
    {
        empMapper.addEmp(e);
    }
}
