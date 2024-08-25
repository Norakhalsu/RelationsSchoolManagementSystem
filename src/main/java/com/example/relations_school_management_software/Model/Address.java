package com.example.relations_school_management_software.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Entity
public class Address {

    @Id
    private Integer id;

    @Column(columnDefinition = "varchar(15) NOT NULL")
    private String area;

    @Column(columnDefinition = "varchar(10) NOT NULL")
    private String street;

    @Column(columnDefinition = "int UNIQUE NOT NULL")
    private int buildingNumber;

    @MapsId
    @OneToOne
    @JsonIgnore
    private Teacher teacher;

}
