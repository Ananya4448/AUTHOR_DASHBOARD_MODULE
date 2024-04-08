package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.entities.Submission;

public interface SubmissionService {

	public Submission addSubmission(Submission submission);
	
	public List<Submission> getSubmissionsByAuthor(long author_id);
	
	public Submission updateSubmission(Submission submission);
	
	public String deleteSubmission(long id);
	
	public List<Submission> getSubmissionsBy();
}
