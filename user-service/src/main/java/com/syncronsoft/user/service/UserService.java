package com.syncronsoft.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.syncronsoft.user.entity.Users;
import com.syncronsoft.user.repository.UserRepository;
import com.syncronsoft.user.vo.Department;
import com.syncronsoft.user.vo.ResponseTemplateVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Users saveUser(Users user) {
		log.info("Inside saveUser method of UserService");
		return userRepository.save(user);
	}

	public Users findUserById(Long userId) {
		log.info("Inside findUserById of UserService");
		return userRepository.findByUserId(userId);
	}

	public ResponseTemplateVO findUserWithDepartment(Long userId) {
		log.info("Inside findUserWithDepartment method of UserService");
		
		ResponseTemplateVO vo= new ResponseTemplateVO();
		
		Users user= userRepository.findByUserId(userId);
		
		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId() , Department.class);
		
		vo.setUser(user);
		vo.setDepartment(department);
		
		return vo;
	}

}
