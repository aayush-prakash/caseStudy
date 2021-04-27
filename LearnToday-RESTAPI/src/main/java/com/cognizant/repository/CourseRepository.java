package com.cognizant.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

}
