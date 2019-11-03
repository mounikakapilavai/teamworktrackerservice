package com.teamworktracker.teamworktrackerservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.teamworktracker.teamworktrackerservice.apispec.ITaskResource;
import com.teamworktracker.teamworktrackerservice.model.Task;
import com.teamworktracker.teamworktrackerservice.services.TaskService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value="Team Work Tracker", description="Operations pertaining to Task in Team Work Tracker")
public class TaskResourceImpl implements ITaskResource {
	
	@Autowired
	private TaskService taskService;
	
	@RequestMapping(path = "/task", method = RequestMethod.POST)
	@ApiOperation(value = "Create a Task")
	public ResponseEntity<Task> createTask(@RequestBody Task task) {
		Task createdTask =  taskService.createTask(task);
		return ResponseEntity.ok(createdTask);
		
	}

	@ApiOperation(value = "Fetch a Task")
	@RequestMapping(path = "/task/{id}", method = RequestMethod.GET)
	public ResponseEntity<Task> getTask(@PathVariable Integer id) {
		Task task = taskService.getTask(id);
		return ResponseEntity.ok(task);
		
	}

	@ApiOperation(value = "Update a Task")
	@RequestMapping(path = "/task/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Task> updateTask(@RequestBody Task task, @PathVariable Integer id) {
		Task updatedTask = taskService.updateTask(task, id);
		return ResponseEntity.ok(updatedTask);
		
	}

	@ApiOperation(value = "Fetch all Tasks")
	@RequestMapping(path = "/tasks", method = RequestMethod.GET)
	public ResponseEntity<List<Task>> getTasks() {
		List<Task> taskList = taskService.getTasks();
		return ResponseEntity.ok(taskList);
		
	}

	@ApiOperation(value = "Delete a Task")
	@RequestMapping(path = "/task/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Task> deleteTask(@PathVariable Integer id) {
		Task task = taskService.deleteTask(id);
		return ResponseEntity.ok(task);
		
	}
}
