package com.teamworktracker.teamworktrackerservice.apispec;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.teamworktracker.teamworktrackerservice.model.Task;

public interface ITaskResource {
	public ResponseEntity<Task> createTask(Task task);
	public ResponseEntity<Task> getTask(Integer id);
	public ResponseEntity<Task> updateTask(Task task, Integer id);
	public ResponseEntity<List<Task>> getTasks();
	public ResponseEntity<Task> deleteTask(Integer id);
}
