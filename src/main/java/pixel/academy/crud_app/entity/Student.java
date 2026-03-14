package pixel.academy.crud_app.entity;

import jakarta.persistence.*;

// mapam clasa la baza noastra de date
@Entity
@Table(name="student")
public class Student {

    //definirea campurilor
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

}
