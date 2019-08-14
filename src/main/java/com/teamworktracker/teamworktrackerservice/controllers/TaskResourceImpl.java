package com.teamworktracker.teamworktrackerservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.teamworktracker.teamworktrackerservice.apispec.ITaskResource;
import com.teamworktracker.teamworktrackerservice.model.Task;
import com.teamworktracker.teamworktrackerservice.services.TaskService;

@RestController
public class TaskResourceImpl implements ITaskResource {
	
	@Autowired
	private TaskService taskService;
	
	@RequestMapping(path = "/task", method = RequestMethod.POST)
	public Task createTask(@RequestBody Task task) {
		return taskService.createTask(task);
		
	}

	@RequestMapping(path = "/task/{id}", method = RequestMethod.GET)
	public Task getTask(@PathVariable Integer id) {
		return taskService.getTask(id);
		
	}

	@RequestMapping(path = "/task/{id}", method = RequestMethod.PUT)
	public Task updateTask(@RequestBody Task task, @PathVariable Integer id) {
		return taskService.updateTask(task, id);
		
	}

	@RequestMapping(path = "/tasks", method = RequestMethod.GET)
	public List<Task> getTasks() {
		return taskService.getTasks();
		
	}

	@RequestMapping(path = "/task/{id}", method = RequestMethod.DELETE)
	public Task deleteTask(@PathVariable Integer id) {
		return taskService.deleteTask(id);
		
	}
}
