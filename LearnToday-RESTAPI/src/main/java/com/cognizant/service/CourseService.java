package com.cognizant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cognizant.model.Course;
import com.cognizant.repository.CourseRepository;

public class CourseService {
	@Autowired
	CourseRepository courseRepo;

	public List<Course> getAllCourses() {
		return courseRepo.findAll();
	}

	public Course getCourseByID(int id) {
		Course course = null;
		Optional<Course> p = courseRepo.findById(id);
		if (p.isPresent()) {
			course = p.get();
		}
		return course;
	}
}
