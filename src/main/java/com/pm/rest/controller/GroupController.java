package com.pm.rest.controller;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pm.core.model.Group;
import com.pm.core.service.GroupService;

public class GroupController {
	
	@Autowired
	GroupService groupService;
	
	@RequestMapping(method = RequestMethod.GET, value = "group/{name}")
	public ResponseEntity<?> findGroupByName(@PathVariable String name){
		return new ResponseEntity<Group>(groupService.findByName(name), HttpStatus.OK);
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "group")
	public ResponseEntity<?> findAllGroup(){
		return new ResponseEntity<List<Group>>(groupService.findAllGroups(), HttpStatus.OK);
	}

}
