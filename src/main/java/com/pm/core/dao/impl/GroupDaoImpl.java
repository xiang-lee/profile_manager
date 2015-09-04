package com.pm.core.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pm.core.dao.GroupDao;
import com.pm.core.model.Group;
import com.pm.core.orm.GeneralDAOImpl;

@Repository("GroupDao")
@Transactional
public class GroupDaoImpl extends GeneralDAOImpl<Group, Long> implements GroupDao{


	public Group findByName(String name) {
		return findUniqueBy("name", name);
	}





}
