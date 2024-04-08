package com.springrest.springrest.entities;

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
public class User {

	@Id
	@GeneratedValue(generator = "user_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "user_seq", sequenceName = "user_sequence", initialValue = 1, allocationSize = 1)
	private long id;
	private String name;
	private String organization;
	private String email;
	private String mobile;
	private String password;
	private String userRole;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Submission> submissionList = new ArrayList<>();

	public User(long id, String name, String organization, String email, String mobile, String password,
			String userRole, List<Submission> submissionList) {
		super();
		this.id = id;
		this.name = name;
		this.organization = organization;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.userRole = userRole;
		this.submissionList = submissionList;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public List<Submission> getSubmissionList() {
		return submissionList;
	}

	public void setSubmissionList(List<Submission> submissionList) {
		this.submissionList = submissionList;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", organization=" + organization + ", email=" + email + ", mobile="
				+ mobile + ", password=" + password + ", userRole=" + userRole + ", submissionList=" + submissionList
				+ "]";
	}

	
}
