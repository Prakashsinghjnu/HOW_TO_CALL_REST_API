package com.Springrest.Springrest.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Springrest.Springrest.entities.Course;
import com.Springrest.Springrest.services.CourseService;

@RestController
public class HomeController {

	@Autowired
	private CourseService courseService;
	
	@GetMapping("/home")
	public String home() {
		
		return "This is home page";
	}
	
		//get all list of courses
	
	@GetMapping("/courses")
	public List<Course> getCourse(){
		
		return this.courseService.getCourses();
		
	}
	
	//to get single course
	@GetMapping("/courses/{courseId}")
	public Course course(@PathVariable String courseId ) {
		return this.courseService.getCourse(Long.parseLong(courseId)); 
	}
	  //insert new course
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		return this.courseService.addCourse(course);
	}
	
	//update new course
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return this.courseService.updateCourse(course);
	}
	
	//Delete course
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
		try
		{
			this.courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
