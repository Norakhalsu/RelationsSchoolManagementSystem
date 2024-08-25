package com.example.relations_school_management_software.Controller;

import com.example.relations_school_management_software.Api.ApiResponse;
import com.example.relations_school_management_software.DTO.AddressDTO;
import com.example.relations_school_management_software.Model.Address;
import com.example.relations_school_management_software.Service.AddressService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @RequiredArgsConstructor @RequestMapping("/api/v1/address")
public class AddressController {
    private final AddressService addressService;

    @GetMapping("/get")
    public ResponseEntity getAllAddresses() {
        return ResponseEntity.status(200).body(addressService.getAllAddresses());
    }

    @PostMapping("/add")
    public ResponseEntity addAddress(@Valid @RequestBody AddressDTO addressDTOe) {
        addressService.addAddressToTeacher(addressDTOe);
        return ResponseEntity.status(200).body(new ApiResponse("Address's Teacher Added successfully"));
    }

    @PutMapping("/update")
    public ResponseEntity updateAddress(@Valid @RequestBody AddressDTO addressDTOe) {
        addressService.updateAddressToTeacher(addressDTOe);
        return ResponseEntity.status(200).body(new ApiResponse("Address's Teacher Updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddress(@PathVariable int id) {
        addressService.deleteAddressFromTeacher(id);
        return ResponseEntity.status(200).body(new ApiResponse("Address's Teacher Deleted successfully"));
    }

}
