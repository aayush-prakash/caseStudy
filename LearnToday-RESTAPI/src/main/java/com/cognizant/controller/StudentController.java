package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.dao.StudentDao;
import com.cognizant.model.Course;
import com.cognizant.model.Student;

@RestController
public class StudentController {
	@Autowired
	StudentDao studentDao;

	@GetMapping("/student")
	public ResponseEntity<Object> getAllCourses() {
		List<Course> courseList = studentDao.getAllCourses();
		if(courseList.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(courseList);
		}
		return ResponseEntity.status(HttpStatus.OK).body(courseList);
	}
	
	@PostMapping("/student")	
	public ResponseEntity<Object> postStudent(@RequestBody Student student){
		if(studentDao.postStudent(student) == 1) {
			return ResponseEntity.status(HttpStatus.CREATED).body(student);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(student);
	}
	
	@DeleteMapping("/student/{id}")
	public ResponseEntity<Object> deleteStudentEnrollment(@PathVariable int id){
		if(studentDao.deleteById(id)==1) {
			return ResponseEntity.status(HttpStatus.OK).body("");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Searched Data not Found");
	}
}
