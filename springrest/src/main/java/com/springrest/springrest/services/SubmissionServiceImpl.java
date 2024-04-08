package com.springrest.springrest.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.SubmissionDao;
import com.springrest.springrest.dao.SubmissionstatusDao;
import com.springrest.springrest.entities.Review;
import com.springrest.springrest.entities.Submission;
import com.springrest.springrest.entities.Submissionstatus;
import com.springrest.springrest.entities.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


@Service
public class SubmissionServiceImpl implements SubmissionService {

	@Autowired
	private SubmissionDao submissionDao;
	
	@Autowired
    private EntityManager entityManager;
	
	@Override
	public Submission addSubmission(Submission submission) {
		// TODO Auto-generated method stub
		submission.setCreated_at(LocalDate.now());
		submission.setUpdated_at(LocalDate.now());
		Submission sub = submissionDao.save(submission);
//		Submission sub = submissionDao.addSubmission(submission.getPaper_title(), submission.getField(), submission.getDocurl(), submission.getPaper_abstract(), submission.getKeywords(), submission.getCreated_at(), submission.getUpdated_at(), 2, 1);
		return sub;
	}

	@Override
	public List<Submission> getSubmissionsByAuthor(long user_id) {
		// TODO Auto-generated method stub
		
//		String jpql = "SELECT s FROM Submission s JOIN Submissionstatus ss WHERE s.author_id = :authorId";
//	    TypedQuery<Submission> query = entityManager.createQuery(jpql, Submission.class);
//	    query.setParameter("authorId", author_id);
//	    List<Submission> submissions = query.getResultList();
	    
//	 // Fetch SubmissionStatus for each Submission
//	    for (Submission submission : submissions) {
//	        Submissionstatus submissionStatus = submissionstatusDao.findById(submission.getStatus_code()).get();
//	        submission.setStatus(submissionStatus);
//	    }
		
		List<Submission> submissions = submissionDao.getSubmissionByUserId(user_id);
		
		for (Submission submission : submissions) {
			User user = submission.getUser();
			user.setSubmissionList(null);
			
			Submissionstatus substat = submission.getSubmissionstatus();
			if(submission.getSubmissionstatus() != null) {
				substat.setSubmissionList(null);
			}
			
			List<Review> rev = submission.getReviewList();
			for(Review review: rev) {
				review.setSubmission(null);
			}
        }
	    
	    return submissions;
	}

	@Override
	public Submission updateSubmission(Submission submission) {
		// TODO Auto-generated method stub
		Submission sub = submissionDao.findById(submission.getId());
		if(sub != null) {
			submission.setCreated_at(submission.getCreated_at());
			submission.setUpdated_at(LocalDate.now());
			submissionDao.save(submission);
			
			User user = sub.getUser();
			user.setSubmissionList(null);
			
			Submissionstatus substat = sub.getSubmissionstatus();
			substat.setSubmissionList(null);
		}
		return sub;
	}

	@Override
	public String deleteSubmission(long id) {
		// TODO Auto-generated method stub
		try {
			Submission sub = submissionDao.findById(id);
			if(sub != null) {
				submissionDao.deleteById(id);
				return "deleted";
			}
			else {
				return "not exists";
			}
		}
		catch(Exception e) {
			return e.getMessage();
		}
	}

	@Override
	public List<Submission> getSubmissionsBy() {
		// TODO Auto-generated method stub
		List<Submission> subList = submissionDao.findAll();
		
		for (Submission submission : subList) {
			User user = submission.getUser();
			user.setSubmissionList(null);
			
			Submissionstatus substat = submission.getSubmissionstatus();
			if(submission.getSubmissionstatus() != null) {
				substat.setSubmissionList(null);
			}
			
			List<Review> rev = submission.getReviewList();
			for(Review review: rev) {
				review.setSubmission(null);
			}
        }
		
		return subList;
	}
	

}
