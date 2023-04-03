package com.example.springdata.repository;

import com.example.springdata.dto.CourseDTO;
import com.example.springdata.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<CourseDTO> findByInstructor_Id(Long id);
}
