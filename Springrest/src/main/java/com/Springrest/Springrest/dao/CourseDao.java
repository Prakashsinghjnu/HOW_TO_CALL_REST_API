package com.Springrest.Springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Springrest.Springrest.entities.Course;
@Repository
public interface CourseDao extends JpaRepository<Course, Long> {
	
	

}