package com.neuedu.model.service;

import com.neuedu.model.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {
    //Mapper should be created by Spring
    /*
        in order for spring to create a Mapper class, it must have control of the database
        have control of Mybatis SQLSessionFactory, and also have control of
     */

    @Autowired
    private AccountMapper accountMapper;

    @Transactional
    public void transferMoney(){
        //get conn here
        accountMapper.deductMoney(1,100);
        accountMapper.addMoney(2,100);
    }
}
