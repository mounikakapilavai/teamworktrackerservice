package com.teamworktracker.teamworktrackerservice.state;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import com.teamworktracker.teamworktrackerservice.model.Task;
import com.teamworktracker.teamworktrackerservice.services.TaskService;
import com.teamworktracker.teamworktrackerservice.utils.ActionCode;
import com.teamworktracker.teamworktrackerservice.utils.TaskStatus;

public class InProgressState extends State {
	
	@Autowired
	private TaskService taskService;

	@Override
	public void moveToCompleted(Task task) throws InvalidStateException {
		task.setStatus(TaskStatus.COMPLETED.toString());
		taskService.updateTask(task, task.getId());
	}

	@Override
	public void submit(Task task) throws InvalidStateException {
		
		String actionCode = task.getActionCode();
		Objects.requireNonNull(actionCode);
		ActionCode currentAction = ActionCode.valueOf(actionCode);
		
		if(ActionCode.TO_COMPLETED.equals(currentAction)) {
			moveToCompleted(task);
		}
		
	}

}
