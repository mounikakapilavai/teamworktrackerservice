package com.teamworktracker.teamworktrackerservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamworktracker.teamworktrackerservice.dao.TaskDao;
import com.teamworktracker.teamworktrackerservice.model.Task;
import com.teamworktracker.teamworktrackerservice.utils.TaskStatus;

@Service
public class TaskService {
	
	@Autowired
	private TaskDao taskDao;
	
	public Task createTask(Task task) {
		task.setStatus(TaskStatus.INPUT.toString());
		return taskDao.createTask(task);
		
	}

	public Task getTask(Integer id) {
		return taskDao.getTask(id);
		
	}

	public Task updateTask(Task task, Integer id) {
		return taskDao.updateTask(task, id);
		
	}

	public List<Task> getTasks() {
		return taskDao.getTasks();
		
	}

	public Task deleteTask(Integer id) {
		return taskDao.deleteTask(id);
		
	}

}
