package com.pm.core.service.impl;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.pm.core.config.WebMvcConfig;
import com.pm.core.model.Group;
import com.pm.core.service.GroupService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebMvcConfig.class)
@WebAppConfiguration
@EnableWebMvc
public class GroupServiceTest {
	@Autowired
	GroupService groupService;
	@Test
	public void testFindByName(){
		//Test conflict git 
		//xiang's comment group
		Group group = groupService.findByName("group1");
		Assert.assertNotNull(group);
	}
	
	@Test
	public void testFindAllGroups(){
		List<Group> group = groupService.findAllGroups();
		Assert.assertNotNull(group);
		//xiang's comment in testFindAllGroups()
	}

}
