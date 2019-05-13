package com.neuedu.testannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceVice {
    @Autowired
    private TestDAO testDAO;

    public void outPutCollaborate(){
        System.out.println(testDAO);
    }
}
