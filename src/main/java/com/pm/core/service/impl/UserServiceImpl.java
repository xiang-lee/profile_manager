package com.pm.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pm.core.dao.UserDao;
import com.pm.core.model.User;
import com.pm.core.service.UserService;
@Transactional
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	@Qualifier("userDao1")
	UserDao userDao;
	

	public User findByName(String name) {
		return userDao.findByName(name);
	}

	public List<User> findAllUsers() {
		return userDao.findAll();
	}

}
