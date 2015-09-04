package com.pm.core.service;

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


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebMvcConfig.class)
@WebAppConfiguration
@EnableWebMvc
public class TestGroupService {
	@Autowired
	GroupService groupService;
	@Test
	public void testFindByName(){
		Group group = groupService.findByName("group1");
		Assert.assertNotNull(group);
	}
	
	@Test
	public void testFindAllGroups(){
		List<Group> group = groupService.findAllGroups();
		Assert.assertNotNull(group);
	}

}
