package com.pm.core.service;

import java.util.List;

import com.pm.core.model.Group;

public interface GroupService {
	Group findByName(String name);

	List<Group> findAllGroups();
}
