package com.pm.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pm.core.dao.GroupDao;
import com.pm.core.model.Group;
import com.pm.core.service.GroupService;

@Transactional
@Service
public class GroupServiceImpl implements GroupService {
	@Autowired
	GroupDao groupDao;

	public Group findByName(String name) {
		return groupDao.findByName(name);
	}

	public List<Group> findAllGroups() {
		return groupDao.findAll() ;
	}

}
