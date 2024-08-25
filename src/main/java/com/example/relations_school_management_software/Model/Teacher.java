package com.example.relations_school_management_software.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotEmpty(message = " Name is Required")
    @Column(columnDefinition = "varchar(20) UNIQUE NOT NULL")
    private String name;

    @NotNull(message = " age id required")
    @Min(value = 18,message = "Age minimum is 18 years old ")
    @Column(columnDefinition = "int NOT NULL")
    @Digits(integer = Integer.MAX_VALUE, fraction = 0, message = "Age must be a Integers")
    private int age;

    @Email(message = " Email must be valid Required")
    @Column(columnDefinition = "varchar(25) UNIQUE NOT NULL")
    private String email;

    @NotNull(message = "salary is Required")
    @Column(columnDefinition = "double NOT NULL")
    @Digits(integer = Integer.MAX_VALUE, fraction = 0, message = "Salary must be a Integers numbers")
    private double salary;


    @OneToOne(cascade = CascadeType.ALL, mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;


    @OneToMany(cascade = CascadeType.ALL , mappedBy = "teacher")
    private Set<Course> courses;


}
