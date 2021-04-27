package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.model.Course;
import com.cognizant.model.Student;
import com.cognizant.repository.CourseRepository;
import com.cognizant.repository.StudentRepository;

@Component
public class StudentService {
	@Autowired
	StudentRepository studentRepo;
	@Autowired
	CourseRepository courseRepo;
	
	public List<Course> getAllCourses(){
		return courseRepo.findAll();
	}
	
	public boolean postStudent(Student student) {
		studentRepo.saveAndFlush(student);
		return true;
	}
	public boolean deleteById(int id) {
		studentRepo.deleteById(id);
		return true;
	}
}
