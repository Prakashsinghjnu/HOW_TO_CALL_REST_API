package com.Springrest.Springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.Springrest.Springrest.entities.Course;

@Service
public class CourseServiceimpl implements CourseService {

	
	List<Course> list;
	public CourseServiceimpl() {
		
		
		list=new ArrayList<Course>();
		list.add(new Course(14,"Java Course","this is course contins basics of java"));
		list.add(new Course(14332,"Spring Boot Course","this is course contins basics of Spring Boot"));
	
	}
	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		
		
		return list;
	}
	@Override
	public Course getCourse(long courseId) {
		// TODO Auto-generated method stub
		
		Course c=null;
		for(Course course:list) {
			if(course.getId()==courseId) {
				c=course;
				break;
				
			}
		}
		return c;
	}
	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
		list.add(course);
		return course;
	}
	@Override
	public Course updateCourse(Course course) {
		
		list.forEach(e -> {
			if(e.getId()==course.getId()) {
				e.setTitle(course.getTitle());
				e.setDescription(course.getDescription());
			}
		});
		return course ;
	}
	@Override
	public void deleteCourse(long parseLong) {
		// TODO Auto-generated method stub
		list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
	}


}
