package com.neuedu.controller;


import com.neuedu.model.po.Emp;
import com.neuedu.model.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/test")
public class TestController {
    /*  po和vo分离
        persistent object 和 value object
        po中可以定义对应关系，对应数据库，vo对应页面的
        mybatis 一起用，最多是概念不清，不会造成错误
        hibernate却是不行，因为是自动同步的，会造成错误，不用写sql语句，这是全自动框架 po不能和页面混在一起
     */
    /*
        pay attention: use Integer(if age is not present, age is set to null),
        not int(if age is not present, error will happen)
     */
    @PostMapping("/loginPage")
    public String test(String username, String password, HttpSession session) {
        //invoke service method to query database.
        //get userinfo(userid, username...... ),put it into session

        //get session by result.getSession();
        System.out.println(username);
        System.out.println(password);

        //session与浏览器一个窗口有关，跳来跳去session都不会丢
        session.setAttribute("userinfo", username);

        return "/index.jsp";
        //服务器将session id发给用户浏览器，浏览器以cookie的形式保存好，下一次发消息的时候带上，
        //服务器将发过来的session id和自己这里的比对，就能够知道你是哪个用户
    }

    @PostMapping("/register")
    public String register(User u, MultipartFile photo) {
        System.out.println(u.getUsername());
        System.out.println(u.getPassword());

        //the photo we have this is location somewhere in your temporary folder
        //put it in D://
        File destination = new File("d://", photo.getOriginalFilename());
        try {
            photo.transferTo(destination);  //after transfer to the destination, the temporary
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "/index.jsp";
    }

    @GetMapping("/emps")
    public String queryAllEmps(HttpServletRequest request) {
        //supposed to invoke service method get data from database
        List<Emp> list = new ArrayList<>();
        Emp e = new Emp();
        e.setEmpno(1);
        e.setEname("james");
        e.setJob("teacher");
        e.setHiredatestr("2019-5-16");

        list.add(e);
        /*
            since controller and jsp share the same request,
            in controller, we can put into request, in emps.jsp, we can ge into from request.
         */

        //put the list into request
        request.setAttribute("list", list);
        request.setAttribute("list", list);

        /*//forward the request
        //只能跳到自己的网站*/
        return "/emps.jsp";

        //redirect to this page
        //可以重定向到别的网站，但是新的request，浏览器请求了控制器后不是转发到emp.jsp，而是直接请求emp.jsp
        //就是为了防止二次插入，如果是转发，刷新的话会先访问/emps，然后转发到jsp emps.jsp，重新来了一遍
//        return "redirect:/emps.jsp";
    }

    @GetMapping("/rest/{username}/{password}")
    public String test2(@PathVariable String username, @PathVariable String password) {
        System.out.println(username);
        System.out.println(password);
        return "/index.jsp";
    }
}
