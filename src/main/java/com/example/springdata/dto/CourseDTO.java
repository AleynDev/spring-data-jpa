package com.example.springdata.dto;

import org.springframework.beans.factory.annotation.Value;

public interface CourseDTO {
    Long getId();
    String getName();

    // @Value -> Proyeccion abierta | Spring Data no puede optimizar la expresion q se ejecuta,
    // ya q la expresion q se utiliza, puede utilizar cualquier atributo
    @Value("#{target.instructor.getFirstName()}")
    String getInstructorName();

    @Value("#{target.studentCourses.size()}")
    int getStudentCount();

}
