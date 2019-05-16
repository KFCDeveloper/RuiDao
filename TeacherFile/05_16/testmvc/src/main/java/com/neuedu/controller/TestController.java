package com.neuedu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neuedu.model.po.Emp;
import com.neuedu.model.po.User;

@Controller
@RequestMapping("/test")
public class TestController {
	
	/*po(posistent object)∫Õvo(value object)∑÷¿Î*/
	
	/*
	 * 
	 *pay attention: use Integer(if age is not present, age is set to null), 
	 *not int(if age is not present, error will happen)
	 */
	@PostMapping("/login")
	public String test(String username,String password)
	{		
		//invoke service method to query database.
		
		System.out.println(username);
		System.out.println(password);
				
		return "/index.jsp";
	}
	
	@PostMapping("/register")
	public String register(User u)
	{
		System.out.println(u.getUsername());
		System.out.println(u.getPassword());
		
		return "/index.jsp";
	}
	
	@GetMapping("/emps")
	public String queryAllEmps(HttpServletRequest request)
	{
		//supposed to invoke service method get data from database
		List<Emp> list = new ArrayList<>();
		
		Emp e = new Emp();
		e.setEmpno(1);
		e.setEname("james");
		e.setJob("teacher");
		e.setHiredatestr("2019-5-16");
		
		list.add(e);
		
		//put the list into request
		request.setAttribute("list", list);
		request.setAttribute("msg", "helloworld");
		
		//forward the request to this page
		return "/emps.jsp"; 
		
	}
	
	/**
	 * 
	 * restful request
	 */
	@GetMapping("/rest/{username}/{password}")
	public String test2(@PathVariable String username, @PathVariable String password)
	{
		System.out.println(username);
		System.out.println(password);
		
		return "/index.jsp";
		
	}

}
