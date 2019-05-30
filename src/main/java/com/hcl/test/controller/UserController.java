package com.hcl.test.controller;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hcl.test.dao.User;
import com.hcl.test.service.UserDaoService;

@RestController
public class UserController {
	@Autowired
	UserDaoService userDaoService;
	
	@Autowired
	MessageSource messageSource;
	
	@GetMapping("/users")
	public List<User> findAll()
	{
		return userDaoService.findAll();
	}
	
	@GetMapping("/retriveuser/{id}")
	public User retriveUser(@PathVariable int id)
	{
		User user=userDaoService.findOne(id);
		if(user==null)
			throw new UserNotFoundException("id-"+id);
		
		Resource<User> resorce=new Resource<User>(user);
		ControllerLinkBuilder link=linkTo(methodOn(this.getClass()).findAll());
		resorce.add(link.withRel("all-ussers"));
		return user;
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user)
	{
			
		User userDao=userDaoService.save(user);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(userDao.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteuser(@PathVariable int id)
	{
		User user=userDaoService.deleteById(id);
		if(user==null)
			throw new UserNotFoundException("id-"+id);
	}
	
	@GetMapping("/hello-internationalization")
	public String helloWorlsInternationalization(@RequestHeader(name="Accept-Language",required = false) Locale locale)
	{
		return messageSource.getMessage("good.morning.message", null, locale);
	}

}
