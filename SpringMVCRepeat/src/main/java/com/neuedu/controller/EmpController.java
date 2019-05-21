package com.neuedu.controller;

import com.neuedu.model.po.Emp;
import com.neuedu.model.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    EmpService empService;

    //如果是GET过来的，这个@RequestBody就不能有，如果是POST，就一定要有@RequestBody 因为参数放的位置不一样
    @RequestMapping("/emps")
    public List<Emp> emps(/*@RequestBody*/ Emp emp){
        System.out.println(emp);
        //1.invoke service method
        //return the result
        return empService.getEmps(emp);
    }
}
