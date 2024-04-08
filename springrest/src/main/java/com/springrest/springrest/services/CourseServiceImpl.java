package com.springrest.springrest.services;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;

// https://youtu.be/V2p5rVIBT5M?si=E0Wwa63v1elH5Em_

@Service
public class CourseServiceImpl implements CourseService {

//	List<Course> list;
	
	@Autowired
	private CourseDao courseDao;
	
	public CourseServiceImpl() {
//		list = new ArrayList<>();
//		list.add(new Course(1, "Java", "basics of Java"));
//		list.add(new Course(2, "Python", "basics of Python"));
	}
	
	
	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return courseDao.findAll();
	}


	@Override
	public Course getCourse(long courseId) {
		// TODO Auto-generated method stub
		return courseDao.getReferenceById(courseId);
	}


	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
		boolean exists = courseDao.existsById(course.getId());
		if(exists)
		{
			return null;
		}
		else
		{
			Course c = courseDao.save(course);
			return c;
		}
	}


	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
		boolean exists = courseDao.existsById(course.getId());
		if(exists)
		{
			Course c = courseDao.save(course);
			return c;
		}
		else
		{
			return null;
		}
		
	}

}
