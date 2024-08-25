package com.example.relations_school_management_software.Controller;

import com.example.relations_school_management_software.Api.ApiResponse;
import com.example.relations_school_management_software.Model.Course;
import com.example.relations_school_management_software.Model.Student;
import com.example.relations_school_management_software.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/course")
public class CourseController {
    private final CourseService courseService;

   @GetMapping("/get")
    private ResponseEntity getAllCourse() {
       return ResponseEntity.status(200).body(courseService.getAllCourses());
   }

   @PostMapping("/add")
    private ResponseEntity addCourse(@RequestBody Course course) {
       courseService.addCourse(course);
       return ResponseEntity.status(200).body(new ApiResponse("Course added successfully"));
   }

   @PutMapping("/update/{id}")
    private ResponseEntity updateCourse(@PathVariable int id,@Valid @RequestBody Course course ) {
       courseService.updateCourse(id, course);
       return ResponseEntity.status(200).body(new ApiResponse("Course updated successfully"));
   }

   @DeleteMapping("/delete/{id}")
    private ResponseEntity deleteCourse(@PathVariable int id) {
       courseService.deleteCourse(id);
       return ResponseEntity.status(200).body(new ApiResponse("Course deleted successfully"));
   }

   @PutMapping("/assign-course/{courseId}/{teacherId}")
    private ResponseEntity assignCourse(@PathVariable int courseId, @PathVariable int teacherId) {
       courseService.assignCourseToTeacher(courseId, teacherId);
       return ResponseEntity.status(200).body(new ApiResponse("Course assigned successfully"));
   }

  @GetMapping("/course/{id}")// get all course details
    private ResponseEntity getCourseById(@PathVariable int id) {
       return  ResponseEntity.status(200).body(courseService.getCourseById(id));
  }

    @GetMapping("/{courseId}/students")
    public ResponseEntity getStudentListByCourse(@PathVariable Integer courseId) {
        Set<Student> studentList = courseService.getStudentListByCourse(courseId);
        return ResponseEntity.status(200).body(studentList);
    }


}
