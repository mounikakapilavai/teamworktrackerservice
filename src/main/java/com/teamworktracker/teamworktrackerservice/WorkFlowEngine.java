package com.teamworktracker.teamworktrackerservice;

import org.springframework.stereotype.Component;

import com.teamworktracker.teamworktrackerservice.model.Task;
import com.teamworktracker.teamworktrackerservice.state.CompletedState;
import com.teamworktracker.teamworktrackerservice.state.InProgressState;
import com.teamworktracker.teamworktrackerservice.state.InputState;
import com.teamworktracker.teamworktrackerservice.state.PendingState;
import com.teamworktracker.teamworktrackerservice.state.State;
import com.teamworktracker.teamworktrackerservice.utils.TaskStatus;

@Component
public class WorkFlowEngine {
	
	private Task task;
	
	TaskStatus currentStatus;
	
	public WorkFlowEngine() {
		
	}

	public void init(Task task) {
		this.task = task;
		if(task.getStatus() == null) {
			this.currentStatus = TaskStatus.INPUT;
		}
		else {
			this.currentStatus = TaskStatus.valueOf(task.getStatus());
		}
		
	}
	
	public State getState() {
		
		State state = null;
		
		if(TaskStatus.INPUT.equals(currentStatus)) {			
			state = new InputState();
		}
		else if(TaskStatus.PENDING.equals(currentStatus)) {
			state = new PendingState();
		}
		else if(TaskStatus.INPROGRESS.equals(currentStatus)) {
			state = new InProgressState();
		}
		else if(TaskStatus.COMPLETED.equals(currentStatus)) {
			state = new CompletedState();
		}
		return state;
	}

}
