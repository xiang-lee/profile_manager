package com.pm.rest.controller;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pm.core.model.User;
import com.pm.core.service.UserService;

@Controller
public class UserController {

	@Resource
	UserService userService;
	
	@RequestMapping(method = RequestMethod.GET, value = "user/{name}")
	public ResponseEntity<?> findUserByName(@PathVariable String name) {
		return new ResponseEntity<User>(userService.findByName(name), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "users")
	public ResponseEntity<?> findAllUsers() {
		return new ResponseEntity<List<User>>(userService.findAllUsers(), HttpStatus.OK);
	}
	
}
