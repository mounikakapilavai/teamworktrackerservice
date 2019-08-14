package com.teamworktracker.teamworktrackerservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.teamworktracker.teamworktrackerservice.WorkFlowEngine;
import com.teamworktracker.teamworktrackerservice.model.Task;
import com.teamworktracker.teamworktrackerservice.model.WorkFlowRequest;
import com.teamworktracker.teamworktrackerservice.state.InvalidStateException;
import com.teamworktracker.teamworktrackerservice.state.State;

@Component
public class WorkFlowService {
	
	@Autowired
	private WorkFlowEngine workFlowEngine;
	
	@Autowired
	private TaskService taskService;
	
	public void doExecute(WorkFlowRequest workFlowRequest) {
		Task task = taskService.getTask(workFlowRequest.getTaskId());
		task.setActionCode(workFlowRequest.getActionCode());
		task.setUpdatedBy(workFlowRequest.getPerformedBy());
		workFlowEngine.init(task);
		State currentState = workFlowEngine.getState();
		try {
			currentState.submit(task);
		} catch (InvalidStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
