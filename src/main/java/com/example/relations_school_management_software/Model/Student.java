package com.example.relations_school_management_software.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Name must be not empty")
    @Column(columnDefinition = "varchar(10) not null")
    private String name;

    @NotNull(message = "Age must be not null")
   // @Column(columnDefinition = "int not null check(age>18)")
    private int age;

    @NotEmpty(message = "Major must be not empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String major;


    @ManyToMany
    @JsonIgnore
    private Set<Course> courses;
}
