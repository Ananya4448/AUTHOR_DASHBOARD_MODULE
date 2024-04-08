package com.springrest.springrest.controller;

import java.util.List;

import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.bodyjson.LoginRequest;
import com.springrest.springrest.entities.Course;
import com.springrest.springrest.entities.Review;
import com.springrest.springrest.entities.Submission;
import com.springrest.springrest.entities.Submissionstatus;
import com.springrest.springrest.entities.User;
import com.springrest.springrest.services.CourseService;
import com.springrest.springrest.services.ReviewService;
import com.springrest.springrest.services.SubmissionService;
import com.springrest.springrest.services.SubmissionstatusService;
import com.springrest.springrest.services.UserService;

@RestController
@CrossOrigin(origins = "*")
public class MyController {
	
	@Autowired
	private CourseService courseService; // interface, and used autowired because it will automatically create the obj from CourseServiceImpl class and put it into this obj 
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SubmissionService submissionService;
	
	@Autowired
	private SubmissionstatusService submissionstatusService;
	
	@Autowired
	private ReviewService reviewService;
	
	
	@GetMapping("/home")
	public String home() {
		return "Welcome to Homepage";
	}
	
	// get all courses
	@GetMapping("/courses")
	public List<Course> getCourses() {
		return this.courseService.getCourses();
	}
	
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return this.courseService.getCourse(Long.parseLong(courseId));
	}
	
	@PostMapping(path="/addCourse", consumes = "application/json")
	public ResponseEntity<Map<String, String>> addCourse(@RequestBody Course course) {
		Course addedCourse =  this.courseService.addCourse(course);
		if (addedCourse != null) {
	        Map<String, String> response = new HashMap<>();
	        response.put("message", "Data added successfully");
	        return ResponseEntity.ok(response);
	    } else {
	        Map<String, String> response = new HashMap<>();
	        response.put("message", "Failed to add data");
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	    }
	}
	
	@PutMapping(path="/updateCourse", consumes = "application/json")
	public ResponseEntity<Map<String, String>> updateCourse(@RequestBody Course course) {
		Course updatedCourse = this.courseService.updateCourse(course);
	    if (updatedCourse != null) {
	        Map<String, String> response = new HashMap<>();
	        response.put("message", "Data updated");
	        return ResponseEntity.ok(response);
	    } else {
	        Map<String, String> response = new HashMap<>();
	        response.put("message", "Failed to update data");
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	    }
	}
	
	
//	Users functionalities
	
	@PostMapping(path="/api/addUser", consumes = "application/json")
	public ResponseEntity<Map<String, Object>> addUser(@RequestBody User user) {
		User addedUser =  this.userService.addUser(user);
		
		try {
			if (addedUser != null) {
		        return ResponseEntity.ok().body(Map.of("message", "User added successfully", "data", addedUser));
		    } else {
		    	 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("message", "Failed to add user"));
		    }
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("message", "An error occurred: " + e));
		}
	}
	
	@PutMapping(path="/api/updateUser")
	public ResponseEntity<Map<String, Object>> updateUser(@RequestBody User user) {
		User addedUser =  this.userService.updateUser(user);
		
		try {
			if (addedUser != null) {
		        return ResponseEntity.ok().body(Map.of("message", "User updated successfully", "data", addedUser));
		    } else {
		    	 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("message", "Failed to update user"));
		    }
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("message", "An error occurred: " + e));
		}
	}
	
	@PutMapping(path="/api/updateUserWithoutPass")
	public ResponseEntity<Map<String, Object>> updateUserWithoutPass(@RequestBody User user) {
		User addedUser =  this.userService.updateUserWithoutPass(user);
		
		try {
			if (addedUser != null) {
		        return ResponseEntity.ok().body(Map.of("message", "User updated successfully", "data", addedUser));
		    } else {
		    	 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("message", "Failed to update user"));
		    }
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("message", "An error occurred: " + e));
		}
	}
	
	
	@PostMapping(path="/api/login", consumes = "application/json")
	public ResponseEntity<Map<String, Object>> getUser(@RequestBody LoginRequest loginRequest) {
		User fetchedUser = this.userService.getUser(loginRequest);
		
		try {
			if (fetchedUser != null) {
		        return ResponseEntity.ok().body(Map.of("message", "User fetched successfully", "data", fetchedUser));
		    } else {
		        return ResponseEntity.status(401).body(Map.of("message", "Invalid credentials", "data", ""));
		    }
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("message", "An error occurred: " + e));
		}
	}
	
	@GetMapping(path="/api/getUserByEmail/{email}")
	public ResponseEntity<Map<String, Object>> getUserByEmail(@PathVariable String email) {
				
		try {
			User fetchedUser = this.userService.getUserByEmail(email);
			if (fetchedUser != null) {
		        return ResponseEntity.ok().body(Map.of("message", "User fetched successfully", "data", fetchedUser));
		    } else {
		        return ResponseEntity.status(200).body(Map.of("message", "User not found", "data", ""));
		    }
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("message", "An error occurred: " + e));
		}
		
	}
	
	
//	Submission functionalities
	
	@PostMapping(path="/api/addSubmission", consumes = "application/json")
	public ResponseEntity<Map<String, Object>> addSubmission(@RequestBody Submission submission) {
		Submission sub =  this.submissionService.addSubmission(submission);
		
		try {
			if (sub != null) {
		        return ResponseEntity.ok().body(Map.of("message", "Submission added successfully", "data", sub));
		    } else {
		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("message", "Failed to add submission", "data", ""));
		    }
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("message", "An error occurred: " + e));
		}
	}
	
	@GetMapping(path = "/api/getAllSubmissions")
	public ResponseEntity<Map<String, Object>> getAllSubmissions() {
		try {
			List<Submission> responseList =  this.submissionService.getSubmissionsBy();
			return ResponseEntity.ok().body(Map.of("data", responseList));
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("message", "An error occurred: " + e));
		}
	}
	
	@GetMapping(path="/api/getAllSubmissionsByAuthor/{author_id}")
	public ResponseEntity<Map<String, Object>> getAllSubmissionByAuthor(@PathVariable String author_id) {
		try {
			List<Submission> responseList =  this.submissionService.getSubmissionsByAuthor(Long.parseLong(author_id));
			return ResponseEntity.ok().body(Map.of("data", responseList));
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("message", "An error occurred: " + e));
		}
	}
	
	@PutMapping(path="/api/updateSubmission", consumes = "application/json")
	public ResponseEntity<Map<String, Object>> updateSubmission(@RequestBody Submission submission) {
		try {
			Submission sub = this.submissionService.updateSubmission(submission);
			if (sub != null) {
				return ResponseEntity.ok().body(Map.of("message", "Submission updated successfully", "data", sub));
			}
			else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("message", "Failed to update submission", "data", ""));
			}
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("message", "An error occurred: " + e));
		}
	}
	
	@DeleteMapping(path="/api/deleteSubmission/{id}")
	public ResponseEntity<Map<String, Object>> deleteSubmission(@PathVariable Long id) {
		try {
			String responseStr =  this.submissionService.deleteSubmission(id);
			if(responseStr == "deleted") {
				return ResponseEntity.ok().body(Map.of("message", "Submission deleted successfully", "data", ""));
			}
			else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("message", "Failed to delete submission", "data", ""));
			}
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("message", "An error occurred: " + e));
		}
	}
	
	
	// Submission Status APIs
	
	@PostMapping(path = "/api/addsubmissionstatus")
	public Submissionstatus addSubmissionstatus(@RequestBody Submissionstatus submissionstatus) {
		return this.submissionstatusService.addSubmissionstatus(submissionstatus);
	}
	
	@GetMapping(path = "/api/getAllStatus")
	public ResponseEntity<Map<String, Object>> getAllStatus() {		
		try {
			List<Submissionstatus> responseList =  this.submissionstatusService.getAllStatus();
			return ResponseEntity.ok().body(Map.of("data", responseList));
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("message", "An error occurred: " + e));
		}
	}
	
	// Review APIs
	
	@PostMapping(path = "/api/addReview")
	public ResponseEntity<Map<String, Object>> addReview(@RequestBody Review review) {
		Review rev = this.reviewService.addReview(review);
		try {
			if (rev != null) {
		        return ResponseEntity.ok().body(Map.of("message", "Review added successfully", "data", rev));
		    } else {
		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("message", "Failed to add Review", "data", ""));
		    }
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("message", "An error occurred: " + e));
		}
	}
}
