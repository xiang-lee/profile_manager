package com.pm.core.service;

import java.util.List;

import com.pm.core.model.User;

public interface UserService {
	User findByName(String name);
	List<User> findAllUsers();
}
