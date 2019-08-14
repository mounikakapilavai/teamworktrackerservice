package com.teamworktracker.teamworktrackerservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.teamworktracker.teamworktrackerservice.apispec.IWorkFlowResource;
import com.teamworktracker.teamworktrackerservice.model.WorkFlowRequest;
import com.teamworktracker.teamworktrackerservice.services.WorkFlowService;

@RestController
@RequestMapping(path = "/task")
public class WorkFlowResourceImpl implements IWorkFlowResource {
	
	@Autowired
	private WorkFlowService workFlowService;

	@RequestMapping(path = "/{id}/execute", method = RequestMethod.POST)
	public void execute(@RequestBody WorkFlowRequest workFlowRequest, @PathVariable Integer id) {
		workFlowRequest.setTaskId(id);
		workFlowService.doExecute(workFlowRequest);

	}

}
