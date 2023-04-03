/*
package com.example.springdata.models.id_class;

// Esta clase representa la entidad

import com.example.springdata.models.Course;
import com.example.springdata.models.Student;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@IdClass(StudentCourseKey.class) // añado la llave creada anteriormente
public class StudentCourse {

    @Id
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Student student;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Course course;

    @Column(name = "rating")
    private int rating;

}
*/
