package com.teamworktracker.teamworktrackerservice.state;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import com.teamworktracker.teamworktrackerservice.model.Task;
import com.teamworktracker.teamworktrackerservice.services.TaskService;
import com.teamworktracker.teamworktrackerservice.utils.ActionCode;
import com.teamworktracker.teamworktrackerservice.utils.TaskStatus;

public class PendingState extends State {
	
	@Autowired
	private TaskService taskService;

	@Override
	public void moveToInProgress(Task task) throws InvalidStateException {
		task.setStatus(TaskStatus.INPROGRESS.toString());
		taskService.updateTask(task, task.getId());
	}

	@Override
	public void submit(Task task) throws InvalidStateException {
		
		String actionCode = task.getActionCode();
		Objects.requireNonNull(actionCode);
		ActionCode currentAction = ActionCode.valueOf(actionCode);
		
		if(ActionCode.TO_INPROGRESS.equals(currentAction)) {
			moveToInProgress(task);
		}
		
	}

}
