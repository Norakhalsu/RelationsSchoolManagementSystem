package com.example.relations_school_management_software.Service;

import com.example.relations_school_management_software.Api.ApiException;
import com.example.relations_school_management_software.DTO.AddressDTO;
import com.example.relations_school_management_software.Model.Address;
import com.example.relations_school_management_software.Model.Course;
import com.example.relations_school_management_software.Model.Teacher;
import com.example.relations_school_management_software.Repository.AddressRepository;
import com.example.relations_school_management_software.Repository.CourseRepository;
import com.example.relations_school_management_software.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service @RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public void addAddressToTeacher(AddressDTO addressDTO) {
        Teacher teacher=teacherRepository.findTeacherById(addressDTO.getTeacherId());

        if(teacher==null){
            throw new ApiException(" Teacher Id not found");
        }
          Address address=new Address(null,addressDTO.getArea(),addressDTO.getStreet(),addressDTO.getBuildingNumber(),teacher);
          addressRepository.save(address);
    }



    public void updateAddressToTeacher(AddressDTO addressDTO) {
       Address address=addressRepository.findAddressById(addressDTO.getTeacherId());
       if(address==null){
           throw new ApiException("  Teacher Id not found");
       }
       address.setArea(addressDTO.getArea());
       address.setStreet(addressDTO.getStreet());
       address.setBuildingNumber(addressDTO.getBuildingNumber());
       addressRepository.save(address);
    }

    public void deleteAddressFromTeacher(Integer addressId) {
        Address address=addressRepository.findAddressById(addressId);
        if(address==null){
            throw new ApiException(" addAddress's Teacher not found");
        }
        addressRepository.delete(address);
    }


}
