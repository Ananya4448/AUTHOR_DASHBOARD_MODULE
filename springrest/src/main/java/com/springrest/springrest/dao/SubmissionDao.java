package com.springrest.springrest.dao;


import java.util.List;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.springrest.entities.Submission;



public interface SubmissionDao extends JpaRepository<Submission, Long> {
	
	Submission findById(long id);
	
	List<Submission> getSubmissionByUserId(long user_id);
	
//	@Query("INSERT INTO Submission (paper_title, field, docurl, paper_abstract, keywords, created_at, updated_at, author_id, status_code) VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9)")
//	Submission addSubmission(String paper_title, String field, String docurl, String paper_abstract, String keywords, LocalDate created_at, LocalDate updated_at, long author_id, long status_code);
	
//	@Query("FROM Submission s INNER JOIN Submissionstatus ss ON s.status_code = ss.id WHERE author_id = :author_id")
//	List<Submission> getSubmissionByAuthor(long author_id);
}
