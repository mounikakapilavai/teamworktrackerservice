package com.teamworktracker.teamworktrackerservice.apispec;

import com.teamworktracker.teamworktrackerservice.model.WorkFlowRequest;

public interface IWorkFlowResource {
	
	public void execute(WorkFlowRequest workFlowRequest, Integer id);

}
