package com.example.springdata.model.embedded_id;

// Esta clase representa la relación entre las entidades Student y Course

import com.example.springdata.model.Course;
import com.example.springdata.model.Student;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class StudentCourse {

    @EmbeddedId
    private StudentCourseKey id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @MapsId("studentId")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    @MapsId("courseId")
    private Course course;

    @Column(name = "rating")
    private int rating;

}
