package com.hcl.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.test.dao.HellowWorldBean;

@RestController
public class HellowWorldRestController {
	
	//@RequestMapping(method = RequestMethod.GET,path = "/hello")
	@GetMapping("/helloworld")
	public String helloworld()
	{
		return "hello";
	}

	
	@GetMapping("/hello-bean")
	public HellowWorldBean helloword()
	{
		return new HellowWorldBean("hello");
	}
	
	@GetMapping("/helo-world/pathvariable/{name}")
	public HellowWorldBean hellowordpath(@PathVariable String name)
	{
		return new HellowWorldBean(name);
	}
}
