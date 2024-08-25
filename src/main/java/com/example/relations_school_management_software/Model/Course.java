package com.example.relations_school_management_software.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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
public class Course {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Name must be not empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @ManyToOne
    @JsonIgnore
    private Teacher teacher;


    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;

}
