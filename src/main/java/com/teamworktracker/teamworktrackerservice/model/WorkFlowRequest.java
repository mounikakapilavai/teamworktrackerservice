package com.teamworktracker.teamworktrackerservice.model;

public class WorkFlowRequest {
	
	private String actionCode;
	private String performedBy;
	private Integer taskId;
	
	public String getActionCode() {
		return actionCode;
	}
	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}
	public String getPerformedBy() {
		return performedBy;
	}
	public void setPerformedBy(String performedBy) {
		this.performedBy = performedBy;
	}
	public Integer getTaskId() {
		return taskId;
	}
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

}
