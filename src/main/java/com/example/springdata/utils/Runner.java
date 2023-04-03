package com.example.springdata.utils;

import com.example.springdata.repository.CourseRepository;
import com.example.springdata.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component // Defina la clase como un beans de Spring
public class Runner implements CommandLineRunner {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public Runner(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {

        // Save and SaveAll
//        Student student1 = new Student("John", "Doe", LocalDate.of(1990, 1, 1));
//        Student student2 = new Student("Jane", "Doe", LocalDate.of(1990, 1, 1));
//
//        studentRepository.saveAll(Set.of(student1, student2));

        // Using @Query
//        studentRepository.findByFirstName("Leora").forEach(System.out::println);
//        studentRepository.findByFirstNameLike("ri").forEach(System.out::println);
//        studentRepository.findByFirstNameNative("Dari").forEach(System.out::println);

//        studentRepository.findByFirstNameLastNameNamed("Leora", "Tutill").forEach(System.out::println);

        //Update
//        studentRepository.updateFirstNameById(6L, "Carmelo");


        //Using Named Method
//        studentRepository.findByBirthDateGreaterThan(LocalDate.of(1988,1,1)).forEach(System.out::println);
//
//        if (studentRepository.existsByFirstName("Leora")) {
//            System.out.println("Leora Exist");
//        }
//
//        System.out.println("Count: " + studentRepository.count());
//        System.out.println("Count: " + studentRepository.countByFirstName("Leora"));
//
//        studentRepository.deleteByFirstName("Leora");

        //Multiples Tables
//        studentRepository.findByContactInfo_State("Michigan").forEach(System.out::println);
//        studentRepository.findByContactInfo_StateIgnoreCaseOrderByFirstNameAscLastNameDesc("michigan").forEach(System.out::println);
//        studentRepository.findByContactInfo_StateIgnoreCaseOrderByIdDesc("michigan").forEach(System.out::println);
//        studentRepository.findByContactInfo_StateOrContactInfo_StateAllIgnoreCase("michigan", "ohio").forEach(System.out::println);


        //Sorting - Ordenamiento
//        Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC, "birthDate"), new Sort.Order(Sort.Direction.DESC, "firstName"));
//        studentRepository.findAll(sort).forEach(System.out::println);

        //Pagination
//        System.out.println("Page 1");
//        Pageable pageable = PageRequest.of(0,6,Sort.by(Sort.Direction.DESC, "birthDate"));
//        studentRepository.findAll(pageable).forEach(System.out::println);
//
//        System.out.println("Page 2");
//        pageable = PageRequest.of(1,6,Sort.by(Sort.Direction.DESC, "birthDate"));
//        studentRepository.findAll(pageable).forEach(System.out::println);
//
//        pageable = Pageable.unpaged(); // sin paginación


        var result = courseRepository.findByInstructor_Id(1L);

        for (var course:result) {
            System.out.println(course.getName() + " -> Instructor: " + course.getInstructorName() + " -> Students: " + course.getStudentCount());
        }



    }
}
