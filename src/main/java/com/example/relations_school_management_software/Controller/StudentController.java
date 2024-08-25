package com.example.relations_school_management_software.Controller;

import com.example.relations_school_management_software.Api.ApiResponse;
import com.example.relations_school_management_software.DTO.AddressDTO;
import com.example.relations_school_management_software.Model.Student;
import com.example.relations_school_management_software.Service.AddressService;
import com.example.relations_school_management_software.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @RequiredArgsConstructor @RequestMapping("/api/v1/student")
public class StudentController {

private final StudentService studentService;


        @GetMapping("/get")
        public ResponseEntity getAllStudent() {
            return ResponseEntity.status(200).body(studentService.getAllStudents());
        }

        @PostMapping("/add")
        public ResponseEntity addAddress(@Valid @RequestBody Student student) {
            studentService.addStudent(student);
            return ResponseEntity.status(200).body(new ApiResponse("Student Added successfully"));
        }

        @PutMapping("/update/{id}")
        public ResponseEntity updateAddress(@PathVariable Integer id,@Valid @RequestBody Student student) {
            studentService.updateStudent(id, student);
            return ResponseEntity.status(200).body(new ApiResponse("Student Updated successfully"));
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity deleteAddress(@PathVariable Integer id) {
            studentService.deleteStudent(id);
            return ResponseEntity.status(200).body(new ApiResponse("Address's Teacher Deleted successfully"));
        }

        @PutMapping("/{studentId}/assign/{courseId}")
        public ResponseEntity assignCourse(@PathVariable Integer studentId, @PathVariable Integer courseId) {
            studentService.assignStudentAndCourses(studentId, courseId);
            return ResponseEntity.status(200).body(new ApiResponse("Student And Course Assigned successfully"));
        }

       @PutMapping("/{studentId}/changeMajor/{major}")
        public ResponseEntity changeMajor(@PathVariable Integer studentId, @PathVariable String major) {
            studentService.changeStudentMajor(studentId, major);
            return ResponseEntity.status(200).body(new ApiResponse("Student Changed Successfully"));
       }


    }


