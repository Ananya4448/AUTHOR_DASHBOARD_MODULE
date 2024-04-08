package com.springrest.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.springrest.entities.Course;

//JpaRepository takes two parameters, 1st - Entity name(Course), 2nd - Type of the primary Key(Long)
public interface CourseDao extends JpaRepository<Course, Long> {

}
