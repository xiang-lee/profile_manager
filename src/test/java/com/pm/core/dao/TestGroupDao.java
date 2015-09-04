package com.pm.core.dao;

import junit.framework.Assert;
import junit.framework.TestCase;

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
public class TestGroupDao extends TestCase{
	
	@Autowired
	GroupDao groupDao;
	
	@Test
	public void testFindByGroup(){
		Group group = groupDao.findByName("group1");
		Assert.assertNotNull(group);
	}

}
