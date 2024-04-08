package com.springrest.springrest.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Submission {

	@Id
	@GeneratedValue(generator = "submission_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "submission_seq", sequenceName = "submission_sequence", initialValue = 1, allocationSize = 1)
	private long id;
	private String paper_title;
	private String field;
	private String docurl;
	private String paper_abstract;
	private String keywords;
	private LocalDate created_at;
	private LocalDate updated_at;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "status_code")
	private Submissionstatus submissionstatus;
	
	@OneToMany(mappedBy = "submission", cascade = CascadeType.ALL)
	private List<Review> reviewList = new ArrayList<>();

	public Submission(long id, String paper_title, String field, String docurl, String paper_abstract, String keywords,
			LocalDate created_at, LocalDate updated_at, User user, Submissionstatus submissionstatus,
			List<Review> reviewList) {
		super();
		this.id = id;
		this.paper_title = paper_title;
		this.field = field;
		this.docurl = docurl;
		this.paper_abstract = paper_abstract;
		this.keywords = keywords;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.user = user;
		this.submissionstatus = submissionstatus;
		this.reviewList = reviewList;
	}

	public Submission() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPaper_title() {
		return paper_title;
	}

	public void setPaper_title(String paper_title) {
		this.paper_title = paper_title;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getDocurl() {
		return docurl;
	}

	public void setDocurl(String docurl) {
		this.docurl = docurl;
	}

	public String getPaper_abstract() {
		return paper_abstract;
	}

	public void setPaper_abstract(String paper_abstract) {
		this.paper_abstract = paper_abstract;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Submissionstatus getSubmissionstatus() {
		return submissionstatus;
	}

	public void setSubmissionstatus(Submissionstatus submissionstatus) {
		this.submissionstatus = submissionstatus;
	}

	public List<Review> getReviewList() {
		return reviewList;
	}

	public void setReviewList(List<Review> reviewList) {
		this.reviewList = reviewList;
	}

	@Override
	public String toString() {
		return "Submission [id=" + id + ", paper_title=" + paper_title + ", field=" + field + ", docurl=" + docurl
				+ ", paper_abstract=" + paper_abstract + ", keywords=" + keywords + ", created_at=" + created_at
				+ ", updated_at=" + updated_at + ", user=" + user + ", submissionstatus=" + submissionstatus
				+ ", reviewList=" + reviewList + "]";
	}

	
	
}
