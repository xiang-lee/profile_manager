package com.pm.core.dao;

import com.pm.core.model.Group;
import com.pm.core.orm.GeneralDAO;

public interface GroupDao extends GeneralDAO<Group, Long> {
	Group findByName(String name);
}
