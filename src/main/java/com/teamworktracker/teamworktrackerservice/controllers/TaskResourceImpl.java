package com.teamworktracker.teamworktrackerservice.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.teamworktracker.teamworktrackerservice.apispec.ITaskResource;

@RestController
@RequestMapping(path = "/test")
public class TaskResourceImpl implements ITaskResource {

	@RequestMapping(method = RequestMethod.GET)
	public String test() {
		// TODO Auto-generated method stub
		return "Hi, Welcome to Team Work Tracker";
	}

}
