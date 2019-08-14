package com.teamworktracker.teamworktrackerservice.apispec;

import java.util.List;

import com.teamworktracker.teamworktrackerservice.model.Task;

public interface ITaskResource {
	public Task createTask(Task task);
	public Task getTask(Integer id);
	public Task updateTask(Task task, Integer id);
	public List<Task> getTasks();
	public Task deleteTask(Integer id);
}
