package com.neuedu.controller;

import com.neuedu.model.po.Emp;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ajax")
public class AjaxController {
    @RequestMapping("/testajax")
    public String ajax() {
        //{"username":"haohao","age":"20"}
        //[{},{}]
        //convert from json string to object
        return "{\"username\":\"haohao\",\"age\":\"20\"}";
    }

    @RequestMapping("/emps")
    public List getAllEmps(){
        //
        List list = new ArrayList<Emp>();

        Emp e1 = new Emp();
        e1.setEmpno(1);
        e1.setEname("皓皓");

        Emp e2 = new Emp();
        e2.setEmpno(1);
        e2.setEname("Pascal");

        list.add(e1);
        list.add(e2);

        //jackson works to convert list to json string
        return list;
    }

    @RequestMapping("/getmap")
    public Map <String,Emp> getMap(){
        Map<String,Emp> m = new HashMap<>();

        Emp e = new Emp();
        e.setEmpno(1);
        e.setEname("皓皓");
        e.setHiredatestr("2018-4-2");

        m.put("haohao",e); //{"haohao":{"empno":1,"ename":"皓皓",.......}}
        return m;
    }
}
