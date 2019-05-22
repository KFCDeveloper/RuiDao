package com.neuedu.springbootdemo.controller;

import com.neuedu.springbootdemo.model.po.Emp;
import com.neuedu.springbootdemo.model.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping("/test")
    public String test(){
        return "{\"result\":\"皓皓\"}";
    }

    @RequestMapping("/emp")
    public Emp getOneEmp(){
        testService.test();
        Emp e = new Emp();
        e.setEmpno(1);
        e.setEname("haohao");
        e.setHiredate(new Date(System.currentTimeMillis()));
        return e;
    }

    @RequestMapping("/getEmps")
    public List<Emp> getEmps(@RequestBody Emp condition){
        System.out.println(condition);
        return testService.getEmps(condition);
    }

    //@RequestBody is used to handle content-type:application/json

    @RequestMapping("/registeremp")
    public String registerEmp(Emp e, MultipartFile photo, HttpServletRequest request)
    {

        //output file name
        System.out.println(photo.getOriginalFilename());

        //copy the file to anywhere you like.
        //String realpath = request.getServletContext().getRealPath("/images");

        String realpath = "./images";

        System.out.println(realpath);

        File dest = new File(realpath, System.currentTimeMillis()+photo.getOriginalFilename());

        //copy temparary file to dest
        try {
            photo.transferTo(dest);
        } catch (IllegalStateException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        } catch (IOException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }

        //get hiredate according to hiredatestr
        e.setHiredate(Date.valueOf(e.getHiredatestr()));

        //invoke service
        try {
            testService.addEmp(e);
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();

            return "{\"result\":false}";
        }

        return "{\"result\":true}";
    }
}
