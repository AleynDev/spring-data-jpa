package com.example.springdata.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "instructor")
@Setter
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Instructor {

    // Se relaciona de oneToMany & manyToOne con la entidad Course.
    // Tenemos dos opciones para crear esta relacion, unidireccional y bidereccional.

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "instructor_generator", allocationSize = 1)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    // Unidireccional -> OneToMany -> se genera una tercera tabla lo q no es optimo
//    @OneToMany
//    private Set<Course> courses = new HashSet<>();

    // Bidireccional -> OneToMany & ManyToOne
    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL)
    private Set<Course> courses = new HashSet<>();

    public Instructor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
