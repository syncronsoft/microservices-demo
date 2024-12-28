package com.syncronsoft.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.syncronsoft.user.entity.Users;
import com.syncronsoft.user.service.UserService;
import com.syncronsoft.user.vo.ResponseTemplateVO;

import jdk.internal.org.jline.utils.Log;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public Users saveUser(@RequestBody Users user) {
		log.info("Inside the saveUser of UserController.");
		return userService.saveUser(user);
	}
	
	@GetMapping("/{id}")
	public ResponseTemplateVO findUserWithDepartment(@PathVariable("id") Long userId) {
		log.info("Inside the findUserWithDepartment of UserController.");
		return userService.findUserWithDepartment(userId);
		
	}

}
