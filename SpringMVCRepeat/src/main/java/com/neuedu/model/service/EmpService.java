package com.neuedu.model.service;

import com.neuedu.model.mapper.EmpMapper;
import com.neuedu.model.po.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Transactional
    public List<Emp>getEmps(Emp condition){
        return empMapper.getEmps(condition);
    }
}
