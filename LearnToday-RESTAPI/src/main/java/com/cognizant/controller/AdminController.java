package com.cognizant.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.dao.CourseDao;
import com.cognizant.dao.StudentDao;
import com.cognizant.model.Course;
import com.cognizant.service.CourseService;

@RestController
public class AdminController {
	@Autowired
	CourseService courseService;

	@GetMapping("/Admin")
	public ResponseEntity<Object> getAllCourses() {
		return new ResponseEntity(courseService.getAllCourses(), HttpStatus.OK);
	}

	@GetMapping("/Admin/{id}")
	public ResponseEntity<Object> getCourseById(@PathVariable int id) {
		Course course = courseService.getCourseByID(id);
		if (course == null) {
			return new ResponseEntity("Searched data not found", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity(course, HttpStatus.OK);
		}

	}
}
