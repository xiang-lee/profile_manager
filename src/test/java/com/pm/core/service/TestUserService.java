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
import com.pm.core.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebMvcConfig.class)
@WebAppConfiguration
@EnableWebMvc
public class TestUserService {

	@Autowired
    UserService userService;
	
	@Test
	public void testFindByName() {
		User user = userService.findByName("xiang");
		Assert.assertNotNull(user);
	}

	@Test
	public void testFindAllUsers() {
		List<User> user = userService.findAllUsers();
		Assert.assertNotNull(user);
	}

}
