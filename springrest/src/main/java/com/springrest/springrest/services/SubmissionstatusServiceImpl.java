package com.springrest.springrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.SubmissionstatusDao;
import com.springrest.springrest.entities.Submission;
import com.springrest.springrest.entities.Submissionstatus;

@Service
public class SubmissionstatusServiceImpl implements SubmissionstatusService {
	
	@Autowired
	private SubmissionstatusDao submissionstatusDao;

	@Override
	public Submissionstatus addSubmissionstatus(Submissionstatus submissionstatus) {
		// TODO Auto-generated method stub
		
		List<Submission> submissionList = submissionstatus.getSubmissionList();
		
		System.out.println(submissionstatus.getStatus());
		
		for (Submission submission : submissionList) {
            submission.setSubmissionstatus(null);
        }
		
		Submissionstatus substat = submissionstatusDao.save(submissionstatus);
		
		return substat;
	}

	@Override
	public List<Submissionstatus> getAllStatus() {
		// TODO Auto-generated method stub
		List <Submissionstatus> statusArr = submissionstatusDao.findAll();
		
		for(Submissionstatus substat : statusArr) {
			substat.setSubmissionList(null);
		}
		
		return statusArr;
	}

}
