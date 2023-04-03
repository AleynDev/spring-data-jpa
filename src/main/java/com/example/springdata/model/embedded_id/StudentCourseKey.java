package com.example.springdata.model.embedded_id;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Esta clase representa la llave compuesta, tiene q cumplir una serie de
 * requisitos:
 *      - debe esta marcadas con la anotación @Embeddable
 *      - deben implementar la interfaz Serializable
 *      - deben sobreescibir los métodos hascode & equals
 *      - ningun campo puede ser una entidad
 */

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class StudentCourseKey implements Serializable {

    // Definimos las dos columnas q seran la llave compuesta de la relación
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "course_id")
    private Long courseId;

}
