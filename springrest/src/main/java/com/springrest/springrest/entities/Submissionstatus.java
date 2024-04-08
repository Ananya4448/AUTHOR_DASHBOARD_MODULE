package com.springrest.springrest.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Submissionstatus {
	
	@Id
	@GeneratedValue(generator = "submissionstatus_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "submissionstatus_seq", sequenceName = "submissionstatus_sequence", initialValue = 1, allocationSize = 1)
	private long id;
	private String status;
	private LocalDate created_at;
	private LocalDate updated_at;
	
	@OneToMany(mappedBy = "submissionstatus", cascade = CascadeType.ALL)
	private List<Submission> submissionList = new ArrayList<>();

	public Submissionstatus(long id, String status, LocalDate created_at, LocalDate updated_at,
			List<Submission> submissionList) {
		super();
		this.id = id;
		this.status = status;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.submissionList = submissionList;
	}

	public Submissionstatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDate created_at) {
		this.created_at = created_at;
	}

	public LocalDate getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(LocalDate updated_at) {
		this.updated_at = updated_at;
	}

	public List<Submission> getSubmissionList() {
		return submissionList;
	}

	public void setSubmissionList(List<Submission> submissionList) {
		this.submissionList = submissionList;
	}

	@Override
	public String toString() {
		return "Submissionstatus [id=" + id + ", status=" + status + ", created_at=" + created_at + ", updated_at="
				+ updated_at + ", submissionList=" + submissionList + "]";
	}
	
	
}
