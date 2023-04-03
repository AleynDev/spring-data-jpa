package com.example.springdata.repository;

import com.example.springdata.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    //JPQL Query
    @Query("select s from Student s where s.firstName = ?1")
    List<Student> findByFirstName(String firstName);

    @Query("select s from Student s where s.firstName like %?1%")
    List<Student> findByFirstNameLike(String firstName);


    //Native SQL Query
    @Query(value = "select * from spring_data.student where first_name = ?1", nativeQuery = true)
    List<Student> findByFirstNameNative(String firstName);


    //JPAQ Named Parameters
    @Query("select s from Student s where s.firstName = :firstName and s.lastName = :lastName")
    List<Student> findByFirstNameLastNameNamed(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Modifying
    @Query("update Student s set s.firstName = :firstName where s.id = :id")
    void updateFirstNameById(@Param("id") Long id, @Param("firstName") String firstName);


    // Named Name Methods -> nombres q se pueden utilizar para Spring Data haga la consulta

    // buscar mayor q...
    List<Student> findByBirthDateGreaterThan(LocalDate birthdate);
    List<Student> readByBirthDateGreaterThan(LocalDate birthdate);
    List<Student> getByBirthDateGreaterThan(LocalDate birthdate);
    List<Student> queryByBirthDateGreaterThan(LocalDate birthdate);
    List<Student> searchByBirthDateGreaterThan(LocalDate birthdate);
    List<Student> streamByBirthDateGreaterThan(LocalDate birthdate);

    // buscar si existe en la DB
    boolean existsByFirstName(String firsName);

    // contar registros
    int countByFirstName(String firstName);

    // eliminar
    void deleteByFirstName(String firstName);
    void removeByFirstName(String firstName);

    //Multiples Tables
        // busca todos los estudiantes de un estado
        List<Student> findByContactInfo_State(String state);

        // busca todos los estudiantes de un estado, ignora la mayusculas o minusculas y ordena
        // el resultado por firstName ascendente y lastName descendente
        List<Student> findByContactInfo_StateIgnoreCaseOrderByFirstNameAscLastNameDesc(String state);

        // busca todos los estudiantes de un estado y los ordena por su id descendente
        List<Student> findByContactInfo_StateIgnoreCaseOrderByIdDesc(String state);

        // agregando operadores logicos
        // estudiantes q pertenezcan a un estado u otro
        List<Student> findByContactInfo_StateOrContactInfo_StateAllIgnoreCase(String state1, String state2);

    //Native query paging
    @Query(value = "select * from student where first_name = ?1",
            countQuery = "select count(*) from student where first_name = ?1", nativeQuery = true)
    Page<Student> findByFirstNameNativePaging(String firstName, Pageable pageable);




}
