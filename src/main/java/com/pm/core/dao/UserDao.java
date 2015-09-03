package com.pm.core.dao;

import com.pm.core.model.User;
import com.pm.core.orm.GeneralDAO;


public interface UserDao extends GeneralDAO<User, Long>{
	User findByName(String name);
}
