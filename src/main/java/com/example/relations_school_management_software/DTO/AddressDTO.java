package com.example.relations_school_management_software.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class AddressDTO {

    @NotNull(message = "Teacher Id is Required")
    private Integer teacherId;

    @NotEmpty(message = "Area must be not empty")
    @Size(min = 2 ,max = 15,message = "Area Length must be 2-10 characters")
    private String area;

    @NotEmpty(message = "street must be not empty")
    @Size(min = 4,max = 10,message = "Street length must be 4-10 characters")
    private String street;

    @NotNull(message = "building Number must be not null")
    @Positive(message = "Price must be positive number ")
    @Digits(integer = Integer.MAX_VALUE, fraction = 0, message = "Building Number must be a Integers")
    private int buildingNumber;

}
