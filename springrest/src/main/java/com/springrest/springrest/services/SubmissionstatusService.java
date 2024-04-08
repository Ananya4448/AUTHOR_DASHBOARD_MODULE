package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.entities.Submissionstatus;

public interface SubmissionstatusService {
	public Submissionstatus addSubmissionstatus(Submissionstatus submissionstatus);
	
	public List<Submissionstatus> getAllStatus();
}
