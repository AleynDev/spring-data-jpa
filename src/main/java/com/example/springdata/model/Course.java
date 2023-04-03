package com.example.springdata.model;

import com.example.springdata.model.embedded_id.StudentCourse;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/*
    Esta entidad tiene una relación de muchos a muchos con Student, para crear esta relacion en Spring Data
    tenemos q crear una coleccion en cada entidad y ponerle la anotacion ManyToMany a cada una,
    y utilizar la anotacion JoinTable para crear una tabla adicional q las una.
 */

@Entity
@Table(name = "course")
@Setter
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "course_generator", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER) // La propiedad FetchType.EAGER -> hace q tengamos todos los cursos del instructor en la primera llamada
    private Instructor instructor;

    // forma directa
//    @ManyToMany(mappedBy = "courses")
//    private Set<Student> students = new HashSet<>();


    // IdClass
//    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
//    private Set<StudentCourse> studentCourses = new HashSet<>();


    // EmbeddedId
    @OneToMany(mappedBy = "course")
    private Set<StudentCourse> studentCourses = new HashSet<>();

    public Course(String name) {
        this.name = name;
    }
}
