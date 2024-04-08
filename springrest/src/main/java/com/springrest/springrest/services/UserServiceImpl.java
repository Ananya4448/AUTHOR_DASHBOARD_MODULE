package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import com.springrest.springrest.entities.Submission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springrest.springrest.bodyjson.LoginRequest;
import com.springrest.springrest.dao.UserDao;
import com.springrest.springrest.entities.User;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	private String encryptPassword(String password) {
        // Use BCryptPasswordEncoder to hash the password
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		User exists = userDao.findByEmail(user.getEmail());
		if(exists != null)
		{
			return null;
		}
		else
		{
			// Encrypt the user's password before saving
            String encryptedPassword = encryptPassword(user.getPassword());
            user.setPassword(encryptedPassword);
            
            List<Submission> submissionList = user.getSubmissionList();
            
            for (Submission submission : submissionList) {
                submission.setUser(user);
            }
            
			User c = userDao.save(user);
			c.setSubmissionList(null);
			return c;
		}
	}
	
	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		User exists = userDao.findByEmail(user.getEmail());
		if(exists == null)
		{
			return null;
		}
		else
		{
			// Encrypt the user's password before saving
            String encryptedPassword = encryptPassword(user.getPassword());
            user.setPassword(encryptedPassword);
            
            List<Submission> submissionList = user.getSubmissionList();
            
            for (Submission submission : submissionList) {
                submission.setUser(user);
            }
            
			User c = userDao.save(user);
			c.setSubmissionList(null);
			return c;
		}
	}
	
	@Override
	public User updateUserWithoutPass(User user) {
		// TODO Auto-generated method stub
		User exists = userDao.findByEmail(user.getEmail());
		if(exists == null)
		{
			return null;
		}
		else
		{
			// here we won't encrypt the password            
            List<Submission> submissionList = user.getSubmissionList();
            
            for (Submission submission : submissionList) {
                submission.setUser(user);
            }
            
			User c = userDao.save(user);
			c.setSubmissionList(null);
			return c;
		}
	}

	@Override
	public User getUser(LoginRequest loginRequest) {
		// TODO Auto-generated method stub
//		User exists = userDao.findByEmailAndPassword(loginRequest.email, loginRequest.password);
		User exists = userDao.findByEmail(loginRequest.getEmail());
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		boolean isMatch = encoder.matches(loginRequest.getPassword(), exists.getPassword());
		
		if(isMatch)
		{
			exists.setSubmissionList(null);
			return exists;
		}
		else
		{
			return null;
		}
	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		User exists = userDao.findByEmail(email);
		if(exists != null) {
			exists.setSubmissionList(null);
			return exists;
		}
		else {
			return null;
		}
	}
	
	

}
