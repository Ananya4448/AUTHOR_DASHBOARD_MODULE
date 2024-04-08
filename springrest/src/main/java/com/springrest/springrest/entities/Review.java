package com.springrest.springrest.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Review {
	@Id
	@GeneratedValue(generator = "review_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "review_seq", sequenceName = "review_sequence", initialValue = 1, allocationSize = 1)
	private long id;
	private String review;
	private LocalDate created_at;
	private LocalDate update_at;
	
	@ManyToOne
	@JoinColumn(name = "submission_id")
	private Submission submission;

	public Review(long id, String review, LocalDate created_at, LocalDate update_at, Submission submission) {
		super();
		this.id = id;
		this.review = review;
		this.created_at = created_at;
		this.update_at = update_at;
		this.submission = submission;
	}

	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public LocalDate getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDate created_at) {
		this.created_at = created_at;
	}

	public LocalDate getUpdate_at() {
		return update_at;
	}

	public void setUpdate_at(LocalDate update_at) {
		this.update_at = update_at;
	}

	public Submission getSubmission() {
		return submission;
	}

	public void setSubmission(Submission submission) {
		this.submission = submission;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", review=" + review + ", created_at=" + created_at + ", update_at=" + update_at
				+ ", submission=" + submission + "]";
	}
	
	
}
