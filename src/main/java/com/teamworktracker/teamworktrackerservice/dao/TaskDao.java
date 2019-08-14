package com.teamworktracker.teamworktrackerservice.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.teamworktracker.teamworktrackerservice.model.Task;

@Repository
public class TaskDao {
	
	private Map<Integer, Task> listOfTaks = new ConcurrentHashMap<>();
	
	@PostConstruct
	private void createSampleTask() {
		Task defaultTask = new Task();
		defaultTask.setId(0);
		defaultTask.setName("defalut");
		defaultTask.setDesc("description");
		defaultTask.setCompletionDate(LocalDate.now().toString());
		defaultTask.setCreatedBy("Chandan Kumar");
		defaultTask.setTimeCreated(LocalDate.now().toString());
		listOfTaks.put(defaultTask.getId(), defaultTask);
		
	}
	
	private Integer maxId = 0;
	
	public Task createTask(Task task) {
		task.setId(++maxId);
		listOfTaks.put(task.getId(), task);
		return task;
		
	}

	public Task getTask(Integer id) {
		return listOfTaks.get(id);
		
	}

	public Task updateTask(Task task, Integer id) {
		task.setId(id);
		listOfTaks.put(task.getId(), task);
		return task;
		
	}

	public List<Task> getTasks() {
		return listOfTaks.values().stream().collect(Collectors.toList());
		
	}

	public Task deleteTask(Integer id) {
		Task task = listOfTaks.get(id);
		listOfTaks.remove(id);
		return task;
		
	}

}
