package com.teamworktracker.teamworktrackerservice.state;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.teamworktracker.teamworktrackerservice.model.Task;
import com.teamworktracker.teamworktrackerservice.services.TaskService;
import com.teamworktracker.teamworktrackerservice.utils.ActionCode;
import com.teamworktracker.teamworktrackerservice.utils.TaskStatus;

@Component
public class InputState extends State {
	
	@Autowired
	private TaskService taskService;

	@Override
	public void moveToInput(Task task) throws InvalidStateException {		
		task.setStatus(TaskStatus.INPUT.toString());
		taskService.updateTask(task, task.getId());
	}

	@Override
	public void moveToPending(Task task) throws InvalidStateException {
		task.setStatus(TaskStatus.PENDING.toString());
		taskService.updateTask(task, task.getId());
	}

	@Override
	public void submit(Task task) throws InvalidStateException {
		
		String actionCode = task.getActionCode();
		Objects.requireNonNull(actionCode);
		ActionCode currentAction = ActionCode.valueOf(actionCode);
		
		if(ActionCode.SAVE.equals(currentAction)) {
			moveToInput(task);
		}
		else if(ActionCode.TO_PENDING.equals(currentAction)) {
			moveToPending(task);
		}
	}

}
