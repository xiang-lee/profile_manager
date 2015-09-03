package com.pm.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.pm.core.dao.UserDao;
import com.pm.core.model.User;
import com.pm.core.service.UserService;

@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	
	public User findByName(String name) {
		return userDao.findByName(name);
	}

	public List<User> findAllUsers() {
		return userDao.findAll();
	}

}
