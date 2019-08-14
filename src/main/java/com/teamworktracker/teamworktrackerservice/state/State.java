package com.teamworktracker.teamworktrackerservice.state;

import com.teamworktracker.teamworktrackerservice.model.Task;

public abstract class State {
	
	public void moveToInput(Task task) throws InvalidStateException {
		throw new InvalidStateException();
	}
	
	public void moveToPending(Task task) throws InvalidStateException {
		throw new InvalidStateException();
	}
	
	public void moveToInProgress(Task task) throws InvalidStateException {
		throw new InvalidStateException();
	}
	
	public void moveToCompleted(Task task) throws InvalidStateException {
		throw new InvalidStateException();
	}
	
	public void moveToDeleted(Task task) throws InvalidStateException {
		throw new InvalidStateException();
	}
	
	public abstract void submit(Task task) throws InvalidStateException;

}
