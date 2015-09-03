package com.pm.core.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pm.core.dao.UserDao;
import com.pm.core.model.User;
import com.pm.core.orm.GeneralDAOImpl;

@Repository("UserDao")
@Transactional
public class UserDaoImpl extends GeneralDAOImpl<User, Long> implements UserDao{
	public User findByName(String name) {
		return findUniqueBy("name", name);
	}
}
