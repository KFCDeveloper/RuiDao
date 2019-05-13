package com.neuedu.testannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TestController {
    //we are sure, Spring uses Java Reflection mechanism to update its private field

    //Spring will have a rule to find matching dependencies, first find by Type,if it find
    //more matches(in this case,TestService could be interface, or a super class),then find by name
    @Autowired
    private TestServiceVice testService;


    public void outPutCollaborators() {
        testService.outPutCollaborate();
    }

}
