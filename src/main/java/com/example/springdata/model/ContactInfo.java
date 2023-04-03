package com.example.springdata.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "contact_info")
@Setter
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ContactInfo {


    // Al ser una realicion oneToOne con student podmeos hacer q la llave primaria sea compartidada por
    // ambas entidades, teniendo en cuenta q contacttInfo depende de student

//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @SequenceGenerator(name = "student_generator", allocationSize = 1)

    @Id
    @Column(name = "student_id")
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "zip", nullable = false)
    private String zip;

    // relacion mediante foreign key
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @MapsId // copia los valores de la llave primaria de Student
    @JoinColumn(name = "student_id")
    private Student student;

    public ContactInfo(String email, String phone, String address, String city, String state, String zip) {
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }
}
